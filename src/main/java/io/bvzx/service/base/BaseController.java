package io.bvzx.service.base;

import org.junit.Test;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * todo
 *
 * @author wugaoda
 * @Description: (类职责详细描述, 可空)
 * @ClassName: WinningRsult
 * @date 2016年07月04日 09:23
 * @Copyright (c) 2015-2020 by caitu99
 */
@Controller
public class BaseController {


    @ExceptionHandler(Exception.class)
    public String exception(Throwable e, HttpServletRequest request){
        return "请求错误";
    }



}
