/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package directorychecker;

import java.io.File;

/**
 *
 * @author Hans
 */
public class DirectoryChecker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String rootFolder = "C:\\apache-maven-3.5.0";
        File file = new File(rootFolder);
        String[] names = file.list();

        for (String name : names) {

            File subFile = new File(rootFolder + "\\" + name);
            String[] subNames = subFile.list();
            System.out.println("name: " + rootFolder + "\\" + name);
            for (String subName : subNames) {
                File subSubFile = new File(rootFolder + "\\" + name);
                String[] subSubNames = subSubFile.list();
                System.out.println("subName: " + rootFolder + "\\" + name + "\\" + subName);
                for(String subSubName: subSubNames){
                    System.out.println("subSubName: " + rootFolder + "\\" + name + "\\" + subName+ "\\" + subSubName);
                }
            }
        }
    }

}
