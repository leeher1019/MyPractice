package com.mypractice.disruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.StreamSupport;

public class Test {

    public static void main(String[] args) throws Exception{
        Executor executor = Executors.newCachedThreadPool();
        PCDataFactory factory = new PCDataFactory();
        int bufferSize = 1024;      // Specify the size of the ring buffer, must be power of 2.
        Disruptor<PCData> disruptor = new Disruptor<PCData>(factory,
                                                        bufferSize,
                                                        executor,
                                                        ProducerType.MULTI,
                                                        new BlockingWaitStrategy());

        disruptor.handleEventsWithWorkerPool(new Consumer(),
                                             new Consumer(),
                                             new Consumer(),
                                             new Consumer());
        disruptor.start();

        RingBuffer<PCData> ringBuffer = disruptor.getRingBuffer();
        Producer producer = new Producer(ringBuffer);
        ByteBuffer bb = ByteBuffer.allocate(8);
        for (long l = 0; true; l++){
            bb.putLong(0, l);
            producer.pushData(bb);
            Thread.sleep(100);
            System.out.println("add data " + l);
        }
    }
}
