package com.fareye.training.service;

public class singleton3 {
    private static volatile singleton3 instatance;

    private  singleton3(){}

    public static singleton3 getInstance() {

        singleton3 result = instatance;
        if (result == null) {
            synchronized (singleton3.class) {
                result = instatance;
                if (instatance == null) {
                    instatance = new singleton3();
                }
            }
        }
        return result;
    }

}
