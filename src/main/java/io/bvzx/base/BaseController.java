package io.bvzx.service.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import io.bvzx.service.exception.ApiException;
import io.bvzx.service.exception.BaseException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * todo
 *
 * @author wugaoda
 * @Description: (类职责详细描述, 可空)
 * @ClassName: BaseController
 * @date 2016年07月04日 09:23
 * @Copyright (c) 2015-2020 by
 */
@Controller
public class BaseController {

    private static final Logger logger= LoggerFactory.getLogger(BaseController.class);

    @ExceptionHandler(Exception.class)
    public String exception(Throwable e, HttpServletRequest request){
        logger.error("hava exception",e);
        logger.error("exception,url:%s",request.getRequestURI());
        if (e instanceof ApiException){
            return e.toString();
        }else if(e instanceof BaseException){
            return e.toString();
        }else{
            logger.error("unknown exception",e);
            Map<String,String> retError= Maps.newHashMap();
            retError.put("code","-1");
            retError.put("message",e.toString());
            return JSON.toJSONString(retError);
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        logger.info("init binder");
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setLenient(false);
        webDataBinder.registerCustomEditor(Date.class,new CustomDateEditor(simpleDateFormat,true));
    }



}
