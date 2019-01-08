package model;

public class Person {
	private long pid; 
	private String vorname;
	private String nachname;
	
	public Person() {}

	public Person(long pid, String vorname, String nachname) {
		this.pid=pid;
		this.vorname = vorname;
		this.nachname = nachname;
	}
	


	public long getBid() {
		return pid;
	}

	public void setBid(long bid) {
		this.pid = bid;
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
		return pid + " " + vorname + " " + nachname;
	} 
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person that = (Person) obj;
			if (
				that.vorname.equalsIgnoreCase(this.vorname) &&
				that.nachname.equalsIgnoreCase(this.nachname)) {
				return true;
			}		
		}
		return false;
	}	
}
