import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class AutoClicker {

   public static int rate = 0;
   public static int clicks = 0;
   public static int amount = 0;
   public static void main(String[] args) throws InterruptedException {
      while (rate == 0 && amount == 0) {
         try {
            System.out.println("Speed of the auto-clicker (in miliseconds):");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            try {
               rate = Integer.parseInt(in.readLine());
               System.out.println("Amount of clicks:");
               amount = Integer.parseInt(in.readLine());
               
            } catch (NumberFormatException ex) {
               System.out.println("Error - please try again.");
            }
         } catch (IOException e) {}
      }
      try {
         Robot robot = new Robot();
         while (clicks < amount) {
            robot.delay(rate);
               robot.mousePress(InputEvent.BUTTON1_MASK);
               robot.mouseRelease(InputEvent.BUTTON1_MASK);
               clicks++;
         }
      } catch (AWTException e) {}
   }

}