/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitchclips;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Hans
 */
public class GetUrlFromApi {
//rmhcllwfnzcw9j784os5hptq7geqo0
    public String getURLs(int gameId) throws MalformedURLException, IOException, URISyntaxException {
        StringBuilder result = new StringBuilder();
//        game = game.replace(" ", "%20");
//        game = game.replace(":", "%3A");
//        URL url = new URL("https://api.twitch.tv/helix/games?name=" + game);
        URL url = new URL("https://api.twitch.tv/helix/clips?game_id=" + gameId);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Client-ID", "wpw2f4qz4ynrr3c1w9qdanqlcjivzy");
//        conn.setRequestProperty("Accept", "application/vnd.twitchtv.v5+json");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return (result.toString());
    }

    public void getVideos(String game, int number, String videoURL) throws FileNotFoundException, IOException, InterruptedException {

        String correctURL = getOnlyVideoURL(videoURL);
        BufferedInputStream in = null;
        FileOutputStream fout = null;
        game = game.replace(":",""); 
        try {
            in = new BufferedInputStream(new URL(getFinalLocation(correctURL)).openStream());
            fout = new FileOutputStream("D:\\Videos\\AutoDownloadedClips\\" + game + "\\" + number + ".mp4");

            byte data[] = new byte[1024];
            int count;
            while ((count = in.read(data, 0, 1024)) != -1) {
                fout.write(data, 0, count);
            }

        } finally {
            if (in != null) {
                in.close();
            }
            if (fout != null) {
                fout.close();
            }
        }
    }

    private String getOnlyVideoURL(String siteURL) throws InterruptedException {
        try {
            URL url = new URL(siteURL);
            URLConnection conn = url.openConnection();
            TimeUnit.SECONDS.sleep(3);
            // open the stream and put it into BufferedReader
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));

            String inputLine = "";
            while ((inputLine = br.readLine()) != null) {
                System.out.println(inputLine);
                Pattern pattern = Pattern.compile("https:(.*?).mp4");
                Matcher matcher = pattern.matcher(inputLine);
                if (matcher.find()) {
                    System.out.println("Matcher:" + matcher.group(0));

                    return matcher.group(0);
                }

            }

            br.close();
            return null;

        } catch (MalformedURLException e) {

        } catch (IOException e) {

        }
        return null;
    }

    private String getFinalLocation(String address) throws IOException {
        URL url = new URL(address);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        int status = conn.getResponseCode();
        if (status != HttpURLConnection.HTTP_OK) {
            if (status == HttpURLConnection.HTTP_MOVED_TEMP
                    || status == HttpURLConnection.HTTP_MOVED_PERM
                    || status == HttpURLConnection.HTTP_SEE_OTHER) {
                String newLocation = conn.getHeaderField("Location");
                return getFinalLocation(newLocation);
            }
        }
        return address;
    }
}
