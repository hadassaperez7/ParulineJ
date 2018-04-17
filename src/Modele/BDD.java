package Modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDD {
    private String Serveur, db, User, MDP;

    private Connection connection;

    public BDD(String serveur, String db, String User, String MDP) {
        this.Serveur = serveur;
        this.db = db;
        this.User =User;
        this.MDP= MDP;

        this.connection = null;
    }

    // Utilisation de JDBC pour l'utilisation de MySQL
    public void chargerPilote() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException exp) {
            System.out.println("Absence du pilote JDBC.");
        }
    }


    // Connexion à la base de données
    public void SeConnecter() {
        String url = "jdbc:mysql://" + this.Serveur + "/" + this.db;

        try {
                this.connection = DriverManager.getConnection(url, this.User, this.MDP);
            }
            catch (SQLException e) {
                System.out.println("Erreur de connexion à " + url);
                e.printStackTrace();
        }
    }


    // Deconnexion du serveur
    public void SeDeconnecter() {
        try {

            if (this.connection != null) {
                this.connection.close();
            }
        }
        catch (SQLException e) {
            System.out.println("Erreur de fermeture de connexion");
        }
    }


    // GETTERS
    public Connection getMaConnection() {
        return this.connection;
    }
}
