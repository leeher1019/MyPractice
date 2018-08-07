package com.mypractice.jdk.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureMain {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<String> futureTask = new FutureTask<String>(new RealData("a"));
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        executorService.submit(futureTask);
        System.out.println("请求完毕");
        try {

            // 这里可以做额外的数据操作，在此使用sleep代替其他业务处理
            Thread.sleep(2000);
        } catch (InterruptedException e){

        }

        // 如果此时call()方法没有执行完成，则依然会等待
        System.out.println("数据 = " + futureTask.get());
    }
}
