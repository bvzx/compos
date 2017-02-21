package lambda;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.summarizingDouble;

/**
 * Created by 73992 on 2017/2/18.
 */
public class LambdaTest  {


    @Test
    public void test() throws ExecutionException, InterruptedException {
      //  System.out.println(processFile((br)-> br.readLine()+"123"));

        List<Transaction> list= Lists.newArrayList();
        list.add(new Transaction(1,100d,"a"));
        list.add(new Transaction(2,123d,"a"));
        list.add(new Transaction(3,321d,"a"));
        list.add(new Transaction(4,111d,"d"));
        list.add(new Transaction(5,222d,"e"));

        list.stream().sorted(comparing(Transaction::getPrice));

        Map<String,List<Transaction>> collocter=list.stream().collect(groupingBy(Transaction::getCurrency));

        System.out.println(Stream.of("1","2","3","4").collect(joining(".")));

        System.out.println((Long) Stream.of("1", "2", "3", "4").count());

        Stream.of("1", "2", "3", "4")
                .max(String::compareTo)
                .map(String::hashCode)
                .ifPresent(System.out::println);


        Callable<Integer> callable=() -> {Thread.sleep(1000);return 1;};

        ExecutorService executor= Executors.newFixedThreadPool(1, Thread::new);


        Future<Integer> result=executor.submit(callable);

        System.out.println(result.get());

        Supplier<Transaction> s1 = Transaction::new;

        Consumer<Transaction> c1 =(r) -> System.out.println(r.getId());

        BiConsumer<Transaction,Transaction> b1 =(r,c) -> System.out.println(r.getId()+c.getId());

        Function<Transaction,Integer> f1= Transaction::getId;

        Predicate<Transaction> p1=(x) ->x.getId().equals(1);

        Predicate<Transaction> p2=p1.negate();
        Predicate<Transaction> p3=p2.and(p1);

        boolean gg=p3.test(new Transaction(1,2d,"3"));

        System.out.println(gg);

        Function<Integer, String> f = x -> x + 1+"";
        Function<String, Integer> g = x -> Integer.parseInt(x) * 2;
        Function<Integer, Integer> h = f.andThen(g);
        int result1 = h.apply(1);


        list.stream().map(f1).limit(5).forEach(System.out::println);

        list.sort(Comparator.comparing(Transaction::getId));

        double a=list.stream()
                .filter((transaction -> transaction.getId() > 3))
                .map(Transaction::getPrice)
                .mapToDouble(x -> x)
                .sum();

        System.out.println(a);

        Function<Set,List> f11=ArrayList::new;

        List DWADW=f11.apply(new HashSet());

        assert !list.stream().allMatch(p1);
    }


    public static String processFile(BufferReadProcesser br){
        try (BufferedReader reader=
                     new BufferedReader(new FileReader(
                             "C:\\Users\\73992\\IdeaProjects\\compos\\src\\test\\java\\lambda\\LambdaTest.java"
                     ))){
            return br.process(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
