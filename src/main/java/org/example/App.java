package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        //Exercise 1: Create a LocalDate of the current day and print it out
        LocalDate today= LocalDate.now();
        System.out.println(LocalDate.now());
        //Create a LocalDate of the current day and print it out in the following pattern using DateTimeFormatter: Torsdag 29 mars

        System.out.println(today.format(DateTimeFormatter.ofPattern("eeee dd MMM YYYY")));

        //Create a LocalDate of last Monday. Then print out the entire week in a loop using standard ISO format.
        LocalDate _lastMonday = today.minus(Period.ofDays(7));   // creating the last Monday's date mechanism
        System.out.println(_lastMonday);
        LocalDate firstDay = _lastMonday;
        LocalDate lastDay = LocalDate.now();
        for(LocalDate date=firstDay;date.isBefore(lastDay);date=date.plusDays(1)){
            System.out.println("Date is " + date+ " and the day is "+ date.getDayOfWeek());
        }


//Exercise 4: Create a LocalDate object from a String by using the .parse() method.

        LocalDate date= LocalDate.parse("2020-06-01");
        System.out.println(date);

//Exercise5 The date time api provides enums for time units such as day and month.
// Create a LocalDate of 194505-08 and extract the day of week for that date.

LocalDate _day1945 = LocalDate.parse("1945-05-08");
        System.out.println(_day1945.getDayOfWeek());
//Exercise6 Create a LocalDate of current date plus 10 years and minus 10 months. From that date extract the month and print it out.

        LocalDate current = LocalDate.now();

        System.out.println(current.plusYears(10).minusMonths(10).getMonth());  // after 10 years and from that year MINUS 10 months -> AUGUST

//Exercise7 Using the LocalDate from exercise 6 and your birthdate, create a Period between your birthdate and the date from exercise 5.
// Print out the elapsed years, months and days.
        System.out.println(_day1945.minusYears(1945).getMonth());
        Period diff=Period.between(_day1945,today);

        System.out.println("Years "+ diff.getYears()+ " Months "+ diff.getMonths()+" Days "+ diff.getDays());

//Exercise 8 Create a period of 4 years, 7 months and 29 days.
// Then create a LocalDate of current date and add the period you created to the current date.

//Period _4yrs7Mon29Days = Period.between(current,current.plusYears(4).plusMonths(7).plusDays(29)); Can also be done as
Period _4yrs7Mon29Days = Period.of(4,7,29);

LocalDate currentDate= LocalDate.now();

LocalDate required= currentDate.plus(_4yrs7Mon29Days);

System.out.println(required);
//Exercise 9 Create a LocalTime object of the current time.

        LocalDateTime localTime = LocalDateTime.now();
        System.out.println(localTime);
//Exercise 10 Extract the nanoseconds of a LocalTime object of current time. Print out the nanoseconds.

        System.out.println(localTime.getNano());  // Nano seconds are 6490000000

//Exercise 11 Create a LocalTime object from a String using the .parse() method.
       /* String stringTime = "06-45-20";
        LocalTime timeObject= LocalTime.parse(stringTime);
        System.out.println(timeObject);
        System.out.println(timeObject);*/
//Extra assignment Create your own calendar for the year 2018.

//getCalendar(2018).forEach(System.out::println);

    }



public static List<LocalDate> getCalendar(int year){
    List<LocalDate> yeardays = new ArrayList<>();

    LocalDate firstday= LocalDate.ofYearDay(year,2);
    LocalDate lastday = LocalDate.ofYearDay(year+1,1);

//firstday.getDayOfWeek();

    for(LocalDate cdate=firstday;cdate.isBefore(lastday);cdate=cdate.plusDays(1)){
        yeardays.add(cdate);
        System.out.println(yeardays);
    }
    return yeardays;
}
}
/*Exercise 1: Create a LocalDate of the current day and print it out

Exercise2: Create a LocalDate of the current day and print it out in the following pattern using DateTimeFormatter: Torsdag 29 mars.

Exercise3: Create a LocalDate of last Monday. Then print out the entire week in a loop using standard ISO format.

Exercise 4: Create a LocalDate object from a String by using the .parse() method.

Exercise5 The date time api provides enums for time units such as day and month. Create a LocalDate of 194505-08 and extract the day of week for that date.

Exercise6 Create a LocalDate of current date plus 10 years and minus 10 months. From that date extract the month and print it out.

Exercise7 Using the LocalDate from exercise 6 and your birthdate, create a Period between your birthdate and the date from exercise 5. Print out the elapsed years, months and days.

Exercise 8 Create a period of 4 years, 7 months and 29 days. Then create a LocalDate of current date and add the period you created to the current date.

Exercise 9 Create a LocalTime object of the current time.

Exercise 10 Extract the nanoseconds of a LocalTime object of current time. Print out the nanoseconds.

Exercise 11 Create a LocalTime object from a String using the .parse() method.

Exercise 12 Using DateTimeFormatter format LocalTime from current time and print it out as following pattern: 10:32:53

Exercise 13 Create a LocalDateTime with the date and time components as: date: 2018-04-05, time: 10.00.

Exercise 14 Using DateTimeFormatter format the LocalDateTime object from exercise 11 to a String that should look tile this: torsdag 5 april 10:00
Exercise 15 Create a LocalDateTime object by combining LocalDate object and LocalTime object.

Exercise 16 Create a LocalDateTime object. Then get the LocalDate and LocalTime components into separate objects of respective types from the LocalDateTime object.

Extra assignment Create your own calendar for the year 2018. */