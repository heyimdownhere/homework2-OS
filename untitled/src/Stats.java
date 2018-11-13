import java.util.ArrayList;

public class Stats {

    public static ArrayList<Double> serviceTimes = new ArrayList<Double>();
    public static ArrayList<Double> turnaroundTimes = new ArrayList<Double>();
    public static ArrayList<Double> waitTimes = new ArrayList<Double>();

    public void Stats() {
    }

    public void addServiceTime(double time) {
        serviceTimes.add(time);
    }

    public double getAvgServiceTime() {
        double average = 0;
        for (double num: serviceTimes) {
            average += num;
        }
        average = average/serviceTimes.size();
        return average;
    }

    public void addTurnaroundTime(double time) {
        turnaroundTimes.add(time);
    }

    public double getAvgTurnaroundTime() {
        double average = 0;
        for (double num: turnaroundTimes) {
            average += num;
        }
        average = average/turnaroundTimes.size();
        return average;
    }

    public void addWaitTimes(double time) {
        waitTimes.add(time);
    }

    public double getAvgWaitTime() {
        double average = 0;
        for (double num: waitTimes) {
            average += num;
        }
        average = average/waitTimes.size();
        return average;
    }


}
