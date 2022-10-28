import java.util.Scanner;

public class Frontend {

  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    String userChoice;
    Backend back = new Backend();
    do {
      System.out.println("Please enter the number of the question you would like answered\n");
      System.out.println(
          "1. Display the home stadium name, city, state, capacity, surface, and year opened for your choice of team.");
      System.out.println(
          "2. Display the player with the most touchdowns (Rec TD + Rush TD + Pass TD) for a team of your choice in each game. List the game date, player with most TDs, the amount of touchdowns, and the amount of both receiving and rushing yards");
      System.out.println("3. Display the total season stats for the player of your choice.");
      System.out.println(
          "4. Display the participating teams, date, attendance, and location of the game with the highest attendance between two specified dates of your choosing.");
      System.out.println(
          "5. Display the home team, visit team, date, attendance, and duration of all the games that took place in a stadium of your choosing");
      System.out.println(
          "6. Display the stats of a player of your choosing for a game between your choice of two teams");
      System.out.println(
          "7. Display the name, position, class, number of touchdowns, and uniform number of the top 5 players total touchdowns from a team of your choosing from the 2010 season");
      System.out.println(
          "8. Display the total season stats for each player playing your specified position");
      System.out.println(
          "9. Display the complete list of the players playing a position of your choice including all of their full names, class, position, and jersey numbers for a team of your choice.");
      System.out.println("10. Exit the application\n");

      System.out.print("Enter your choice: ");
      userChoice = scan.nextLine();
      System.out.println();
      String[] str;
      switch (userChoice) {
        case "1":
          try {
            System.out.print("Please enter a team of your choice: ");
            String team = scan.nextLine();
            System.out.println();

            if (back.getStadium(team).equals("")) {
              System.out.println("Wrong Input. Please try again later");
              break;
            }

            str = back.getStadium(team).split("\t");
            System.out.println("Team Name: " + str[0]);
            System.out.println("Home Stadium: " + str[2]);
            System.out.println("City: " + str[3]);
            System.out.println("State: " + str[4]);
            System.out.println("Capacity: " + str[5]);
            System.out.println("Field Type: " + str[6]);
            System.out.println("Year Opened: " + str[7]);
          } catch (Exception e) {
            System.out.println("Wrong Input. Please try again later");
          }
          break;

        case "2":
          try {
            System.out.print("Please enter a team of your choice: ");
            String team = scan.nextLine();
            System.out.println();

            if (back.getMostTDsPerGame(team).equals("")) {
              System.out.println("Wrong Input. Please try again later");
              break;
            }

            System.out.println("Date\t\tLast Name\tFirst Name\tTotal Touchdowns\tRush Yards\tReceiving Yards");
            System.out.println("----------------------------------------------------------------------------------------------------");
            str = back.getMostTDsPerGame(team).split("\t");
            for (int i = 0; i < str.length; i++) {
              if (i % 7 == 1)
                i++;
              System.out.print(str[i]);
              if (i % 7 == 0)
                System.out.print("\t");
              else if (i % 7 == 2) {
                if (str[i].length() < 8)
                  System.out.print("\t\t");
                else
                  System.out.print("\t");
              } else if (i % 7 == 3) {
                if (str[i].length() < 8)
                  System.out.print("\t\t");
                else
                  System.out.print("\t");
              } else if (i % 7 == 4)
                System.out.print("\t\t\t");
              else if (i % 7 == 5)
                System.out.print("\t\t");
              else if (i % 7 == 6)
                System.out.print("\t");
            }
          } catch (Exception e) {
            System.out.println("Wrong Input. Please try again later");
          }
          break;

        case "3":
          try {
            System.out.print("Please enter the first name of the player of your choice: ");
            String firstName = scan.nextLine();
            System.out.println();
            System.out.print("Please enter the last name of the player of your choice: ");
            String lastName = scan.nextLine();
            System.out.println();

            if (back.getSeasonStats(firstName, lastName).equals("")) {
              System.out.println("Wrong Input. Please try again later");
              break;
            }

            str = back.getSeasonStats(firstName, lastName).split("\t");

            System.out.println("First Name: " + str[0]);
            System.out.println("Last Name: " + str[2]);
            System.out.println("Total Pass Attempts: " + str[3]);
            System.out.println("Total Pass Completions: " + str[4]);
            System.out.println("Total Pass Yards: " + str[5]);
            System.out.println("Total Pass Touchdowns: " + str[6]);
            System.out.println("Total Rush Touchdowns: " + str[7]);
            System.out.println("Total Rush Yards: " + str[8]);
            System.out.println("Total Receiving Yards: " + str[9]);
          } catch (Exception e) {
            System.out.println("Wrong Input. Please try again later");
          }
          break;

        case "4":
          try {
            System.out.print("Please enter the starting date in yyyy-mm-dd format: ");
            String startDate = scan.nextLine();
            System.out.println();
            System.out.print("Please enter the ending date in yyyy-mm-dd format: ");
            String endDate = scan.nextLine();
            System.out.println();

            if (back.getHighestAttendance(startDate, endDate).equals("")) {
              System.out.println("Wrong Input. Please try again later");
              break;
            }

            str = back.getHighestAttendance(startDate, endDate).split("\t");

            System.out.println("Home Team: " + str[0]);
            System.out.println("Visit Team: " + str[2]);
            System.out.println("Date: " + str[3]);
            System.out.println("Attendance: " + str[4]);
            System.out.println("Stadium: " + str[5]);
            System.out.println("City: " + str[6]);
            System.out.println("State: " + str[7]);
          } catch (NullPointerException e) {
            System.out.println("No games occurred between these two dates");
          }
          break;

        case "5":
          try {
            System.out.print("Please enter a stadium of your choice: ");
            String stadium = scan.nextLine();
            System.out.println();
            System.out.print("Please enter a city of your choice: ");
            String city = scan.nextLine();
            System.out.println();
            System.out.print("Please enter a state of your choice: ");
            String state = scan.nextLine();
            System.out.println();

            if (back.getStadiumInformation(stadium, city, state).equals("")) {
              System.out.println("Wrong Input. Please try again later");
              break;
            }
            
            System.out.println("Home Team\tVisit Team\t\tDate\t\tAttendance\tDuration");
            System.out.println("-------------------------------------------------------------------------------");
            str = back.getStadiumInformation(stadium, city, state).split("\t");
            for (int i = 0; i < str.length; i++) {
              if (i % 6 == 1)
                i++;
              System.out.print(str[i]);
              if (i % 6 == 0) {
                if (str[i].length() > 5)
                  System.out.print("\t");
                else
                  System.out.print("\t\t");
              } else if (i % 6 == 2) {
                if (str[i].length() < 8)
                  System.out.print("\t\t\t");
                else
                  System.out.print("\t\t");
              } else if (i % 6 == 3)
                System.out.print("\t");
              else if (i % 6 == 4)
                System.out.print("\t\t");
              else if (i % 6 == 5)
                System.out.print("\t");
            }
          } catch (Exception e) {
            System.out.println("Wrong Input. Please try again later");
          }
          break;

        case "6":
          try {
            System.out.print("Please enter the first team: ");
            String team1 = scan.nextLine();
            System.out.println();
            System.out.print("Please enter the second team: ");
            String team2 = scan.nextLine();
            System.out.println();
            System.out.print("Please enter the first name of the player: ");
            String firstName = scan.nextLine();
            System.out.println();
            System.out.print("Please enter the last name of the player: ");
            String lastName = scan.nextLine();
            System.out.println();
            
            if (back.getPlayerStatsForGame(firstName, lastName, team1, team2).equals("")) {
              System.out.println("Wrong Input. Please try again later");
              break;
            }
            
            System.out.println("First Name\tLast Name\tPass Attempts\tPass Completions\tPass Yards\tPass Touchdowns\tRush Touchdowns\tRush Yards\tRec Touchdowns\tRec Yards");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            str = back.getPlayerStatsForGame(firstName, lastName, team1, team2).split("\t");
            for (int i = 0; i < str.length; i++) {
              if (i % 11 == 1)
                i++;
              System.out.print(str[i]);
              if (i % 11 == 0) {
                if (str[i].length() < 8)
                  System.out.print("\t\t");
                else
                  System.out.print("\t");
              } else if (i % 11 == 2) {
                if (str[i].length() < 8)
                  System.out.print("\t\t");
                else
                  System.out.print("\t");
              } else if (i % 11 == 3)
                  System.out.print("\t\t");
              else if (i % 11 == 4)
                System.out.print("\t\t\t");
              else if (i % 11 == 5)
                System.out.print("\t\t");
              else if (i % 11 == 6)
                System.out.print("\t\t");
              else if (i % 11 == 7)
                System.out.print("\t\t");
              else if (i % 11 == 8)
                System.out.print("\t\t");
              else if (i % 11 == 9)
                System.out.print("\t\t");
              else if (i % 11 == 10)
                System.out.print("\t\t");
            }
          } catch (Exception e) {
            System.out.println("Wrong Input. Please try again later");
          }
          break;

        case "7":
          try {
            System.out.print("Please enter a team of your choice: ");
            String team = scan.nextLine();
            System.out.println();
            
            if (back.getTop5TDs(team).equals("")) {
              System.out.println("Wrong Input. Please try again later");
              break;
            }
            
            System.out.println("First Name\tLast Name\tClass\tTotal Touchdowns\tUniform Number");
            System.out.println("---------------------------------------------------------------------------------------");
            str = back.getTop5TDs(team).split("\t");
            for (int i = 0; i < str.length; i++) {
              if (i % 6 == 1)
                i++;
              System.out.print(str[i]);
              if (i % 6 == 0) {
                if (str[i].length() <= 8)
                  System.out.print("\t\t");
                else
                  System.out.print("\t");
              } else if (i % 6 == 2) {
                if (str[i].length() < 8)
                  System.out.print("\t\t");
                else
                  System.out.print("\t");
              } else if (i % 6 == 3)
                  System.out.print("\t");
              else if (i % 6 == 4)
                System.out.print("\t\t\t");
              else if (i % 6 == 5)
                System.out.print("\t\t");
            }
          } catch (Exception e) {
            System.out.println("Wrong Input. Please try again later");
          }
          break;

        case "8":
          try {
            System.out.print("Please enter a position of your choice: ");
            String position = scan.nextLine();
            System.out.println();
            
            if (back.getPosStats(position).equals("")) {
              System.out.println("Wrong Input. Please try again later");
              break;
            }
            
            System.out.println("First Name\tLast Name\tPass Attempts\tPass Completions\tPass Yards\tPass Touchdowns\tRush Touchdowns\tRush Yards\tRec Touchdowns\tRec Yards");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            str = back.getPosStats(position).split("\t");
            for (int i = 0; i < str.length; i++) {
              if (i % 11 == 1)
                i++;
              System.out.print(str[i]);
              if (i % 11 == 0) {
                if (str[i].length() <= 8)
                  System.out.print("\t\t");
                else
                  System.out.print("\t");
              } else if (i % 11 == 2) {
                if (str[i].length() < 8)
                  System.out.print("\t\t");
                else
                  System.out.print("\t");
              } else if (i % 11 == 3)
                  System.out.print("\t\t");
              else if (i % 11 == 4)
                System.out.print("\t\t\t");
              else if (i % 11 == 5)
                System.out.print("\t\t");
              else if (i % 11 == 6)
                System.out.print("\t\t");
              else if (i % 11 == 7)
                System.out.print("\t\t");
              else if (i % 11 == 8)
                System.out.print("\t\t");
              else if (i % 11 == 9)
                System.out.print("\t\t");
              else if (i % 11 == 10)
                System.out.print("\t\t");
            }
          } catch (Exception e) {
            System.out.println("Wrong Input. Please try again later");
          }
          break;

        case "9":
          try {
            System.out.print("Please enter a team of your choice: ");
            String team = scan.nextLine();
            System.out.println();
            System.out.print("Please enter a position of your choice: ");
            String position = scan.nextLine();
            System.out.println();
            
            if (back.getPosPerTeam(position, team).equals("")) {
              System.out.println("Wrong Input. Please try again later");
              break;
            }
            
            System.out.println("First Name\tLast Name\tClass\tPosition\tUniform Number");
            System.out.println("---------------------------------------------------------------------------------------");
            str = back.getPosPerTeam(position, team).split("\t");
            for (int i = 0; i < str.length; i++) {
              if (i % 6 == 1)
                i++;
              System.out.print(str[i]);
              if (i % 6 == 0) {
                if (str[i].length() <= 8)
                  System.out.print("\t\t");
                else
                  System.out.print("\t");
              } else if (i % 6 == 2) {
                if (str[i].length() < 8)
                  System.out.print("\t\t");
                else
                  System.out.print("\t");
              } else if (i % 6 == 3)
                  System.out.print("\t");
              else if (i % 6 == 4)
                System.out.print("\t\t");
            }
          } catch (Exception e) {
            System.out.println("Wrong Input. Please try again later");
          }
          break;

        case "10":
          System.out.println("Thank you for using our application !!!!");
          scan.close();
          return;

        default:
          System.out.println("Incorrect formatting or number entered");

      }
      scan.nextLine();
    } while (!userChoice.equals("10"));
    scan.close();
  }
}

