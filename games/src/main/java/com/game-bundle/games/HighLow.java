package com.gamebundle.games;

import com.gamebundle.api.GameInterface;

public class HighLow implements GameInterface {

    //ゲーム名と実行内容をオーバーライド
    @Override
    public String getGameName() {
        return "HighLowゲーム";
    }

    @Override
    public void start() {
        System.out.println("HighLowゲーム（仮）が呼び出されました");
    }
}
