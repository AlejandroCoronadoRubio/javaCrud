package database;

import java.sql.*;

public class baseDatos {

    private Connection _connection = null;

    public baseDatos() {

//        String _url = "jdbc:mysql://localhost:3306/sapitoPrueba";
        String _url = "jdbc:mysql://localhost:3306/jspbasiccrud";
//        String password = "phantomteam";
        String password = "";
        String _user = "root";

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            this._connection = DriverManager.getConnection(_url, _user, password);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return this._connection;
    }

    public void closeConnection() {
        if (this._connection != null) {
            try {
                this._connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

}
