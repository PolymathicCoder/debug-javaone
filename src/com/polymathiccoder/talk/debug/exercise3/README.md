# Exercise 3:

## jmap

For more information <http://docs.oracle.com/javase/8/docs/technotes/tools/unix/jmap.html>

From the project root directory

	cd src
	
Compile

	javac com/polymathiccoder/talk/debug/exercise3/Main3.java

Run
	
	java -XX:+HeapDumpOnOutOfMemoryError com/polymathiccoder/talk/debug/exercise3/Main3 > /dev/null 2>&1 &
	
Get the pid

	EXERCISE3_PID=`jps | grep Main3 | cut -d' ' -f1`
	
	watch -n 1 jmap -histo:live $EXERCISE3_PID
	
	watch -n 1 jmap -heap $EXERCISE3_PID
	
Kill the process

	kill -9 $EXERCISE3_PID