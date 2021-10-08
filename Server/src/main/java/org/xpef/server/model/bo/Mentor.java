package org.xpef.server.model.bo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.xpef.server.model.po.User;


@Data
@ApiModel
public class Mentor {


    private Integer id;

    private String name;

    private String email;

    private String weixin;

    private String qq;

    private String phone;

    private Integer isSystem;

    private Integer isMentor;

    public Mentor(User user){
        this.id=user.getId();
        this.name=user.getName();
        this.email=user.getEmail();
        this.weixin=user.getWeixin();
        this.qq=user.getQq();
        this.phone=user.getPhone();
        this.isSystem=user.getIsSystem();
        this.isMentor=user.getIsMentor();
    }

    public User toUser(){
        User user=new User();
        user.setId(id);
        user.setName(name);
        user.setWeixin(weixin);
        user.setQq(qq);
        user.setPhone(phone);
        user.setEmail(email);
        user.setIsMentor(isMentor);
        user.setIsSystem(isSystem);
        return user;
    }

    public Mentor(){}

    public String nameAndId(){
        return name+"_"+id;
    }

}
