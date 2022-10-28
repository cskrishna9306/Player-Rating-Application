public class BackendTester {

  /**
   * Tests the functionality of 5 methods from the Backend class by comparing their output with the
   * expected results.
   * 
   * @param args
   */
  public static void main(String[] args) {

    Backend back = new Backend();

    String[] test;
    // Test 1: Testing if the home stadium for the specified team is correct
    try {
      test = back.getStadium("wisconsin").split("\t");
      if (test[0].equals("Wisconsin") && test[2].equals("Camp Randall Stadium")
          && test[3].equals("Madison") && test[4].equals("WI") && test[5].equals("79500")
          && test[6].equals("FieldTurf") && test[7].equals("1917"))
        System.out.println("Test 1: PASSED");
      else
        System.out.println("Test 1: FAILED");
    } catch (Exception e) {
      System.out.println("Test 1: FAILED");
    }

    // Test 2: Testing if the total season statistics of a specified player are displayed correctly
    try {
      test = back.getSeasonStats("alex", "allen").split("\t");
      if (test[0].equals("Alex") && test[2].equals("Allen") && test[3].equals("0")
          && test[4].equals("0") && test[5].equals("0") && test[6].equals("0")
          && test[7].equals("6") && test[8].equals("446") && test[9].equals("0")
          && test[10].equals("52"))
        System.out.println("Test 2: PASSED");
      else
        System.out.println("Test 2: FAILED");
    } catch (Exception e) {
      System.out.println("Test 2: FAILED");
    }

    // Test 3: Testing if displaying the player with the most TDs from a user specified team in each
    // game is correct
    try {
      test = back.getTop5TDs("ohio").split("\t");
      if (test[0].equals("Riley") && test[2].equals("Dunlop") && test[3].equals("JR")
          && test[4].equals("2") && test[5].equals("15") && test[6].equals("\nPhil")
          && test[8].equals("Bates") && test[9].equals("JR") && test[10].equals("3")
          && test[11].equals("5") && test[12].equals("\nTerrence") && test[14].equals("McCrae")
          && test[15].equals("SR") && test[16].equals("3") && test[17].equals("11")
          && test[18].equals("\nVince") && test[20].equals("Davidson") && test[21].equals("SR")
          && test[22].equals("4") && test[23].equals("26") && test[24].equals("\nBoo")
          && test[26].equals("Jackson") && test[27].equals("SR") && test[28].equals("10")
          && test[29].equals("8"))
        System.out.println("Test 3: PASSED");
      else
        System.out.println("Test 3: FAILED");
    } catch (Exception e) {
      System.out.println("Test 3: FAILED");
    }

    // Test 4: Testing if displaying the home team, visit team, date, attendance, and duration of
    // all the games that took place in a user specified stadium is correct
    try {
      test = back.getStadiumInformation("camp randall stadium", "madison", "wi").split("\t");
      if (test[0].equals("Wisconsin") && test[2].equals("San Jose State")
          && test[3].equals("2009-11-10") && test[4].equals("78469") && test[5].equals("182")
          && test[6].equals("\nWisconsin") && test[8].equals("Minnesota")
          && test[9].equals("2010-09-10") && test[10].equals("80328") && test[11].equals("189"))
        System.out.println("Test 4: PASSED");
      else
        System.out.println("Test 4: FAILED");
    } catch (Exception e) {
      System.out.println("Test 4: FAILED");
    }

    // Test 5: Test if displaying the player with the most touchdowns (Rec TD + Rush TD) from a user
    // specified team in each game is correct
    try {
      test = back.getMostTDsPerGame("ohio").split("\t");
      if (test[0].equals("2010-09-10") && test[2].equals("Kyle") && test[3].equals("Clinton")
          && test[4].equals("3") && test[5].equals("0") && test[6].equals("0")
          && test[7].equals("\n2011-04-10") && test[9].equals("Kyle") && test[10].equals("Clinton")
          && test[11].equals("4") && test[12].equals("0") && test[13].equals("0")
          && test[14].equals("\n2010-02-10") && test[16].equals("Kyle")
          && test[17].equals("Clinton") && test[18].equals("3") && test[19].equals("0")
          && test[20].equals("0") && test[21].equals("\n2009-11-10") && test[23].equals("Elijah")
          && test[24].equals("Jones") && test[25].equals("2") && test[26].equals("0")
          && test[27].equals("0") && test[28].equals("\n2009-04-10") && test[30].equals("Mike")
          && test[31].equals("McCrimon") && test[32].equals("1") && test[33].equals("0")
          && test[34].equals("0"))
        System.out.println("Test 5: PASSED");
      else
        System.out.println("Test 5: FAILED");
    } catch (Exception e) {
      System.out.println("Test 5: FAILED");
    }

    back.closeConnection();
  }
}
