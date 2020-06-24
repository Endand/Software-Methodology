package application;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * SampleController class, reads in students and add them to the student list
 * 
 * @author Jonathan Li, Jihun Joo, Bufan Jiang
 */
public class SampleController {
	StudentList Rutgers = new StudentList();
	@FXML
	private RadioButton instateRadio;
	@FXML
	private RadioButton outstateRadio;
	@FXML
	private RadioButton internationalRadio;

	@FXML
	private CheckBox funding;
	@FXML
	private CheckBox tristate;
	@FXML
	private CheckBox exchange;

	@FXML
	private TextArea output;
	@FXML
	private TextField first;
	@FXML
	private TextField last;
	@FXML
	private TextField credit;
	@FXML
	private TextField fundamnt;

	@FXML
	private Button add;
	@FXML
	private Button remove;
	@FXML
	private Button print;

	/**
	 * defines the events that occur when instate radiobutton is selected, disables
	 * exchange student and international student
	 * 
	 * @param evt Event
	 */
	@FXML
	public void instateSelected(Event evt) {

		tristate.setDisable(true);
		exchange.setDisable(true);
		funding.setDisable(false);
		tristate.setSelected(false);
		exchange.setSelected(false);

	}

	/**
	 * defines the events that occur when outstate radiobutton is selected, disables
	 * instate students funding and international students
	 * 
	 * @param evt Event
	 */
	@FXML
	public void outstateSelected(Event evt) {

		exchange.setDisable(true);
		funding.setDisable(true);
		tristate.setDisable(false);
		fundamnt.setEditable(false);
		funding.setSelected(false);
		exchange.setSelected(false);
		fundamnt.setText(null);
		fundamnt.setVisible(false);
		fundamnt.setEditable(false);
	}

	/**
	 * defines the events that occur when international radiobutton is selected,
	 * disables instate students funding and outstate students tristate option
	 * 
	 * @param evt Event
	 */
	@FXML
	public void internationalSelected(Event evt) {

		tristate.setDisable(true);
		funding.setDisable(true);
		exchange.setDisable(false);
		fundamnt.setEditable(false);
		funding.setSelected(false);
		tristate.setSelected(false);
		fundamnt.setText(null);
		fundamnt.setVisible(false);
		fundamnt.setEditable(false);
	}

	/**
	 * defines the events that occur when funding checkbox is selected, makes the
	 * funding text box appear so that the user can input funding amount
	 * 
	 * @param evt Event
	 */
	@FXML
	public void fundselected(Event evt) {
		if (funding.isSelected()) {
			fundamnt.setVisible(true);
			fundamnt.setEditable(true);
		} else {
			fundamnt.setText(null);
			fundamnt.setVisible(false);
			fundamnt.setEditable(false);
		}

	}

	/**
	 * defines the events that occur when add button is pressed, will add according
	 * to which typed of student is chosen
	 * 
	 * @param evt Event
	 */
	@FXML
	public void addButtonPressed(Event evt) {
		String fName = first.getText();
		String lName = last.getText();
		String strCredits = credit.getText();
		Integer credits = null;
		try {
			if (fName.length() == 0 || lName.length() == 0) {
				if (fName.length() == 0) {
					output.appendText("Student first name cannot be blank.\n");
				}
				if (lName.length() == 0) {
					output.appendText("Student last name cannot be blank.\n");
				}

			}
			credits = Integer.parseInt(strCredits);
			if (credits <= 0) {
				output.appendText("Credits must be more than 0! \n");
			}
			if (fName.length() != 0 && lName.length() != 0 && credits != null && credits > 0) {
				if (instateRadio.isSelected()) {
					addInstate(fName, lName, credits);

				}
				if (outstateRadio.isSelected()) {
					addOutstate(fName, lName, credits);
				}
				if (internationalRadio.isSelected()) {
					addInternational(fName, lName, credits);
				}
			}
		} catch (NumberFormatException exception) {
			// Output expected NumberFormatException.
			output.appendText("Credits cannot be left blank and must be an integer! \n");
		}
	}

	/**
	 * gets fund from text box fund, adds in-state student to student list if he's
	 * not on the list already
	 * 
	 * @param fname  first name
	 * @param lname  last name
	 * @param credit number of credits
	 */
	private void addInstate(String fname, String lname, int credit) {
		int funds = 0;

		try {

			if (fundamnt.getText() == null || fundamnt.getText().length() == 0) {
				funds = 0;
			} else {
				funds = Integer.parseInt(fundamnt.getText());
			}
			if (funds < 0) {
				output.appendText("Funds must be more or equal to zero!\n");
			} else {
				Instate student = new Instate(fname, lname, credit, funds);
				if (Rutgers.contains(student)) {
					output.appendText("Student " + fname + " " + lname + " is already on the list. \n");
				} else {
					Rutgers.add(student);
					if (!student.isFullTime() && funds > 0) {
						output.appendText("(Warning: Part time in-state students are not eligible for funding)\n");
					}
					output.appendText("Student " + fname + " " + lname + " is now added to the student list.\n");
				}
			}
		} catch (NumberFormatException exception) {
			// Output expected NumberFormatException.
			output.appendText("Funds must be an integer!\n");
		}
	}

	/**
	 * gets tristateBool from Tri-state Student checkbox, adds out-state student to
	 * student list if he's not on the list already
	 * 
	 * @param fname  first name
	 * @param lname  last name
	 * @param credit number of credits
	 */
	private void addOutstate(String fname, String lname, int credit) {
		boolean tristateBool = tristate.isSelected();
		Outstate student = new Outstate(fname, lname, credit, tristateBool);
		if (Rutgers.contains(student)) {
			output.appendText("Student " + fname + " " + lname + " is already on the list. \n");
		} else {
			Rutgers.add(student);
			output.appendText("Student " + fname + " " + lname + " is now added to the student list.\n");
		}
	}

	/**
	 * gets exchangeBool from Exchange Student checkbox, adds international student
	 * to student list if he's not on the list already checks if the credits is at
	 * least 9
	 * 
	 * @param fname  first name
	 * @param lname  last name
	 * @param credit number of credits
	 */
	private void addInternational(String fname, String lname, int credit) {
		boolean exchangeBool = exchange.isSelected();
		if (credit < 9) {
			output.appendText("International students must enroll at least 9 credit hours.\n");
		} else {
			International student = new International(fname, lname, credit, exchangeBool);

			if (Rutgers.contains(student)) {
				output.appendText("Student " + fname + " " + lname + " is already on the list. \n");
			} else {
				Rutgers.add(student);
				output.appendText("Student " + fname + " " + lname + " is now added to the student list. \n");
			}
		}
	}

	/**
	 * defines the events that occur when remove button is pressed
	 * 
	 * @param evt Event
	 */
	@FXML
	public void removeButtonPressed(Event evt) {
		String fName = first.getText();
		String lName = last.getText();
		if (fName.length() == 0 || lName.length() == 0) {
			if (fName.length() == 0) {
				output.appendText("Student first name cannot be blank.\n");
			}
			if (lName.length() == 0) {
				output.appendText("Student last name cannot be blank.\n");
			}
		} else {
			Instate temp = new Instate(fName, lName, 1, 0);
			if (Rutgers.isEmpty()) {
				output.appendText("The student list is currently empty, no students to remove. \n");
			} else if (!Rutgers.contains(temp)) {
				output.appendText("Student " + fName + " " + lName + " is not on the list. \n");
			} else {
				Rutgers.remove(temp);
				output.appendText("Student " + fName + " " + lName + " has been removed from the list. \n");
			}
		}
	}

	/**
	 * defines the events that occur when print button is pressed
	 * 
	 * @param evt Event
	 */
	@FXML
	public void printButtonPressed(Event evt) {
		if (Rutgers.isEmpty()) {
			output.appendText("We have 0 students! \n");
		} else {
			output.appendText("We have the following students: \n");
			output.appendText(Rutgers.printAllStudents() + "\n");
			output.appendText("-- end of the list -- \n");
		}
		// must check if the team has 0 members.

	}
}
