package model;

public class Person {
	private long bid; 
	private String vorname;
	private String nachname;
	
	public Person() {}

	public Person(long bid ,String vorname, String nachname) {
		this.bid=bid;
		this.vorname = vorname;
		this.nachname = nachname;
	}
	


	public long getBid() {
		return bid;
	}

	public void setBid(long bid) {
		this.bid = bid;
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

	@Override
	public String toString() {
		return bid + " " + vorname + " " + nachname;
	} 
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person that = (Person) obj;
			if (that.bid==this.bid &&
				that.vorname.equalsIgnoreCase(this.vorname) &&
				that.nachname.equalsIgnoreCase(this.nachname)) {
				return true;
			}		
		}
		return false;
	}	
}
