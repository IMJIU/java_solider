package chapter05_thread.t06_tools;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class T04_SemaphoreByWaitNotify {

	private final static int QUERY_MAX_LENGTH = 5;

	private final static int THREAD_COUNT = 20;

	private final static AtomicInteger WORKING_CNT = new AtomicInteger(0);

	private final static Object LOCK_OBJECT = new Object();

	public static void main(String[] args) {
		final Random radom = new Random();
		for (int i = 0; i < THREAD_COUNT; i++) {
			new Thread(String.valueOf(i)) {
				public void run() {
					tryToLock();// ���Ի�ȡ��ִ��Ȩ��
					System.out.println(this.getName() + "======�ҿ�ʼ�������ˣ�");
					try {
						Thread.sleep(100 + (radom.nextInt() & 3000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(this.getName() + "======���������ˣ�");
					tryToUnLock();// �ͷ���
				}
			}.start();
		}
	}

	private static void tryToUnLock() {
		WORKING_CNT.getAndDecrement();
		synchronized (LOCK_OBJECT) {
			LOCK_OBJECT.notify();
		}
	}

	private static void tryToLock() {
		int tryTimes = 0;
		int nowCnt = WORKING_CNT.get();
		while (true) {
			if (nowCnt < QUERY_MAX_LENGTH && WORKING_CNT.compareAndSet(nowCnt, nowCnt + 1)) {
				break;// ��ȡ����
			}
			if (tryTimes % 3 == 0) {// ����3�������ɹ�������
				waitForObjectNotify();
			}
			nowCnt = WORKING_CNT.get();
			tryTimes++;
		}
	}

	private static void waitForObjectNotify() {
		synchronized (LOCK_OBJECT) {
			try {
				LOCK_OBJECT.wait(500);// ���ȴ�500ms������
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
