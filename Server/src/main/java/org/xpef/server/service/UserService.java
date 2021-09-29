//package org.xpef.server.service;
//
//import core.util.*;
//import org.xpef.server.dao.UserDao;
//import org.xpef.server.model.bo.User;
//import core.util.EmailUtil;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Service;
//
//import java.io.Serializable;
//import java.util.concurrent.TimeUnit;
//
//@Service
//public class UserService {
//    private  static  final Logger logger = LoggerFactory.getLogger(UserService.class);
//
//    @Value("${competition.user.depart_id}")
//    private Long userDepId;
//    @Value("${competition.expire_time}")
//    private int expireTime;
//    @Value("${competition.code_expire_time}")
//    private int verifyTime;
//
//
//    @Autowired
//    private UserDao userDao;
//
//    @Autowired
//    private RedisTemplate<String, Serializable> redisTemplate;
//
//    /**
//     * 登录
//     * @param email
//     * @param password
//     * @return
//     */
//    public Result login(String email, String password){
//        Result ret=userDao.findUserByEmail(email);
//        if (ret.getCode()== ResponseCode.OK){
//            User user=(User) ret.getData();
//            if (user==null){
//                return new Result(ResponseCode.AUTH_NOT_EXIST);
//            }
//            if (user.getPassword().equals(password)){
//                logger.debug("login: successful . email: "+email);
//                String jwt= JwtHelper.getInstance().createToken(user.getId(),userDepId,expireTime*60*60);
//                return new Result(jwt);
//            }
//            else {
//                logger.debug("login: password error . email: "+email);
//                return new Result(ResponseCode.AUTH_WRONG_ACCOUNT);
//            }
//        }
//        logger.debug("login: error ."+ret.getErrmsg());
//        return ret;
//    }
//
//    /**
//     * 注册
//     * @param email
//     * @param password
//     * @param verifyCode
//     * @return
//     */
//    public Result register(String email, String password, String verifyCode){
//        logger.debug("register: email: "+email);
//        Result check=verify(email,verifyCode);
//        if (check.getCode()==ResponseCode.OK){
//            return userDao.insertUser(email,password);
//        }
//        return check;
//    }
//
//    /**
//     * 发送验证码
//     * @param email
//     * @return
//     */
//    public Result sendCodeByEmail(String email){
//        String code=createVerCode(email);
//        EmailUtil.send(email,"【***】验证码","【***】您的验证码是"+code+"，请于5分钟内正确输入。");
//        logger.debug("send code "+code+"  to "+email);
//        return new Result(code);
//    }
//
//    /**
//     * 验证验证码
//     * @param email
//     * @param code
//     * @return
//     */
//    public Result verify(String email, String code){
//        String key="v_"+email;
//        if (redisTemplate.hasKey(key)){
//            logger.debug("verify code is true. "+email);
//            redisTemplate.delete(key);
//            return new Result(ResponseCode.OK);
//        }
//        logger.debug("verify code is false. "+email);
//        return new Result(ResponseCode.VERIFY_CODE_EXPIRE);
//    }
//
//    /**
//     * 产生验证码并放入redis
//     * @param destination
//     * @return
//     */
//    public String createVerCode(String destination){
//
//        String code= Common.genSeqNum();
//        String key="v_"+destination;
//        redisTemplate.opsForValue().set(key,code,verifyTime,TimeUnit.MINUTES);
//        logger.debug("create verify code."+code);
//        return code;
//    }
//
//    /**
//     * 用户重置密码
//     * @param email
//     * @param newPassword
//     * @return
//     */
//    public Result resetPassword(String email, String newPassword){
//        return userDao.updateUser(email,newPassword);
//    }
//
//
//}
