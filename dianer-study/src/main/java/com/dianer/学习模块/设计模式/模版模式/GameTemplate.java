package com.dianer.学习模块.设计模式.模版模式;

public abstract class GameTemplate {

    abstract void initialize();

    abstract void startPlay();

    abstract void endPlay();

    // 模板
    public final void play() {

        // 初始化游戏
        initialize();
        // 开始游戏
        startPlay();
        // 结束游戏
        endPlay();
    }
}
