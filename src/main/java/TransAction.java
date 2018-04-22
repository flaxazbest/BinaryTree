import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 * Created by vsevoloddoroshenko on 4/7/18.
 */

public class TransAction {
    private long time;
    private static final Random rnd = new Random();

    public TransAction(long n) {
        time = n;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int compareTo(TransAction tt){
        if (this.time > tt.getTime()) return 1;
        if (this.time < tt.getTime()) return -1;
        return 0;
    }

    public TransAction() {
//        time = System.currentTimeMillis();
        time = rnd.nextLong()%10;
    }
}
