package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Person implements Serializable{
	

	private static final long serialVersionUID = 2844634059313740890L;
	private String fNavn;
	private String eNavn;
	private int alder;
	private static int id = 0;
	private int id_;
	private static ArrayList<Person> persons = new ArrayList<>();
	public String getfNavn() {
		return fNavn;
	}
	public int getCurrID(){
		return id;
	}
	public int getId(){
		return id_;
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
		this.id_ = Person.id;
		Person.id++;
		Person.getPersons().add(this);
	}
	
	public Person(int ID, String fNavn, String eNavn, int alder) {
		super();
		this.fNavn = fNavn;
		this.eNavn = eNavn;
		this.alder = alder;
		this.id_ = ID;
		Person.id = ID + 1;
		Person.getPersons().add(this);
	}
	@Override
	public String toString() {
		return id_ + ": " + fNavn + " " + eNavn + " " + alder + " År";
	}
	
}
