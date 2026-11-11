package com.gamebundle.menu;

import com.gamebundle.api.GameInterface;
import com.gamebundle.games.HighLow;
//仮置きのゲーム
//import com.gamebundle.games.ExampleGame;

import java.util.ArrayList;
import java.util.List;

public class GameRegistry {
    //GameInterfaceで形式を指定
    public static List<GameInterface> createGameList() {
        //ArrayListでListの中身を生成
        List<GameInterface> games = new ArrayList<>();

        //ゲームをListに追加
        games.add(new HighLow());
        //games.add(new ExampleGame_2());

        return games;
    }
}
