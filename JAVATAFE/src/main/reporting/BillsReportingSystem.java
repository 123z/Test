/**
 * 
 */
package main.reporting;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.SpringLayout;

/**
 * @author 9100159816
 *
 */
public class BillsReportingSystem extends Frame implements WindowListener {

	private int x = 12;
	private int y = 22;
	private TextField[][] fields = new TextField[x][y];
	private Button clear, save, sort, search, RAF, exit;
	private String fileName = "BillsReportingSystem.csv";
	private String[] question = { "Qns", "Q1", "Q2", "Q3", "Q4", "Q5", "Q6", "Q7", "Q8", "Q9", "Q10", "Result" };
	private String[] test;
	private List<String> test1 = new ArrayList<String>();
	String[][] test2 = new String[20][11];

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BillsReportingSystem frame = new BillsReportingSystem();
		frame.run();
	}

	private void run() {
		setBounds(0, 0, 1100, 620);
		setTitle("Bill's Reporting System");
		this.addWindowListener(this);
		startLayout();
		setVisible(true);

	}

	@SuppressWarnings("serial")
	private void startLayout() {
		SpringLayout layout = new SpringLayout();
		setLayout(layout);

		startData(layout);

		exit = new Button("Exit");
		add(exit);
		exit.addActionListener(new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}

		});
		layout.putConstraint(SpringLayout.WEST, exit, 330, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, exit, 550, SpringLayout.NORTH, this);

		clear = new Button("Clear");
		add(clear);
		clear.addActionListener(new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}

		});
		layout.putConstraint(SpringLayout.WEST, clear, 20, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, clear, 550, SpringLayout.NORTH, this);

		save = new Button("Save");
		add(save);
		save.addActionListener(new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}

		});
		layout.putConstraint(SpringLayout.WEST, save, 70, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, save, 550, SpringLayout.NORTH, this);

		search = new Button("Search");
		add(search);
		search.addActionListener(new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}

		});
		layout.putConstraint(SpringLayout.WEST, search, 220, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, search, 550, SpringLayout.NORTH, this);

		RAF = new Button("RAF");
		add(RAF);
		RAF.addActionListener(new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}

		});
		layout.putConstraint(SpringLayout.WEST, RAF, 280, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, RAF, 550, SpringLayout.NORTH, this);

		sort = new Button("Sort Data");
		add(sort);
		sort.addActionListener(new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}

		});
		layout.putConstraint(SpringLayout.WEST, sort, 120, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, sort, 550, SpringLayout.NORTH, this);

		// readFile(fileName);
		// calculateTotal();
	}

	private void startData(SpringLayout layout) {

		for (int x = 0; x < this.x; x++) {
			for (int y = 0; y < this.y; y++) {
				fields[x][y] = new TextField(8);

				if (y == 0) {
					fields[x][y].setEditable(false);
					fields[x][y].setBackground(new Color(0, 0, 255));
					fields[x][y].setText(question[x]);
				}
				if (y > 1 && x == 0) {
					fields[x][y].setEditable(false);
					fields[x][y].setBackground(new Color(255, 255, 0));

				}
				add(fields[x][y]);
				layout.putConstraint(SpringLayout.NORTH, fields[x][y], y * 25, SpringLayout.NORTH, this);
				layout.putConstraint(SpringLayout.WEST, fields[x][y], x * 90, SpringLayout.WEST, this);
			}
		}
		loadData(fileName);
	}

	private void loadData(String _fileName) {
		try {
			FileInputStream fStream = new FileInputStream(_fileName);
			DataInputStream in = new DataInputStream(fStream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			String line;

			for (int y = 0; y < 21; y++) {
				line = br.readLine();
				test = line.split(",");
				// test1.add(test[i]);

				for (int x = 0; x < 11; x++) {
					fields[x][y + 1].setText(test[x]);
				}
			}
			in.close();
		} catch (Exception ex) {
			System.err.println("Error Reading File: " + ex.getMessage());
		}
	}

	@Override
	public void windowActivated(WindowEvent arg0) {

	}

	@Override
	public void windowClosed(WindowEvent arg0) {

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
	}

}
