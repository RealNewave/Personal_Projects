/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcamstream;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Hans
 */
public class WebcamStream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Webcam webcam = Webcam.getDefault();
        webcam.setViewSize(new Dimension(640, 480));
        
        WebcamPanel webcamPanel = new WebcamPanel(webcam);
        webcamPanel.setFPSLimit(30.0);
        
        
        JFrame frame = new JFrame();
        frame.add(webcamPanel);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

}
