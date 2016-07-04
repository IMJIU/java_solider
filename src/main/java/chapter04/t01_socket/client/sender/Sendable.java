package chapter04.t01_socket.client.sender;

import java.io.IOException;

import chapter04.t01_socket.SocketWrapper;

public interface Sendable {
	
	public byte getSendType();

	public void sendContent(SocketWrapper socketWrapper) throws IOException;
}
