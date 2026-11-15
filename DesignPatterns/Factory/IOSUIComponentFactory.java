package DesignPatterns.Factory;

import DesignPatterns.Factory.components.button.Button;
import DesignPatterns.Factory.components.button.IOSButton;
import DesignPatterns.Factory.components.dropdown.DropDown;
import DesignPatterns.Factory.components.dropdown.IOSDropDown;
import DesignPatterns.Factory.components.menu.IOSMenu;
import DesignPatterns.Factory.components.menu.Menu;

public class IOSUIComponentFactory implements UIComponentFactory {
    @Override
    public DropDown createDropDown() {
        return new IOSDropDown();
    }

    @Override
    public Menu creatMenu() {
        return new IOSMenu();
    }

    @Override
    public Button createButton() {
        return new IOSButton();
    }
}
