package com.wln.dp.proxy;

public class Client {
    public static void main(String[] args) {
        //定义一个玩家
        IGamePlayer player=new GamePlayer("宋仲基");
        //代练
        IGamePlayer proxyPlayer=new GamePlayerProxy(player);
        //打游戏
        System.out.println("开始时间：2020-2-2 13:00");
        player.login("songsong", "123456");
        player.killBoss();
        player.upgrade();
        System.out.println("结束时间：2020-2-2 23:00");
    }
}
