package io.bvzx.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 系统上下文  获取bean
 * Created by 73992 on 2016/6/30.
 */
@Component
public class AppContext implements ApplicationContextAware {

    private static ApplicationContext springContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (applicationContext==null){
            throw new IllegalArgumentException("Please configure in the spring xml");
        }
        this.springContext =applicationContext;
    }

    /**
     *
     * @param name Bean Name
     * @param requiredType Bean Type
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name, Class<T> requiredType){
        return springContext.getBean(name,requiredType);
    }

    /**
     *
     * @param requiredType Bean Type
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> requiredType){
        return springContext.getBean(requiredType);
    }



    /**
     *
     * @param name Bean Name
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name){
        return (T) springContext.getBean(name);
    }


}
