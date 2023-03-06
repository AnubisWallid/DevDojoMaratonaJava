package RDatas;

import java.time.Duration;
import java.time.LocalDateTime;

public class DurationTest01 {
    public static void main(String[] args) {
        LocalDateTime localDateTime01 = LocalDateTime.now();
        LocalDateTime localDateTime02 = LocalDateTime.of(1993,10,29,21,30);
        Duration d1 = Duration.between(localDateTime02,localDateTime01);
        System.out.println(d1.toDays()/365);
    }
}
