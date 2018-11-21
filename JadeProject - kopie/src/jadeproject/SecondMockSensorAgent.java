/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadeproject;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jadeproject.xml.ObjectToXML;
import jadeproject.xml.XMLMessage;

/**
 *
 * @author Hans
 */
public class SecondMockSensorAgent extends Agent {

    ObjectToXML xmlMessage;
    String message;

    @Override
    protected void setup() {

        prepareMessage();

        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
                msg.setContent(message);
                msg.addReceiver(new AID("MyAgent", AID.ISLOCALNAME));
                send(msg);
            }
        });
    }

    private void prepareMessage() {
        XMLMessage agent = new XMLMessage();
        agent.setAgentName(getLocalName());
        agent.setAgentType("HeartRate");
        agent.setAgentMessage("60");

        xmlMessage = new ObjectToXML(agent);
        message = xmlMessage.createXML();
    }
}
