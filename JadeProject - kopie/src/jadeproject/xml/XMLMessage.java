/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadeproject.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hans
 */
@XmlRootElement
public class XMLMessage {
 private String agentName;
    private String agentType;
    private String agentMessage;
    
    public String getAgentName() {
        return agentName;
    }
    @XmlElement
    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentType() {
        return agentType;
    }
    @XmlElement
    public void setAgentType(String agentType) {
        this.agentType = agentType;
    }

    public String getAgentMessage() {
        return agentMessage;
    }
    @XmlElement
    public void setAgentMessage(String agentMessage) {
        this.agentMessage = agentMessage;
    }
    public void setNullObject(){
        agentName = "failedToParse";
        agentType= "failedToParse";
        agentMessage = "failedToParse";
    }
   
    
    
}
