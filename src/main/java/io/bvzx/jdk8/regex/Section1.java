package io.bvzx.jdk8.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bvzx on 16-11-3.
 */
public class Section1 {


    public static final String waitForMatchString="雷军，[1]  1969年12月出生于湖北仙桃，现任小米科技董事长兼CEO，同时兼任金山、YY、猎豹移动公司等三家上市公司董事长，是中国大陆著名天使投资人。\n" +
            "雷军曾任两届海淀区政协委员，2012年当选北京市人大代表，2013年2月当选全国人民代表大会代表。\n" +
            "雷军作为中国互联网代表人物及全球年度电子商务创新领袖人物[1]  ，曾获中国经济年度人物及十大财智领袖人物、中国互联网年度人物[2]  等多项国内外荣誉，并当选《福布斯》亚洲版2014年度商业人物。";
    public static final String regexExpression="雷军(.*)，";

    public static final String waitForMatchString1="extend the end";
    public static final String regexExpression1="e.*d";
    public static final String regexExpression1change="e.*?d";

    public static void main(String [] args){

        //demo1

        System.out.println("demo1----start");
        Pattern pattern=Pattern.compile(regexExpression);

        Matcher matcher=pattern.matcher(waitForMatchString);

        while (matcher.find()){
            System.out.println(matcher.start());
            System.out.println(waitForMatchString.charAt(matcher.start()));
            System.out.println(matcher.group());
            System.out.println(matcher.end());
            System.out.println(waitForMatchString.charAt(matcher.end()));

        }
        System.out.println("demo1----end");
        System.out.println("demo2----start");
        //demo2
        Pattern pattern1=Pattern.compile(regexExpression1);
        Matcher matcher1=pattern1.matcher(waitForMatchString1);

        while (matcher1.find()){
            System.out.println(matcher1.start());
            System.out.println(waitForMatchString1.charAt(matcher1.start()));
            System.out.println(matcher1.group());
            System.out.println(matcher1.end());
            System.out.println(waitForMatchString1.charAt(matcher1.end()-1));
        }

        System.out.println("demo2----change regex pattern");
        pattern1=Pattern.compile(regexExpression1change);
        matcher1=pattern1.matcher(waitForMatchString1);

        while (matcher1.find()){
            System.out.println(matcher1.start());
            System.out.println(waitForMatchString1.charAt(matcher1.start()));
            System.out.println(matcher1.group());
            System.out.println(matcher1.end());
            System.out.println(waitForMatchString1.charAt(matcher1.end()-1));
        }

        System.out.println("demo2----end");
    }
}
