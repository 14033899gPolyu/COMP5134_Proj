Name: NG WING CHI
Std id: 14033899G
Assignment: COMP 5134 Project

**********Warning**************************************************************
The project supports jre1.5 or later version
please set the following if faced the the version priblem:
1. Open Eclipse
2. Select the project
3. Right click and select "property" and choose "Java compiler"
4. set the compiler compliance level to 1.6 / 1.7
************************************************************************

File structure:

1. Src => contain the source code of the project
	- System contains 3 package (main, model, UI, JunitTestSuit) inside a proj
	- the main package contains the main method
	- the model uses the decorator pattern to handle the main operator & calculation
	- the UI contains the user interface
	- the JunitTestSuit contains all test cases
	
2. lib => contains the library that the proj used
	- junit_project.jar    : The test suite of the project, contains all test case
	- junit-3.8.1.jar      : The junit offocial library

3. docs => doc of the project

4. build.xml => the build file of ant

5. dist => contains the runnable jar file (project.jar) allows to double click to run automatically

Project introduction:

The project is a POS system for icecream shop. It provides the following functions:
1. Allow user to create a new flavor / decorator of the icecream
2. Allow user to make a order by selecting a flavor and 0~unlimited number of decorator 
3. The description and cost shows in the UI accroding to the order

Step for the system:
1) Create new flavor / decorator
	1.1 Click "system administor" and it pop up a dialog automatically
	1.2 Select Flavor / decorator that you want to create in the dialog
	1.3 Enter the description and price in the corrsponding textfield
	1.4 Click "OK" for create and the main GUI will display the new button
	1.5 OR Click "Cancel" for cancel the action of creating a button
	** If the system checks there are NULL in any one textfield, then it will not create a button for user
2) Create a order
	2.1 Click "New Ice Cream" button
	2.2 Click one flavor button
	2.3 Click Decorator (if any)
	2.4 The description and price will show according to the icecream user selected
	2.5 Repeat 2.3 - 2.4 until finish adding the decorator needed
	** ONLY one flavor can be choosed in one order, and 0-unlimited decorator can be choosed.