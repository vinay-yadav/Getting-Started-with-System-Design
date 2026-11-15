package DesignPatterns.Factory;

public class IOS extends Platform {
    public UIComponentFactory createUIComponentFactory() {
        return new IOSUIComponentFactory();
    }
}
