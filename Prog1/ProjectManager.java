import java.util.Scanner;

/**
  
 @author  Caitlyn Romano, Rose Sirohi, Jihun Joo
 */
 
public class ProjectManager
{
   Scanner stdin = new Scanner(System.in);
   Team cs213 = new Team();
   public String dateVal;
   public String name;
   public Date date;
   public char function;
   
   /**
   Method to take in commands from the user.
   */
   public void run()
   {
      System.out.println("Let's start a new team!");
      boolean done = false;
      
      //while there are still more commands to be executed.
      while ( !done )
      {
         
         String command = "";
         command = stdin.next();
         function = command.charAt(0);
         switch (function)  
         {   
            case 'A':
               name= stdin.next();
               dateVal= stdin.next();
               date = new Date(dateVal);
               add();
		    break; 
            case 'R' :
               name= stdin.next();
               dateVal= stdin.next();
               date = new Date(dateVal);
               remove();
            	break;
            case 'P' : 
            	print();
            	break;
            case 'Q' :
               print(); 
               done = true;
            	break;
            default: 
            	System.out.println("Command '" + function + "' not supported!"); 
            	stdin.nextLine();
        		
         }  
      }
   } //run()
   
   /**
   Method to add a team member.
   */
   private void add()
   {	//check date
	   if(!date.isValid())
	   {
		   System.out.println(dateVal + " is not a valid date!");
		   return;
	   }
	   
	   TeamMember member = new TeamMember(name, date);

	   //check if the member has already been added

   	if(cs213.contains(member))
      {
   	  System.out.println( member.toString() + " is already in the team."); 
   	  return;
      }
	  
	   //attempt to add member
   	cs213.add(member);
	System.out.println( member.toString() + " has joined the team.");
   }
   
   /**
   Method to remove a team member.
   */
   private void remove()
   {	//check date
	   if(!date.isValid())
	   {
		   System.out.println(dateVal + " is not a valid date!");
		   return;
	   }
	   
	   TeamMember member = new TeamMember(name, date);
	   boolean success = cs213.remove(member);
	   
	   //check if the member exists in the team
	   if(success == false) 
	   {
		   System.out.println( member.toString() + " is not a team member.");
	   }
	   else 
	   {
		   System.out.println( member.toString() + " has left the team.");
	   }
	   
	   
   }
   /**
   Method to print all members of the team.
   */
   private void print()
   { 
	   //check if the team has 0 members
	   if(cs213.isEmpty()) 
	   {
		   System.out.println("We have 0 team members!");
		   return;
	   } 
	   if(function == 'Q') 
	   {
		   cs213.print();
		   System.out.print("-- end of the list --\n");
		   System.out.println("The team is ready to go!");
	   }
	   else 
	   {
		   System.out.println("We have the following team members: ");
		   cs213.print();
		   System.out.print("-- end of the list --\n");
	   }
      return;
   }   
} 


