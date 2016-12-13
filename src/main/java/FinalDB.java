import java.sql.*;
import java.util.Scanner;

public class FinalDB {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";        //Configure the driver needed
    static final String DB_CONNECTION_URL = "jdbc:mysql://localhost:3306/FinalsDB";     //Connection string – where's the database?
    static final String USER = "sczapuchlak";
    static final String PASSWORD = "stardust123";
    private static final String TABLE_NAME = "femalesuggestions";
    private static final String ID_NUMBER = "idNumber";
    private static final String TOP_COL = "FemaleTopSuggestions";
    private static final String BOTTOM_COL = "FemaleBottomsSuggestions";
    private static final String SHOES_COL = "FemaleShoesSuggestions";
    private static final String ACCESSORIES_COL = "FemaleAccessoriesSuggestions";
    private static final String TEMP_COL = "FemaleTempSuggestions";
    private static final String OCCASION_COL = "FemaleOccasionColumn";
    Scanner newScanner = new Scanner(System.in);

    FinalDB() {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Can't instantiate driver class; check you have drivers and classpath configured correctly?");
            cnfe.printStackTrace();
            System.exit(-1);  //No driver? Need to fix before anything else will work. So quit the program
        }


    }

    public void createTable(){

        try (Connection conn= DriverManager.getConnection(DB_CONNECTION_URL,USER,PASSWORD);
             Statement statement = conn.createStatement()) {
            //You should have already created a database via terminal/command prompt OR MySQL Workbench

            //Create a table in the database, if it does not exist already
            String createTableSQLTemplate= "CREATE TABLE IF NOT EXISTS femalesuggestions (idNumber int(20) PRIMARY KEY, TopColumn varchar(20), BottomsColumn varchar(20)," +
                    "ShoesColumn varchar(20), AccessoriesColumn varchar(20), TemperatureColumn varchar(10), OccasionColumn varchar(10))" ;
            String createTableSQL = String.format(createTableSQLTemplate,ID_NUMBER,TABLE_NAME,TOP_COL,BOTTOM_COL,SHOES_COL,ACCESSORIES_COL,TOP_COL,OCCASION_COL);

            System.out.println(createTableSQL);
            statement.executeUpdate(createTableSQL);
            System.out.println("Created Female Clothing Suggestion Table!");

            statement.close();
            conn.close();


        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
    public String selectingAccessories(){
        String finished =null;
        try (
                Connection conn = DriverManager.getConnection(DB_CONNECTION_URL, USER, PASSWORD);
                Statement statement = conn.createStatement()) {
            System.out.println("Hot Weather Gear! ");
            String selectAcces = "SELECT FemaleAccessoriesSuggestion FROM finalsdb.femalesuggestions";
            ResultSet rsAccess = statement.executeQuery(selectAcces);
            while (rsAccess.next()) {
                String accessH = rsAccess.getObject(5).toString();
                //print what to wear
                finished = "To accessorize you should wear a :"+ accessH;
            }
        }     catch (SQLException se) {
        se.printStackTrace();


    }return finished;
}
    public String selectingSuperColdQueries() {

        String finished = null;
        try (
                Connection conn = DriverManager.getConnection(DB_CONNECTION_URL, USER, PASSWORD);
                Statement statement = conn.createStatement()) {

            //a little redundant, but until I figure out how to do it, this works
            //go through each category and print each query
            System.out.println("Super Cold Weather Gear !");
            String selectSuper = "SELECT t.* FROM finalsdb.femalesuggestions t WHERE TemperatureColumn = 'super'";
            ResultSet rsSuperCold = statement.executeQuery(selectSuper);
            while (rsSuperCold.next()) {
                String topSC = rsSuperCold.getObject(2).toString();
                String bottomSC = rsSuperCold.getObject(3).toString();
                String shoesSC = rsSuperCold.getObject(4).toString();
                String accessSC = rsSuperCold.getObject(5).toString();
                finished = "You should wear a " + topSC + ", " + bottomSC + ", " + shoesSC + ", and " + accessSC + " !";
                ;
                System.out.println(finished);
                rsSuperCold.close();
            }

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return (finished);
    }

    public String selectingColdQueries() {
        String finished = null;

        try (
                Connection conn = DriverManager.getConnection(DB_CONNECTION_URL, USER, PASSWORD);
                Statement statement = conn.createStatement()) {

            System.out.println("Cold Weather Gear! ");
            String selectCold = "SELECT t.* FROM finalsdb.femalesuggestions t WHERE TemperatureColumn = 'cold'";
            ResultSet rsCold = statement.executeQuery(selectCold);
            while (rsCold.next()) {
                String topCC = rsCold.getObject(2).toString();
                String bottomCC = rsCold.getObject(3).toString();
                String shoesCC = rsCold.getObject(4).toString();
                String accessCC = rsCold.getObject(5).toString();
                //print what to wear

                finished = "You should wear a " + topCC + ", " + bottomCC + ", " + shoesCC + ", and " + accessCC + " !";

                rsCold.close();
            }

        } catch (SQLException se) {
            se.printStackTrace();
        }

        return finished;
    }
    public String selectingMediumQueries() {
        String finished = null;

        try (
                Connection conn = DriverManager.getConnection(DB_CONNECTION_URL, USER, PASSWORD);
                Statement statement = conn.createStatement()) {

            System.out.println( "Neutral Weather Gear! ");
                String selectMedium ="SELECT t.* FROM finalsdb.femalesuggestions t WHERE TemperatureColumn = 'cold'";
                ResultSet rsMedium = statement.executeQuery(selectMedium);
                while (rsMedium.next()) {
                    String topM= rsMedium.getObject(2).toString();
                    String bottomM = rsMedium.getObject(3).toString();
                    String shoesM = rsMedium.getObject(4).toString();
                    String accessM = rsMedium.getObject(5).toString();
                    //print what to wear

                    finished= "You should wear a " + topM + ", " + bottomM + ", " + shoesM + ", and " + accessM + " !";
                    rsMedium.close();
                }
        } catch (SQLException se) {
            se.printStackTrace();
        }

        return finished;
    }
    public String selectingWarmQueries() {
        String finished = null;
        try (
                Connection conn = DriverManager.getConnection(DB_CONNECTION_URL, USER, PASSWORD);
                Statement statement = conn.createStatement()) {

                System.out.println( "Warm Weather Gear! ");
                String selectWarm ="SELECT t.* FROM finalsdb.femalesuggestions t WHERE TemperatureColumn = 'warm'";
                ResultSet rsWarm = statement.executeQuery(selectWarm);
                while (rsWarm.next()) {
                    String topW= rsWarm.getObject(2).toString();
                    String bottomW = rsWarm.getObject(3).toString();
                    String shoesW = rsWarm.getObject(4).toString();
                    String accessW = rsWarm.getObject(5).toString();
                    //print what to wear

                    finished = "You should wear a " + topW + ", " + bottomW + ", " + shoesW + ", and " + accessW + " !";
                    rsWarm.close();

                }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return finished;
    }

    public String selectingHotQueries() {
        String finished = null;
        try (
                Connection conn = DriverManager.getConnection(DB_CONNECTION_URL, USER, PASSWORD);
                Statement statement = conn.createStatement()) {
            System.out.println("Hot Weather Gear! ");
            String selectHot = "SELECT t.* FROM finalsdb.femalesuggestions t WHERE TemperatureColumn = 'hot'";
            ResultSet rsHot = statement.executeQuery(selectHot);
            while (rsHot.next()) {
                String topH = rsHot.getObject(2).toString();
                String bottomH = rsHot.getObject(3).toString();
                String shoesH = rsHot.getObject(4).toString();
                String accessH = rsHot.getObject(5).toString();
                //print what to wear
                finished = "You should wear a " + topH + ", " + bottomH + ", " + shoesH + ", and " + accessH + " !";
            }


            rsHot.close();
            statement.close();
            conn.close();

        } catch (SQLException se) {
            se.printStackTrace();
        }

        return finished;


    }}
