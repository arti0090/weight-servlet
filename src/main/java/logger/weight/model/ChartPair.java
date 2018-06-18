package logger.weight.model;

public class ChartPair {

    private String x;
    private double value;

    public ChartPair(String x, double value) {
        this.x = x;
        this.value = value;
    }

    public String getX() {
        return x;
    }

    public double getValue() {
        return value;
    }
}
