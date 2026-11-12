package com.gamebundle.api;

public final class InputValidator {

    // ただのツールなので継承禁止（final）、インスタンス化禁止（throw）
    private InputValidator() {
        throw new UnsupportedOperationException("Utility class");
    }

    // 検証結果を保持するrecord
    // nullも扱えるIntegerを使用
    public record ValidationResult(boolean isValid, Integer value, String errorMessage) {
        // 入力チェックをパスした場合数値を返す
        public static ValidationResult success(int value) {
            return new ValidationResult(true, value, null);
        }

        // 入力チェックで弾かれた場合エラー文を返す
        public static ValidationResult failure(String errorMessage) {
            return new ValidationResult(false, null, errorMessage);
        }

    }

    // 入力文字列を検証し範囲内の整数であるか確認
    public static ValidationResult validateInteger(String input, int min, int max) {

        // 最大最小が逆になっってたら止める
        if (min > max) {
            throw new IllegalArgumentException("min (%d) must not be greater than max (%d)".formatted(min, max));
        }
        // 空欄ならエラー文を返す
        if (input == null || input.isBlank()) {
            return ValidationResult.failure("\n入力が空です、数字を入力してください\n");
        }

        try {
            // 文字列を整数化
            int value = Integer.parseInt(input.trim());

            // 正しい範囲内なら数値を返す、そうでないならエラー文を返す
            if (value <= max && value >= min) {
                return ValidationResult.success(value);
            } else {
                return ValidationResult.failure(String.format("\n%d~%dの範囲で入力してください\n", min, max));
            }
        } catch (NumberFormatException e) {
            // 整数でなければエラー
            return ValidationResult.failure("\n数字を入力してください\n");
        }
    }
}
