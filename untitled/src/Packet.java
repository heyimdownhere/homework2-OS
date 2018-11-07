import java.time.*;

public class Packet {

    public int serviceTime = 0;
    public double waitTime = 0;
    public double startTime = 0;

    public Packet (int time) {
        serviceTime = time;
    }

    public void startTime() {
        startTime = System.currentTimeMillis();
    }

    public void endTime() {
        waitTime = startTime- System.currentTimeMillis();
    }

}
