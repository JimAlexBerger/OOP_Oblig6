package main;

import java.awt.EventQueue;

import model.Person;
import view.Gui;

public class main {

	public static void main(String[] args) {
		new Person("Per", "Gunnar", 40);
		new Person("Anette", "Henriksen", 24);
		new Person("Henrik", "Sivertsen", 16);
		new Person("Kjetil", "Pederstad", 74);

		
		
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
