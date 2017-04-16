package main;

import java.awt.EventQueue;

import csv.CSV;
import database.DbPerson;
import model.Person;
import serialiserbare.Serial;
import view.Gui;

public class main {

	public static void main(String[] args) {
		//new CSV("C:\\Users\\Jim-Alexander\\workspace\\Oblig6\\save.txt").loadPeople();
		//new Serial("C:\\Users\\Jim-Alexander\\workspace\\Oblig6\\save.txt").loadPeople();
		new DbPerson().loadPeople();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
