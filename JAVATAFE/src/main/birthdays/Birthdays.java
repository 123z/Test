package main.birthdays;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;

/**
 * @author Mark O'Reilly
 * 
 *         Interface with Low Coupling and High Cohesion and initial internal
 *         documentation
 */

@SuppressWarnings("serial")
public class Birthdays extends Frame implements WindowListener {

	int maxEntries = 100;
	int numberOfEntries = 0;
	int currentEntry = 0;


	FriendRecords[] friendRecords = new FriendRecords[maxEntries];

	Label lblFriendsName, lblLikes, lblDislikes, lblBirthdayDay, lblBirthdayMonth;
	TextField txtFriendsName, txtLikes, txtDislikes, txtBirthdayDay, txtBirthdayMonth, txtBirthdaysInMonth, txtFind;
	Button btnNew, btnSave, btnDel, btnFind, btnExit, btnFirst, btnPrev, btnNext, btnLast, btnBirthdaysInMonth;
	JTextArea txtaMonthSearch;

	/**
	 * Entry point to the class and application.
	 * 
	 * @param args
	 *            Array of String arguments.
	 */
	public static void main(String[] args) {
		Frame myFrame = new Birthdays();
		myFrame.setSize(500, 250);
		myFrame.setLocation(400, 200);
		myFrame.setResizable(false);
		myFrame.setVisible(true);

	}

	/**
	 * Constructor which sets up the screen layout and listeners.
	 */
	public Birthdays() {
		setTitle("Friend's birthdays");
		// setBackground(Color.black);

		SpringLayout myLayout = new SpringLayout();
		setLayout(myLayout);

		LocateLabels(myLayout);
		LocateTextFields(myLayout);
		LocateButtons(myLayout);

		this.addWindowListener(this);
	}

	public void BdayReportFrame() {
		// Setting the frame for the birthdays in month report
		SpringLayout myLayout = new SpringLayout();
		// Setting a value to the "font" variable.
		Font font = new Font("Verdana", Font.BOLD, 15);
		
		// Defining new colors.
		Color lightblue = new Color(0, 102, 255);
		Color verylightblue = new Color(92, 184, 230);
		// Setting heading.
		Label bdayheading = new Label("BIRTHDAYS In Month Of: " + txtBirthdaysInMonth.getText());
		// Attaching a font to "bdayheading"
		bdayheading.setFont(font);
		JFrame reportFrame = new JFrame();
		reportFrame.setSize(565, 350);
		reportFrame.setLocation(400, 200);
		reportFrame.setResizable(false);
		reportFrame.setVisible(true);
		// Setting close function Dispose of frame and Keep main open.
		reportFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// Defining new Panel and adding it to the frame.
		Panel panel = new Panel();
		reportFrame.add(panel);
		// Setting layout to panel
		panel.setLayout(myLayout);
		panel.setBackground(lightblue);
		// Setting the design elements to the Jtext area
		txtaMonthSearch = new JTextArea();
		txtaMonthSearch.setEditable(false);
		txtaMonthSearch.setBackground(verylightblue);

		// adding ScrollPane to the JTextArea txtaMonthSearch.
		JScrollPane sp = new JScrollPane(txtaMonthSearch);
		sp.setPreferredSize(new Dimension(525, 250));
		// Setting location of scrollpane
		myLayout.putConstraint(SpringLayout.WEST, sp, 20, SpringLayout.WEST, panel);
		myLayout.putConstraint(SpringLayout.NORTH, sp, 40, SpringLayout.NORTH, panel);
		// Setting location of bdayheading
		myLayout.putConstraint(SpringLayout.WEST, bdayheading, 20, SpringLayout.WEST, panel);
		myLayout.putConstraint(SpringLayout.NORTH, bdayheading, 10, SpringLayout.NORTH, panel);

		// Setting the ScrollPane to only show when required
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		panel.add(sp);
		panel.add(bdayheading);

	}

	/**
	 * Controlling method for adding multiple labels to the screen
	 */
	public void LocateLabels(SpringLayout myLabelLayout) {
		lblFriendsName = LocateALabel(myLabelLayout, lblFriendsName, "Friend's Name: ", 30, 25);
		lblLikes = LocateALabel(myLabelLayout, lblLikes, "Likes: ", 30, 50);
		lblDislikes = LocateALabel(myLabelLayout, lblDislikes, "Dislikes: ", 30, 75);
		lblBirthdayDay = LocateALabel(myLabelLayout, lblBirthdayDay, "Birthday day: ", 30, 100);
		lblBirthdayMonth = LocateALabel(myLabelLayout, lblBirthdayMonth, "Birthday month: ", 30, 125);
	}

	/**
	 * Method with low coupling and high cohesion for adding individual labels:
	 * - reduces overall code, especially in the LocateLabels method. - makes
	 * this method re-usable with minimal adjustment as it is moved from one
	 * program to another.
	 */
	public Label LocateALabel(SpringLayout myLabelLayout, Label myLabel, String LabelCaption, int x, int y) {
		myLabel = new Label(LabelCaption);
		add(myLabel);
		myLabelLayout.putConstraint(SpringLayout.WEST, myLabel, x, SpringLayout.WEST, this);
		myLabelLayout.putConstraint(SpringLayout.NORTH, myLabel, y, SpringLayout.NORTH, this);
		return myLabel;
	}

	/**
	 * Controlling method for adding multiple textboxes to the screen
	 */
	public void LocateTextFields(SpringLayout myTextFieldLayout) {
		txtFriendsName = LocateATextField(myTextFieldLayout, txtFriendsName, 20, 130, 25);
		txtLikes = LocateATextField(myTextFieldLayout, txtLikes, 20, 130, 50);
		txtDislikes = LocateATextField(myTextFieldLayout, txtDislikes, 20, 130, 75);
		txtBirthdayDay = LocateATextField(myTextFieldLayout, txtBirthdayDay, 20, 130, 100);
		txtBirthdayMonth = LocateATextField(myTextFieldLayout, txtBirthdayMonth, 20, 130, 125);
		txtBirthdaysInMonth = LocateATextField(myTextFieldLayout, txtBirthdaysInMonth, 5, 310, 182);
		txtFind = LocateATextField(myTextFieldLayout, txtFind, 20, 130, 150);
	}

	/**
	 * Method with low coupling and high cohesion for adding individual
	 * textboxes: - reduces overall code, especially in the LocateTextFields
	 * method. - makes this method re-usable with minimal adjustment as it is
	 * moved from one program to another.
	 */
	public TextField LocateATextField(SpringLayout myTextFieldLayout, TextField myTextField, int width, int x, int y) {
		myTextField = new TextField(width);
		add(myTextField);
		myTextFieldLayout.putConstraint(SpringLayout.WEST, myTextField, x, SpringLayout.WEST, this);
		myTextFieldLayout.putConstraint(SpringLayout.NORTH, myTextField, y, SpringLayout.NORTH, this);
		return myTextField;
	}

	/**
	 * Controlling method for adding multiple buttons to the screen
	 */
	public void LocateButtons(SpringLayout myButtonLayout) {
		btnNew = LocateAButton(myButtonLayout, btnNew, "New", 320, 25, 80, 25);
		btnNew.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				numberOfEntries++;
				currentEntry = numberOfEntries - 1;
				friendRecords[currentEntry] = new FriendRecords("", "", "", "", "");
				displayEntry(currentEntry);
			}

		});

		btnSave = LocateAButton(myButtonLayout, btnSave, "Save", 320, 50, 80, 25);
		btnSave.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveEntry(currentEntry);
			}

		});

		btnDel = LocateAButton(myButtonLayout, btnDel, "Delete", 320, 75, 80, 25);
		btnDel.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int index = currentEntry; index < numberOfEntries - 1; index++) {
					friendRecords[index].setRecords(friendRecords[index + 1].getFriendsName(),
							friendRecords[index + 1].getLikes(), friendRecords[index + 1].getDislikes(),
							friendRecords[index + 1].getBirthdayDay(), friendRecords[index + 1].getBirthdayMonth());
				}
				numberOfEntries--;
				if (currentEntry > numberOfEntries - 1) {
					currentEntry = numberOfEntries - 1;
				}
				displayEntry(currentEntry);
			}

		});

		btnFind = LocateAButton(myButtonLayout, btnFind, "Find", 320, 150, 80, 25);
		btnFind.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean found = false;
				int index = 0;
				while (index < numberOfEntries - 1 && !found) {
					if (friendRecords[index].getFriendsName().equalsIgnoreCase(txtFind.getText())) {
						found = true;
					}
					index++;
				}
				if (found) {
					currentEntry = index - 1;
					displayEntry(currentEntry);
				}
			}

		});

		btnExit = LocateAButton(myButtonLayout, btnExit, "Exit", 370, 180, 80, 25);
		btnExit.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				saveEntry(currentEntry);
				System.exit(0);
			}

		});

		btnFirst = LocateAButton(myButtonLayout, btnFirst, "|<", 30, 180, 30, 25);
		btnFirst.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				currentEntry = 0;
				displayEntry(currentEntry);
			}
		});

		btnPrev = LocateAButton(myButtonLayout, btnPrev, "<", 60, 180, 30, 25);
		btnPrev.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (currentEntry > 0) {
					currentEntry--;
					displayEntry(currentEntry);
				}
			}
		});

		btnNext = LocateAButton(myButtonLayout, btnNext, ">", 90, 180, 30, 25);
		btnNext.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (currentEntry < numberOfEntries - 1) {
					currentEntry++;
					displayEntry(currentEntry);
				}
			}
		});

		btnLast = LocateAButton(myButtonLayout, btnLast, ">|", 120, 180, 30, 25);
		btnLast.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				currentEntry = numberOfEntries - 1;
				displayEntry(currentEntry);
			}
		});

		btnBirthdaysInMonth = LocateAButton(myButtonLayout, btnBirthdaysInMonth, "Birthdays in the month of: ", 160,
				180, 150, 25);
		btnBirthdaysInMonth.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				BdayReportFrame();
				for (int i = 0; i < numberOfEntries; i++) {
					if (txtBirthdaysInMonth.getText().equals(friendRecords[i].getBirthdayMonth())) {
						
						txtaMonthSearch.append(friendRecords[i].getBirthdayDay() + "/"
								+ friendRecords[i].getBirthdayMonth() + " - " + friendRecords[i].getFriendsName()
								+ " - " + friendRecords[i].getLikes() + " - " + friendRecords[i].getDislikes() + "\n");
						
					}

				}
			}
		});
	}

	/**
	 * Method with low coupling and high cohesion for adding individual buttons:
	 * - reduces overall code, especially in the LocateButtons method. - makes
	 * this method re-usable with minimal adjustment as it is moved from one
	 * program to another.
	 */
	public Button LocateAButton(SpringLayout myButtonLayout, Button myButton, String ButtonCaption, int x, int y, int w,
			int h) {
		myButton = new Button(ButtonCaption);
		add(myButton);
		myButtonLayout.putConstraint(SpringLayout.WEST, myButton, x, SpringLayout.WEST, this);
		myButtonLayout.putConstraint(SpringLayout.NORTH, myButton, y, SpringLayout.NORTH, this);
		myButton.setPreferredSize(new Dimension(w, h));
		return myButton;
	}

	/**
	 * Respond to Window events, such as clicking the Close ( X ) button
	 */

	public void windowClosing(WindowEvent we) {
		writeFile();
		System.exit(0);
	}

	public void windowIconified(WindowEvent we) {
	}

	public void windowOpened(WindowEvent we) {
		readFile();
		displayEntry(currentEntry);
	}

	public void windowClosed(WindowEvent we) {
	}

	public void windowDeiconified(WindowEvent we) {
	}

	public void windowActivated(WindowEvent we) {
	}

	public void windowDeactivated(WindowEvent we) {
	}

	public void displayEntry(int index) {
		txtFriendsName.setText(friendRecords[index].getFriendsName());
		txtLikes.setText(friendRecords[index].getLikes());
		txtDislikes.setText(friendRecords[index].getDislikes());
		txtBirthdayDay.setText(friendRecords[index].getBirthdayDay());
		txtBirthdayMonth.setText(friendRecords[index].getBirthdayMonth());
	}

	public void saveEntry(int index) {

		friendRecords[index].setRecords(friendRecords[index].getFriendsName(), friendRecords[index].getLikes(),
				friendRecords[index].getDislikes(), friendRecords[index].getBirthdayDay(),
				friendRecords[index].getBirthdayMonth());
		writeFile();
	}

	public void readFile() {
		try {
			FileInputStream fstream = new FileInputStream("Birthdays.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			int i = 0; // i is used as the line counter
			String line;
			// Read File Puts next line into buffer and checks if it is null (in
			// which case means there's no more data left)
			while ((line = br.readLine()) != null) {
				// Splits the line of data from txt and puts it in a temporary
				// array - temp
				String[] temp = line.split(",");

				friendRecords[i] = new FriendRecords(temp[0], temp[1], temp[2], temp[3], temp[4]);
				i++; // Used to go to next line
			}
			numberOfEntries = i; // Global variable to remember how many entries
									// are in the 3 arrays
			in.close();// close stream
		} catch (Exception e) {
			System.err.println("Error Reading File: " + e.getMessage());
		}
	}

	public void writeFile() {
		try {
			// Create file
			PrintWriter out = new PrintWriter(new FileWriter("Birthdays_New.txt"));
			// Write out each line of the data file: PCName, ID, IPAddress
			for (int m = 0; m < numberOfEntries; m++) {
				out.println(friendRecords[m].getFriendsName() + "," + friendRecords[m].getLikes() + ","
						+ friendRecords[m].getDislikes() + "," + friendRecords[m].getBirthdayDay() + ","
						+ friendRecords[m].getBirthdayMonth());
			}
			out.close();
		} catch (Exception e) {
			System.err.println("Error Writing File: " + e.getMessage());
		}
	}

}
