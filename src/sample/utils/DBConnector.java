package sample.utils;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

public class DBConnector {
    // objects to hold the data
    private TableView tableView;
    private ObservableList<ObservableList> queryData;
    public Connection databaseLink;

    // this method used to verify login
    String dbName = "guild";
    String dbUser = "root";
    String dbPassword = "";
    String url = "jdbc:mysql://localhost:3306/"+dbName;

    public Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,dbUser,dbPassword);
        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
        return databaseLink;
    }

    // initialize the objects
    public DBConnector() {
        queryData = null;
        tableView = null;
    }

    public void insert(String dbCommand) {
        try {
            Connection conn = DriverManager.getConnection(url,dbUser,dbPassword);
            Statement st = conn.createStatement();
            st.executeUpdate(dbCommand);
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void update(String dbCommand) {
        // try to connect to the database
        try (Connection dbConnection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db_oop?serverTimezone=UTC",
                "root", "");
             Statement statement = dbConnection.createStatement();) {

            // execute the command to update the table
            statement.executeUpdate(dbCommand);
        }
        // if something is wrong, it will be found here
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void delete(String dbCommand) {
        // try to connect to the database
        try (Connection dbConnection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db_oop?serverTimezone=UTC",
                "root", "");
             Statement statement = dbConnection.createStatement();) {

            // execute the command to update the table
            statement.executeUpdate(dbCommand);
        }
        // if something is wrong, it will be found here
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}