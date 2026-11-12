package com.gamebundle.api;

//ゲームの共通の型を定義
public interface GameInterface {

    // ゲームの名前の取得と実行機能（scannerを渡してて依存性注入）
    String getTitle();

    void start(ConsoleInput input);
}
