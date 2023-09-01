package First;

public class Test {
    public static void main(String[] args) {
        MyTime time = new MyTime();
        time.setMyTime(12,59,0, true);
        time.display12(time);
        time.tickByMinute();
        time.display12(time);
        System.out.println(time);
    }
}
