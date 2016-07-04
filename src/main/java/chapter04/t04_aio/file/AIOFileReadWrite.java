package chapter04.t04_aio.file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;

public class AIOFileReadWrite {

	public static void main(String[] args) throws IOException {
		AsynchronousFileChannel readChannel = AsynchronousFileChannel.open(Paths.get("d:/GTGraphics.themepack"));
		// AsynchronousFileChannel.open(file, options, executor, attrs)
		FileChannel writeChannel = new FileOutputStream("d:/GTGraphics_2.themepack").getChannel();
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		FileReadCompletion completion = new FileReadCompletion(byteBuffer, readChannel);
		readChannel.read(byteBuffer, 0l, writeChannel, completion);
		System.in.read();// �ó�����ͣ����������ֱ���˳�
	}
}
