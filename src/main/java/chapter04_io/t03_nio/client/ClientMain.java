package chapter04_io.t03_nio.client;

import static chapter04_io.t01_socket.Commons.*;

import java.io.FileOutputStream;
import java.io.IOException;

import chapter04_io.t01_socket.SocketWrapper;
import chapter04_io.t02_file.FileUtils;

public class ClientMain {

	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 50; i++) {
			final String num = String.valueOf(i);
			new Thread(String.valueOf(i)) {
				public void run() {
					SocketWrapper socketWrapper = null;
					FileOutputStream stream = null;
					try {
						stream = new FileOutputStream("c:/temp/aaa" + num + ".pdf");
						socketWrapper = new SocketWrapper("localhost", 8888);

						println("已经连接上服务器端.....");
						socketWrapper.write("我是线程：" + num, DEFAULT_MESSAGE_CHARSET);
						byte[] buffer = new byte[8192];
						int len = socketWrapper.read(buffer);
						while (len > 0) {
							println("我是线程：" + num + " 我接受到数据，长度为：" + len);
							stream.write(buffer, 0, len);
							len = socketWrapper.read(buffer);
						}
						// System.in.read();
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						FileUtils.closeStream(stream, socketWrapper);
					}
				}
			}.start();
		}

	}
}
