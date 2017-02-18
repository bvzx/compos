package lambda;

import java.io.BufferedReader;

/**
 * Created by 73992 on 2017/2/18.
 */
@FunctionalInterface
public interface BufferReadProcesser {
    String process(BufferedReader br) throws Exception;
}
