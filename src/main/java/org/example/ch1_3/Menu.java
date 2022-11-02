package org.example.ch1_3;

import java.util.List;

public class Menu {

    private List<MenuItem> menuItems;
    public  Menu(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public MenuItem choose(String name) {
        return this.menuItems.stream()
                .filter(menuItem -> menuItem.matches(name))
                .findFirst()
                .orElseThrow(() ->  new IllegalArgumentException("잘못된 메뉴입니다."));
    }
}
