package DesignPatterns.Factory;

public class UIFactory {
    public static final String ANDROID = "Android";
    public static final String IOS = "IOS";

    public static UIComponentFactory getUIComponentFactory(String platform) {
        if (platform.equals(ANDROID)) {
            return new AndroidUIComponentFactory();
        }
        else if (platform.equals(IOS)) {
            return new IOSUIComponentFactory();
        }

        return null;
    }
}
