package chapter03.tools.btrace;

import java.lang.reflect.Field;
import java.util.Map;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;
import com.sun.btrace.annotations.Return;
import com.sun.btrace.annotations.Self;
import com.sun.btrace.annotations.TLS;

@BTrace
public class BTraceTest {
	@TLS
	static long startTime;

	@OnMethod(clazz = "chapter03.tools.btrace.TestHello", method = "test")
	public static void traceExecute() {
		startTime = BTraceUtils.timeMillis();
	}

	@OnMethod(clazz = "chapter03.tools.btrace.TestHello", method = "test", location = @Location(value = Kind.RETURN))
	public static void traceExecute(@Return boolean result, @Self chapter03.tools.btrace.TestHello testHello, @ProbeClassName String className,
			@ProbeMethodName String methodName, int time, String name, Map<String, String> map) {
		BTraceUtils.println("===================================>");
		BTraceUtils.println(BTraceUtils.strcat("call class = ", className));
		BTraceUtils.println(BTraceUtils.strcat("call method = ", methodName));

		Field fieldName = BTraceUtils.field(className, "name");
		Field fieldFreeeMSize = BTraceUtils.field(className, "THREE_M_SIZE");

		BTraceUtils.println(BTraceUtils.strcat("property name = ", BTraceUtils.str(BTraceUtils.get(fieldName, testHello))));
		BTraceUtils.println(BTraceUtils.strcat("static property THREE_M_SIZE = ", BTraceUtils.str(BTraceUtils.get(fieldName, fieldFreeeMSize))));

		BTraceUtils.println(BTraceUtils.strcat("map.toString() = ", BTraceUtils.str(map)));
		BTraceUtils.println(BTraceUtils.strcat("map.get() = ", BTraceUtils.get(map, "fuck")));
		BTraceUtils.println(BTraceUtils.strcat(BTraceUtils.strcat("times: = ", BTraceUtils.str(time)), BTraceUtils.strcat(",name:", name)));
		BTraceUtils.jstack();
		BTraceUtils.println(BTraceUtils.strcat("delay:", BTraceUtils.str(BTraceUtils.timeMillis() - startTime)));
		BTraceUtils.println(BTraceUtils.strcat("return value is:", BTraceUtils.str(result)));
	}
}
