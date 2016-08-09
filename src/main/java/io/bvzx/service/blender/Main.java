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

        executor.submit(() ->{
            System.out.println("11111111111111");
            System.out.println("22222222222222");
            System.out.println("33333333333333");
            System.out.println("44444444444444");
            System.out.println("55555555555555");
            System.out.println("66666666666666");
            System.out.println("77777777777777");
            System.out.println("88888888888888");
            System.out.println("99999999999999");
            System.out.println("101010101010101010101010");
            System.out.println("111111111111111111111111");
        });
        executor.execute(System.out::println);
    }
}
