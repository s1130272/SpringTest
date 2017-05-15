package socketio.fakeAsychronize;

import java.io.IOException;

public class ServerStart {
	
	public static void main(String[] args) {
		
		 //运行服务器  
        new Thread(new Runnable() {  
            @Override  
            public void run() {  
                try {  
                	ServerAcceptorThreadPool.start();  
                	//ServerWithoutAcceptor.start();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        }).start();  
	}

}
