package chapter03.t03_inst.transformer;

import java.lang.instrument.UnmodifiableClassException;

import chapter03.t02_asm.ForASMTestClass;

public class TestformerTestMain {

	public static void main(String[] args) throws UnmodifiableClassException {
		InstForTransformer.premain("", "");
		InstForTransformer.reTransClass(ForASMTestClass.class);
		ForASMTestClass testClass = new ForASMTestClass();
		testClass.display1();
		testClass.display2();
	}
}
