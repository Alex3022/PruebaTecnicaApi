package co.com.sofka.utils.database;

import java.sql.*;
import java.util.logging.Logger;

import static co.com.sofka.utils.database.SqlTemplate.getTable;


public class ConnectSQLite {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(ConnectSQLite.class));
    public static Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:src/test/resources/database/data.db";
            conn = DriverManager.getConnection(url);

        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return conn;
    }

    public static long selectId(){
  
        long id = 0;
        String query = "SELECT id from pets WHERE id=9223372036854594923";
        try (Connection conn = connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(query)){



            while (rs.next()) {
                    id = Long.parseLong(rs.getString("id"));
            }
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        System.out.println(id);
        return id;
    }

    public static String selectStatus(){

        String status = "";
        String query = "SELECT status from pets WHERE id=9223372036854594923";
        try (Connection conn = connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(query)){



            while (rs.next()) {
                status = rs.getString("status");
            }
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        System.out.println(status);
        return status;
    }

    public static String selectName(){

        String name= "";
        String query = "SELECT name from pets WHERE id=9223372036854594923";
        try (Connection conn = connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(query)){

            while (rs.next()) {
                name = rs.getString("name");
            }
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        System.out.println(name);
        return name;
    }


}
