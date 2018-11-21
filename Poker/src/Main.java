import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Hans on 30-10-2015.
 */
public class Main {

    static ArrayList<String> kaartDeck;
    static String[] speler1;
    static String[] speler2;
    static int aantalGedeeldeKaarten = 0;
    int kaartPick = 0;
    public static void main (String[] args){

       maakDeck();
       schudDeck();
       deelKaarten();
       startSpel();
    }
    public static void startSpel(){
        int maxRuilen = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Uw kaarten zijn:");
        for(String kaart : speler1) {
            System.out.print(kaart + ", ");
        }
        System.out.println("Wilt u een kaart ruilen? y/n");
        String antwoord = sc.next();
        while(!antwoord.equals("y") && !antwoord.equals("n")){
            System.out.println("U kunt alleen y/n invullen");
            System.out.println("Wilt u een kaart ruilen? y/n");
            antwoord = sc.next();
        }
        while(antwoord.equals("y")){
            System.out.println("Welke kaart wilt u ruilen?");
            int ruilen = sc.nextInt()- 1;
            speler1[ruilen] = String.valueOf(5);
            maxRuilen++;
            System.out.println("Wilt u een kaart ruilen? y/n");
            antwoord = sc.next();
            if(maxRuilen == 5){
                break;
            }
        if(antwoord.equals("n") || maxRuilen == 5){
            deelKaarten();
            }
        }

    }
    public static void deelKaarten(){
    speler1 = new String[5];
    speler2 = new String[5];



        for(int i = 0;i < 5  ; i++) {
            speler1[i] = kaartDeck.get(i);

        }
        for(int i = 5; i < 10; i++) {
            speler2[i-5] = kaartDeck.get(i);
        }
    }


    private static void schudDeck(){
        Collections.shuffle(kaartDeck);

    }
    private static void maakDeck(){
        String[] kaartKleur = {"Harten", "Schoppen", "Klaveren", "Ruiten"};
        String[] kaartNummer = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        kaartDeck = new ArrayList<>();
        for(int i = 0; i <4; i++){
            for(int j = 0; j < 13; j++){
                kaartDeck.add(kaartKleur[i] +" "+ kaartNummer[j]);
            }
        }
    }
}
