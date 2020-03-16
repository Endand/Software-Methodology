/**
 
 @author Rose Sirohi, Caitlyn Romano, Jihun Joo  

 */
import java.util.StringTokenizer; //for first constructor

public class Date 
{
   private int  day;
   private int  month;
   private int  year;
   public static final int FIRST_INDEX=0;
   public static final int NUM_FORMAT_ERROR=0;
   public static final int MAX_MONTH=12;
   public static final int MIN_MONTH=1;
   public static final int MAX_DAY=31;
   public static final int MIN_DAY=1;
   public static final int MIN_YEAR=0;
   public static final int EVENLY_DIVISIBLE=0;
   public static final int LEAP_FEB_DAY= Month.DAYS_FEB+1;
   
   /**
   Constructor that converts String date into Date class.
   @param d a start date entered as a String
   */
   public Date(String d)
   {
      int stringIndex = FIRST_INDEX;
      //iterate until reaching date part of string:
      while (Character.isDigit(d.charAt(stringIndex)) == false && stringIndex < d.length())
      {
         stringIndex++;
      }

      d = d.substring(stringIndex, d.length()); //d now equals just Date part of string

      StringTokenizer dToken = new StringTokenizer(d, "/");

      try
      {
         this.month = Integer.parseInt(dToken.nextToken());
         this.day = Integer.parseInt(dToken.nextToken());
         this.year = Integer.parseInt(dToken.nextToken());
      }
      catch (NumberFormatException error)
      {
         this.month = NUM_FORMAT_ERROR;
         this.day = NUM_FORMAT_ERROR;
         this.year = NUM_FORMAT_ERROR;
      }     
   }
   
   /**
   Constructor takes a Date object's fields to create a new date with same data
   @param d Date received, whose fields will be used for new date
   */
   public Date(Date d)
   {
      this.day = d.day;
      this.month = d.month;
      this.year = d.year;
   }      
   
   /**
   method checks if format of the date is legal
   @return boolean true if date is legal, false if illegal
   */
   private boolean checkLegal() 
   {
	   if (this.month > MAX_MONTH || this.month < MIN_MONTH)
	         return false;
	   if (this.day > MAX_DAY || this.day < MIN_DAY)
	         return false;
	   if (this.year < MIN_YEAR)
	         return false;
      return true;
   }
   
   /**
   method checks months for valid day entry
   @return boolean true if day entry for month is valid, 
   false if day entry for the month is invalid.
   */
   private boolean checkValidMonth()
   {
	   if (this.month == Month.FEB && this.day > LEAP_FEB_DAY)
           return false;      
	   if ((this.month == Month.JAN || this.month == Month.MAR || this.month == Month.MAY || this.month == Month.JUL || this.month == Month.AUG || this.month == Month.OCT || this.month == Month.DEC) && this.day > Month.DAYS_ODD)
            return false;
	   else if ((this.month == Month.APR || this.month == Month.JUN || this.month == Month.SEP || this.month == Month.NOV) && this.day > Month.DAYS_EVEN)
            return false;

      return true;
   }
    
   /**
   method checks if a year is a leap year
   @return boolean true if year is leapyear, false otherwise
   */
   private boolean isLeapYear()
   {
	   if(this.day!= LEAP_FEB_DAY)
		   return false;
	   
	   if(this.year % Month.QUADRENNIAL == EVENLY_DIVISIBLE)
	   {
		   if(this.year % Month.CENTENNIAL == EVENLY_DIVISIBLE)
		   {
			   if(this.year % Month.QUATERCENTENNIAL != EVENLY_DIVISIBLE)
				   return false;
		   }
		   return true;
	   }
	   return false;
   }
   
   /**
   method checks if a Date is valid.
   @return boolean true if Date is valid, false otherwise
   */ 
   public boolean isValid()
   {
	   if(checkLegal() && checkValidMonth())
	   {
		 //check if leap year
	         if (this.day == LEAP_FEB_DAY && this.month == Month.FEB)
	         {
	            return isLeapYear();
	         }
         return true;
	   }  
	   return false;
   }
  
   @Override
   //Format: month/day/year
   public String toString()
   {
	   return String.format(month + "/" + day + "/" + year);
   }
   
   @Override
   public boolean equals(Object obj)
   {
	 if(obj instanceof Date)
       {
    	   Date d = (Date) obj;
    	   return d.day==day &&
    			  d.month==month &&
    			  d.year== year;
       }
       return false;
   }  
   //testbed main;
    public static void main(String [] args)
   {
      Date date= new Date("11/21/1998");
      Date date2= new Date("11/21/1998");
      Date date3 = new Date ("2/29/2020");
      Date date4 = date3;
      System.out.println(date.equals(date2));
      System.out.println(date2.equals(date3));
      System.out.println(date.toString());
      System.out.println(date4.toString());

   }
}


