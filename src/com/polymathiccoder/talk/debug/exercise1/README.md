# Exercise 1:

## jdb - The Java Debugger

For more information <http://docs.oracle.com/javase/8/docs/technotes/tools/unix/jdb.html>

From the project root directory

	cd src

Compile with -g option to generate the necessary debugging info

	javac -g com/polymathiccoder/talk/debug/exercise1/*.java
	
Start a jdb session

	jdb com/polymathiccoder/talk/debug/exercise1/Main1
	
Set a breakpoint at the beginning of the main method

	stop in com.polymathiccoder.talk.debug.exercise1.Main1.main

Start the execution

	run

See current code
	
	list
	
Step into the constructor
	
	step
	
	list
	
Exexcute the next statement
	
	step
	
	list
	
Go to the caller
		
	step up
	
	list
	
Step over the prettyPrint method
	
	next
	
	list
		
List all methods of a particlular class

	methods com.polymathiccoder.talk.debug.exercise1.RandomNumbers
		
Set a breakpoint at the beginning of sum method of the RandomNumbers class

	stop in com.polymathiccoder.talk.debug.exercise1.RandomNumbers.sum
	
Continue the execution until the next breakpoint
	
	cont
		
	list
	
Set a breakpoint at line 25 in the RandomNumbers class
		
	stop at com.polymathiccoder.talk.debug.exercise1.RandomNumbers:25
	
	cont
	
	list
	
Show all local varibales within scope and their values
	
	locals
	
	cont
	
	list
	
	locals
	
Remove the breakpoint at line 34 in the RandomNumbers class
	
	clear com.polymathiccoder.talk.debug.exercise1.RandomNumbers:25
	
	stop at com.polymathiccoder.talk.debug.exercise1.RandomNumbers:27
	
	cont
	
	list
	
Print the value of the varibale named "sum"
	
	print sum

Get some help
	
	help

Exit

	exit
	
Start the Exercise1 application with the following JVM arguments

	java com/polymathiccoder/talk/debug/exercise1/Main1 -Xdebug –Xrunjdwp:transport=st_socket,server=y,address=4000,suspend=y > /dev/null 2>&1 &

Attach jdb to the running application JVM

	jdb com/polymathiccoder/talk/debug/exercise1/Main1 –attach 4000
	
Set a breakpoint at line 27 in the RandomNumbers class

	stop at com.polymathiccoder.talk.debug.exercise1.RandomNumbers:27
	
	run
	
	list
	
	cont