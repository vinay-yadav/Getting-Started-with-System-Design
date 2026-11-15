package DesignPatterns.Factory;

import DesignPatterns.Factory.components.button.Button;

public class Client {
    public static final String ANDROID = "Android";
    public static final String IOS = "IOS";

    public static void main(String[] args) {
        Platform p = new Platform();
        UIComponentFactory uiComponentFactory = p.createUIComponentFactory(IOS);
        Button b = uiComponentFactory.createButton();
        b.getSize();
    }
}
