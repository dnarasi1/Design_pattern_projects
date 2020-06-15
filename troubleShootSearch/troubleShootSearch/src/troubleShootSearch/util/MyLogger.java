/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dheeraj_deshmudre_5.troubleShootSearch.src.troubleShootSearch.util;

/**
 *
 * @author dheer
 */
public class MyLogger {
    /*DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
      DEBUG_VALUE=3 [Print to stdout everytime when the visitor method is called]
      DEBUG_VALUE=2 [Print to stdout everytime an entry has made to results]
      DEBUG_VALUE=1 [Print the search results to stdout]
      DEBUG_VALUE=0 [No output should be printed from the applicatio to stdout. It is ok to write to the output file though" ]
    */

    /**
     *
     */


    public static enum DebugLevel {CONSTRUCTOR, VISITOR, IN_RESULTS, IN_RUN, SEARCH_RESULTS 
                                   };

    private static DebugLevel debugLevel;

    /**
     *
     * @param levelIn
     */
    public static void setDebugValue (int levelIn) {
	switch (levelIn) {
	  case 4: debugLevel = DebugLevel.CONSTRUCTOR; break;
	      // FIXME: add code for other cases
          case 3: debugLevel = DebugLevel.VISITOR; break;
          case 2: debugLevel = DebugLevel.IN_RESULTS; break;
          case 1: debugLevel = DebugLevel.SEARCH_RESULTS; break;
	  case 0: debugLevel = DebugLevel.IN_RUN; break;
	}
    }

    /**
     *
     * @param levelIn
     */
    public static void setDebugValue (DebugLevel levelIn) {
	debugLevel = levelIn;
    }

    // @return None

    /**
     *
     * @param message
     * @param levelIn
     */
    public static void writeMessage (String  message  ,
                                     DebugLevel levelIn ) {
	if (levelIn == debugLevel)
	    System.out.println(message);
    }

    /**
	 * @return String
	 */
    @Override
    public String toString() {
	return "Debug Level is " + debugLevel;
}
}
