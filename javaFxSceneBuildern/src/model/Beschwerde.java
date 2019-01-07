package model;

public class Beschwerde {

	private String email;
	private String anliegen;
	private String nachricht;
	
	public Beschwerde () {
		
	}

	public Beschwerde(String email, String anliegen, String nachricht) {
		super();
		this.email = email;
		this.anliegen = anliegen;
		this.nachricht = nachricht;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAnliegen() {
		return anliegen;
	}

	public void setAnliegen(String anliegen) {
		this.anliegen = anliegen;
	}

	public String getNachricht() {
		return nachricht;
	}

	public void setNachricht(String nachricht) {
		this.nachricht = nachricht;
	}
	
	
	@Override
	public boolean equals (Object obj) {
		
		if (!(obj instanceof Beschwerde) )
			return false;
		Beschwerde that =  (Beschwerde) obj;
		if (that.email.equals(this.email) && that.anliegen.equals(this.anliegen))
			return true;
		
		return false;
	}
	
	@Override
	public String toString () {
		return email +" " + anliegen;
		
	}
	
	
	
	
	
	
	
	
	
	
}
