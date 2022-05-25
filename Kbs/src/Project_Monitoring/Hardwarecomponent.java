package Project_Monitoring;
import Monitoring.HardwareComponent;

import javax.swing.*;
import java.net.URL;
import java.sql.*;
public class Hardwarecomponent {
    private int idComponent;
    private String naam;
    private Boolean heeftVerbinding;
    private double uptime;
    private double cpu;
    private double disk;
    private String url = "jdbc:mysql://localhost:3306/Monitoring";
    private String username = "root", password = "";
    private ImageIcon afbeelding = new ImageIcon("webserver.png");



    //constructor
    public Hardwarecomponent(int idComponent){
        this.idComponent = idComponent;
        getUptime();
        getCpu();
        getDisk();
        getNaam();
        getHeeftVerbinding();
        setImage();
    }





    //getters
    public double getUptime() {


        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Meeting WHERE idComponent=? AND idSensor=?");
            statement.setInt(1,idComponent);
            statement.setInt(2,3);
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                this.uptime = rs.getDouble("waarde");
            }
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
           this.uptime = 0;
        }
        System.out.println(uptime); // verwijderen

       return this.uptime;
    }

    public double getCpu() {

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Meeting WHERE idComponent=? AND idSensor=?");
            statement.setInt(1,idComponent);
            statement.setInt(2,1);
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                this.cpu = rs.getDouble("waarde");
            }
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
            this.cpu = 0;
        }
        System.out.println(cpu); // verwijderen

        return this.cpu;
    }

    public double getDisk() {


        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Meeting WHERE idComponent=? AND idSensor=?");
            statement.setInt(1,idComponent);
            statement.setInt(2,2);
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                this.disk = rs.getDouble("waarde");
            }
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
            this.disk = 0;
        }
        System.out.println(disk); // verwijderen

        return this.disk;
    }

    public int getIdComponent() {



        return idComponent;
    }

    public String getNaam() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Hardwarecomponent WHERE idComponent=?");
            statement.setInt(1,idComponent);
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                this.naam = rs.getString("naam");
            }
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
            this.naam = null;
        }
        System.out.println(naam); // verwijderen

        return this.naam;
    }

    public Boolean getHeeftVerbinding() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Hardwarecomponent WHERE idComponent=?");
            statement.setInt(1,idComponent);
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                this.heeftVerbinding = rs.getBoolean("verbindingCheck");
            }
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
            this.heeftVerbinding = false;
        }
        System.out.println(heeftVerbinding); // verwijderen


        return this.heeftVerbinding;
    }
    public ImageIcon getAfbeelding() {
        return afbeelding;
    }

    public void setImage(){
        if(idComponent == 1 || idComponent == 2){
            this.afbeelding = new ImageIcon("src/Project_Monitoring/databaseserver.png");
        }else{
            this.afbeelding = new ImageIcon( "src/Project_Monitoring/webserver.png");
        }
    }







}
