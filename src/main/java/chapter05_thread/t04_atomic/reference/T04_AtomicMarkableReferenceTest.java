package chapter05_thread.t04_atomic.reference;

import java.util.concurrent.atomic.AtomicMarkableReference;

public class T04_AtomicMarkableReferenceTest {

	/**
	 * ʹ�÷�ʽ������AtomicStampedReferenceһ��
	 * �������������Ӽ����������Ĺ�ϵ����������ֻ������״̬�������ڽ��ABA�����ʱ��Ҫ�����е�Ŀ��ͨ��ֻ������״̬
	 * ��ΪABA����Ҫ���ǵ���ģ���Ϊȷ����������һ����һ��״̬�����һ��״̬�󣬾Ͳ����ٱ仯������ֻ�Ǹ���Ҫ��ֻ������״̬
	 * һ�����ƣ���ɾ������ʧЧ�Ȳ��ɸ��õ�����������AtomicStampedReference���Ӿ��пɶ��ԣ���ΪAtomicStampedReference������һ�����޸ĵİ汾�źͼ�����
	 */
	public final static AtomicMarkableReference <String>ATOMIC_MARKABLE_REFERENCE = new AtomicMarkableReference<String>("abc" , false);
	
	{
		ATOMIC_MARKABLE_REFERENCE.compareAndSet("abc", "abc2", false, true);
	}
}