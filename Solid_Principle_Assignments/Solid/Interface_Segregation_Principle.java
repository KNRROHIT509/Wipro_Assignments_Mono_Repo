package com.Solid;

interface Callable {
    void call();
}

interface InternetEnabled {
    void internet();
}

interface CameraEnabled {
    void photo();
}

class ButtonPhone implements Callable {

    @Override
    public void call() {
        System.out.println("Supports call");
    }
}

class SmartPhone implements Callable, InternetEnabled, CameraEnabled {

    @Override
    public void call() {
        System.out.println("Supports call");
    }

    @Override
    public void internet() {
        System.out.println("Supports internet browsing");
    }

    @Override
    public void photo() {
        System.out.println("Supports taking photos");
    }
}

public class Interface_Segregation_Principle {

    public static void main(String[] args) {
        Callable buttonPhone = new ButtonPhone();
        System.out.println("Button phone supports only:");
        buttonPhone.call();
        System.out.println();
        SmartPhone smartPhone = new SmartPhone();
        System.out.println("Smart phone supports:");
        smartPhone.call();
        smartPhone.internet();
        smartPhone.photo();
    }
}
