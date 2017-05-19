package socketio.nio.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class ClientTest implements Runnable {

	private volatile boolean started;
	private SocketChannel c_socketChannel_1;
	private Selector selector;

	@Override
	public void run() {

		//创建选择器  
		try {
			selector = Selector.open();
			c_socketChannel_1 = SocketChannel.open();
			c_socketChannel_1.configureBlocking(false);//开启非阻塞模式  

			if (c_socketChannel_1.connect(new InetSocketAddress("127.0.0.1", 12345))) {
			} else {
				c_socketChannel_1.register(selector, SelectionKey.OP_CONNECT);
			}
			started = true;
			while (started) {
				selector.select(1000);
				Set<SelectionKey> keys = selector.selectedKeys();
				Iterator<SelectionKey> it = keys.iterator();
				SelectionKey key = null;
				while (it.hasNext()) {
					key = it.next();
					it.remove();
					try {

						if (key.isValid()) {
							SocketChannel c_socketChannel_2 = (SocketChannel) key.channel();
							// case1:
							if (key.isConnectable()) {
								if (c_socketChannel_2.finishConnect()) {
								} else {
									System.exit(1);
								}
							}
							//case2:
							if (key.isReadable()) {
								ByteBuffer buffer = ByteBuffer.allocate(1024);
								int readBytes = c_socketChannel_2.read(buffer);
								if (readBytes > 0) {
									buffer.flip();
									byte[] bytes = new byte[buffer.remaining()];
									buffer.get(bytes);
									String result = new String(bytes, "UTF-8");
									System.out.println("线程：" + Thread.currentThread().getId() + "客户端收到消息：" + result + " c_socketChannel_2: " + c_socketChannel_2.hashCode() + " Key: " + key);
								} else if (readBytes < 0) {
									key.cancel();
									c_socketChannel_2.close();
								}
							}
						}
					} catch (Exception e) {
					}
				}
			}
		} catch (IOException e) {
		}

	}

	public void sendMsg(String msg) throws Exception {
		c_socketChannel_1.register(selector, SelectionKey.OP_READ);
		byte[] bytes = msg.getBytes();
		ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
		writeBuffer.put(bytes);
		writeBuffer.flip();
		c_socketChannel_1.write(writeBuffer);
		System.out.println("线程:"+Thread.currentThread().getId()+"   客户端发送消息："+msg+"  c_socketChannel_1"+c_socketChannel_1.hashCode());
	}

}
