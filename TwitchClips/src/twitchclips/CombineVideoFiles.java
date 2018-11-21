/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitchclips;

import java.io.IOException;

/**
 *
 * @author Hans
 */
public class CombineVideoFiles {

    public void combineVideos(String game) throws IOException, InterruptedException {
        game = game.replace(":","");        
        Process p = Runtime.getRuntime().exec("cmd /c d: && cd D:\\Videos\\AutoDownloadedClips\\"+game+" && start combine.bat");
        p.waitFor();
    }
}
