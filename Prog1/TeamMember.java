/**
 
 @author Jihun Joo, Caitlyn Romano, Rose Sirohi
 */

public class TeamMember 
{
   private String name;
   private Date startDate;
   
   public TeamMember(String nm, Date date)
   {
       this.name = nm;
       this.startDate = date;
   }
   
   /**
   method to obtain the startDate of a TeamMember.
   @return the startDate of the TeamMember
   */
   public Date getStartDate()
   {
      return this.startDate;
   }
   
   /**
   equals method determined whether two TeamMembers are equal
   based on their name and startDate. 
   @param obj
   @return boolean true if equal, false if not equal
   */
   public boolean equals(Object obj)
   {
	   if(obj instanceof TeamMember)
       {
    	   TeamMember member = (TeamMember) obj;
    	   return member.name.equals(name) &&
    			  member.startDate.equals(startDate);
       }
       return false;
   }  

   /**
   method to convert TeamMember's name and startDate into one String.
   @return TeamMember's name and date as String
   */
   public String toString()
   {
       return String.format(name + " " + startDate);
   }
   
  /*
  testbed main; includes test cases that exercise 
  the constructor and all methods in this class.
  */
   public static void main(String [] args)
   {
	   Date date= new Date("11/21/1998");
	   Date date2= new Date("11/21/1998");
     Date date3= new Date("2/29/2012");

	   TeamMember a = new TeamMember("Lily", date);
	   TeamMember b = new TeamMember("Lily", date2);
     TeamMember c = new TeamMember("Nath",date3); 
     TeamMember d = new TeamMember("Sesh", date3);
	   System.out.println(a.equals(b));
     System.out.println(b.equals(c));
     System.out.println(c.equals(d));
     System.out.println(b.toString());
     System.out.println(c.toString());
     System.out.println(b.getStartDate());

   }
}