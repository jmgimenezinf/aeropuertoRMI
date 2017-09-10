package Consultas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import Avion.Avion;
import Middleware.SingletonNTP;

public class ConsultasSQL {
	private Connection connect = null;
	public static ConsultasSQL instancia = null;

	public ConsultasSQL() {

		try {
			setConnect(DriverManager
					.getConnection("jdbc:mysql://localhost/aeropuerto?"
							+ "user=martin&password=martin"));

			// Do something with the Connection

		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}

	public void createAvion(Avion avion,int puerto,String date) {
		PreparedStatement stmt=null;
		try {
			stmt = (PreparedStatement) this.getConnect()
					.prepareStatement(
							"INSERT INTO Avion(nombre,estado,hora_solicitud,nro_turno,nro_pista,puerto) "
									+ "VALUES (?,?,?,null,null,?)");
			stmt.setString(1, avion.getNombre());
			stmt.setString(2, "SOLICITANDO PISTA");
			Date dateTime = SingletonNTP.getInstancia().stringToDate(date);
			Timestamp sqlTimeStamp = new Timestamp(dateTime.getTime());
			stmt.setTimestamp(3,sqlTimeStamp);
			stmt.setInt(4, puerto);
			stmt.executeUpdate();
			String query = "SELECT MAX(idAvion) as ultimoAvion FROM aeropuerto.avion ";
		    ResultSet rs = stmt.executeQuery(query);
		    rs.next();
		    avion.setId(rs.getInt(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void agregarTurno(Avion avion , int nroTurno){
	     String query = "UPDATE aeropuerto.avion set estado='SOBREVOLANDO', nro_turno = ?  where idAvion = ?";
	      PreparedStatement preparedStmt;
		try {
			preparedStmt = this.getConnect().prepareStatement(query);
			preparedStmt.setInt(2,avion.getId());
		    preparedStmt.setInt(1,nroTurno);
		    preparedStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	}
	public void aterrizando(Avion avion,int nroPista){
		 String query = "UPDATE aeropuerto.avion set estado='ATERRIZANDO',nro_pista=? where idAvion = ?";
		 PreparedStatement preparedStmt;
			try {
				preparedStmt = this.getConnect().prepareStatement(query);
				preparedStmt.setInt(1,nroPista);
				preparedStmt.setInt(2,avion.getId());
			    preparedStmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public void aterrizado(Avion avion){
		String query = "UPDATE aeropuerto.avion set estado='ATERRIZADO'where idAvion = ?";
		 PreparedStatement preparedStmt;
			try {
				preparedStmt = this.getConnect().prepareStatement(query);
				preparedStmt.setInt(1,avion.getId());
			    preparedStmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	public static ConsultasSQL getInstancia() {
		if (instancia == null) {
			instancia = new ConsultasSQL();
		}
		return instancia;
	}

	public Connection getConnect() {
		return connect;
	}

	public void setConnect(Connection connect) {
		this.connect = connect;
	}

}
