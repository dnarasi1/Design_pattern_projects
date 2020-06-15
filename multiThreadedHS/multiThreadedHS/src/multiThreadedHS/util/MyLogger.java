/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dheeraj_deshmudre_assign_4.multiThreadedHS.src.multiThreadedHS.util;

/**
 *
 * @author dheer
 */
public class MyLogger {
    /*DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
      DEBUG_VALUE=3 [Print to stdout after mergeSort of result data structure]
      DEBUG_VALUE=2 [Print to stdout before mergeSort of result data structure]
      DEBUG_VALUE=1 [Print the data structures of each thread to stdout]
      DEBUG_VALUE=0 [No output should be printed from the applicatio to stdout. It is ok to write to the output file though" ]
    */

    public static enum DebugLevel {RELEASE, FROM_DATA_STRUCTURE, IN_RESULTS, IN_RUN, CONSTRUCTOR
                                   };

    
    private static DebugLevel debugLevel;


    public static void setDebugValue (int levelIn) {
	switch (levelIn) {
	  case 4: debugLevel = DebugLevel.CONSTRUCTOR; break;
	      // FIXME: add code for other cases
          case 3: debugLevel = DebugLevel.IN_RUN; break;
          case 2: debugLevel = DebugLevel.FROM_DATA_STRUCTURE; break;
          case 1: debugLevel = DebugLevel.IN_RESULTS; break;
	  case 0: debugLevel = DebugLevel.RELEASE; break;
	}
    }

    public static void setDebugValue (DebugLevel levelIn) {
	debugLevel = levelIn;
    }

    // @return None
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
