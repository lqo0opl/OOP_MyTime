package Time;

public class Main {
    public static void main(String[] args) {
        Time time = new Time();
        time.setMyTime(12,59,0, true);
        time.display12(time);
        time.tickByMinute();
        time.display12(time);
        time.tickByHour();
        System.out.println(time);
    }
}