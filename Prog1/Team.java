/** holds group of TeamMembers that allow user to create a project team 
without restriction of number of team members.
  
 @author  Caitlyn Romano, Jihun Joo, Rose Sirohi
 */
public class Team 
{
   private final int NOT_FOUND = -1;
   private final int GROW_SIZE = 4; //initial and grow size
   private TeamMember [] team;
   private int numMembers;
   public static final int EMPTY = 0;
   
   public Team()
   {
      //this is the default constructor

   }
   
   /**
   Method to obtain the index of a member in the team array.
   @param m The member to be found.
   @return The index of the TeamMember.
   */
   private int find(TeamMember m)
   {
	   for(int i=0; i<numMembers; i++) 
	   {
		   if(team[i].equals(m)){
			   return i;
		   }
	   }
	   return NOT_FOUND; 
   }
   
   /**
   Method to increase the size of the team array.
   */
   private void grow()
   {
     TeamMember[] temp = new TeamMember[numMembers + GROW_SIZE];
     for(int i=0; i<numMembers; i++)
     {
    	 temp[i]=team[i];
     }
     team = temp;
   }
   
   /**
   Method to check if the team is empty.
   @return True if team is empty, false otherwise.
   */
   public boolean isEmpty()
   {
       if(numMembers == EMPTY) 
       {
    	   return true;
       }
       return false;
   }
   /**
   Method to add a team member.
   @param m The member to be added.
   */
   
   public void add(TeamMember m)
   {     
       if (isEmpty()) 
       {
    	   team = new TeamMember[GROW_SIZE];
    	   numMembers = EMPTY;
       }
       else if(numMembers == team.length) 
       {
    	  grow();
       }
      
       numMembers++;
       team[numMembers-1] = m;
   }
   /**
   Method to remove a team member.
   @param m The member to be deleted.
   @return True if member has been deleted, false otherwise.
   */
   public boolean remove(TeamMember m)
   {
	   if(!contains(m)) 
		   return false; 
     int indexToRemove = find(m);
     team[indexToRemove] = team[numMembers-1];
     team[numMembers-1]=null;
   	 numMembers--;
   	 return true;
   
   } 
   
   /**
   Method to check if the team array contains a team member.
   @param m The member to be checked.
   @return True if member exists in the team array, false otherwise.
   */
   public boolean contains(TeamMember m)
   {
	   if(find(m)==NOT_FOUND)
	   {
		   return false;
	   }
	   return true;
   } 
   /**
    Method to print all team members
    */
   public void print()
   {
	   for(int i=0; i<numMembers; i++)
	   {
		   System.out.println(team[i].toString());
	   }
   } 
  
   /**
   testbed main; includes test cases that exercise 
   the constructor and all methods in this class.
   */
   public static void main(String [] args)
   {
    	Team dbs = new Team();
    	Date date= new Date("11/21/1998");
    	System.out.println(dbs.isEmpty());
    	TeamMember member1 = new TeamMember("Lily", date);
    	TeamMember member2 = new TeamMember("Chang", date);
    	TeamMember member3 = new TeamMember("other", date);
    	TeamMember member4 = new TeamMember("hhh", date);
    	TeamMember member5 = new TeamMember("ya", date);
    	TeamMember member6 = new TeamMember("ya", date);
    	dbs.add(member1); 
    	dbs.add(member2); 
    	dbs.add(member3);
    	dbs.add(member4);
    	dbs.add(member5);
    	dbs.add(member6);
    	dbs.print();
    	System.out.println(dbs.numMembers);
    	dbs.remove(member6);
    	dbs.remove(member1);
    	dbs.print();
    	System.out.println(dbs.team.length);
    	System.out.println(dbs.numMembers);
   }
}
