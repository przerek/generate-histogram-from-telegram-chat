package com.company;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {












        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Szerokosc przedzialu [ w minutach, domyślnie 5m ]: ");

        int duration = 5;
        String userInputduration = input.readLine();


        if (!"".equals(userInputduration.trim())) {
            try {
                duration = Integer.parseInt(userInputduration);
            } catch (NumberFormatException nfe) {
            }
        }


        System.out.println("Podzialka co [ w godzinach, domyślnie 1h ]:  ");

        int interval = 1;
        String userInputinterval = input.readLine();


        if (!"".equals(userInputinterval.trim())) {
            try {
                duration = Integer.parseInt(userInputinterval);
            } catch (NumberFormatException nfe) {
            }
        }








        Histogram histogram = new Histogram();
        JSONFile jsonFile = new JSONFile("histogram.html");


        jsonFile.read();
        jsonFile.parseJSON();
        histogram.fillData(jsonFile.makeOutputListOfPeopleWithData(), duration, interval);

    }
}