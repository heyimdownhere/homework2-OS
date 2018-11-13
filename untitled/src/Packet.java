
public class Packet {

    public int serviceTime = 0;
    public double turnaroundTime = 0;
    public double startTime = 0;
    public double waitTime = 0;

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
        return turnaroundTime + "";
    }
}
