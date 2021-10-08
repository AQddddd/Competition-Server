package org.xpef.server.service.impl;

import com.alibaba.fastjson.JSONObject;
import netscape.javascript.JSObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.xpef.server.constrants.UserConstrant;
import org.xpef.server.mapper.UserMapper;
import org.xpef.server.model.bo.Mentor;
import org.xpef.server.model.bo.Student;
import org.xpef.server.model.po.User;
import org.xpef.server.model.po.UserExample;
import org.xpef.server.service.MentorService;
import org.xpef.server.service.UserService;
import org.xpef.server.util.ParseUtil;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service("mentorService")
public class MentorServiceImpl implements MentorService {

    private final Logger logger= LoggerFactory.getLogger(MentorServiceImpl.class);

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;

    @Override
    public List<Mentor> getMentorByNames(List<String> names) {
        if (names==null||names.isEmpty())
            return Collections.emptyList();
        List<Mentor> mentors=new ArrayList<>(names.size());
        for (String name : names) {
            UserExample example=new UserExample();
            UserExample.Criteria criteria=example.createCriteria();

            criteria.andNameEqualTo(name);
            criteria.andIsDeletedEqualTo(UserConstrant.NOT_DELETE);
            criteria.andIsMentorNotEqualTo(UserConstrant.STUDENT);

            List<User> users=userMapper.selectByExample(example);

            if (users==null||users.isEmpty()){
                logger.error("can not find mentor. name: {}",name);
            }else {
                try {
                    List<Mentor> mentorList= ParseUtil.parseFromUser(users,Mentor.class);
                    logger.info("find mentor success. info: {}", JSONObject.toJSONString(mentorList));
                    mentors.add(mentorList.get(0));
                }catch (Exception e){
                    logger.error("find mentor error.name: {}, msg: {}",name,e.getMessage());
                }
            }
        }
        return mentors;
    }

    @Override
    public List<Mentor> getTypeMentors(int type) {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();

        criteria.andIsDeletedEqualTo(UserConstrant.NOT_DELETE);
        criteria.andIsMentorEqualTo(type);
        List<User> users=userMapper.selectByExample(userExample);
        try {
            return ParseUtil.parseFromUser(users, Mentor.class);
        }catch (Exception e){
            logger.error("get mentors error. msg:{}",e.getMessage());
            return null;
        }
    }

    @Override
    public List<Mentor> getAllMentors() {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();

        criteria.andIsDeletedEqualTo(UserConstrant.NOT_DELETE);
        criteria.andIsMentorNotEqualTo(UserConstrant.STUDENT);
        List<User> users=userMapper.selectByExample(userExample);
        try {
            return ParseUtil.parseFromUser(users, Mentor.class);
        }catch (Exception e){
            logger.error("get all mentors error. msg:{}",e.getMessage());
            return null;
        }
    }



    @Override
    public Boolean updateMentor(Mentor mentor) {
        User user=mentor.toUser();
        user.setGmtModified(LocalDateTime.now());

        int ret=userMapper.updateByPrimaryKeySelective(user);
        if (ret>0){
            logger.info("update mentor success. info: {}",JSONObject.toJSONString(mentor));
            return true;
        }
        logger.error("update mentor error. info: {}",JSONObject.toJSONString(mentor));
        return false;
    }

    @Override
    public List<Mentor> getMentorByIds(List<Integer> mentorIds) {
        if (mentorIds==null||mentorIds.isEmpty())
            return Collections.emptyList();
        List<Mentor> mentors=new ArrayList<>(mentorIds.size());
        for (Integer id : mentorIds) {

            User user=userService.getUserById(id);

            if (user==null){
                logger.error("can not find mentor. id: {}",id);
            }else {
                try {
                    List<Mentor> mentorList= ParseUtil.parseFromUser(Collections.singletonList(user),Mentor.class);
                    logger.info("find mentor by id success. info: {}", JSONObject.toJSONString(mentorList));
                    mentors.add(mentorList.get(0));
                }catch (Exception e){
                    logger.error("find mentor by id error.msg: {}",e.getMessage());
                }
            }
        }
        return mentors;
    }
}
