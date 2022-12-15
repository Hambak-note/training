package me.flower.java8to11.date_time;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class App {

    public static void main(String[] args) throws InterruptedException {
        //예전 것들
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat dateFormat = new SimpleDateFormat();

        //date(날짜)에서 시간(getTIme)을 가져 온다고?
        long time = date.getTime();
        System.out.println(date);
        System.out.println(time);

        Thread.sleep(1000 * 3);
        Date after3Seconds = new Date();
        System.out.println(after3Seconds);
        //3초 이전의 값으로 인스턴스 변경 가능 = mutable 함
        after3Seconds.setTime(time);
        System.out.println(after3Seconds);

        //숫자로 month를 사용하면 0부터 시작한다는 것을 알아야 함. (애매)
        Calendar birthDay = new GregorianCalendar(1991, 2, 5);
        Calendar birthDay2 = new GregorianCalendar(1991, Calendar.MARCH, 5);

        System.out.println(birthDay.getTime());
        birthDay.add(Calendar.DAY_OF_YEAR, 1);
        System.out.println(birthDay.getTime());

        LocalDate dateOfBirth = LocalDate.of(1991, 2, 5);
        LocalDate firstBirthday = dateOfBirth.plusYears(1);

        //기계용 시간
        Date machineDate = new Date();
        long machineTime = machineDate.getTime();
        System.out.println(machineTime);


    }
}
