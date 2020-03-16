/**
 * Student superclass
 * @author Jihun Joo, Jonathan Li, Bufan Jiang
 */
@SuppressWarnings("rawtypes")
public abstract class Student implements Comparable {
	private String fname;
	private String lname;
	protected int credit;

	 /**
	  * Constructor takes a Student object's fields to create a new Student with same data
	  * @param  fname, lname, credit, whose fields will be used for new Student
	  */
	public Student(String fname, String lname, int credit) {
		this.fname = fname;
		this.lname = lname;
		this.credit = credit;
	} 

	 /**
	  * Used to compare first name and last name to see if Student is equal 
	  * must implement compareTo method because Student class implements the Comparable Interface
	  * @param obj
	  * @return 0 if first name and last name are equal, -1 if this is greater than obj, 1 if this less than obj 
	  */
	public int compareTo(Object obj) {
		int cmp = 0;
		if (obj instanceof Student) {
			Student st = (Student) obj;
			cmp = st.fname.compareToIgnoreCase(fname);
			if (cmp < 0) {
				return -1;
			} else if (cmp > 0) {
				return 1;
			}
			if (cmp == 0) {
				cmp = st.lname.compareToIgnoreCase(lname);
				if (cmp < 0) {
					return -1;
				} else if (cmp > 0) {
					return 1;
				} else {
					return 0;
				}
			}
		}
		return cmp;

	}

	/**
	  * Used to convert Student's fields into String
	  * subclasses will be using this method.
	  * @return return a string with fname, lname and credit hours
	  */
	public String toString() {
		return String.format(fname + " " + lname + " " + credit + " credit hours");
	}

	/**
	  * compute the tuition due; 
	  * concrete implementation is required in the subclasses.
	  */
	public abstract int tuitionDue();


	/**
	  * determines if student is part time or full time
	  * @return true if FullTime and false if not FullTime
	  */
	protected boolean isFullTime() {
		if (credit >= Money.isFullTime) {
			return true;
		}
		return false;
	}

}
