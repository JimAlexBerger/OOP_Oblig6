package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import csv.CSV;
import model.Person;
import serialiserbare.Serial;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import java.awt.event.ActionEvent;
import javax.swing.AbstractListModel;

public class Gui extends JFrame {

	private JPanel contentPane;
	private JTextField fNavn;
	private JTextField eNavn;
	private JTextField alder;
	DefaultListModel<Person> modell = new DefaultListModel<>();
	private JList<Person> list;

	/**
	 * Create the frame.
	 */
	public Gui() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 556);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 242, 527);
		contentPane.add(panel);
		panel.setLayout(null);

		fNavn = new JTextField();
		fNavn.setBounds(111, 30, 86, 20);
		panel.add(fNavn);
		fNavn.setColumns(10);

		JLabel lblFnavn = new JLabel("fNavn");
		lblFnavn.setBounds(24, 33, 46, 14);
		panel.add(lblFnavn);

		JLabel lblEnavn = new JLabel("eNavn");
		lblEnavn.setBounds(24, 94, 46, 14);
		panel.add(lblEnavn);

		eNavn = new JTextField();
		eNavn.setBounds(111, 91, 86, 20);
		panel.add(eNavn);
		eNavn.setColumns(10);

		JLabel lblAlder = new JLabel("alder");
		lblAlder.setBounds(24, 162, 46, 14);
		panel.add(lblAlder);

		alder = new JTextField();
		alder.setBounds(111, 159, 86, 20);
		panel.add(alder);
		alder.setColumns(10);

		JButton create = new JButton("Create");
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Person(fNavn.getText(), eNavn.getText(), Integer.parseInt(alder.getText()));
					fNavn.setText("");
					eNavn.setText("");
					alder.setText("");
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Ikke gyldig verdi i boksene.");
				}
				updateList();
				save();
			}
		});
		create.setBounds(73, 235, 89, 23);
		panel.add(create);

		JButton btnForceSave = new JButton("Force save");
		btnForceSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				save();
			}
		});
		btnForceSave.setBounds(73, 444, 89, 23);
		panel.add(btnForceSave);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(240, 0, 472, 527);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		ButtonGroup radioButtons = new ButtonGroup();

		JRadioButton rdbtnAZ = new JRadioButton("A-\u00C5");
		rdbtnAZ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Collections.sort(Person.getPersons(), new Comparator<Person>() {
					@Override
					public int compare(Person p2, Person p1) {
						return p2.getfNavn().compareTo(p1.getfNavn());
					}
				});
				updateList();
			}
		});
		rdbtnAZ.setBounds(6, 7, 109, 23);
		panel_1.add(rdbtnAZ);
		radioButtons.add(rdbtnAZ);

		JRadioButton rdbtnZA = new JRadioButton("\u00C5-A");
		rdbtnZA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Collections.sort(Person.getPersons(), new Comparator<Person>() {
					@Override
					public int compare(Person p2, Person p1) {
						return -p2.getfNavn().compareTo(p1.getfNavn());
					}
				});
				updateList();
			}
		});
		rdbtnZA.setBounds(6, 33, 109, 23);
		panel_1.add(rdbtnZA);
		radioButtons.add(rdbtnZA);

		JRadioButton rdbtnLH = new JRadioButton("Alder lav-h\u00F8y");
		rdbtnLH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Collections.sort(Person.getPersons(), new Comparator<Person>() {
					@Override
					public int compare(Person p2, Person p1) {
						return p2.getAlder() - p1.getAlder();
					}
				});
				updateList();
			}
		});
		rdbtnLH.setBounds(117, 7, 109, 23);
		panel_1.add(rdbtnLH);
		radioButtons.add(rdbtnLH);

		JRadioButton rdbtnHL = new JRadioButton("Alder h\u00F8y-lav");
		rdbtnHL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Collections.sort(Person.getPersons(), new Comparator<Person>() {
					@Override
					public int compare(Person p2, Person p1) {
						return p1.getAlder() - p2.getAlder();
					}
				});
				updateList();
			}
		});
		rdbtnHL.setBounds(117, 33, 109, 23);
		panel_1.add(rdbtnHL);
		radioButtons.add(rdbtnHL);

		JButton delete = new JButton("DELETE");
		delete.setToolTipText("DELETE");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Person.getPersons().remove(list.getSelectedValue());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				updateList();
				save();
			}
		});
		delete.setBounds(191, 464, 89, 23);
		panel_1.add(delete);

		list = new JList<>();
		list.setModel(modell);
		list.setBounds(10, 76, 452, 377);
		panel_1.add(list);
		updateList();
	}

	private void updateList() {
		modell.clear();
		for (Person p : Person.getPersons()) {
			modell.addElement(p);
		}
		list.updateUI();
	}

	private void save() {
		//new CSV("C:\\Users\\Jim-Alexander\\workspace\\Oblig6\\save.txt").savePeople();
		new Serial("C:\\Users\\Jim-Alexander\\workspace\\Oblig6\\save.txt").savePeople();

	}

	private void load() {
		//new CSV("C:\\Users\\Jim-Alexander\\workspace\\Oblig6\\save.txt").loadPeople();
		new Serial("C:\\Users\\Jim-Alexander\\workspace\\Oblig6\\save.txt").loadPeople();

		updateList();
	}
}
