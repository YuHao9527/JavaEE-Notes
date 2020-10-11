package com.wln.principle.ocp;
//扩展的子类
public class OffNovelBook extends NovelBook{

    public OffNovelBook(String name, int price, String author) {
        super(name, price, author);
    }

    @Override
    public int getPrice() {
        int sellPrice=super.getPrice();
        int offPrice=0;
        if(sellPrice>7000){
            offPrice=sellPrice*90/100;
        }else{
            offPrice=sellPrice*80/100;
        }
        return offPrice;
    }
}
