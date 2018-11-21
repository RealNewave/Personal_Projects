/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitchclips;

import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.*;
/**
 *
 * @author Hans
 */
public class TwitchClips {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.InterruptedException
     * @throws java.net.MalformedURLException
     * @throws java.net.URISyntaxException
     */
    public static void main(String[] args) throws IOException, InterruptedException, MalformedURLException, URISyntaxException, JSONException {

        ArrayList<Integer> games = new ArrayList<>();
        games.add(460630);
//        games.add("Tom Clancy's Rainbow Six: Siege");
//        games.add("League of Legends");
//        games.add("Fortnite");
//        games.add("PLAYERUNKNOWN'S BATTLEGROUNDS");
//        games.add("Hearthstone");
//        games.add("Overwatch");
//        games.add("Dota 2");

        for (int s : games) {
            int i = 1;
            GetUrlFromApi gufa = new GetUrlFromApi();
            String jsonString = gufa.getURLs(s);
            ObjectMapper mapper = new ObjectMapper();
            JSONObject obj = new JSONObject(jsonString);
            JSONArray data = obj.getJSONArray(("data"));
            for(int j = 0; j < data.length(); j++){
                gufa.getVideos("Tom Clancy's Rainbow Six: Siege", j, data.getJSONObject(j).getString("url"));
            }
//            for (Clip c : jsonObject.getClips()) {
////            String displayName = c.getBroadcaster().getDisplayName();
////            String channelUrl = c.getBroadcaster().getChannelUrl();
//                String videoUrl = c.getUrl();
//                try {
//                    gufa.getVideos("Tom Clancy's Rainbow Six: Siege", "" + i, videoUrl);
//                } catch (IOException ex) {
//                    Logger.getLogger(TwitchClips.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                i++;
//            }
//            CombineVideoFiles cvf = new CombineVideoFiles();
//            cvf.combineVideos("Tom Clancy's Rainbow Six: Siege");
        }
    }
}
