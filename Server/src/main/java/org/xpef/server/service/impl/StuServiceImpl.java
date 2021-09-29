package org.xpef.server.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.xpef.server.constrants.DefaultValue;
import org.xpef.server.constrants.UserConstrant;
import org.xpef.server.mapper.UserMapper;
import org.xpef.server.model.bo.Mentor;
import org.xpef.server.model.bo.Student;
import org.xpef.server.model.po.User;
import org.xpef.server.model.po.UserExample;
import org.xpef.server.service.MentorService;
import org.xpef.server.service.StuService;
import org.xpef.server.util.ParseUtil;
import org.xpef.server.util.Result;
import org.xpef.server.util.XpNoHandle;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service("stuService")
public class StuServiceImpl implements StuService {

    Logger logger= LoggerFactory.getLogger(StuServiceImpl.class);

    @Resource
    private UserMapper userMapper;

    @Resource
    private MentorService mentorService;

    @Override
    public List<Student> getAllStudents() {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();

        criteria.andIsDeletedEqualTo(UserConstrant.NOT_DELETE);
        criteria.andIsMentorNotEqualTo(UserConstrant.HK_MENTOR);
        List<User> users=userMapper.selectByExample(userExample);
        try {
            return ParseUtil.parseFromUser(users,Student.class);
        }catch (Exception e){
            logger.error("get all students error. msg:{}",e.getMessage());
            return null;
        }
    }

    @Override
    public List<Student> getStuByNames(List<String> stuNames) {
        return null;
    }

    @Override
    public List<Student> getStuByIds(List<Integer> ids) {
        if (ids==null||ids.isEmpty())
            return Collections.emptyList();
        List<User> users=new ArrayList<>(ids.size());
        for (Integer id:ids){
            UserExample userExample=new UserExample();
            UserExample.Criteria criteria=userExample.createCriteria();

            criteria.andIdEqualTo(id);
            criteria.andIsDeletedEqualTo(UserConstrant.NOT_DELETE);
            criteria.andIsMentorNotEqualTo(UserConstrant.HK_MENTOR);

            List<User> userList=userMapper.selectByExample(userExample);
            if (userList!=null&&!userList.isEmpty())
                users.add(userList.get(0));
            else {
                logger.info("can not find. userId--->{}",id);
            }
        }
        try {
            return ParseUtil.parseFromUser(users,Student.class);
        }catch (Exception e){
            logger.error("get users error. msg:{}",e.getMessage());
            return null;
        }
    }

    @Override
    public List<Student> getStuByMentorName(String mentorName) {
        return null;
    }

    @Override
    public Result<Student> createStudent(Student student) {

        return null;
    }

    @Override
    public Result<Boolean> importInfo(List<Student> students) {
        Result<Boolean> result=null;
        List<String> emailExist=new ArrayList<>();
        List<String> error=new ArrayList<>();
        for (Student student : students) {
            if (isStuExist(student)){
                emailExist.add(student.getName());
            }else {
                User user=student.toUser();
                completeMentorInfo(user);
                user.setPassword(DefaultValue.PASSWORD);
                user.setIsDeleted(UserConstrant.NOT_DELETE);
                user.setGmtCreated(LocalDateTime.now());
                user.setGmtModified(LocalDateTime.now());

                int ret=userMapper.insert(user);
                if (ret<=0){
                    logger.error("insert error. info: {}",JSONObject.toJSONString(user));
                    error.add(user.getName());
                }else {
                    logger.info("insert success.");
                    String xpNo=XpNoHandle.buildXpNo(user.getId(),Integer.parseInt(user.getGrade()),user.getRegion());
                    user.setXpNo(xpNo);
                    //更新xpNo
                    updateStuInfo(new Student(user));
                }
            }

        }
        if (emailExist.isEmpty()&&error.isEmpty()){
            logger.info("import success.");
            return new Result<>(true);
        }
        String msg=String.format("import error. {%s} are exist , {%s} are insert error"
                ,JSONObject.toJSONString(emailExist),JSONObject.toJSONString(error));
        logger.info(msg);
        return new Result<>(false,msg);
    }

    @Override
    public Boolean isStuExist(Student student) {

        String email=student.getEmail();
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();

        criteria.andEmailEqualTo(email);
        criteria.andIsDeletedEqualTo(UserConstrant.NOT_DELETE);
        //criteria.andIsMentorNotEqualTo(UserConstrant.HK_MENTOR);

        List<User> users=userMapper.selectByExample(userExample);
        if (users != null&&!users.isEmpty()){
            logger.error("user exists. info:{}",JSONObject.toJSONString(users));
            return true;
        }
        return false;
    }

    @Override
    public Student getStuByEmail(String email) {

        return null;
    }

    @Override
    public Boolean updateStuInfo(Student student) {
        User user=student.toUser();
        user.setGmtModified(LocalDateTime.now());

        int ret=userMapper.updateByPrimaryKeySelective(user);
        if (ret>0){
            logger.info("update success. info: {}",JSONObject.toJSONString(student));
            return true;
        }
        logger.error("update error. info: {}",JSONObject.toJSONString(student));
        return false;
    }

    /**
     * 将数据库user转化为student

     */
    private List<Student> parseToStu(List<User> users){
        if (users==null||users.isEmpty()){
            return Collections.emptyList();
        }
        List<Student> students=new ArrayList<>(users.size());
        for (User user : users) {
            Student student=new Student(user);
            students.add(student);
        }
        return students;
    }


    /**
     * 补全导师信息
     */
    private User completeMentorInfo(User user){
        List<String> mentorNames=new ArrayList<>(2);
        if (!StringUtils.isEmpty(user.getStuMentorName())){
            mentorNames.add(user.getStuMentorName());
        }
        if (!StringUtils.isEmpty(user.getHkMentorName()))
            mentorNames.add(user.getHkMentorName());
        if (!mentorNames.isEmpty()){
            List<Mentor> mentors=mentorService.getMentorByNames(mentorNames);
            if (mentors==null||mentors.isEmpty())
                logger.error("can not find mentor. name: {}",JSONObject.toJSONString(mentorNames));
            else {
                if (mentors.size()>2)
                    logger.error("more than 2 mentors. name: {},mentors:{}",JSONObject.toJSONString(mentorNames), JSONObject.toJSONString(mentors));
                for (Mentor m : mentors) {
                    if (UserConstrant.STU_MENTOR == m.getIsMentor()&&user.getStuMentorId()!=null)
                        user.setStuMentorId(m.getId());
                    if (UserConstrant.HK_MENTOR==m.getIsMentor()&&user.getHkMentorId()!=null)
                        user.setHkMentorId(m.getId());
                }
            }
        }
        return user;
    }
}
