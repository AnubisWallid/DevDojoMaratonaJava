package RDatas;

import java.time.LocalTime;

public class localTimeTest01 {
    public static void main(String[] args) {
        LocalTime localTime = LocalTime.of(12,30,59);
        System.out.println(localTime.isAfter(LocalTime.now()));
        System.out.println(LocalTime.MIN);
    }
}
