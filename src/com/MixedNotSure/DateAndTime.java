
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateAndTime {
        public static void main(String[] args) throws ParseException {

            Calendar calndr = Calendar.getInstance();
            //System.out.println("The Current Date is: "+ calndr.get(Calendar.DATE));
            System.out.println("First time Current Time is : "+ calndr.getTime());
/*
            //*************************************************** for day name like sunday printing
            Date now = new Date();
            SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE"); // the day of the week abbreviated
            System.out.println(simpleDateformat.format(now));
            calndr.setTime(now);
            System.out.println(calndr.get(calndr.DAY_OF_WEEK));*/

            /*

//Parsing Date doesnt work it takes any randome date
            System.out.println("hiiiiiiiiiiiiii");
            //String pattern = "MM-dd-yyyy";
            //String pattern = "HH:mm:ss";
            String pattern ="yyyy-mm-dd hh:mm:ss";
            //String dateStr=Integer.toString(calndr.get(Calendar.DATE));
            SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat(pattern);
            //Date date = simpleDateFormat3.parse(dateStr);
            Date date=calndr.getTime();
            String strDate = simpleDateFormat3.format(date);
            System.out.println(date);
            System.out.println(strDate);

            System.out.println("byeeeeeeeeeeeeeeee");
*/

/*          String newDate="23-8-2019"; //8=september coz 11=december
            calndr.set(Calendar.DATE, 14);
            calndr.set(Calendar.MONTH, 10);
            calndr.set(Calendar.YEAR, 2019);*/

            Scanner input=new Scanner(System.in);
            System.out.println("give new date- int (1-31)=");
            calndr.set(Calendar.DATE,input.nextInt());
            System.out.println("give new month- int (1-12)=");
            calndr.set(Calendar.MONTH,input.nextInt()-1);
            System.out.println("give new year- int =");
            calndr.set(Calendar.YEAR,input.nextInt());



            DateFormat dfalt = new SimpleDateFormat("E dd/MM/yyyy");
            System.out.println("now altered day and datee = "+dfalt.format(calndr.getTime()));
            //System.out.println("Altered Current Time is : "+ calndr.getTime());
            //System.out.println("Altered day of week = "+calndr.get(calndr.DAY_OF_WEEK));
/*
            //**********************************

            // Displaying the modified result
            System.out.println("Altered Date is: "+ calndr.get(Calendar.DATE));
            System.out.println("Altered MONTH is: "+ calndr.get(Calendar.MONTH));
            System.out.println("Altered Year is: "+ calndr.get(Calendar.YEAR));
            System.out.println("Altered Current Time is : "+ calndr.getTime());
            System.out.println("Altered day of week = "+calndr.get(calndr.DAY_OF_WEEK));
            // System.out.println("Altered day of week without get  = "+calndr.DAY_OF_WEEK); this always gives 7
            // therefore use get
*/

            switch (calndr.get(calndr.DAY_OF_WEEK))
            {
                case 1:
                    System.out.println("1=sunday="+calndr.get(calndr.DAY_OF_WEEK));
                    System.out.println("This is already first day of this week");
                    calndr.add(Calendar.DATE, 6);
                    DateFormat dfsun = new SimpleDateFormat("E dd/MM/yyyy");
                    System.out.println("last date of this given week= "+dfsun.format(calndr.getTime()));
                    //System.out.println("the last day of this week="+calndr.get(Calendar.DATE));
                    //System.out.println("the last day of this week="+calndr.get(Calendar.DATE));
                    //System.out.println("month="+calndr.get(Calendar.MONTH));
                    //System.out.println("year="+calndr.get(Calendar.YEAR));
                    break;
                case 2:
                    System.out.println("2=monday="+calndr.get(calndr.DAY_OF_WEEK));
                    //System.out.println("The first date of the week"+calndr.get(Calendar.DATE)+" / "+calndr.get
                    // (Calendar.MONTH)+" / "+calndr.get(Calendar.YEAR));
                    calndr.add(Calendar.DATE, -1);
                    DateFormat dfmon = new SimpleDateFormat("E dd/MM/yyyy");
                    System.out.println("first date  of this given week= "+dfmon.format(calndr.getTime()));
                    calndr.add(Calendar.DATE, 6);
                    System.out.println("last date  of this given week= "+dfmon.format(calndr.getTime()));

                    //System.out.println("the last day of this week="+calndr.get(Calendar.DATE));
                    //System.out.println("month="+calndr.get(Calendar.MONTH));
                    //System.out.println("year="+calndr.get(Calendar.YEAR));
                    break;
                case 3:
                    System.out.println("3=tuesday="+calndr.get(calndr.DAY_OF_WEEK));
                    DateFormat dftue = new SimpleDateFormat("E dd/MM/yyyy");
                    calndr.add(Calendar.DATE, -2);
                    System.out.println("first date  of this given week= "+dftue.format(calndr.getTime()));
                    calndr.add(Calendar.DATE, 6);
                    System.out.println("first date  of this given week= "+dftue.format(calndr.getTime()));
                    break;
                case 4:
                    System.out.println("4=wednesday="+calndr.get(calndr.DAY_OF_WEEK));
                    DateFormat dfwed = new SimpleDateFormat("E dd/MM/yyyy");
                    calndr.add(Calendar.DATE, -3);
                    System.out.println("first date  of this given week= "+dfwed.format(calndr.getTime()));
                    calndr.add(Calendar.DATE, 6);
                    System.out.println("first date  of this given week= "+dfwed.format(calndr.getTime()));
                    break;
                case 5:
                    System.out.println("5=thursday="+calndr.get(calndr.DAY_OF_WEEK));
                    DateFormat dfthu = new SimpleDateFormat("E dd/MM/yyyy");
                    calndr.add(Calendar.DATE, -4);
                    System.out.println("first date  of this given week= "+dfthu.format(calndr.getTime()));
                    calndr.add(Calendar.DATE, 6);
                    System.out.println("first date  of this given week= "+dfthu.format(calndr.getTime()));
                    break;
                case 6:
                    System.out.println("6=friday="+calndr.get(calndr.DAY_OF_WEEK));
                    DateFormat dffri = new SimpleDateFormat("E dd/MM/yyyy");
                    calndr.add(Calendar.DATE, -5);
                    System.out.println("first date  of this given week= "+dffri.format(calndr.getTime()));
                    calndr.add(Calendar.DATE, 6);
                    System.out.println("first date  of this given week= "+dffri.format(calndr.getTime()));
                    break;
                case 7:
                    System.out.println("7=saturday="+calndr.get(calndr.DAY_OF_WEEK));
                    DateFormat dfsat = new SimpleDateFormat("E dd/MM/yyyy");
                    calndr.add(Calendar.DATE, -6);
                    System.out.println("first date  of this given week= "+dfsat.format(calndr.getTime()));
                    System.out.println("this is already last day of week saturday");
                    break;
            }

/*      calndr.add(Calendar.DATE, -15);
        System.out.println("15 days ago: " + calendar.getTime());
        calndr.add(Calendar.MONTH, 4);
        System.out.println("4 months later: " + calendar.getTime());
        calndr.add(Calendar.YEAR, 2);
        System.out.println("2 years later: " + calendar.getTime());*/

        }

}


