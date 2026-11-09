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

        //メインタイトル表示
        System.out.print("""
                ---------------------
                ミニゲームコレクション
                ---------------------
                """);

        while(true) {
            StringBuilder gameTitles = new StringBuilder();

            int selectNumber = 1;
            //ゲームタイトルを表示
            for(GameInterface game: games){
                gameTitles.append("   |%d:   %-20s\n".formatted(selectNumber, game.getTitle()));
                selectNumber ++;
            }
            System.out.println(gameTitles.toString());

            System.out.print("""
                    遊びたいゲームの番号を入力してください
                    終了する場合は0を入力してください
                    ==>""");

            //まず文字列として入力を受け取る
            String input = scanner.nextLine();
            try {
                //ユーザの入力を整数化
                int choice = Integer.parseInt(input);

                if(choice == 0){
                    System.out.println("システムを終了します");
                    break;
                }else if(choice > 0 && choice <= games.size()) {
                    GameInterface selectedGame = games.get(choice - 1);
                    selectedGame.start();
                }else {
                    System.out.println("1から" + games.size() + "の範囲で入力してください");
                }
            }catch(NumberFormatException e) {
                System.out.println("数字を入力してください");
            }
        }


    }
}
