package com.example.foodcalender.Domain;

import java.io.Serializable;

public class FoodDomain implements Serializable {
    private String title;
    private int pic;
    private String time2;

    //private int numberInCart;

    public FoodDomain(String title, int pic,String time2) {
        this.title = title;
        this.pic = pic;
        this.time2 = time2;
    }

//    public FoodDomain(String title, String pic, String description, String time1,String time2, int numberInCart) {
//        this.title = title;
//        this.pic = pic;
//        this.description = description;
//        this.time1 = time1;
//        this.time2 = time2;
//        //this.numberInCart = numberInCart;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }




    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    //    public int getNumberInCart() {
//        return numberInCart;
//    }
//
//    public void setNumberInCart(int numberInCart) {
//        this.numberInCart = numberInCart;
//    }
}
