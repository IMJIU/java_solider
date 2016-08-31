package chapter07_source_code.t02_dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AOPHandler implements InvocationHandler {

	private Object target;

	public AOPHandler(Object target) {
		this.target = target;
	}

	public void println(String str, Object... args) {
		System.out.println(str);
		if (args == null) {
			System.out.println("\tδ�����κ�ֵ.....");
		} else {
			for (Object obj : args) {
				System.out.println(obj);
			}
		}
	}

	public Object invoke(Object proxyed, Method method, Object[] args) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		// System.out.println(method.getDeclaringClass());
		System.out.println("====>���÷�������" + method.getName());
		Class<?>[] variables = method.getParameterTypes();
		System.out.println("���������б�");
		for (Class<?> typevariables : variables) {
			System.out.println("\t" + typevariables.getName());
		}
		println("�������ֵΪ��");
		for (Object arg : args) {
			System.out.println("\t" + arg);
		}
		System.out.println("invoke:");
		Object result = method.invoke(target, args);
		println("���صĲ���Ϊ��", result);
		println("����ֵ����Ϊ��", method.getReturnType());
		return result;
	}
}
