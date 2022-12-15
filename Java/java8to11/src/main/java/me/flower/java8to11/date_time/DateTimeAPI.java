package me.flower.java8to11.date_time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateTimeAPI {

    public static void main(String[] args) {

        Instant instant = Instant.now();
        System.out.println(instant);  //기준시 UTC, GMT
        System.out.println(instant.atZone(ZoneId.of("UTC")));

        ZoneId zone = ZoneId.systemDefault();
        System.out.println(zone);
        ZonedDateTime zonedDateTime = instant.atZone(zone);
        System.out.println(zonedDateTime);

        System.out.println("============================================================");

        //현재 시스템 zone 정보를 참고해서 시간 가져옴
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime.of(1982, Month.JULY, 15, 0, 0, 0);
        //특정 zone의 현재 시간을 보고 싶다면
        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(nowInKorea);

        //Instant 를 사용해도 가능
        Instant nowInstant = Instant.now();
        ZonedDateTime zonedDateTime1 = nowInstant.atZone(ZoneId.of("Asia/Seoul"));
        System.out.println(zonedDateTime1);

        System.out.println("============================================================");

        LocalDate today = LocalDate.now();
        LocalDate thisYearBirthday = LocalDate.of(2022, Month.DECEMBER, 25);

        Period period = Period.between(today, thisYearBirthday);
        System.out.println(period.getDays());

        Period until = today.until(thisYearBirthday);
        System.out.println(period.get(ChronoUnit.DAYS));

        //Duration은 Instant(머신용 시간)를 가지고 비교
        Instant now2 = Instant.now();
        Instant plus = now2.plus(10, ChronoUnit.SECONDS);
        Duration between = Duration.between(now2, plus);
        System.out.println(between.getSeconds());


        //포매팅
        LocalDateTime now3 = LocalDateTime.now();
        DateTimeFormatter MMddyyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(now.format(MMddyyyy ));
        //미리 정의해둔 포맷 사용
        System.out.println(now3.format(DateTimeFormatter.BASIC_ISO_DATE));
        //파싱
        LocalDate parse = LocalDate.parse("07/15/1982", MMddyyyy);
        System.out.println(parse);

        //레거시 API지원
        Date date3 = new Date();
        Instant instant1 = date3.toInstant();
        Date newDate = Date.from(instant1);

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        LocalDateTime dateTime = gregorianCalendar.toInstant()
                .atZone(ZoneId.systemDefault()).toLocalDateTime();
        ZonedDateTime zonedDateTime2 = gregorianCalendar.toInstant()
                .atZone(ZoneId.systemDefault());
        GregorianCalendar from = GregorianCalendar.from(zonedDateTime2);

        //TimeZone이 예전꺼
        ZoneId zoneId = TimeZone.getTimeZone("PST").toZoneId();
        TimeZone timeZone = TimeZone.getTimeZone(zoneId);


    }
}
