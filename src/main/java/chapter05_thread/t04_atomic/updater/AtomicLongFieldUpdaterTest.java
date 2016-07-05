package chapter05_thread.t04_atomic.updater;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

public class AtomicLongFieldUpdaterTest {
	
	static class A {
		volatile long longValue = 100l;
	}

	/**
	 * ����������AtomicIntegerFieldUpdaterһ��
	 */
	AtomicLongFieldUpdater <A>ATOMIC_LONG_FIELD_UPDATER = AtomicLongFieldUpdater.newUpdater(A.class , "longValue");
}