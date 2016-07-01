package io.bvzx.service.web.controller.api;

import io.bvzx.service.web.controller.vo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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
public class IndexController {


    @RequestMapping("/welcome")
    public String index(){
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
        return "welcome";
    }

}
