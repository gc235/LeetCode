package space.worldhu.practice;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        String startDate = now.plusDays(1).toString();
        String s = now.plusYears(1).toString();
        System.out.println(startDate);
        System.out.println(s);
    }
}
