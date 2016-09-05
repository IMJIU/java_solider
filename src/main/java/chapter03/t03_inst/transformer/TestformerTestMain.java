package chapter03.t03_inst.transformer;

import java.lang.instrument.UnmodifiableClassException;


public class TestformerTestMain {

	public static void main(String[] args) throws UnmodifiableClassException {
		//InstForTransformer.reTransClass(ForASMTestClass.class);
		ForASMTestClass testClass = new ForASMTestClass();
		testClass.display1();
		testClass.display2();
	}
}
