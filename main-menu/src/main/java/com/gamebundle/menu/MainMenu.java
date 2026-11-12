package com.gamebundle.menu;

import com.gamebundle.games.GameRegistry;
import com.gamebundle.api.GameInterface;
import com.gamebundle.api.InputValidator;

import java.util.List;
import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        // ゲームリストの作成
        List<GameInterface> games = GameRegistry.createGameList();
        Scanner scanner = new Scanner(System.in);

        // メインタイトル表示
        System.out.print("""
                ---------------------
                ミニゲームコレクション
                ---------------------
                """);

        while (true) {
            // メニューを表示
            printMenu(games);

            // まず文字列として入力を受け取る
            String input = scanner.nextLine();

            // 入力をチェク
            if (InputValidator.isValidInteger(input, games.size(), 0)) {
                // 指定されたシステム実行
                Boolean shouldExit = handleMenuInput(input, games);

                // 0ならシステム終了
                if (shouldExit) {
                    break;
                }
            }
        }
    }

    // メニュー表示機能
    private static void printMenu(List<GameInterface> games) {
        StringBuilder gameTitles = new StringBuilder();

        // タイトルを表示
        for (int i = 0; i < games.size(); i++) {
            GameInterface game = games.get(i);
            gameTitles.append("   |%d:   %-20s\n".formatted(i + 1, game.getTitle()));
        }
        System.out.println(gameTitles.toString());

        System.out.print("""
                遊びたいゲームの番号を入力してください
                終了する場合は0を入力してください
                ==>""");
    }

    // システム実行機能
    private static Boolean handleMenuInput(String input, List<GameInterface> games) {
        // ユーザの入力を整数化
        int choice = Integer.parseInt(input);

        if (choice == 0) {
            // 0ならシステム終了
            System.out.println("\nシステムを終了します");
            return true;
        } else {
            // ゲームプログラム実行
            GameInterface selectedGame = games.get(choice - 1);
            selectedGame.start();
        }

        return false;
    }
}
