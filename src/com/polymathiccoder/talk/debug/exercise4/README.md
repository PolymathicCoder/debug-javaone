# Exercise 4:

## BTrace

For more information <https://github.com/jbachorik/btrace/wiki>

BTrae has some know issues on Mac. Here is a [workaround](http://kensipe.blogspot.com/2009/02/fixing-btrace-on-mac.html)

From the project root directory

	mkdir bin
	cd bin
	wget https://kenai.com/projects/btrace/downloads/download/releases/release-1.2.5.1/btrace-bin.tar.gz
	mkdir btrace; tar -xzf btrace-bin.tar.gz -C btrace; rm btrace-bin.tar.gz

	
Compile

	javac -cp "bin/btrace/build/*" com/polymathiccoder/talk/debug/exercise4/Main4.java
	
Run
	
	java com.polymathiccoder.talk.debug.exercise4.Main4 > /dev/null 2>&1 &
	
Get the pid

	EXERCISE4_PID=`jps | grep Main4 | cut -d' ' -f1`
	
Execute the BTrace script in the Tracer.java file
	
	../bin/btrace/bin/btrace com/polymathiccoder/talk/debug/exercise4/Tracer.java $EXERCISE4_PID