import java.util.ArrayList;

public class Packet {

    public double serviceTime = 0;
    public double realServiceTime = 0;
    public double turnaroundTime = 0;
    public double startTime = 0;
    public double waitTime = 0;
    public static double maxServiceTime = 0;
    public static double maxTurnaroundTime = 0;
    public static double maxWaitTime = 0;
    public static double avgServiceTime = 0;
    public static double avgTurnaroundTime = 0;
    public static double avgWaitTime = 0;
    public static double totalServiceTime = 0;

    public static ArrayList<Double> serviceTimes = new ArrayList<Double>();
    public static ArrayList<Double> turnaroundTimes = new ArrayList<Double>();
    public static ArrayList<Double> waitTimes = new ArrayList<Double>();


    public Packet (int time) {
        serviceTime = time;
        startTime();
    }

    public void startTime() { startTime = System.currentTimeMillis(); }

    public void endTime() {
        turnaroundTime = System.currentTimeMillis() - startTime;
    }

    public void waitTime() {
        waitTime = turnaroundTime - (realServiceTime);
    }

    public void startRealServiceTime() {
        realServiceTime = System.currentTimeMillis();
    }

    public void setRealServiceTime() {
        realServiceTime = System.currentTimeMillis() - realServiceTime;
    }

    @Override
    public String toString() {
        setRealServiceTime();
        if(turnaroundTime == 0) {
            endTime();
            waitTime();
        }
        //add current stats to stats list
        addStats();
        getMax();
        return turnaroundTime + " wait time: " + waitTime + "ms";
    }

    //set max after every packet
    private void getMax() {
        if (serviceTime > maxServiceTime) {
            maxServiceTime = realServiceTime;
        }
        if(waitTime > maxWaitTime) {
            maxWaitTime = waitTime;
        }
        if(turnaroundTime > maxTurnaroundTime) {
            maxTurnaroundTime = turnaroundTime;
        }
    }

    private void addStats() {
        waitTimes.add(waitTime);
        turnaroundTimes.add(turnaroundTime);
        serviceTimes.add(realServiceTime);
        totalServiceTime += realServiceTime;
    }

    public void getAverages() {
        for(double num: waitTimes) {
            avgWaitTime += num;
        }
        avgWaitTime = avgWaitTime / waitTimes.size();

        for(double num: turnaroundTimes) {
            avgTurnaroundTime += num;
        }
        avgTurnaroundTime = avgTurnaroundTime / turnaroundTimes.size();

        for(double num: serviceTimes) {
            avgServiceTime += num;
        }
        avgServiceTime = avgServiceTime / serviceTimes.size();
    }


}
