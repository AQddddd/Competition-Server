package org.xpef.server.model.bo;

import lombok.Data;
import org.xpef.server.model.po.User;


@Data
public class Mentor {


    private Integer id;

    private String name;

    private String idCard;

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
        this.idCard=user.getIdCard();
        this.isSystem=user.getIsSystem();
        this.isMentor=user.getIsMentor();
    }

    public Mentor(){}

    public String nameAndId(){
        return name+"_"+id;
    }

}
