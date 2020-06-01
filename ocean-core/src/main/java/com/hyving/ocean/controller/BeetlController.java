package com.hyving.ocean.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * @Description
 * @Classname BeetlController
 * @Date 2020/6/1 23:00
 * @Author hyving
 */
@Controller
@RequestMapping(path={"/index"})
public class BeetlController {

    //beetl配置是否成功
    @RequestMapping("/test")
    public ModelAndView testBeetl(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("test", "hello");
        modelAndView.addObject("test2", "hello2");
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping(path = "/test2")
    public String showOne(Model model) {
        model.addAttribute("test", "临江仙");
        model.addAttribute("test2", "绿蚁浮觞香泛泛，黄花共荐芳辰。\\n清霜天宇净无尘。\\n登高宜有赋，拈笔戏成文。\\n可奈园林摇落尽，悲秋意与谁论。\\n眼中相识几番新。\\n龙山高会处，落帽定何人");
        return "index";
    }

    @GetMapping(path = "/show2")
    public String showTow(Map<String, Object> data) {
        data.put("test", "Show2---->");
        data.put("test2", LocalDateTime.now().toString());
        return "index";
    }


}
