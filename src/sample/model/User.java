package sample.model;

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

    //mungkin isinya ntar nyambung ke login
    //public boolean Login(){}

}
