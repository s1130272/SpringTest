package socketio.nio.test;

import java.util.Random;

public class ClientSendMsgTest2 {
	
	public static void main(String[] args) {
		
		ClientTest clientTest = new ClientTest();  
	    new Thread(clientTest,"Server").start();  
		System.out.println("---------------------------1----------------------");
	  //运行客户端   
        char operators[] = {'+','-','*','/'};  
        Random random = new Random(System.currentTimeMillis());  
        new Thread(new Runnable() {  
            @SuppressWarnings("static-access")  
            @Override  
            public void run() {  
                while(true){  
                    //随机产生算术表达式  
                    String expression = random.nextInt(10)+""+operators[random.nextInt(4)]+(random.nextInt(10)+1);  
                    try {
                    	System.out.println("---------------------------0----------------------");
                    	clientTest.sendMsg(expression);
                        Thread.currentThread().sleep(random.nextInt(5000));  
                    } catch (InterruptedException e) {  
                        e.printStackTrace();  
                    } catch (Exception e) {
					}  
                }  
            }  
        }).start();  
        System.out.println("---------------------------2----------------------");
    }  
	
}
