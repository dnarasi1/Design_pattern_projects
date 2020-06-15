Following are the commands and the instructions to compile and run ANT on your
project.

Navigate to src folder inside troubleShootSearch folder.

-----------------------------------------------------------------------
## To clean:

ant clean

Description: it cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## To compile:

ant all

Description: Compiles your code and generates .class files inside the BUILD
folder.

--------------------------------------------------------------------------------

## To run by specifying arguments from command line

## We will use this to run your code

ant run -Darg0=product1.txt -Darg1=product2.txt -Darg2=product3.txt -Darg3=product4.txt -Darg4=synonym.txt -Darg5=userInputs.txt -Darg6=output.txt -Darg7=0 

--------------------------------------------------------------------------------

Code compiles and runs according to the instructions in the assignment.

-------------------------------------------------------------------------------
/* references for building tee:
Reference: https://stackoverflow.com/questions/25417363/java-string-contains-matches-exact-word
 */

-------------------------------------------------------------------------------
/*DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
      DEBUG_VALUE=3 [Print to stdout everytime when the visitor method is called]
      DEBUG_VALUE=2 [Print to stdout everytime an entry has made to results]
      DEBUG_VALUE=1 [Print the search results to stdout]
      DEBUG_VALUE=0 [No output should be printed from the application to stdout. It is ok to write to the output file though" ]
    */
-------------------------------------------------------------------------------
Note: Sometimes multiple troubleshoot sentences will be printed for a particular user input.
    : please delete output.txt on each check.

--------------------------------------------------------------------------------

Academic Honesty Policy:

I have done this assignment completely on my own. I have not copied it, 
nor have I given my solution to anyone else. I understand that if I am involved in plagiarism or cheating I 
will have to sign an official form that I have cheated and that this form will be stored in my official 
university record. I also understand that I will receive a grade of 0 for the involved assignment for my 
first offense and that I will receive a grade of F for the course for any additional offense.
