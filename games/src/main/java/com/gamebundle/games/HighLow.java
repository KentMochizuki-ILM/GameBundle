package com.gamebundle.games;

import com.gamebundle.api.GameInterface;
import com.gamebundle.api.ConsoleInput;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class HighLow implements GameInterface {
    // HighLowゲーム固有の数値
    private static final int DECK_SIZE = 13;
    private static final int CHOICE_HIGH = 1;
    private static final int CHOICE_LOW = 2;

    // ゲーム名
    @Override
    public String getTitle() {
        return "HighLowゲーム";
    }

    // ゲーム内容
    @Override
    public void start(ConsoleInput input) {
        int countWin = 0;

        System.out.println("\nHighLowゲームを開始します\n");

        // デッキを用意
        List<Integer> deck = createShuffleDeck();

        // デッキが尽きるまで勝負
        for (int i = 0; i < deck.size() - 1; i++) {
            int currentCard = deck.get(i);
            int nextCard = deck.get(i + 1);
            int remainingNumber = deck.size() - (i + 1);
            String promptMessage = """
                    次のカードは%dより高い？低い？
                    （高い: %d/低い: %d）==>\
                    """.formatted(currentCard, CHOICE_HIGH, CHOICE_LOW);

            printTableInfo(currentCard, remainingNumber, countWin);

            int choice = input.promptInputInt(promptMessage, CHOICE_HIGH, CHOICE_LOW);

            if (checkWin(choice, currentCard, nextCard)) {
                System.out.println("-- WIN! --\n");
                countWin++;
            } else {
                System.out.println("-- LOSE... --\n");
            }
        }

        // リザルト
        System.out.println("勝利数は" + countWin + "でした！");

        System.out.println("メニューに戻ります\n");
    }

    // シャッフルされたデッキ（1〜13）を作成
    private List<Integer> createShuffleDeck() {
        List<Integer> deck = new ArrayList<>();

        for (int i = 0; i < DECK_SIZE; i++) {
            deck.add(i + 1);
        }

        Collections.shuffle(deck);
        return deck;
    }

    private void printTableInfo(int currentCard, int reminingNumber, int countWin) {
        System.out.printf("現在のカード:%2d / 残りのカード枚数:%2d枚 / 勝利数%2d\n", currentCard, reminingNumber, countWin);
    }

    private boolean checkWin(int choice, int currentCard, int nextCard) {
        // ユーザの入力を整数化
        return switch (choice) {
            case CHOICE_HIGH -> currentCard < nextCard;
            case CHOICE_LOW -> currentCard > nextCard;
            default -> false;

        };
    }
}
