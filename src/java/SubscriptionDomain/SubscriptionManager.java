/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SubscriptionDomain;

import java.util.HashSet;
import java.util.Set;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * REST Web Service
 *
 * @author gsonali
 */
@Path("subscriptions")
public class SubscriptionManager {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Subscriptions getSubscriptions(JsonObject object) throws Exception{
        //Json object converter
        ObjectMapper mapper = new ObjectMapper();
        SubscriptionPeriod sp = mapper.readValue(object.toString(), SubscriptionPeriod.class);

        Subscriptions subscriptions = new Subscriptions();

        checkSubscriptions(subscriptions, (Set<String>) sp.getStart(), "start");
        checkSubscriptions(subscriptions, (Set<String>) sp.getEnd(), "end");

        return subscriptions;
    }
    
    public void checkSubscriptions(Subscriptions subscriptions, Set<String> emails, String subscriptionPeriod) {

        //Check the starting subscriptions set, lets assume everyone unsubscribed 
        //since we dont know who stayed till the end as that is not processed yet
        if (subscriptionPeriod.equalsIgnoreCase("start")) {
            subscriptions.setUnsubscribed(emails);
        } else { 
            // Check the end subscription list
            Set<String> newSubs = new HashSet<String>();
            Set<String> stayed = new HashSet<String>();

            for (String emailId : emails) {

                // check with start subscription list (unsubscribed), 
                //if seen in the start list  then they stayed
                if (subscriptions.getUnsubscribed().contains(emailId)) {
                    subscriptions.getUnsubscribed().remove(emailId);
                    stayed.add(emailId);
                } else {
                    //if not seen in the start list  then they are new subscriptions
                    newSubs.add(emailId);
                }
            }

            subscriptions.setNewSubscribed(newSubs);
            subscriptions.setStayed(stayed);
        }
    }
}
