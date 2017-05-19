package socketio.nio;

public class StartServerTest {
	
	public static void main(String[] args) {
		  //运行服务器  
        Server.start();  
        //避免客户端先于服务器启动前执行代码  
	}

}
