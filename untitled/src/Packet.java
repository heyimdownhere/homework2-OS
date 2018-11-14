import java.util.ArrayList;

public class Packet {

    public double serviceTime = 0;
    public double turnaroundTime = 0;
    public double startTime = 0;
    public double waitTime = 0;

    public static ArrayList<Double> serviceTimes = new ArrayList<Double>();
    public static ArrayList<Double> turnaroundTimes = new ArrayList<Double>();
    public static ArrayList<Double> waitTimes = new ArrayList<Double>();


    public Packet (int time) {
        serviceTime = time;
        startTime();
    }

    public void startTime() {
        startTime = System.currentTimeMillis();
    }

    public void endTime() {
        turnaroundTime = System.currentTimeMillis() - startTime;
    }

    public void waitTime() {
        waitTime = turnaroundTime - serviceTime;
    }

    @Override
    public String toString() {
        if(turnaroundTime == 0) {
            endTime();
            waitTime();
        }
        //add current stats to stats list
        addStats();
        return turnaroundTime + "";
    }

    private void addStats() {
        waitTimes.add(waitTime);
        turnaroundTimes.add(turnaroundTime);
        serviceTimes.add(serviceTime);
    }
}
