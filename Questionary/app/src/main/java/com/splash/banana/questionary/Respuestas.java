package com.splash.banana.questionary;

import java.io.Serializable;

/**
 * Created by fernando on 6/11/16.
 */

public class Respuestas implements Serializable{

    private static boolean p1;
    private static boolean p2;
    private static boolean p3;

    public Respuestas() {
        this.p1=false;
        this.p2=false;
        this.p3=false;
    }

    public static void setP1(boolean p1) {
        this.p1 = p1;
    }

    public static void setP2(boolean p2) {
        this.p2 = p2;
    }

    public static void setP3(boolean p3) {
        this.p3 = p3;
    }

    public static boolean getP1() {
        return p1;
    }

    public static boolean getP2() {
        return p2;
    }

    public static boolean getP3() {
        return p3;
    }

    @Override
    public String toString() {
        return "Respuestas{" +
                "Pregunta 1=" + p1 +
                ", Pregunta 2=" + p2 +
                ", Pregunta 3=" + p3 +
                '}';
    }
}
