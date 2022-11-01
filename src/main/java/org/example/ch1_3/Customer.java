package org.example.ch1_3;

public class Customer {

    public void order(String menuName, Menu menu, Cooking cooking) {
        MenuItem menuItem = menu.choose(menuName);
        cooking.makeCook(menuItem);
    }
}
