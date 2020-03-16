/**
 * creates an array of students and has the ability to add, remove and search
 * for students in the list
 * 
 * @author Jonathan Li, Jihun Joo, Bufan Jiang
 */
public class StudentList {
	private final int NOT_FOUND = -1;
	private final int GROW_SIZE = 4; // initial and grow size
	private Student[] list;
	private int numStudents;
	

	
	 /**
	  * Default constructor  
	   */
	public StudentList() {
		
	}
	
	/**
	  * Used to find Students
	  * @param s The Student to be found
	  * @return which index s is located in or -1 if not found
	  */
	private int find(Student s) {
		if (list == null) {
			return NOT_FOUND;
		}
		for (int i = 0; i < numStudents; i++) {
			if (list[i].compareTo(s) == 0) {
				return i;
			}
		}
		return NOT_FOUND;
	}
	
	/**
	  * used to start a list if Students don't exist in it already
	  */
	private void makeNew() {
		if (list == null) {
			list = new Student[GROW_SIZE];
			numStudents = 0;
		} 
	}
	
	/**
	  * used to make the list longer to add more Students
	  */
	private void grow() {
			Student[] temp = new Student[list.length + GROW_SIZE];
			for (int i = 0; i < list.length; i++) {
				temp[i] = list[i];
			}
			list = temp;
	}

	/**
	  * Used to tell if the list is empty or not
	  * @return true if empty, false if not empty
	  */
	public boolean isEmpty() {
		if (numStudents == 0) {
			return true;
		}
		return false;
	}
	
	/**
	  * Used to add Students
	  * @param s The Student to be added
	  */
	public void add(Student s) {
		if(list == null) {
			makeNew();
		}
		if (numStudents >= list.length) {
			grow();
		}
		list[numStudents] = s;
		numStudents++;

	}

	/**
	  * Used to remove Students
	  * @param s The Student to be removed
	  */
	public boolean remove(Student s) {
		if (find(s) != NOT_FOUND) {
			list[find(s)] = list[numStudents-1];
			list[numStudents-1] = null;
			numStudents--;
			return true;
		}
		return false;
	}

	/**
	  * Used to see if a Student is already on the list
	  * @param s The Student to find
	  * @return true if s exists on the list, false otherwise
	  */
	public boolean contains(Student s) {
		if (find(s) != NOT_FOUND) {
			return true;
		}
		return false;
	}

	/**
	  * Used to print the list of Students
	  * Format: fname lname credit status tuition_due
	  */
	public void print() {
		for (int i = 0; i < numStudents; i++) {
			System.out.print(list[i].toString());
			System.out.println(", Tuition Due: $" + list[i].tuitionDue());
			
		}
	}

}
