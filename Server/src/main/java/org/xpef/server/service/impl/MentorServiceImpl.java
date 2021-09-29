package org.xpef.server.service.impl;

import com.alibaba.fastjson.JSONObject;
import netscape.javascript.JSObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.xpef.server.constrants.UserConstrant;
import org.xpef.server.mapper.UserMapper;
import org.xpef.server.model.bo.Mentor;
import org.xpef.server.model.po.User;
import org.xpef.server.model.po.UserExample;
import org.xpef.server.service.MentorService;
import org.xpef.server.util.ParseUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service("mentorService")
public class MentorServiceImpl implements MentorService {

    private final Logger logger= LoggerFactory.getLogger(MentorServiceImpl.class);

    @Resource
    private UserMapper userMapper;

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
}
