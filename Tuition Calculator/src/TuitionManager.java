import java.util.Scanner;

/**
 * reads in students and add them to the student list
 * @author Jonathan Li, Jihun Joo, Bufan Jiang
 */
public class TuitionManager {
	Scanner stdin;
	StudentList Rutgers;

	/**
	 * takes commands and take appropriate action according to the command
	 */
	public void run() {
		System.out.println("Let's start a new student list!");
		stdin = new Scanner(System.in);
		Rutgers = new StudentList();
		boolean done = false;
		while (!done) {
			String command = stdin.next();
			switch (command.charAt(0)) {
			case 'I':
				addInstate();
				break;
			case 'O':
				addOutstate();
				break;
			case 'N':
				addInternational();
				break;
			case 'R':
				remove();
				break;
			case 'P':
				print();
				break;
			case 'Q':
				done = true;
				break;
			default:
				System.out.println("Command '" + command.charAt(0) + "' not supported!");
				stdin.nextLine();
				// deal with bad command here
			}
		}
		print();
		System.out.println("The student list is ready to go!");

	}

	/**
	 * adds Instate Students to the StudentList checks for invalid credit, funds
	 * amount, and duplicate warns if part-time
	 */
	private void addInstate() {
		String fname = stdin.next();
		String lname = stdin.next();
		int credit = Integer.parseInt(stdin.next());
		int funds = Integer.parseInt(stdin.next());
		Instate student = new Instate(fname, lname, credit, funds);
		if (credit <= 0) {
			System.out.println("Invalid credit hours, must be more than 0.");
		} else if (funds < 0) {
			System.out.println("Invalid funds, must be more than or equal to $0.");
		} else {
			if (Rutgers.contains(student)) {
				System.out.println("Student " + fname + " " + lname + " is already on the list.");
			} else {
				Rutgers.add(student);
				if (!student.isFullTime()) {
					System.out.print("(Warning: Part time in-state students are not eligible for funding) ");
				}
				System.out.println("Student " + fname + " " + lname + " is now added to the student list.");
			}
		}
	}

	/**
	 * adds Outstate Students to the StudentList checks for invalid credit,
	 * duplicate, and correct boolean input
	 */
	private void addOutstate() {
		String fname = stdin.next();
		String lname = stdin.next();
		int credit = Integer.parseInt(stdin.next());
		String isTristate = stdin.next();
		boolean tristate;
		if (!(isTristate.equals("T") || isTristate.equals("F"))) {
			System.out.println("Invalid tristate input, can either be T or F");
		} else if (credit <= 0) {
			System.out.println("Invalid credit hours, must be more than 0.");
		} else {
			if (isTristate.equals("T")) {
				tristate = true;
			} else {
				tristate = false;
			}
			Outstate student = new Outstate(fname, lname, credit, tristate);
			if (Rutgers.contains(student)) {
				System.out.println("Student " + fname + " " + lname + " is already on the list.");
			} else {
				Rutgers.add(student);
				System.out.println("Student " + fname + " " + lname + " is now added to the student list.");
			}
		}
	}

	/**
	 * adds International Students to the StudentList checks for invalid credit,
	 * duplicate, and correct boolean input
	 */
	private void addInternational() {
		String fname = stdin.next();
		String lname = stdin.next();
		int credit = Integer.parseInt(stdin.next());
		String isExchange = stdin.next();
		boolean exchange;
		if (credit < 9) {
			System.out.println("International students must enroll at least 9 credit hours.");
		} else if (!(isExchange.equals("T") || isExchange.equals("F"))) {
			System.out.println("Invalid tranfer input, can either be T or F");
		} else {
			if (isExchange.equals("T")) {
				exchange = true;
			} else {
				exchange = false;
			}
			International student = new International(fname, lname, credit, exchange);

			if (Rutgers.contains(student)) {
				System.out.println("Student " + fname + " " + lname + " is already on the list.");
			} else {
				Rutgers.add(student);
				System.out.println("Student " + fname + " " + lname + " is now added to the student list.");
			}
		}
	}

	/**
	 * removes Student from StudentList checks to see if the list is empty and
	 * Student is on the list before allowing the removal procedure
	 */
	private void remove() {
		String fname = stdin.next();
		String lname = stdin.next();
		// this in-state student is initialized here to compare the name to remove
		Instate temp = new Instate(fname, lname, 1, 0);
		if (Rutgers.isEmpty()) {
			System.out.println("The student list is currently empty, no students to remove.");
		} else if (!Rutgers.contains(temp)) {
			System.out.println("Student " + fname + " " + lname + " is not on the list.");
		} else {
			Rutgers.remove(temp);
			System.out.println("Student " + fname + " " + lname + " has been removed from the list.");
		}

		// must check if the date is valid

	}

	/**
	 * prints the list
	 */
	private void print() {
		if (Rutgers.isEmpty()) {
			System.out.println("We have 0 students!");
		} else {
			System.out.println("We have the following students: ");
			Rutgers.print();
			System.out.println("-- end of the list --");
		}
		// must check if the team has 0 members.
	}

}
