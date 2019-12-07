package com.dianer.study.设计模式.模版模式;

public class BasketballGame extends GameTemplate {
    @Override
    void initialize() {
        System.out.println("Basketball Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Basketball Game Started. Enjoy the game!");
    }

    @Override
    void endPlay() {
        System.out.println("Basketball Game Finished!");
    }
}
