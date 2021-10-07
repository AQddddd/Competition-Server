package org.xpef.server.controller;


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
import org.xpef.server.util.Result;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


@Api(value = "用户信息服务相关", tags = "user")
@RestController
@RequestMapping(value = "/user/", produces = "application/json;charset=UTF-8")
public class UserController {
    private  static  final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private StuService stuService;

    @Resource
    private MentorService mentorService;

    /**
     * 查看所有受助学生
     * @return
     */
    @RequestMapping(path = "student/list/funded",method = RequestMethod.GET)
    public Result<List<Student>> listFunded(){
        List<Student> students=stuService.getAllStudents(UserConstrant.FUNDED);
        return new Result<>(students);
    }

    /**
     * 查看所有预受助学生
     * @return
     */
    @RequestMapping(path = "student/list/not_fund",method = RequestMethod.GET)
    public Result<List<Student>> listNotFund(){
        List<Student> students=stuService.getAllStudents(UserConstrant.NOT_FUNDED);
        return new Result<>(students);
    }

    @RequestMapping(path = "student/create",method = RequestMethod.POST)
    public Result<Boolean> create(@RequestParam String student){
        if (StringUtils.isEmpty(student)){
            return new Result<>(false,"user is null");
        }
        Student newStu= JSONObject.parseObject(student,Student.class);
        if (newStu.getEmail()==null){
            return new Result<>(false,"email is null");
        }

        if (newStu.getName()==null){
            return new Result<>(false,"user name is null");
        }

        logger.info("create user. userinfo--->{}",student);
        Result<Boolean> res=stuService.createStudent(newStu);

        if (res.getSuccess()&&res.getData()){
            logger.info("create success.  name:{} ",newStu.getName());
            return new Result<>(true);
        }else {
            logger.error("create error. msg:{}",res.getErrMsg());
            return new Result<>(false,res.getErrMsg());
        }
    }

    @GetMapping(value = "student/import")
    public Result<Boolean> importInfo(){
        try {
            List<Student> students= ExcelHandle.handleExcel("src/main/resources/test.xlsx");
            return stuService.importInfo(students);
        }catch (Exception e){
            logger.error(e.getMessage());
            return new Result<>(false,e.getMessage());
        }
    }

    @PutMapping(value = "student/updateInfo")
    public Result<Student> update(@RequestParam(name = "studentInfo")String studentInfo){
        if (StringUtils.isEmpty(studentInfo)){
            logger.error("studentInfo is null");
            return new Result<>(false,"info is null");
        }
        logger.info("update student. info: {}",studentInfo);
        Student student=JSONObject.parseObject(studentInfo,Student.class);
        if (student.getId()==null){
            return new Result<>(false,"id is null");
        }

        Boolean isSuccess=stuService.updateStuInfo(student);
        if (isSuccess){
            Student s=stuService.getStuByIds(Collections.singletonList(student.getId())).get(0);
            return new Result<>(s);
        }else {
            return new Result<>(false,"update error");
        }

    }

    @GetMapping(value = "student/names")
    public Result<List<String>> names(){
        List<Student> students=stuService.getAllStudents(UserConstrant.FUNDED);
        return new Result<>(students.stream().map(Student::getName).collect(Collectors.toList()));
    }

    @GetMapping(value = "mentor/nameAndIds")
    public Result<List<String>> nameAndIdList(){
        List<Mentor> mentors=mentorService.getAllMentors();
        return new Result<>(mentors.stream().map((Mentor::nameAndId)).collect(Collectors.toList()));
    }

    @PutMapping(value = "delete/{userId}")
    public Result<Boolean> delete(@PathVariable(name = "userId")Integer userId){
        return new Result<>(stuService.delete(userId));
    }




}
