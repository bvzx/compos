package lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 73992 on 2017/2/19.
 */
public class FlatMapTest {

/*    给定两个数字列表，如何返回所有的数对呢？例如，给定列表[1, 2, 3]和列表[3, 4]，应
    该返回[(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]。为简单起见，你可以用有两个元素的数组来代
    表数对。*/

    @Test
    public void test(){
        List<Integer> a=Arrays.asList(1,2,3);
        List<Integer> b=Arrays.asList(4,5);
        List<int []> c=a.stream()
                        .flatMap((x) -> b.stream()
                                .filter((d) -> (d+x)%3==0)
                                .map((y)->new int[]{x,y})
                )
                .collect(Collectors.toList());
    }
}
