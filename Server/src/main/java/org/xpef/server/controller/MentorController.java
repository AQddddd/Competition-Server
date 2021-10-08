package org.xpef.server.controller;


import ch.qos.logback.core.pattern.ConverterUtil;
import com.alibaba.fastjson.JSONObject;

import org.springframework.util.StringUtils;
import org.xpef.server.constrants.UserConstrant;
import org.xpef.server.model.bo.Mentor;
import org.xpef.server.model.bo.Student;
import org.xpef.server.service.MentorService;
import org.xpef.server.service.StuService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.xpef.server.util.ExcelHandle;
import org.xpef.server.util.ParseUtil;
import org.xpef.server.util.Result;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Api(value = "导师信息服务相关", tags = "mentor")
@RestController
@RequestMapping(value = "/user/mentor", produces = "application/json;charset=UTF-8")
public class MentorController {
    private  static  final Logger logger = LoggerFactory.getLogger(MentorController.class);


    @Resource
    private MentorService mentorService;



    @ApiOperation("获取所有导师名字和id，格式: 姓名_id")
    @GetMapping(value = "mentor/nameAndIds")
    public Result<List<String>> nameAndIdList(){
        List<Mentor> mentors=mentorService.getAllMentors();
        return new Result<>(mentors.stream().map((Mentor::nameAndId)).collect(Collectors.toList()));
    }

    @ApiOperation("获取所有导师列表")
    @GetMapping(value = "mentor/list")
    public Result<List<Mentor>> listM(){
        return new Result<>(mentorService.getAllMentors());
    }




}
