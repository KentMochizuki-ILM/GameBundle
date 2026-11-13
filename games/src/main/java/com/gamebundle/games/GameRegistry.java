package com.gamebundle.games;

import com.gamebundle.api.GameInterface;

import java.util.List;

public final class GameRegistry {

    // ユーティリティクラス（継承禁止、インスタンス化禁止）
    private GameRegistry() {
        throw new UnsupportedOperationException("Utility class");
    }

    /*
     * GameInterfaceで形式を指定
     * List.ofで不変リストを返す（外部から編集されないため）
     */
    public static List<GameInterface> createGameList() {
        // ここにゲームを追加
        return List.of(
                new HighLow());
    }
}
