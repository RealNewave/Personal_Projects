/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadeproject.xml;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Hans
 */
public class XMLToObject {

    public XMLMessage createObject(String agentName) {
        XMLMessage xmlMessage = new XMLMessage();
        try {
            System.out.println("agentName = " + agentName);
            File file = new File("C:\\Users\\Hans\\Documents\\NetBeansProjects\\JadeProject\\"+agentName+".xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(XMLMessage.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            xmlMessage = (XMLMessage) jaxbUnmarshaller.unmarshal(file);
            return xmlMessage;

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        xmlMessage.setNullObject();//if failed, all info is set to failed
        return xmlMessage;

    }

}
