package io.bvzx.service.blender;

import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by lss on 16-7-29.
 */
public class Main {


    public static ExecutorService executor= Executors.newFixedThreadPool(100);


    public static void  main(String [] args){

        executor.execute(System.out::println);



    }
}
