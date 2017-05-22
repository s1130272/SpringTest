package socketio.nio.mytest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class MyServer implements Runnable {

	@Override
	public void run() {

		try {
			Selector selector = Selector.open();
			ServerSocketChannel ssc = ServerSocketChannel.open();
			ssc.configureBlocking(false);
			ssc.bind(new InetSocketAddress("127.0.0.1", 12345), 1024);
			ssc.register(selector, SelectionKey.OP_ACCEPT);

			while (true) {
				selector.select(1000);
				Set<SelectionKey> keys = selector.selectedKeys();
				Iterator<SelectionKey> iterator = keys.iterator();
				SelectionKey key = null;
				while (iterator.hasNext()) {
					key = iterator.next();
					iterator.remove();
					if (!key.isValid())
						continue;
					//处理新接入的请求消息  
					if (key.isAcceptable()) {
						ServerSocketChannel ssc2 = (ServerSocketChannel) key.channel();
						//通过ServerSocketChannel的accept创建SocketChannel实例  
						//完成该操作意味着完成TCP三次握手，TCP物理链路正式建立  
						SocketChannel sc = ssc2.accept();
						sc.configureBlocking(false);
						sc.register(selector, SelectionKey.OP_READ);
					}

					if (key.isReadable()) {
						// channel=>buffer=>byte[]=>String
						SocketChannel sc = (SocketChannel) key.channel();
						ByteBuffer readBuffer = ByteBuffer.allocate(1024);
						int readResult = sc.read(readBuffer);
						if (readResult > 0) {
							readBuffer.flip();
							byte[] readBytes = new byte[readBuffer.remaining()];
							readBuffer.get(readBytes);
							String str = new String(readBytes, "UTF-8");
							str = "回答" + str;

							//String=>byte[]=>buffer=>channel
							byte[] writeBytes = str.getBytes();
							ByteBuffer writeBuffer = ByteBuffer.allocate(writeBytes.length);
							readBuffer.put(writeBytes);
							readBuffer.flip();
							sc.write(writeBuffer);
							//链路已经关闭，释放资源
						} else if (readResult < 0) {
							key.cancel();
							sc.close();
						}

					}
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
