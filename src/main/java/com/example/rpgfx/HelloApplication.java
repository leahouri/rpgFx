package com.example.rpgfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class HelloApplication extends Application {

    public static void main(String[] args){
        String num = choixParser();
        Game game;

        if(num.equals("1")){
            game = new Game();
            InputParser inputParser = new ConsoleParser(game);
            game.setInputParser(inputParser);
            game.start();
        }else{
            launch();
        }


    }

    public static String choixParser(){
        InputParser inputParser = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bonjour voulez vous lancer le jeu en mode console (1) ou en mode interface graphique (2) ?");
        String str = scanner.nextLine();

        while(!str.equals("1") && !str.equals("2")){
            System.out.println("L'entree que vous avez effectué est incorrecte veuillez entrer (1) pour lance le jeu"+
                    " en mode console, et (2) pour le lancer en mode interface graphique");
            str = scanner.nextLine();
        }

        return str;
    }


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

}