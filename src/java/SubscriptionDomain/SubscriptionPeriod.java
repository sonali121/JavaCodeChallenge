/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SubscriptionDomain;

import java.util.Set;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sonali
 */
@XmlRootElement
public class SubscriptionPeriod {
    @XmlElement
    private Set<String> start;
    @XmlElement
    private Set<String> end;

    /**
     * @return the start
     */
    public Set<String> getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(Set<String> start) {
        this.start = start;
    }

    /**
     * @return the end
     */
    public Set<String> getEnd() {
        return end;
    }

    /**
     * @param end the end to set
     */
    public void setEnd(Set<String> end) {
        this.end = end;
    }

   
}
