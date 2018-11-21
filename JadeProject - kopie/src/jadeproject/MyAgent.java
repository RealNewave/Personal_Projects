/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadeproject;

import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import jadeproject.xml.XMLMessage;
import jadeproject.xml.XMLToObject;

/**
 *
 * @author Hans
 */
public class MyAgent extends Agent {

    private String sender;
    private String message;
    private String name;

    @Override
    protected void setup() {
        addBehaviour(new getSensorAgentData(this));
        addBehaviour(new decisionAgent(this));
        
    }

    public String getMessage() {
        return message;
    }

    class getSensorAgentData extends CyclicBehaviour {

        public getSensorAgentData(Agent a) {
            super(a);
        }

        @Override
        public void action() {
//            System.out.println("checkForSensorData");
            ACLMessage msg = receive();
            if (msg != null) {
                sender = msg.getSender().getLocalName();
                message = msg.getContent();
            } else {
                block();
            }
        }

    }

    class decisionAgent extends SimpleBehaviour {

        private boolean finished = false;
        XMLToObject xmlObject = new XMLToObject();
        XMLMessage xmlMessage = xmlObject.createObject(sender);

        public decisionAgent(Agent a) {
            super(a);
        }

        @Override
        public void action() {

            getSensorName();
            getSensorType();
            getSensorMessage();
            returnDecision();
            done();
            block();
        }

        @Override
        public boolean done() {
            return finished;
        }

        private void getSensorName() {
            System.out.println("AgentName: " + xmlMessage.getAgentName());
        }

        private void getSensorType() {
            System.out.println("AgentType: " + xmlMessage.getAgentType());
        }

        private void getSensorMessage() {
            System.out.println("AgentType: " + xmlMessage.getAgentMessage());
        }

        private void returnDecision() {
            System.out.println("Decision: ");
        }

    }
}
