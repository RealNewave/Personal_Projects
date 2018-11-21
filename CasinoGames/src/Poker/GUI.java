///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Poker;
//
//import java.util.ArrayList;
//import javafx.application.Application;
//import javafx.event.ActionEvent;
//
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.FlowPane;
//
//import javafx.stage.Stage;
//
///**
// *
// * @author Hans
// */
//
//public class GUI extends Application {
//
//    Controller controller = new Controller();
//
//    @Override
//    public void start(Stage primaryStage) {
//        FlowPane root = new FlowPane();
//        Button fold = new Button("Fold");
////        fold.setLayoutX(150);
////        fold.setLayoutY(200);
//        Button call = new Button("Call");
////        fold.setLayoutX(200);
////        fold.setLayoutY(200);
//        Button raise = new Button("Raise");
////        fold.setLayoutX(250);
////        fold.setLayoutY(200);
//        Button start = new Button("Start");
//        fold.setOnAction((ActionEvent event) -> {
//            controller.setEvent("fold");
//            System.out.println("pressed fold");
//        });
//
//        call.setOnAction((ActionEvent event) -> {
//            controller.setEvent("call");
//            System.out.println("pressed call");
//        });
//        raise.setOnAction((ActionEvent event) -> {
//            controller.setEvent("raise");
//            System.out.println("pressed raise");
//        });
//
//        start.setOnAction((ActionEvent event) -> {
//            start.setVisible(false);
//            initialize();
//        });
//
//        root.getChildren().addAll(fold, call, raise, start);
//
//        Scene scene = new Scene(root, 300, 300);
//
//        primaryStage.setTitle("Poker");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//
//    }
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    private void initialize() {
//        ArrayList<Player> players = new ArrayList<>();
//        char name = '1';
//        for (int i = 0; i < 9; i++) {
//            Player p = new Player();
//            p.nickName = "player " + name;
//            name++;
//            p.chipAmount = 500;
//            p.isFolded = false;
//            players.add(p);
//        }
//        Game game = Game.getInstance();
//        Deck deck = new Deck();
//        HandRanking ranking = new HandRanking();
//        game.runGame(players, deck, ranking);
//    }
//
//}
