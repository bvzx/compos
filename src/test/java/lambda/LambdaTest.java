package lambda;

import org.junit.Test;

import java.io.*;

/**
 * Created by 73992 on 2017/2/18.
 */
public class LambdaTest  {


    @Test
    public void test(){
        System.out.println(processFile((br)-> br.readLine()+"123"));
    }

    public static String processFile(BufferReadProcesser br){
        try (BufferedReader reader=
                     new BufferedReader(new FileReader("C:\\Users\\73992\\IdeaProjects\\compos\\src\\test\\java\\lambda\\LambdaTest.java"))){
            return br.process(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
