package com.gamebundle.api;

import java.util.Scanner;

public class ConsoleInput {
    // コンストラクタ
    private final Scanner scanner;

    public ConsoleInput(Scanner scanner) {
        this.scanner = scanner;
    }

    // 指定された範囲の数字が入力されるまで再入力を求める
    public int promptInputInt(String promptMessage, int min, int max) {
        while (true) {
            System.out.print(promptMessage);
            String input = scanner.nextLine();
            var result = InputValidator.validateInteger(input, min, max);

            if (result.isValid()) {
                return result.value();
            }
            System.out.println(result.errorMessage());
            System.out.println("再入力してください");
        }
    }
}
