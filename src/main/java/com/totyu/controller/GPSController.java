package com.totyu.controller;

import com.alibaba.fastjson.JSONObject;
import com.totyu.utils.BaiduUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;

@RestController
public class GPSController {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @GetMapping("/acountDistinct")
    public String acountDistinct(
            @RequestParam("startLng") Double startLng,
            @RequestParam("startLat") Double startLat,
            @RequestParam("endLng") Double endLng,
            @RequestParam("endLat") Double endLat){
        log.info("startLng:"+startLng);
        log.info("startLat:"+startLat);
        log.info("endLng:"+endLng);
        log.info("endLat:"+endLat);
        double distance = BaiduUtil.distanceOfTwoPoints2(startLat,startLng,endLat,endLng);
        distance = distance*1.0/1000;
        DecimalFormat df = new DecimalFormat("#.00");
        StringBuffer buff = new StringBuffer();
        buff.append("实际距离");
        buff.append(df.format(distance));
        buff.append("公里");
        log.info(buff.toString());
        return JSONObject.toJSONString(buff.toString());
    }
}
