# Exercise 5:

## Deadlock Detection with JConsole

For more information <http://docs.oracle.com/javase/8/docs/technotes/guides/management/jconsole.html>

From the project root directory

	cd src

Compile

	javac com/polymathiccoder/talk/debug/exercise2/Main2.java

Run
	
	java com/polymathiccoder/talk/debug/exercise2/Main2 > /dev/null 2>&1 &
	
Get the pid

	EXERCISE5_PID=`jps | grep Main2 | cut -d' ' -f1`
		
	jconsole $EXERCISE5_PID
	
Browse to the Threads tab and click on "Detect DeadLocks"
	
Kill the process

	kill $EXERCISE5_PID
	
## Memory Leaks with VisualVM

For more information <http://docs.oracle.com/javase/8/docs/technotes/guides/visualvm/index.html>

From the project root directory

	cd src

Compile

	javac com/polymathiccoder/talk/debug/exercise3/Main3.java

Run
	
	java com/polymathiccoder/talk/debug/exercise3/Main3 > /dev/null 2>&1 &
	
Run VisualVM

	jvisualvm
	
On the left pane double click on the Java process named com.polymathiccoder.talk.debug.exercise3.Main3 under Local

Click on the monitor tab and uncheck all monitors except for Memory

Observe the heap being used up
	
Get the pid

	EXERCISE5_PID=`jps | grep Main2 | cut -d' ' -f1`
	
Kill the process

	kill $EXERCISE5_PID