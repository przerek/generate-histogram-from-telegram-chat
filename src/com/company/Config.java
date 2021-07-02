package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Config {

    double interval;
    int duration;
    String input_file;
    String output_file;

    public double getInterval() {
        return interval;
    }

    static Config config = new Config();

    public static Config getInstance() {
        return config;
    }

    public int getDuration() {
        return duration;
    }

    public String getInput_file() {
        return input_file;
    }

    public String getOutput_file() {
        return output_file;
    }

    private String readConfigFile() {

        try {
            String data = "";
            File myObj = new File("config.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine())
                data += myReader.nextLine();
            myReader.close();
            return data;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return String.valueOf(e);
        }
    }

    private Config() {
        String input = readConfigFile();

        Pattern pattern1 = Pattern.compile("interval=(.+?);", Pattern.DOTALL);
        Pattern pattern2 = Pattern.compile("duration=(.+?);", Pattern.DOTALL);
        Pattern pattern3 = Pattern.compile("input_file=(.+?);", Pattern.DOTALL);
        Pattern pattern4 = Pattern.compile("output_file=(.+?);", Pattern.DOTALL);

        Matcher matcher1 = pattern1.matcher(input);
        matcher1.find();

        Matcher matcher2 = pattern2.matcher(input);
        matcher2.find();

        Matcher matcher3 = pattern3.matcher(input);
        matcher3.find();

        Matcher matcher4 = pattern4.matcher(input);
        matcher4.find();

        this.interval = Double.parseDouble(matcher1.group(1));
        this.duration = Integer.parseInt(matcher2.group(1));
        this.input_file = matcher3.group(1);
        this.output_file = matcher4.group(1);

    }


}
