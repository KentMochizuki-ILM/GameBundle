package com.gamebundle.menu;

import com.gamebundle.games.GameRegistry;
import com.gamebundle.api.GameInterface;
import com.gamebundle.api.ConsoleInput;

import java.util.List;
import java.util.Scanner;

public class MainMenu {
    private static final int QUIT_OPTION = 0;

    public static void main(String[] args) {
        // ゲームリストの作成
        List<GameInterface> games = GameRegistry.createGameList();

        // ConsoleInputにscannerを渡す
        Scanner scanner = new Scanner(System.in);
        ConsoleInput input = new ConsoleInput(scanner);
        String promptMessage = """
                遊びたいゲームの番号を入力してください
                終了する場合は0を入力してください
                ==>""";

        // メインタイトル表示
        System.out.print("""
                ---------------------
                ミニゲームコレクション
                ---------------------
                """);
        while (true) {
            printMenu(games);

            int choice = input.promptInputInt(promptMessage, QUIT_OPTION, games.size());

            boolean shouldQuit = handleMenuInput(choice, games, input);

            if (shouldQuit) {
                break;
            }
        }
    }

    // ゲームタイトル表示機能
    private static void printMenu(List<GameInterface> games) {
        StringBuilder gameTitles = new StringBuilder();

        for (int i = 0; i < games.size(); i++) {
            GameInterface game = games.get(i);
            gameTitles.append("   |%d:   %-20s\n".formatted(i + 1, game.getTitle()));
        }
        System.out.println(gameTitles.toString());

    }

    // システム実行機能
    private static boolean handleMenuInput(int choice, List<GameInterface> games, ConsoleInput input) {
        if (choice == QUIT_OPTION) {
            // 0（終了）ならゲームを実行せずtrueを返す
            System.out.println("\nシステムを終了します");
            return true;
        } else {
            // ゲーム実行
            GameInterface selectedGame = games.get(choice - 1);
            selectedGame.start(input);
        }

        return false;
    }
}
