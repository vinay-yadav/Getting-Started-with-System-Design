package DesignPatterns.Factory;

import DesignPatterns.Factory.components.button.AndroidButton;
import DesignPatterns.Factory.components.button.Button;
import DesignPatterns.Factory.components.dropdown.AndroidDropDown;
import DesignPatterns.Factory.components.dropdown.DropDown;
import DesignPatterns.Factory.components.menu.AndroidMenu;
import DesignPatterns.Factory.components.menu.Menu;

public class AndroidUIComponentFactory implements UIComponentFactory {
    @Override
    public DropDown createDropDown() {
        return new AndroidDropDown();
    }

    @Override
    public Button createButton() {
        return new AndroidButton();
    }

    @Override
    public Menu creatMenu() {
        return new AndroidMenu();
    }
}
