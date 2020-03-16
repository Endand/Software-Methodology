/**
 * Outstate subclass
 * @author Jihun Joo, Jonathan Li, Bufan Jiang
 */
public class Outstate extends Student {
	private boolean tristate;

	/**
	  * Constructor takes a Outstate Student object's fields to create a new Outstate Student with same data
	  * @param  fname, lname, credit, tristate, whose fields will be used for new Outstate Student
	  */
	public Outstate(String fname, String lname, int credit, boolean tristate) {
		super(fname, lname, credit);
		this.tristate = tristate;
	}

	/**
	  * Computes the tuition due
	  * @return tuition in int
	  */
	public int tuitionDue() {
		int tuition = 0;
		if (isFullTime()) {
			if (tristate) {
				tuition = Money.tristateCred * Math.min(credit, Money.maxCred);
			} else {
				tuition = Money.outStateTuitionCred * Math.min(credit, Money.maxCred);
			}
			tuition += Money.fullTime;
		} else { // parttime
			tuition = Money.outStateTuitionCred * credit + Money.partTime;
		}

		return tuition;
	}
	
	/**
	  * Used to convert International Student's fields into String
	  * @return return a string with fname, lname, credit hours, and status
	  */
	public String toString() {
		
		if (tristate) {
			return String.format(super.toString() + " Outstate, Tristate");
		} else {
			return String.format(super.toString() + " Outstate, Not Tristate");
		}
	}
	
	/**
	  * testbed main
	  */
	public static void main(String[] args) {
		Student a = new Outstate("Alex","Riv",11,true);
		Student b = new Outstate("Alex","Riv",11,false);
		Student c = new Outstate("Levi","Riv",12,true);
		Student d = new Outstate("Papa","Riv",20,false);
		System.out.println(a.toString());
		System.out.println(b.toString());
		System.out.println(a.compareTo(b));
		System.out.println(a.compareTo(c));
		System.out.println(d.compareTo(a));
		System.out.println(a.tuitionDue());
		System.out.println(b.tuitionDue());
		System.out.println(c.tuitionDue());
		System.out.println(d.tuitionDue());
	}

}
