package application;

public class Person {
	
	private String vorname;
	private String nachname;
	
	Person () {
		
	}
	
	Person (String vorname , String nachname) {
		this.vorname=vorname;
		this.nachname=nachname;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	
	public String toString () {

		return vorname + " " + nachname;
	}
	
	
	

}
