package com.wln.principle.lvp;

import java.util.HashMap;
import java.util.Map;

public class LSP1 {
    //当子类实现父类的抽象方法时，方法的后置条件要比父类更严格
    abstract class Parent{
        public abstract Map fun();
    }
    class Sub extends Parent{
        @Override
        public HashMap fun(){
            HashMap map=new HashMap();
           map.put("b", "子类被执行");
           return map;
        }
    }

    public static void main(String[] args) {
        LSP1 lsp1=new LSP1();
        Parent a=lsp1.new Sub();
        System.out.println( a.fun());

    }
}
