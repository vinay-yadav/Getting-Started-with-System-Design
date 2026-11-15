package DesignPatterns.Factory.components.button;

public class IOSButton implements Button {
    @Override
    public void getSize() {
        System.out.println("IOS Button Size");
    }
    
}
