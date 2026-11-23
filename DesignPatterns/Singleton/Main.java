package DesignPatterns.Singleton;

public class Main {
    public static void main(String[] args) {
        System.out.println("Singleton Implementation");

        Singleton s1 = Singleton.getinstance();
        Singleton s2 = Singleton.getinstance();

        System.out.println("Are both objects same: " + (s1 == s2 ? "Yes" : "No"));
    }
}
