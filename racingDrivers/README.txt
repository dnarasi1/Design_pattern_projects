Following are the commands and the instructions to compile and run ANT on your
project.

Navigate to src folder inside racingDrivers folder.

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

-----------------------------------------------------------------------

## To run by specifying arguments from command line

## We will use this to run your code

ant run -Darg0=input.txt -Darg1=output.txt -Darg2 = 0

-----------------------------------------------------------------------------

Code compiles and runs according to the instructions in the assignment.

-----------------------------------------------------------------------------
The debug value and the action it does is mentioned below:

      DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
      DEBUG_VALUE=3 [Print to stdout everytime the state is changed]
      DEBUG_VALUE=2 [Print to stdout everytime a driver shares a same position with other]
      DEBUG_VALUE=1 [Print the final result to stdout]
      DEBUG_VALUE=0 [No output should be printed from the applicatio to stdout. It is ok to write to the output file though" ]

-----------------------------------------------------------------------------


Academic Honesty Policy:

I have done this assignment completely on my own. I have not copied it, 
nor have I given my solution to anyone else. I understand that if I am involved in plagiarism or cheating I 
will have to sign an official form that I have cheated and that this form will be stored in my official 
university record. I also understand that I will receive a grade of 0 for the involved assignment for my 
first offense and that I will receive a grade of F for the course for any additional offense.
