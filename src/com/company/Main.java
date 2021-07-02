package com.company;


public class Main {

    public static void main(String[] args) {

        Config config = Config.getInstance();
        Histogram histogram = new Histogram();
        JSONFile jsonFile = new JSONFile(config.getOutput_file());


        jsonFile.read();
        jsonFile.parseJSON();
        histogram.fillData(jsonFile.makeOutputListOfPeopleWithData(), config.getDuration(), config.getInterval());

    }
}