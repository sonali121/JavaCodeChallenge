/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SubscriptionDomain;
import java.util.Set;

/**
 *
 * @author Sonali
 */
public class Subscriptions {
    
    private Set<String> newSubscribed;
    private Set<String> stayed;
    private Set<String> unsubscribed;

    /**
     * @return the newSubscribed
     */
    public Set<String> getNewSubscribed() {
        return newSubscribed;
    }

    /**
     * @param newSubscribed the newSubscribed to set
     */
    public void setNewSubscribed(Set<String> newSubscribed) {
        this.newSubscribed = newSubscribed;
    }

    /**
     * @return the stayed
     */
    public Set<String> getStayed() {
        return stayed;
    }

    /**
     * @param stayed the stayed to set
     */
    public void setStayed(Set<String> stayed) {
        this.stayed = stayed;
    }

    /**
     * @return the unsubscribed
     */
    public Set<String> getUnsubscribed() {
        return unsubscribed;
    }

    /**
     * @param unsubscribed the unsubscribed to set
     */
    public void setUnsubscribed(Set<String> unsubscribed) {
        this.unsubscribed = unsubscribed;
    }

    
}
