package DesignPatterns.Factory;

public class Platform {
    public void setRefreshRate() {
        System.out.println("REFRESH RATE UPDATED");
    }

    public void setTheme() {
        System.out.println("THEME UPDATED");
    }

    public UIComponentFactory createUIComponentFactory() {
        return null;
    }

    public UIComponentFactory createUIComponentFactory(String platform) {
        return UIFactory.getUIComponentFactory(platform);
    }
}
