package com.sameer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpClientExample{


    public static void main(String[] args) {

//ExecutorService is a interface and Executors is a class which has static method newFixedThreadPool.
// This method takes argument as number of worker thread as 10.
// These number of threads called as Thread Pool which can be decided on certain parameters.


        ExecutorService   executorService= Executors.newFixedThreadPool(1000);
        for(int i=1;i<=3000;i++) {

            executorService.execute(new MultiThreading());
            //Thread object=new Thread(new MultiThreading());
            //object.start();
        }

    }

}
