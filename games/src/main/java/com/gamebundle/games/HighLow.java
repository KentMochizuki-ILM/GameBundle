package com.gamebundle.games;

import com.gamebundle.api.GameInterface;
import com.gamebundle.api.InputValidator;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HighLow implements GameInterface {

    // ゲーム名と実行内容をオーバーライド
    @Override
    public String getTitle() {
        return "HighLowゲーム";
    }

    @Override
    public void start() {
        int countWin = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nHighLowゲームを開始します\n");

        // デッキを用意
        List<Integer> deck = createShuffleDeck();

        for (int i = 0; i < deck.size() - 1; i++) {
            int currentCard = deck.get(i);
            int nextCard = deck.get(i + 1);
            int turn = i + 1;

            tableInfo(currentCard, turn, countWin);

            System.out.printf("\n次のカードは%dより高い？低い？\n（高い: 1/低い: 2）==>", currentCard);

            while (true) {
                String input = scanner.nextLine();

                if (InputValidator.isValidInteger(input, deck.size(), 1)) {

                    Boolean isWin = checkWin(input, currentCard, nextCard);

                    if (isWin) {
                        System.out.println("-- WIN! --\n");
                        countWin++;
                    } else {
                        System.out.println("-- LOSE... --\n");
                    }

                    break;
                } else {
                    continue;
                }
            }
        }

        // リザルト
        System.out.println("勝利数は" + countWin + "でした！");

        System.out.println("メニューに戻ります\n");
    }

    // シャッフルされたデッキ（1〜13）を作成
    private List<Integer> createShuffleDeck() {
        List<Integer> deck = new ArrayList<>();

        for (int i = 0; i < 13; i++) {
            deck.add(i + 1);
        }

        Collections.shuffle(deck);
        return deck;
    }

    private void tableInfo(int currentCard, int turn, int countWin) {
        int deckSize = 13;
        System.out.printf("現在のカード:%2d / 残りのカード枚数:%2d枚 / 勝利数%2d\n", currentCard, deckSize - turn, countWin);
    }

    private Boolean checkWin(String input, int currentCard, int nextCard) {
        // ユーザの入力を整数化
        int answer = Integer.parseInt(input);

        return switch (answer) {
            case 1 -> currentCard < nextCard;
            case 2 -> currentCard > nextCard;
            default -> false;

        };
    }
}
