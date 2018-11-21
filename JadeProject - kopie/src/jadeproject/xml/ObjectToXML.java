/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadeproject.xml;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Hans
 */
public class ObjectToXML {
    
    private XMLMessage agent;
    
    public ObjectToXML(XMLMessage agent) {
        this.agent = agent;
    
    }
    
    public String createXML() {

        String xmlString = "";
        File file = new File("C:\\Users\\Hans\\Documents\\NetBeansProjects\\JadeProject\\"+agent.getAgentName()+".xml");
        try {
            
            JAXBContext jaxbContext = JAXBContext.newInstance(XMLMessage.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            
            jaxbMarshaller.marshal(agent, file);
            xmlString = fileToString(file.getAbsolutePath());
            
        } catch (JAXBException e) {

        } catch (IOException ex) {
            Logger.getLogger(ObjectToXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return xmlString;
    }

    private String fileToString(String filePath) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        return contentBuilder.toString();
    }

}
