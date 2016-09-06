package chapter03.t03_inst.sizeof;

import java.util.ArrayList;
import java.util.HashMap;

public class NormalSizeOfTestMain {

	public static void main(String []args) {
		System.out.println("integer:"+NormalObjectSizeOf.sizeOf(new Integer(1))/8+" byte");
		System.out.println("map:"+NormalObjectSizeOf.sizeOf(new HashMap<String,Object>())/8+" byte");
		System.out.println("arraylist:"+NormalObjectSizeOf.sizeOf(new ArrayList<Object>())/8+" byte");
		System.out.println("string:"+NormalObjectSizeOf.sizeOf(new String())/8+" byte");
		System.out.println("char[1]:"+NormalObjectSizeOf.sizeOf(new char[1])/8+" byte");
	}
}
