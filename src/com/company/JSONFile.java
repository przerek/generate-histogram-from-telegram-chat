package com.company;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JSONFile {

    public JSONFile(String name) {
        this.name = name;
    }

    String name;
    String text;
    List<Message> records = new ArrayList<Message>();

    public String read() {

        try {
            String data = "";
            File myObj = new File("result.json");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine())
                data += myReader.nextLine();

            myReader.close();
            return text = data;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return String.valueOf(e);
        }
    }

    public void parseJSON() {

        String jsonString = this.text;
        JSONObject obj = new JSONObject(jsonString);

        JSONArray arr = obj.getJSONArray("messages");
        for (int i = 0; i < arr.length(); i++) {
            try {
                if (arr.getJSONObject(i).getJSONArray("text").getJSONObject(0).getString("type").equals("hashtag"))
                    if (arr.getJSONObject(i).getJSONArray("text").getJSONObject(0).getString("text").equals("#in"))
                        records.add(new Message(arr.getJSONObject(i).getString("date").substring(0, 10), arr.getJSONObject(i).getString("date").substring(11, 16), arr.getJSONObject(i).getString("from"), "in"));
                    else if (arr.getJSONObject(i).getJSONArray("text").getJSONObject(0).getString("text").equals("#out"))
                        records.add(new Message(arr.getJSONObject(i).getString("date").substring(0, 10), arr.getJSONObject(i).getString("date").substring(11, 16), arr.getJSONObject(i).getString("from"), "out"));
            } catch (JSONException e) {

            }
        }
    }

    public List<Person> makeOutputListOfPeopleWithData() {

        List<Person> listOfPeople = new ArrayList<>();

        for (Message str : this.records) {
            boolean isPerson = false;
            for (Person prs : listOfPeople)
                if (prs.getPersonName().equals(str.getPerson()))
                    isPerson = true;

            if (!isPerson) {
                Person person = new Person();
                if (str.getMessage().equals("in"))
                    listOfPeople.add(person.insertHourIn(str.getPerson(), str.getHour()));
                else if (str.getMessage().equals("out"))
                    listOfPeople.add(person.insertHourOut(str.getPerson(), str.getHour()));
            } else {
                if (str.getMessage().equals("in"))
                    listOfPeople.stream().filter(f -> f.personName.equals(str.getPerson())).forEach(person -> person.setHourIn(str.getHour()));
                else if (str.getMessage().equals("out"))
                    listOfPeople.stream().filter(f -> f.personName.equals(str.getPerson())).forEach(person -> person.setHourOut(str.getHour()));
            }

        }
        return listOfPeople;
    }


}