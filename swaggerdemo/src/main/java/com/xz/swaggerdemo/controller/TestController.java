package com.xz.swaggerdemo.controller;

import com.xz.xzcommon.constant.XZResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author xz小泽
 * @date 2019/9/18 14:52
 **/
@Controller
@RequestMapping(value = "test")
public class TestController {

    @Value("${swaggerdoc.url}")
    String swaggerUrl;
    @GetMapping(value = "getTest")
    @ResponseBody
    public XZResponse getResponse() {
        return new XZResponse().setData("测试返回");
    }

    @RequestMapping(value = "/showSwagger")
    public String getSwagerUrl(Model modelAndView){
     modelAndView.addAttribute("url",swaggerUrl);
        return "swagger";
    }
}
