package com.MixedNotSure;
//**************************************
//CHANGE CLASS NAME BEFORE RUNNING THIS
//**************************************
//JavaCalendargetFirstDayOfWeekExample1.java

import java.util.Calendar;
class JavaCalendargetFirstDayOfWeekExample1 {
public static void main(String[] args)
{
Calendar calobj = Calendar.getInstance();
System.out.println("first day of current week:"+calobj.getFirstDayOfWeek());

calobj.add(Calendar.YEAR, 1);
calobj.add(Calendar.MONTH, 2);
calobj.add(Calendar.DAY_OF_WEEK, 1);
System.out.println("If date is  " + calobj.getTime() +"then first day of week is  "
+ calobj.getFirstDayOfWeek());

calobj.setFirstDayOfWeek(Calendar.TUESDAY);
System.out.println("now first day of week :" + calobj.getFirstDayOfWeek());
}
}


/* Java DayOfWeek Example: plus()

import java.time.*;  
public class DayOfWeekExample3 {  
  public static void main(String[] args) {  
    LocalDate date = LocalDate.of(2017, Month.JANUARY, 31);  
    DayOfWeek day = DayOfWeek.from(date);  
    System.out.println(day.getValue());  
    day = day.plus(3);  
    System.out.println(day.getValue());  
  }  
}  
 */
 
 
/* Java DayOfWeek Example: of()

import java.time.DayOfWeek;  
public class DayOfWeekExample2 {  
  public static void main(String[] args) {  
    DayOfWeek day = DayOfWeek.of(5);  
    System.out.println(day.name());  
    System.out.println(day.ordinal());  
    System.out.println(day.getValue());  
  }  
}
 */

