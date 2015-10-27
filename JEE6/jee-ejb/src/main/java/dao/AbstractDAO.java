package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public abstract class AbstractDAO {

	protected Connection con = null;
	protected Statement st = null;

	protected void getConnection() throws SQLException {
		if (con == null || con.isClosed()) {
			try {
				InitialContext initialContext = new InitialContext();
				DataSource dataSource = (DataSource) initialContext.lookup("java:/MySqlDS");
				con = dataSource.getConnection();
			} catch (NamingException e) {
				System.out.println("Error: " + e.getMessage());
				con = null;
			}
		}
		st = getStatement();
	}

	private Statement getStatement() throws SQLException {
		try {
			if (con == null) {
				String msg = "AbstractDAO.getStatement() : con == null";
				throw new SQLException(msg);
			}
			return con.createStatement();
		} catch (SQLException sqlEx) {
			System.out.println("Error: " + sqlEx.getMessage());
			throw sqlEx;
		}
	}

	protected ResultSet executeSelect(String request) throws SQLException {
		ResultSet rs = null;

		try {
			rs = st.executeQuery(request);
		} catch (SQLException sqlE) {
			System.out.println("Error: " + sqlE.getMessage());
			throw sqlE;
		}
		return rs;
	}
}
