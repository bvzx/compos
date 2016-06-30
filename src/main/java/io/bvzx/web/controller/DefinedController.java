package io.bvzx.web.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * todo
 *
 * @author wugaoda
 * @Description: (类职责详细描述, 可空)
 * @ClassName: WinningRsult
 * @date 2016年06月27日 18:10
 * @Copyright (c) 2015-2020 by caitu99
 */
@RestController
public class DefinedController {


    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void method1(){

    }

    @GetMapping()
    public void method2(){

    }

}
