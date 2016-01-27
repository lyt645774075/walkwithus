/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.web.controller.ajax;

import com.google.common.collect.Maps;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 图片上传控制器
 *
 * @author yangtao.lyt
 * @version $Id: ImageUploadController, v 0.1 2016-01-25 23:54 yangtao.lyt Exp $
 */
@Controller
public class ImageUploadController {


    @RequestMapping(value = "/img/upload", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,String> imageUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request){

        System.out.println(file);

            System.out.println(request.getSession().getServletContext().getRealPath("assets/img"));
            //file.transferTo(new File("/Users/liyangtao/temp/upload/" + file.getOriginalFilename()));



        Map<String, String> dataMap = Maps.newHashMap();

        dataMap.put("url", "/upload/6ED1DCF1-8D6E-4D91-8A4F-C1DEB8881E34.png");

        return dataMap;

    }





}
