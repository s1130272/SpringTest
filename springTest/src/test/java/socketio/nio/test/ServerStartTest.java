package socketio.nio.test;

public class ServerStartTest {
	
	public static void main(String[] args) {
		ServerTest  serverTest = new ServerTest();  
	        new Thread(serverTest,"Server").start(); 
	}

}
