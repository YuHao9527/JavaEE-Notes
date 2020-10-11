package com.wln.dp.proxy;

public class GamePlayer implements  IGamePlayer {

    private String petName="";

    public GamePlayer(String petName) {
        this.petName = petName;
    }

    @Override
    public void login(String username, String password) {
        System.out.println("登录账号："+username+",昵称："+petName+"登录成功！！！");
    }

    @Override
    public void killBoss() {
        System.out.println("打怪ing-----------");
    }

    @Override
    public void upgrade() {
        System.out.println(this.petName+"又升级了---------撒花庆祝-------------");
    }
}
