package socketio.nio.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

import socketio.bio.Calculator;

public class ServerTest implements Runnable {

	private volatile boolean started = true;

	@Override
	public void run() {

		try {
			Selector s_selector = Selector.open();
			ServerSocketChannel s_serverSocketChannel_1 = ServerSocketChannel.open();
			s_serverSocketChannel_1.configureBlocking(false);//开启非阻塞模式  
			s_serverSocketChannel_1.socket().bind(new InetSocketAddress("127.0.0.1", 12345), 1024);
			s_serverSocketChannel_1.register(s_selector, SelectionKey.OP_ACCEPT);
			System.out.println("服务器已启动，端口号：" + "12345" + "	s_selector=" + s_selector + ";  s_selector hashcode:" + s_selector.hashCode());
			
			
			SocketChannel s_socketChannel_1=null;
			
			SocketChannel s_socketChannel_2=null;

			while (started) {
				s_selector.select(1000);
				Set<SelectionKey> keys = s_selector.selectedKeys();
				Iterator<SelectionKey> it = keys.iterator();
				SelectionKey key = null;
				while (it.hasNext()) {
					key = it.next();
					it.remove();
					try {
						if (key.isValid()) {
							//case1:
							if (key.isAcceptable()) {
								ServerSocketChannel s_serverSocketChannel_2 = (ServerSocketChannel) key.channel();
								System.out.println("s_serverSocketChannel_1 = "+s_serverSocketChannel_1+"s_serverSocketChannel_2="+s_serverSocketChannel_2+";  chanel1==channel2 is "+(s_serverSocketChannel_1==s_serverSocketChannel_2));
								s_socketChannel_1 = s_serverSocketChannel_2.accept();
								s_socketChannel_1.configureBlocking(false);
								s_socketChannel_1.register(s_selector, SelectionKey.OP_READ);
							}
							//case2 
							if (key.isReadable()) {
								s_socketChannel_2 = (SocketChannel) key.channel();
								System.out.println("s_socketChannel_1 = "+s_socketChannel_1+"s_socketChannel_2="+s_socketChannel_2+";  chanel1==channel2 is"+(s_socketChannel_1==s_socketChannel_2));
								ByteBuffer buffer = ByteBuffer.allocate(1024);
								int readBytes = s_socketChannel_2.read(buffer);
								if (readBytes > 0) {
									buffer.flip();
									byte[] bytes = new byte[buffer.remaining()];
									buffer.get(bytes);
									String expression = new String(bytes, "UTF-8");
									System.out.println("服务器收到消息：" + expression);
									String result = null;
									try {
										result = Calculator.cal(expression).toString();
									} catch (Exception e) {
										result = "计算错误：" + e.getMessage();
									}
									byte[] Writebytes = result.getBytes();
									ByteBuffer writeBuffer = ByteBuffer.allocate(Writebytes.length);
									writeBuffer.put(Writebytes);
									writeBuffer.flip();
									s_socketChannel_2.write(writeBuffer);
								} else if (readBytes < 0) {
									key.cancel();
									s_socketChannel_2.close();
								}
							}
						}
					} catch (Exception e) {
						if (key != null) {
							key.cancel();
							if (key.channel() != null) {
								key.channel().close();
							}
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
