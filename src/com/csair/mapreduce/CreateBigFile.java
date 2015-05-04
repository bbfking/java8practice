package com.csair.mapreduce;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 生成大文件的类
 * @author bbfking
 *
 */
public class CreateBigFile {
	 // data chunk be written per time
    private static final int DATA_CHUNK =128*1024 * 1024; 
    private static final long LEN = 2L* 1024 * 1024 * 1024L;
    
	private static void writeBigFileComparison() throws IOException {
		File file = new File("e://fc1.txt");
		if (file.exists()) {
			file.delete();
		}
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileChannel fileChannel = fos.getChannel();
		
		byte[] data = null;
        long len = LEN;
        ByteBuffer buf = ByteBuffer.allocate(DATA_CHUNK);
        int dataChunk = DATA_CHUNK / (1024 * 1024);
        String ip = "10.90.192.";
        while (len >= DATA_CHUNK) {
            System.out.println("write a data chunk: " + dataChunk + "MB");
 
            buf.clear(); // clear for re-write
            data = new byte[DATA_CHUNK];
            
            for (int i = 0; i < DATA_CHUNK; i++) {
            	int inIp = i%100;
            	if(inIp<30){
            		inIp = inIp%10;
            	}
            	i = i+(ip+inIp).getBytes().length+1;
            	if(i<DATA_CHUNK){
            		 buf.put((ip+inIp).getBytes());
            		 buf.put("\n".getBytes());
            	}
            }
 
            data = null;
 
            buf.flip(); // switches a Buffer from writing mode to reading mode
            fileChannel.write(buf);
            fileChannel.force(true);
 
            len -= DATA_CHUNK;
        }
        fileChannel.close();
        fos.close();
        
	}
	public static void main(String[] args) throws IOException {
		writeBigFileComparison();
	}
}
