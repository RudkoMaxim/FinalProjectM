package org.example.utils;

public class Waiters {
    public static void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {

        }
    }
}
