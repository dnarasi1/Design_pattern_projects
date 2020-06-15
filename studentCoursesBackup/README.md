*Please ignore the first commit. Added as "Final commit" by mistake*

-----------------------------------------------------------------------

Following are the commands and the instructions to compile and run ANT on your
project.

Navigate to src folder inside studentCoursesBackup folder.

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

ant run -Darg0=input.txt -Darg1=delete.txt -Darg2=output1.txt -Darg3=output2.txt -Darg4=output3.txt -Darg5=0 

--------------------------------------------------------------------------------

Code compiles and runs according to the instructions in the assignment.

-------------------------------------------------------------------------------
/* references for building tee:
https://www.journaldev.com/23086/binary-search-tree-bst-search-insert-remove
https://www.geeksforgeeks.org/print-level-order-traversal-line-line/
 */

-------------------------------------------------------------------------------

I have created subject Interface which has 3 methods such as 
*registerObserver method: Adds the observer to an arrayList
*deleteObserver method: Deletes the observer from an arrayList
notifyAll method: Notifies all the observers in the arrayList whenever any changes are made to the original node.

And in the observer interface I have declared an update method which is used in notifyAll method to update the courses.


-------------------------------------------------------------------------------
Why BST? because,
The search for the elements in the bst is O(log(n))(best case), which is faster. 
The worst case time complexity of insert and search is O(n).
Easy to implement.

--------------------------------------------------------------------------------
MyLogger functionalities:
/*DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
      DEBUG_VALUE=3 [Print to stdout everytime when the observers are notified]
      DEBUG_VALUE=2 [Print to stdout everytime when more than one course has been added to a particular Bmumber]
      DEBUG_VALUE=1 [Print to stdout when the node is empty]
      DEBUG_VALUE=0 [No output should be printed from the application to stdout. It is ok to write to the output file though" ]
    */


--------------------------------------------------------------------------------

Academic Honesty Policy:

I have done this assignment completely on my own. I have not copied it, 
nor have I given my solution to anyone else. I understand that if I am involved in plagiarism or cheating I 
will have to sign an official form that I have cheated and that this form will be stored in my official 
university record. I also understand that I will receive a grade of 0 for the involved assignment for my 
first offense and that I will receive a grade of F for the course for any additional offense.
