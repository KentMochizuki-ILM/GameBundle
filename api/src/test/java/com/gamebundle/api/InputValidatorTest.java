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
        var result = InputValidator.validateInteger("5", 1, 10);

        assertTrue(result.isValid());
        assertEquals(5, result.value());
        assertNull(result.errorMessage());
    }
}
