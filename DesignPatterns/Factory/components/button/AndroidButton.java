package DesignPatterns.Factory.components.button;

public class AndroidButton implements Button {
    @Override
    public void getSize() {
        System.out.println("Android Button Size");
    }
    
}
