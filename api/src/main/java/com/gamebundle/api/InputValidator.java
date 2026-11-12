package com.gamebundle.api;

public class InputValidator {

    // 範囲内の整数であるか確認
    public static Boolean isValidInteger(String input, int max, int min) {

        // 空欄ならエラー
        if (input == null || input.trim().isEmpty()) {
            return false;
        }

        try {
            // 範囲内の整数でなければエラー
            int value = Integer.parseInt(input.trim());

            if (value <= max && value >= min) {
                return true;
            } else {
                System.out.printf("%d~%dの範囲で入力してください\n\n", min, max);
                return false;
            }
        } catch (NumberFormatException e) {
            // 整数でなければエラー
            System.out.println("数字を入力してください\n");
            return false;
        }
    }
}
