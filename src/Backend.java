import java.sql.Connection;
import java.sql.Statement;
import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import org.w3c.dom.Text;

public class Backend {
  // This series of code connects our java code with the mySQL table
  // Make sure to change the values of netID and password if you are not Tanner
  static final String databasePrefix = "college_football_2010";
  static final String netID = "root"; // The Username of the user's mySQL account
  static final String hostName = "localhost";
  static final String databaseURL =
      "jdbc:mysql://" + hostName + "/" + databasePrefix + "?autoReconnect=true&useSSL=false";
  static final String password = "asafafabafb"; // The password of the user's mySQL

  // Stores these three SQL things that will help us connect to and receive output from our database
  private static Connection connection;
  private static Statement statement;

  // Creates an object of "Backend" so that we can keep track of the data that needs to be stored
  public Backend() {
    // Sets up our stored procedures and queries
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      connection = DriverManager.getConnection(databaseURL, netID, password);
    } catch (ClassNotFoundException e1) {
      System.out.println("Class not found.");
    } catch (SQLException e2) {
      System.out.println("SQLException");
    }

  }

  /**
   * Gets information for the stadium of the user's choice of football team User inputs their
   * football team Returns the data as an array containing the home team, stadium name, city, state,
   * capacity, turf, and year opened
   */
  public String getStadium(String team) {
    String stadium = ""; // Sets up the stadium variable to be used later

    try {
      // Creates a statement and prepares the call to the stored procedure
      Statement statement = connection.createStatement();
      CallableStatement myCallStmt = connection.prepareCall("{call getHomeStadium(?, ?)}");

      // Sets the input
      myCallStmt.setString(1, team); // In Parameter
      myCallStmt.setString(2, stadium);

      // Sets the output
      myCallStmt.registerOutParameter(2, Types.VARCHAR);

      // Executes the code and gets the output
      myCallStmt.execute();
      stadium = myCallStmt.getString(2);

    } catch (SQLException e1) {
      throw new NullPointerException("SQLException in getStadium.");
    }

    return stadium; // 7 columns
  }


  /**
   * Gets the player who scored the most touchdowns in a game for every game of the season User
   * inputs the team that they want to see the "MVPs" for Returns array of every game's date, first
   * and last name of player, touchdowns scored, and rush and rec yards
   */
  public String getMostTDsPerGame(String team) {
    // The maximum number of games played per team was 14,
    // 12 regular season, 1 conference championship, and 1 bowl game
    String MVPs = ""; // Sets up the stadium variable to be used later

    try {
      // Creates a statement and prepares the call to the stored procedure
      statement = connection.createStatement();
      CallableStatement myCallStmt =
          connection.prepareCall("{call getPlayerWithMostTouchdowns(?, ?)}");

      // Sets the input
      myCallStmt.setString(1, team); // In Parameter
      myCallStmt.setString(2, MVPs);

      // Sets the output
      myCallStmt.registerOutParameter(2, Types.VARCHAR);

      // Executes the code and gets the output
      myCallStmt.execute();
      MVPs = myCallStmt.getString(2);

    } catch (SQLException e1) {
      throw new NullPointerException("SQLException in getMostTDsPerGame.");
    }

    // I will put in code that gets rid of any extra null spaces, so don't worry about that
    return MVPs; // 7 columns
  }

  /**
   * Gets the full season stats for the player that has both this first and last name User inputs
   * first and last name Returns array of pass TDs, yards, completions, and attempts, rush TDs and
   * yards, and rec TDs and yards
   */
  public String getSeasonStats(String firstName, String lastName) {
    // Again, the player could have played any number of games, so I will write code later to get of
    // nulls
    String totalStats = new String();

    try {
      // Creates a statement and prepares the call to the stored procedure
      statement = connection.createStatement();
      CallableStatement myCallStmt = connection.prepareCall("{call getTotalSeasonStats(?, ?, ?)}");

      // Sets the input
      myCallStmt.setString(1, firstName); // In Parameter
      myCallStmt.setString(2, lastName);
      myCallStmt.setString(3, totalStats);

      // Sets the output
      myCallStmt.registerOutParameter(3, Types.VARCHAR);

      // Executes the code and gets the output
      myCallStmt.execute();
      totalStats = myCallStmt.getString(3);

    } catch (SQLException e1) {
      throw new NullPointerException("SQLException in getMostTDsPerGame.");
    }

    return totalStats; // 8 columns
  }

  /**
   * Gets information for the game with the highest attendance between two dates User inputs start
   * date and end date Returns array of home team, away team, attendance, stadium name, and
   * city/state
   */
  public String getHighestAttendance(String startDate, String endDate) {
    // Initializes the array that will store all of the information
    String attendanceStats = new String();

    try {
      // Creates a statement and prepares the call to the stored procedure
      statement = connection.createStatement();
      CallableStatement myCallStmt =
          connection.prepareCall("{call getHighestAttendanceGame(?, ?, ?)}");

      // Sets the input
      myCallStmt.setString(1, startDate); // In Parameter
      myCallStmt.setString(2, endDate);
      myCallStmt.setString(3, attendanceStats);

      // Sets the output
      myCallStmt.registerOutParameter(3, Types.VARCHAR);

      // Executes the code and gets the output
      myCallStmt.execute();
      attendanceStats = myCallStmt.getString(3);

    } catch (SQLException e1) {
      throw new NullPointerException("SQLException in getHighestAttendance.");
    }

    // returns the attendance statistics
    return attendanceStats; // 6 columns
  }

  /**
   * Gets information for all games that took place in a user specified stadium User input is the
   * desired stadium Returns array of every game's home team, opponent, date, attendance, and game
   * time
   */
  public String getStadiumInformation(String stadium, String city, String state) {
    // There shouldn't be any stadiums that hosted more than 8 games
    String stadiumStats = new String();

    try {
      // Creates a statement and prepares the call to the stored procedure
      statement = connection.createStatement();
      CallableStatement myCallStmt = connection.prepareCall("{call getGameList(?, ?, ?, ?)}");

      // Sets the input
      myCallStmt.setString(1, stadium); // In Parameter
      myCallStmt.setString(2, city);
      myCallStmt.setString(3, state);
      myCallStmt.setString(4, stadiumStats);

      // Sets the output
      myCallStmt.registerOutParameter(4, Types.VARCHAR);

      // Executes the code and gets the output
      myCallStmt.execute();
      stadiumStats = myCallStmt.getString(4);

    } catch (SQLException e1) {
      throw new NullPointerException("SQLException in getStadiumInformation.");
    }

    // Implements strategy to get rid of empty space in the array

    return stadiumStats; // 5 columns
  }

  /**
   * Gets information for selected player for selected game User input is first and last name of
   * player, and both team names Returns string of player's first and last name and a whole bunch of
   * different statistics
   */
  public String getPlayerStatsForGame(String firstName, String lastName, String team1,
      String team2) {
    // Gets all of the stats for selected player along with first and last name
    String playerGameStats = "";

    try {
      // Creates a statement and prepares the call to the stored procedure
      statement = connection.createStatement();
      CallableStatement myCallStmt = connection.prepareCall("{call getPlayerStats(?, ?, ?, ?, ?)}");

      // Sets the input
      myCallStmt.setString(1, firstName); // In Parameter
      myCallStmt.setString(2, lastName); // In Parameter
      myCallStmt.setString(3, team1); // In Parameter
      myCallStmt.setString(4, team2); // In Parameter
      myCallStmt.setString(5, playerGameStats); // InOut Parameter

      // Sets the output
      myCallStmt.registerOutParameter(5, Types.VARCHAR);

      // Executes the code and gets the output
      myCallStmt.execute();
      playerGameStats = myCallStmt.getString(5);

    } catch (SQLException e1) {
      throw new NullPointerException("SQLException in getPlayerStatsForGame.");
    }

    return playerGameStats; // 10 columns
  }

  /**
   * Gets the top 5 players total TDs and names for a user input team User input is the team they
   * are interested in Returns string of every player's name, class level, total touchdowns, and
   * uniform number
   */
  public String getTop5TDs(String team) {
    // Gets statistics for the top 5 players on this team in TDs for the season
    String top5TDs = "";

    try {

      // Creates a statement and prepares the call to the stored procedure
      statement = connection.createStatement();
      CallableStatement myCallStmt = connection.prepareCall("{call getTopFivePlayers(?, ?)}");

      // Sets the input
      myCallStmt.setString(1, team); // In Parameter
      myCallStmt.setString(2, top5TDs); // InOut Parameter

      // Sets the output
      myCallStmt.registerOutParameter(2, Types.VARCHAR);

      // Executes the code and gets the output
      myCallStmt.execute();
      top5TDs = myCallStmt.getString(2);

    } catch (SQLException e1) {
      throw new NullPointerException("SQLException in getTop5TDs.");
    }

    return top5TDs; // 5 columns
  }

  /**
   * Gets the season stats for every player on every team that played the user given position User
   * input is the position of interest Outputs an array of every players name and total season stats
   */
  public String getPosStats(String position) {
    // Holds all season stats for player that played the position of the user's choice
    // First name, last name, pass attempts, completions, yards, and TDs, rush TDs and yards,
    // receiving TDs and yards
    String statsPerPos = ""; // This will be changed later to hold all of the stats

    try {

      // Creates a statement and prepares the call to the stored procedure
      statement = connection.createStatement();
      CallableStatement myCallStmt =
          connection.prepareCall("{call getPositionSpecificTotalSeasonStats(?, ?)}");

      // Sets the input
      myCallStmt.setString(1, position); // In Parameter
      myCallStmt.setString(2, statsPerPos); // InOut Parameter

      // Sets the output
      myCallStmt.registerOutParameter(2, Types.VARCHAR);

      // Executes the code and gets the output
      myCallStmt.execute();
      statsPerPos = myCallStmt.getString(2);

    } catch (SQLException e1) {
      throw new NullPointerException("SQLException in getPosStats." + e1);
    }

    return statsPerPos; // 10 columns
  }

  /**
   * Gets information on the who players who play a position on the team of user's choice User
   * inputs team they are curious about Returns an array of everybody on the secondary's first and
   * last name, class, position, and jersey number
   */
  public String getPosPerTeam(String position, String team) {
    // Holds the information for everybody that plays in the secondary on this team
    String posPerTeam = ""; // Dimensions of this will be set when I get the data
    try {

      // Creates a statement and prepares the call to the stored procedure
      statement = connection.createStatement();
      CallableStatement myCallStmt =
          connection.prepareCall("{call getPlayerListFromTeam(?, ?, ?)}");

      // Sets the input
      myCallStmt.setString(1, position); // In Parameter
      myCallStmt.setString(2, team); // In Parameter
      myCallStmt.setString(3, posPerTeam); // InOut Parameter

      // Sets the output
      myCallStmt.registerOutParameter(3, Types.VARCHAR);

      // Executes the code and gets the output
      myCallStmt.execute();
      posPerTeam = myCallStmt.getString(3);

    } catch (SQLException e1) {
      throw new NullPointerException("SQLException in getPosPerTeam.");
    }

    return posPerTeam; // 5 columns
  }

  /**
   * Closes the connection between the java application and the MySQL server.
   */
  public void closeConnection() {
    try {
      connection.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
