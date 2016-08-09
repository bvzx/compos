package io.bvzx.service.web.controller.api;

import io.bvzx.service.AppConfig;
import io.bvzx.service.base.BaseController;
import io.bvzx.service.web.controller.vo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * todo
 *
 * @author wugaoda
 * @Description: (类职责详细描述, 可空)
 * @ClassName: WinningRsult
 * @date 2016年06月27日 18:10
 * @Copyright (c) 2015-2020 by caitu99
 */
@Controller
public class IndexController extends BaseController {


    @Autowired
    AppConfig appConfig;

    /*@RequestMapping("/welcome")
    public ModelAndView index(){
        ModelAndView modelAndView=new ModelAndView("welcome");
        Person me=new Person();
        me.setAge(12);
        me.setCity("中国");
        me.setHight(183);
        me.setLook("medium");
        me.setProvince("浙江省");
        me.setUserName("bvzx");
        me.setWeight(130);
        modelAndView.addObject("me",me);
        return modelAndView;
    }*/

    @RequestMapping("/{path}")
    @ResponseBody
    public String appearAppConfig(@PathVariable("path") String path) throws NoSuchFieldException, IllegalAccessException {
        return appConfig.getValue(path);
    }

}
