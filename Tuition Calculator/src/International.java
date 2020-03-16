/**
 * International subclass
 * @author Jihun Joo, Jonathan Li, Bufan Jiang
 */
public class International extends Student {
	private boolean exchange;

	 /**
	  * Constructor takes a International Student object's fields to create a new International Student with same data
	  * @param  fname, lname, credit, exchange, whose fields will be used for new International Student
	  */
	public International(String fname, String lname, int credit, boolean exchange) {
		super(fname, lname, credit);
		this.exchange = exchange;
	}

	/**
	  * Computes the tuition due
	  * @return tuition in int
	  */
	public int tuitionDue() {
		int tuition = 0;
		if (exchange) {
			tuition = Money.intStudFee + Money.fullTime;
			return tuition;
		}

		if (super.isFullTime()) {
			tuition = Money.intTuitionCred * Math.min(credit, Money.maxCred) + Money.intStudFee + Money.fullTime;

		} else {
			tuition = Money.intTuitionCred * credit + Money.intStudFee + Money.partTime;
		}

		return tuition;
	}

	/**
	  * Used to convert International Student's fields into String
	  * @return return a string with fname, lname, credit hours, and status
	  */
	public String toString() {
		if (exchange) {
			return String.format(super.toString() + " International, Exchange Student");
		} else {
			return String.format(super.toString() + " International, Not Exchange Student");
		}
		
	}
	
	/**
	  * testbed main
	  */
	public static void main(String[] args) {
		Student a = new International("Alex","Riv",11,true);
		Student b = new International("Alex","Riv",11,false);
		Student c = new International("Levi","Riv",12,true);
		Student d = new International("Papa","Riv",20,false);
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
