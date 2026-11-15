package DesignPatterns.Factory;

import DesignPatterns.Factory.components.button.Button;
import DesignPatterns.Factory.components.dropdown.DropDown;
import DesignPatterns.Factory.components.menu.Menu;

public interface UIComponentFactory {
    public Button createButton();
    public Menu creatMenu();
    public DropDown createDropDown();
}
