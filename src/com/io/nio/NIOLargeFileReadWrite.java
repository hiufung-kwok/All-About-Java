package com.io.nio;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * This class will throw error, as the file doesn't exist.
 */
public class NIOLargeFileReadWrite {
    public static void main(String[] args) {

        try (RandomAccessFile file = new RandomAccessFile("largefile.dat", "rw");
             FileChannel fileChannel = file.getChannel()) {

            // Map a region of the file directly to memory
            MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, fileChannel.size());

            // Read data
            while (buffer.hasRemaining()) {
                System.out.print((char) buffer.get());
            }

            // Write data
            buffer.position(0); // Reset position to start
            buffer.put("New data".getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
