package sample.model;

import sample.utils.DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {
    private int id;
    private String name;
    private String username;
    private String password;

    //aku nambahin dr sini
    public User(){}

    public User(int id, String name){ /*kayanya ambil dr database*/}

    public User(String username, String password){ /* ini juga*/}

    //gatau ini bener apa engga
    public User(int id, String name, String username, String password){
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
    }
    public static boolean getLogin(String username, String password){
        DBConnector connectNow = new DBConnector();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM users WHERE username = '"+username+"' AND password = md5('"+password+"');";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            while (queryResult.next()){
                if (queryResult.getInt(1)==1){
                    try {
                        return true;
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                }else {
                    return false;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
        return false;
    }


    //mungkin isinya ntar nyambung ke login
    //public boolean Login(){}

}
