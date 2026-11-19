package com.gamebundle.api;

//説明文をつける
import org.junit.jupiter.api.DisplayName;
//テスト用の処理@Test
import org.junit.jupiter.api.Test;

//パラメータ化テスト用
//複数パターンでテスト@ParameterizedTest
import org.junit.jupiter.params.ParameterizedTest;
//nullと空白入力をテストケースに用意
import org.junit.jupiter.params.provider.NullAndEmptySource;
//テストしたい入力値を配列で用意
import org.junit.jupiter.params.provider.ValueSource;

//結果判定メソッド
//スタティックインポート（クラス名を省略できる）
import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {
    // テストメソッドの命名規則:検証するメソッド名_条件_期待する結果

    @Test
    @DisplayName("範囲内の有効な数字が入力されればtrueと数値を返すエラーメッセージはnull")
    void validateInteger_validNumber_returnSuccess() {
        // 入力範囲1~10の代表値として5を入力
        var result = InputValidator.validateInteger("5", 1, 10);

        assertAll(
                () -> assertTrue(result.isValid()),
                () -> assertEquals(5, result.value()),
                () -> assertNull(result.errorMessage()));
    }

    @Test
    @DisplayName("有効な境界値が正しく許容される")
    void validateInteger_validBoundary_returnSuccess() {
        var minResult = InputValidator.validateInteger("1", 1, 10);
        var maxResult = InputValidator.validateInteger("10", 1, 10);

        assertAll(
                // 最小値の場合
                () -> assertTrue(minResult.isValid()),
                () -> assertEquals(1, minResult.value()),
                () -> assertNull(minResult.errorMessage()),
                // 最大値の場合
                () -> assertTrue(maxResult.isValid()),
                () -> assertEquals(10, maxResult.value()),
                () -> assertNull(maxResult.errorMessage()));
    }

    @Test
    @DisplayName("前後空白月の文字がトリムされて正しく許容される")
    void validateInteger_withWhitespace_returnSuccess() {
        var result = InputValidator.validateInteger(" 5 ", 1, 10);

        assertAll(
                () -> assertTrue(result.isValid()),
                () -> assertEquals(5, result.value()),
                () -> assertNull(result.errorMessage()));
    }
}
