/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Hans
 */
public class WebScraper {
//http://ge.jupath.me/GranadoEspadaEUR-CharacterJobs.html

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        URL url;

        try {
            // get URL content
            System.setProperty("http.agent", "Chrome");
            String site = "http://ge.jupath.me/GranadoEspadaEUR-CharacterJobs.html";
            url = new URL(site);
            URLConnection conn = url.openConnection();

            // open the stream and put it into BufferedReader
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));

            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                System.out.println(inputLine);
            }
            br.close();

            System.out.println("Done");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
