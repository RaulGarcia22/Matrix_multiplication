package org.example;

import java.io.IOException;

public class Main {
        public static void main(String[] args) throws IOException {
            long startTime, endTime;
            try {
                startTime = System.currentTimeMillis();
                Controller.controller();
                endTime = System.currentTimeMillis();
                long elapsedTime = endTime - startTime;
                System.out.println(elapsedTime + " miliseconds.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
