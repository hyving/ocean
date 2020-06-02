package com.hyving.ocean.controller;

import com.hyving.ocean.utils.ImageTools;
import com.hyving.ocean.utils.SecretTools;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author: Hyving 黄瀚
 * @date: 2020/6/1
 * han.huang@sioeye.com
 * Chengdu Tianfu Software Park
 */
@Controller
@RequestMapping("/passport")
public class PassportController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;


    private static final String CODE_NAME ="verifycode";

    @GetMapping("/authImage")
    public void authImage() throws IOException {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        //生成随机字串
        String verifyCode = SecretTools.generateSecret(4);
        //存入会话session
        HttpSession session = request.getSession(true);
        //删除以前的
        session.removeAttribute(CODE_NAME);
        //转为小写加密一次
        session.setAttribute(CODE_NAME, SecretTools.md5(verifyCode.toLowerCase()));
        //生成图片
        int w = 100, h = 30;

        ImageTools.outputImage(w, h, response.getOutputStream(), verifyCode);

    }


}
