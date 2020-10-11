package com.wln.dp.proxy;

public class GamePlayerProxy implements IGamePlayer{

    private IGamePlayer player=null;

    public GamePlayerProxy(IGamePlayer player) {
        this.player = player;
    }

    @Override
    public void login(String username, String password) {
        this.player.login(username, password);
    }

    @Override
    public void killBoss() {
        this.player.killBoss();
    }

    @Override
    public void upgrade() {
        this.player.upgrade();
    }
}
