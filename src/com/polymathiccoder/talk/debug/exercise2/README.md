# Exercise 2:

## jstack - Stack Trace

For more information <http://docs.oracle.com/javase/8/docs/technotes/tools/unix/jstack.html>

From the project root directory

	cd src

Compile

	javac com/polymathiccoder/talk/debug/exercise2/Main2.java

Run
	
	java com/polymathiccoder/talk/debug/exercise2/Main2 > /dev/null 2>&1 &

Get the pid

	EXERCISE2_PID=`jps | grep Main2 | cut -d' ' -f1`
	
Run jstack

	jstack $EXERCISE2_PID
	
Kill the process

	kill -9 $EXERCISE2_PID
