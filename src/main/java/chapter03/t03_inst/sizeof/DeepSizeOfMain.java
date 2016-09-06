package chapter03.t03_inst.sizeof;

public class DeepSizeOfMain {

	public static void main(String []args) {
		System.out.println(DeepObjectSizeOf.deepSizeOf(new Integer(1)));
		System.out.println(DeepObjectSizeOf.deepSizeOf(new String()));
		System.out.println(DeepObjectSizeOf.deepSizeOf(new char[1]));
	}
}

