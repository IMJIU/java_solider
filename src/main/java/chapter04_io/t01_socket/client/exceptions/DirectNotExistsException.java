package chapter04_io.t01_socket.client.exceptions;

public class DirectNotExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DirectNotExistsException(String directPath) {
		super("�ڱ���û���ҵ�Ŀ¼��" + directPath);
	}

}
