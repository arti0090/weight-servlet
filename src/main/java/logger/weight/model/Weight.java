package logger.weight.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Weight {

    private int id;     //id number of entry
    private String name; //short name of entry
    private double weight; // weight to log
    private String description; //long description of entry
    private String date;

    public Weight(int id, String name, double weight, String description) {// missing date in constructor
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.description = description;
    }

    //public Date getDate() {
      //  return date;
   // }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public String getDescription() {
        return description;
    }


    @Override
    public String toString() {
        return "Weight{" +
                    "id= " + id +
                    "name= " + name +
                    "weight= "  + weight +
                    "description= " + description +
                    "date= " + date +
        '}';
    }
}
