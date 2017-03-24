package model;

import java.util.ArrayList;

public class Person {
	private String fNavn;
	private String eNavn;
	private int alder;
	private static ArrayList<Person> persons = new ArrayList<>();
	public String getfNavn() {
		return fNavn;
	}
	public void setfNavn(String fNavn) {
		this.fNavn = fNavn;
	}
	public String geteNavn() {
		return eNavn;
	}
	public void seteNavn(String eNavn) {
		this.eNavn = eNavn;
	}
	public int getAlder() {
		return alder;
	}
	public void setAlder(int alder) {
		this.alder = alder;
	}
	public static ArrayList<Person> getPersons() {
		return persons;
	}
	public Person(String fNavn, String eNavn, int alder) {
		super();
		this.fNavn = fNavn;
		this.eNavn = eNavn;
		this.alder = alder;
		this.persons.add(this);
	}
	@Override
	public String toString() {
		return fNavn + " " + eNavn + " " + alder + " År";
	}
	
}
