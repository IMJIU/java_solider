package chapter07_source_code.t02_dynamic;

public class AOPTestMain {

	public static void main(String []args) {
		try {
			HelloInterface hello = BeanFactory.getBean("chapter07_source_code.t02_dynamic.HelloImpl" , HelloInterface.class);
			hello.setInfo("xieyuooo", "xiaopang");
			//hello.getInfos1();
			//hello.getInfos2();
			//hello.display();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
