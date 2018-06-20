package logger.weight.model;

public class Weight {

    private int id;     //id number of entry
    private String name; //short name of entry
    private double weight; // weight to log
    private String description; //long description of entry
    private String date;

    public Weight(int id, String name, double weight, String description, String date) {// missing date in constructor
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.description = description;
        this.date= date;
    }

    public String getDate() { return date; }

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
