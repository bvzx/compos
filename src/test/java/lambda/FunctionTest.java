package lambda;

import org.junit.Test;

import java.util.function.Function;

/**
 * Created by 73992 on 2017/2/19.
 */
public class FunctionTest {

    @Test
    public void test(){
        Function<Integer,Integer> f=(x) ->x+1;
        Function<Integer,Integer> g=(x) ->x*2;
        Function<Integer,Integer> c=f.andThen(g);
        System.out.println(c.apply(100));
    }
}
