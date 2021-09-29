package org.xpef.server.model.bo;

import lombok.Data;
import org.xpef.server.constrants.System;
import org.xpef.server.constrants.UserConstrant;
import org.xpef.server.model.po.User;


@Data
public class Student {


    private Integer id;

    private String xpNo;

    private String name;

    private String idCard;

    private String sex;

    private String region;

    private String grade;

    private Integer stuMentorId;

    private String stuMentorName;

    private Integer hkMentorId;

    private String hkMentorName;

    private String highSchool;

    private String university;

    private Integer schoolYear;

    private String major;

    private String living;

    private String email;

    private String weixin;

    private String qq;

    private String phone;

    private String highSchRegion;

    private String bankCardNo;

    private String bankName;

    private String bankAddress;

    private Integer isSystem;

    private Integer isMentor;

    private Integer isFunded;

    private Integer isQualified;

    public void fixDefault(){

        this.isFunded=UserConstrant.NOT_FUNDED;
        this.isMentor=UserConstrant.STUDENT;
        this.isQualified=UserConstrant.QUALIFIED;
        this.isSystem= System.NORMAL;

    }

    public Student(User user){
        this.id=user.getId();
        this.xpNo=user.getXpNo();
        this.name=user.getName();
        this.idCard=user.getIdCard();
        this.sex=user.getSex();
        this.region=user.getRegion();
        this.grade=user.getGrade();
        this.stuMentorId=user.getStuMentorId();
        this.stuMentorName=user.getStuMentorName();
        this.hkMentorId=user.getHkMentorId();
        this.hkMentorName=user.getHkMentorName();
        this.highSchool=user.getHighSchool();
        this.university=user.getUniversity();
        this.schoolYear=user.getSchoolYear();
        this.major=user.getMajor();
        this.living=user.getLiving();
        this.email=user.getEmail();
        this.weixin=user.getWeixin();
        this.qq=user.getQq();
        this.phone=user.getPhone();
        this.highSchRegion=user.getHighSchRegion();
        this.bankCardNo=user.getBankCardNo();
        this.bankName=user.getBankName();
        this.bankAddress=user.getBankAddress();
        this.isSystem=user.getIsSystem();
        this.isMentor=user.getIsMentor();
        this.isFunded=user.getIsFunded();
        this.isQualified=user.getIsQualified();
    }

    public User toUser(){
        User user=new User();
        user.setId(id);
        user.setXpNo(xpNo);
        user.setName(name);
        user.setIdCard(idCard);
        user.setSex(sex);
        user.setRegion(region);
        user.setStuMentorId(stuMentorId);
        user.setStuMentorName(stuMentorName);
        user.setHkMentorId(hkMentorId);
        user.setHkMentorName(hkMentorName);
        user.setUniversity(university);
        user.setSchoolYear(schoolYear);
        user.setMajor(major);
        user.setLiving(living);
        user.setWeixin(weixin);
        user.setQq(qq);
        user.setPhone(phone);
        user.setHighSchRegion(highSchRegion);
        user.setEmail(email);
        user.setBankAddress(bankAddress);
        user.setBankCardNo(bankCardNo);
        user.setBankName(bankName);
        user.setGrade(grade);
        user.setHighSchool(highSchool);
        user.setIsMentor(isMentor);
        user.setIsSystem(isSystem);
        user.setIsFunded(isFunded);
        user.setIsQualified(isQualified);
        return user;
    }


    public Student(){}
}
