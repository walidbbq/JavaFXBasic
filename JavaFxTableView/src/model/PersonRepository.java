package model;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.PreparedQuery;
import com.mysql.cj.xdevapi.Result;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import java.sql.DriverManager;
//import java.sql.SQLException;

public class PersonRepository extends Thread {
	public static Connection conn;

	private static ObservableList<Person> personen = FXCollections.observableArrayList();
//	
//	public static ObservableList <Person> getPersonen () {
//		return personen;
//	}

//	public static void addToPersonen (Person p) {
//		personen.add(p);
//	}
//	
//	public static void removeFromPersonen (Person p) {
//		personen.remove(p);
//	}

	public static List<Person> LeseDb() {
		List<Person> listePersonen = new ArrayList<>();
		String sql = "SELECT * FROM person";
		try {
			Statement stm = conn.createStatement();
			ResultSet result = stm.executeQuery(sql);

			while (result.next()) {
				long bid = (long) result.getInt("pid");
				String vorname = result.getString("vorname");
				String nachname = result.getString("nachname");

				Person p = new Person(bid, vorname, nachname);
				listePersonen.add(p);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listePersonen;

	}

	public static ObservableList<Person> holeAllePersonenAusDbOL() {
		String sql = "SELECT * FROM person";
		try {
			Statement stm = conn.createStatement();
			ResultSet result = stm.executeQuery(sql);

			while (result.next()) {
				long bid = (long) result.getInt("pid");
				String vorname = result.getString("vorname");
				String nachname = result.getString("nachname");

				Person p = new Person(bid, vorname, nachname);
				synchronized (personen) {
					if (!personen.contains(p)) {
						personen.add(p);
					}
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return personen;

	}

	public static boolean insertIntoPersonDB(String vorname, String nachname) {

		Person p = new Person();
		p.setVorname(vorname);
		p.setNachname(nachname);

		String insertSql = "INSERT INTO person (vorname,nachname) VALUES (?,?)";
		synchronized (personen) {

			if (!personen.contains(p)) {
				try (PreparedStatement prep = conn.prepareStatement(insertSql)) {
					prep.setString(1, vorname);
					prep.setString(2, nachname);
					synchronized (p) {

					}
					prep.executeUpdate();
					personen.add(p);
					return true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
			}
		}
		return true;
	}

	public static boolean deleteFromPersonDB(String vorname, String nachname) {

		Person p = new Person();
		p.setVorname(vorname);
		p.setNachname(nachname);

		String deleteSql = "DELETE FROM person WHERE vorname=? AND nachname=? ";
		synchronized (personen) {
			if (personen.contains(p)) {
				try (PreparedStatement prep = conn.prepareStatement(deleteSql)) {
					prep.setString(1, vorname);
					prep.setString(2, nachname);
					synchronized (p) {
						prep.executeUpdate();
						personen.remove(p);
					}
					return true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
			}
		}
		return false;

	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("aus Run Method");
//			for (Person p : LeseDb()) {
//				synchronized (personen) {
//					if (!personen.contains(p)) {
//						personen.add(p);
//						System.out.println("aus add liste");
//					}
//				}
//			}
			holeAllePersonenAusDbOL();
			synchronized (personen) {
				for (int i = 0; i < personen.size(); i++) {
					if (!LeseDb().contains(personen.get(i))) {
						Person pRaus = personen.get(i);
						personen.remove(pRaus);
						System.out.println("aus remove liste");
						i--;
					}
				}
			}
		}
	}
}
