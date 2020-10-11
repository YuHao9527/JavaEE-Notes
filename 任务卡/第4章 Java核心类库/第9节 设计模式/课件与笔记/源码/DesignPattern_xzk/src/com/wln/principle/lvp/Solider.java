package com.wln.principle.lvp;
//士兵：使用枪支
public class Solider {
    //士兵使用的枪
    private AbstacTGun gun;
    //通过set方法给士兵配枪
    public void setGun(AbstacTGun gun) {
        this.gun = gun;
    }
    public void killEnemy(){
        System.out.println("士兵杀敌：");
        gun.shoot();
    }
}
