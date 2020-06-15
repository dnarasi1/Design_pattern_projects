Following are the commands and the instructions to compile and run ANT on your
project.

Navigate to src folder inside multiThreaded folder.

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

 ant run -Dargs="2 input1.txt input2.txt output.txt 1"
--------------------------------------------------------------------------------

Code compiles and runs according to the instructions in the assignment.

-------------------------------------------------------------------------------
/* references for insert sort and merge sort:
https://repl.it/@StephanieStern/Merge-Sort-with-ArrayList
https://stackoverflow.com/questions/3601472/insert-element-to-arraylist-with-ascending-order-and-no-duplicate-elements
 */


-------------------------------------------------------------------------------
The data structure used in this project is ArrayList because
1) We can increase or decrease the arrayList size dynamically during run time.
2) Easy to add duplicate elements.

--------------------------------------------------------------------------------

/*DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
      DEBUG_VALUE=3 [Print to stdout after mergeSort of result data structure]
      DEBUG_VALUE=2 [Print to stdout before mergeSort of result data structure]
      DEBUG_VALUE=1 [Print the data structures of each thread to stdout]
      DEBUG_VALUE=0 [No output should be printed from the application to stdout. It is ok to write to the output file though" ]
    */
----------------------------------------------------------------------------------

Academic Honesty Policy:

I have done this assignment completely on my own. I have not copied it, 
nor have I given my solution to anyone else. I understand that if I am involved in plagiarism or cheating I 
will have to sign an official form that I have cheated and that this form will be stored in my official 
university record. I also understand that I will receive a grade of 0 for the involved assignment for my 
first offense and that I will receive a grade of F for the course for any additional offense.

--------------------------------------------------------
