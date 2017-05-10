package socketio;

import java.io.IOException;

public class ServerStart {
	
	public static void main(String[] args) {
		
		 //运行服务器  
        new Thread(new Runnable() {  
            @Override  
            public void run() {  
                try {  
                	ServerAcceptor2.start();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        }).start();  
	}

}
