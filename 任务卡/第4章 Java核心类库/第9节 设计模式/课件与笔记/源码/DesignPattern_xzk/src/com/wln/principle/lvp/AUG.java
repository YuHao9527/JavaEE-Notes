package com.wln.principle.lvp;
//AUG狙击步枪
public class AUG extends Rifle{
    //狙击枪都携带了精准的望远镜
    public void zoomOut(){
        System.out.println("通过望远镜观察敌人：");
    }

    @Override
    public void shoot() {
        System.out.println("AUG射击-----------");
    }
}
