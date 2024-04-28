package com.example.foodcalender.Domain;

import com.example.foodcalender.Domain.Menu;

import java.util.ArrayList;
import java.util.List;

public class Utils_Menu {
    public static List<Menu> loadMenuData() {
        List<Menu> llMenuList = new ArrayList<>();
        llMenuList.add(new Menu("منوی اول"));
        llMenuList.add(new Menu("منوی دوم"));
        llMenuList.add(new Menu("منوی سوم"));
        return llMenuList;
    }
}
