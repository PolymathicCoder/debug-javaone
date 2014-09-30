package com.polymathiccoder.talk.debug.exercise4;

import static com.sun.btrace.BTraceUtils.println;

import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnMethod;

@BTrace
public class Tracer {
	@OnMethod(clazz = "java.lang.Thread", method = "start")
	void func() {
		println("about to start a thread!");
	}

	void sharedMethod(String msg) {
		println(msg);
	}
}