package com.gamebundle.menu;

import com.gamebundle.menu.GameResistry;
import com.gamebundle.api.GameInterface;

import java.util.List;
import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        //ゲームリストの作成
        List<GameInterface> games = GameResistry.createGameList();
        Scanner scanner = new Scanner(System.in);
        int selectNumber;
        StringBuilder gameTitles = new StringBuilder();

        //メインタイトル表示
        System.out.println("""
                ---------------------
                ミニゲームコレクション
                ---------------------
                """);

        while(true){
            selectNumber = 1;
            //ゲームタイトルを表示
            for(GameInterface game: games){
                gameTitles.append("   |%d:   %-20s\n".formatted(selectNumber, game.getTitle()));
                selectNumber ++;
            }

            System.out.println(gameTitles.toString());

            break;
        }


    }
}
