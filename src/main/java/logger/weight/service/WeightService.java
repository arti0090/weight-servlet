package logger.weight.service;

import logger.weight.model.Weight;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class WeightService {

    public static final String DATE_FORMAT_NOW = "yyyy-MM-dd";
    public static final Weight UNKNOW_WEIGHT = new Weight(-1,"Unknown Weight",0.0,"","");
    public static int CURRENT_INDEX = 1;
    private static List<Weight> WEIGHTS = new ArrayList<>();

    static{
        //int id, String name, double weight, String description, String date

        WEIGHTS.add(new Weight(CURRENT_INDEX++,"weight-1",90.0,"description-1","19-06-2018"));
        WEIGHTS.add(new Weight(CURRENT_INDEX++,"weight-2",80.0,"description-2","20-06-2018"));
    }


    public Weight findOne(int id) {
        return WEIGHTS
                .stream()
                .filter(weight -> weight.getId() == id)
                .findFirst()
                .orElse(UNKNOW_WEIGHT);
    }

    public List<Weight> findAll(){ return WEIGHTS; }

    public void add(Weight weight) {
        WEIGHTS.add(weight);
    }

    public void remove(Integer idToRemove) {
        WEIGHTS =WEIGHTS.stream()
                .filter(weight -> weight.getId() != idToRemove)
                .collect(Collectors.toList());
    }

//    public String formatDate(String date) {
//        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
//        String sdate = sdf.format(date);
//        return sdate;
//    }

}
