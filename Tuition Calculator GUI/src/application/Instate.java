package application;

/**
 * Instate subclass
 * 
 * @author Jihun Joo, Jonathan Li, Bufan Jiang
 */
public class Instate extends Student {
	private int funds;

	/**
	 * Constructor takes a Instate Student object's fields to create a new Instate
	 * Student with same data
	 * 
	 * @param fname  First Name
	 * @param lname  Last Name
	 * @param credit Number of Credit
	 * @param funds  The amount of funds the student has
	 */
	public Instate(String fname, String lname, int credit, int funds) {
		super(fname, lname, credit);
		this.funds = funds;
	}

	/**
	 * Computes the tuition due
	 * 
	 * @return tuition in int
	 */
	public int tuitionDue() {
		int tuition = 0;
		if (super.isFullTime()) {
			tuition = Money.inStateTuitionCred * Math.min(credit, Money.maxCred) + Money.fullTime;
			tuition -= funds;
		} else {
			tuition = Money.inStateTuitionCred * credit + Money.partTime;
		}
		return tuition;
	}

	/**
	 * Used to convert International Student's fields into String
	 * 
	 * @return return a string with fname, lname, credit hours, and funds
	 */
	public String toString() {
		return String.format(super.toString() + " Instate, Funds:" + " " + funds);
	}

	/**
	 * testbed main
	 * 
	 * @param args tests
	 */
	public static void main(String[] args) {
		Student a = new Instate("Alex", "Riv", 11, 0);
		Student b = new Instate("Alex", "Riv", 11, 100);
		Student c = new Instate("Levi", "Riv", 12, 100);
		Student d = new Instate("Papa", "Riv", 20, 100);
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
