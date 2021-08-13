package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Histogram {
    HTMLContent htmlContent = new HTMLContent();

    public void writeToFile(String zawartosc) {

        try {
            FileWriter myWriter = new FileWriter("histogram.html");
            myWriter.write(zawartosc);
            myWriter.close();
            System.out.println("Zapisano pomyślnie.");
        } catch (IOException e) {
            System.out.println("Wystąpił błąd.");
            e.printStackTrace();
        }
    }

    public int hourToMunutes(String hour) {
        return Integer.parseInt(hour.substring(0, 2)) * 60 + Integer.parseInt(hour.substring(3, 5));
    }

    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    public void fillData(List<Person> listOfPeople, int duration, double interval) {
        int numberOfChart = 0;
        int numberOfIntervals = 1440 / duration;
        String output_in = "";
        String output_out = "";

        for (Person prs : listOfPeople) {

            int[] in = new int[numberOfIntervals];
            int[] out = new int[numberOfIntervals];

            for (String str_in : prs.getHourIn()) {
                for (int i = 0; i <= numberOfIntervals - 1; i++) {
                    if (hourToMunutes(str_in) >= (i * duration) && hourToMunutes(str_in) < ((i + 1) * duration))
                        in[i]++;
                }
            }

            for (String str_out : prs.getHourOut()) {
                for (int i = 0; i <= numberOfIntervals - 1; i++) {
                    if (hourToMunutes(str_out) >= (i * duration) && hourToMunutes(str_out) < ((i + 1) * duration))
                        out[i]++;
                }
            }

            output_in += htmlContent.section_a1 + "visitorsOptionsIn" + numberOfChart + htmlContent.section_a2 + prs.getPersonName() + " #in" + htmlContent.section_a3v1 + interval + htmlContent.section_a3v2v1 + htmlContent.colorin + htmlContent.section_a3v2v2;
            for (int i = 0; i <= numberOfIntervals - 1; i++)
                output_in += "{ x: " + roundAvoid((i / (60 / (duration * 1.0))) + (duration / 120.0), 2) + ", y: " + in[i] + "},\n";
            output_in += htmlContent.section_a4;

            output_out += htmlContent.section_a1 + "visitorsOptionsOut" + numberOfChart + htmlContent.section_a2 + prs.getPersonName() + " #out" + htmlContent.section_a3v1 + interval + htmlContent.section_a3v2v1 + htmlContent.colorout + htmlContent.section_a3v2v2;
            for (int i = 0; i <= numberOfIntervals - 1; i++)
                output_out += "{ x: " + roundAvoid((i / (60 / (duration * 1.0))) + (duration / 120.0), 2) + ", y: " + out[i] + "},\n";
            output_out += htmlContent.section_a4;

            numberOfChart++;
        }

        writeToFile(generatePage(output_in, output_out, numberOfChart));

    }

    public String generatePage(String arraysOfData_in, String arraysOfData_out, int liczba_wykresow) {

        String section_b = "";
        for (int i = 0; i < liczba_wykresow; i++)
            section_b += "  charts.push(new CanvasJS.Chart(\"visitorsOptionsIn" + i + "\", visitorsOptionsIn" + i + "));\n" +
                    "       charts.push(new CanvasJS.Chart(\"visitorsOptionsOut" + i + "\", visitorsOptionsOut" + i + "));\n";

        String section_d = "";
        for (int i = 0; i < liczba_wykresow; i++)
            section_d += "<div id=\"visitorsOptionsIn" + i + "\" style=\"height: 370px; width: 100%;\"></div>" +
                    "<br>" +
                    "<br>" +
                    "<br>" +
                    "<br>" +
                    "<br>" +
                    "<br>" +
                    "<br>" +
                    "<br>\n" +
                    "<div id=\"visitorsOptionsOut" + i + "\" style=\"height: 370px; width: 100%;\"></div>" +
                    "<br>" +
                    "<br>" +
                    "<br>" +
                    "<br>" +
                    "<br>" +
                    "<br>" +
                    "<br>" +
                    "<hr>" +
                    "<br>" +
                    "<br>" +
                    "<br>" +
                    "<br>" +
                    "<br>" +
                    "<br>" +
                    "<br>" +
                    "<br>\n";

        String section_e = "<script src=\"https://canvasjs.com/assets/script/canvasjs.min.js\"></script>\n" +
                "</body>\n" +
                "</html>";

        return htmlContent.section_a + arraysOfData_in + arraysOfData_out + section_b + htmlContent.section_c + section_d + section_e;
    }

}
