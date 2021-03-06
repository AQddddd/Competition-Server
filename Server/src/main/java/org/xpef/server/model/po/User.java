package org.xpef.server.model.po;


import java.time.LocalDateTime;

public class User {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.xp_no
     *
     * @mbg.generated
     */
    private String xpNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.id_card
     *
     * @mbg.generated
     */
    private String idCard;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.password
     *
     * @mbg.generated
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.sex
     *
     * @mbg.generated
     */
    private String sex;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.region
     *
     * @mbg.generated
     */
    private String region;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.grade
     *
     * @mbg.generated
     */
    private String grade;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.stu_mentor_id
     *
     * @mbg.generated
     */
    private Integer stuMentorId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.stu_mentor_name
     *
     * @mbg.generated
     */
    private String stuMentorName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.hk_mentor_id
     *
     * @mbg.generated
     */
    private Integer hkMentorId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.hk_mentor_name
     *
     * @mbg.generated
     */
    private String hkMentorName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.high_school
     *
     * @mbg.generated
     */
    private String highSchool;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.university
     *
     * @mbg.generated
     */
    private String university;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.school_year
     *
     * @mbg.generated
     */
    private Integer schoolYear;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.major
     *
     * @mbg.generated
     */
    private String major;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.living
     *
     * @mbg.generated
     */
    private String living;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.email
     *
     * @mbg.generated
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.weixin
     *
     * @mbg.generated
     */
    private String weixin;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.qq
     *
     * @mbg.generated
     */
    private String qq;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.phone
     *
     * @mbg.generated
     */
    private String phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.high_sch_region
     *
     * @mbg.generated
     */
    private String highSchRegion;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.bank_card_no
     *
     * @mbg.generated
     */
    private String bankCardNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.bank_name
     *
     * @mbg.generated
     */
    private String bankName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.bank_address
     *
     * @mbg.generated
     */
    private String bankAddress;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.is_system
     *
     * @mbg.generated
     */
    private Integer isSystem;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.is_mentor
     *
     * @mbg.generated
     */
    private Integer isMentor;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.is_funded
     *
     * @mbg.generated
     */
    private Integer isFunded;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.is_qualified
     *
     * @mbg.generated
     */
    private Integer isQualified;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.is_deleted
     *
     * @mbg.generated
     */
    private Integer isDeleted;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.gmt_created
     *
     * @mbg.generated
     */
    private LocalDateTime gmtCreated;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.gmt_modified
     *
     * @mbg.generated
     */
    private LocalDateTime gmtModified;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.id
     *
     * @return the value of user.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.id
     *
     * @param id the value for user.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.xp_no
     *
     * @return the value of user.xp_no
     *
     * @mbg.generated
     */
    public String getXpNo() {
        return xpNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.xp_no
     *
     * @param xpNo the value for user.xp_no
     *
     * @mbg.generated
     */
    public void setXpNo(String xpNo) {
        this.xpNo = xpNo == null ? null : xpNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.name
     *
     * @return the value of user.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.name
     *
     * @param name the value for user.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.id_card
     *
     * @return the value of user.id_card
     *
     * @mbg.generated
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.id_card
     *
     * @param idCard the value for user.id_card
     *
     * @mbg.generated
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.password
     *
     * @return the value of user.password
     *
     * @mbg.generated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.password
     *
     * @param password the value for user.password
     *
     * @mbg.generated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.sex
     *
     * @return the value of user.sex
     *
     * @mbg.generated
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.sex
     *
     * @param sex the value for user.sex
     *
     * @mbg.generated
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.region
     *
     * @return the value of user.region
     *
     * @mbg.generated
     */
    public String getRegion() {
        return region;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.region
     *
     * @param region the value for user.region
     *
     * @mbg.generated
     */
    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.grade
     *
     * @return the value of user.grade
     *
     * @mbg.generated
     */
    public String getGrade() {
        return grade;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.grade
     *
     * @param grade the value for user.grade
     *
     * @mbg.generated
     */
    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.stu_mentor_id
     *
     * @return the value of user.stu_mentor_id
     *
     * @mbg.generated
     */
    public Integer getStuMentorId() {
        return stuMentorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.stu_mentor_id
     *
     * @param stuMentorId the value for user.stu_mentor_id
     *
     * @mbg.generated
     */
    public void setStuMentorId(Integer stuMentorId) {
        this.stuMentorId = stuMentorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.stu_mentor_name
     *
     * @return the value of user.stu_mentor_name
     *
     * @mbg.generated
     */
    public String getStuMentorName() {
        return stuMentorName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.stu_mentor_name
     *
     * @param stuMentorName the value for user.stu_mentor_name
     *
     * @mbg.generated
     */
    public void setStuMentorName(String stuMentorName) {
        this.stuMentorName = stuMentorName == null ? null : stuMentorName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.hk_mentor_id
     *
     * @return the value of user.hk_mentor_id
     *
     * @mbg.generated
     */
    public Integer getHkMentorId() {
        return hkMentorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.hk_mentor_id
     *
     * @param hkMentorId the value for user.hk_mentor_id
     *
     * @mbg.generated
     */
    public void setHkMentorId(Integer hkMentorId) {
        this.hkMentorId = hkMentorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.hk_mentor_name
     *
     * @return the value of user.hk_mentor_name
     *
     * @mbg.generated
     */
    public String getHkMentorName() {
        return hkMentorName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.hk_mentor_name
     *
     * @param hkMentorName the value for user.hk_mentor_name
     *
     * @mbg.generated
     */
    public void setHkMentorName(String hkMentorName) {
        this.hkMentorName = hkMentorName == null ? null : hkMentorName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.high_school
     *
     * @return the value of user.high_school
     *
     * @mbg.generated
     */
    public String getHighSchool() {
        return highSchool;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.high_school
     *
     * @param highSchool the value for user.high_school
     *
     * @mbg.generated
     */
    public void setHighSchool(String highSchool) {
        this.highSchool = highSchool == null ? null : highSchool.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.university
     *
     * @return the value of user.university
     *
     * @mbg.generated
     */
    public String getUniversity() {
        return university;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.university
     *
     * @param university the value for user.university
     *
     * @mbg.generated
     */
    public void setUniversity(String university) {
        this.university = university == null ? null : university.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.school_year
     *
     * @return the value of user.school_year
     *
     * @mbg.generated
     */
    public Integer getSchoolYear() {
        return schoolYear;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.school_year
     *
     * @param schoolYear the value for user.school_year
     *
     * @mbg.generated
     */
    public void setSchoolYear(Integer schoolYear) {
        this.schoolYear = schoolYear;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.major
     *
     * @return the value of user.major
     *
     * @mbg.generated
     */
    public String getMajor() {
        return major;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.major
     *
     * @param major the value for user.major
     *
     * @mbg.generated
     */
    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.living
     *
     * @return the value of user.living
     *
     * @mbg.generated
     */
    public String getLiving() {
        return living;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.living
     *
     * @param living the value for user.living
     *
     * @mbg.generated
     */
    public void setLiving(String living) {
        this.living = living == null ? null : living.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.email
     *
     * @return the value of user.email
     *
     * @mbg.generated
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.email
     *
     * @param email the value for user.email
     *
     * @mbg.generated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.weixin
     *
     * @return the value of user.weixin
     *
     * @mbg.generated
     */
    public String getWeixin() {
        return weixin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.weixin
     *
     * @param weixin the value for user.weixin
     *
     * @mbg.generated
     */
    public void setWeixin(String weixin) {
        this.weixin = weixin == null ? null : weixin.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.qq
     *
     * @return the value of user.qq
     *
     * @mbg.generated
     */
    public String getQq() {
        return qq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.qq
     *
     * @param qq the value for user.qq
     *
     * @mbg.generated
     */
    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.phone
     *
     * @return the value of user.phone
     *
     * @mbg.generated
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.phone
     *
     * @param phone the value for user.phone
     *
     * @mbg.generated
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.high_sch_region
     *
     * @return the value of user.high_sch_region
     *
     * @mbg.generated
     */
    public String getHighSchRegion() {
        return highSchRegion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.high_sch_region
     *
     * @param highSchRegion the value for user.high_sch_region
     *
     * @mbg.generated
     */
    public void setHighSchRegion(String highSchRegion) {
        this.highSchRegion = highSchRegion == null ? null : highSchRegion.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.bank_card_no
     *
     * @return the value of user.bank_card_no
     *
     * @mbg.generated
     */
    public String getBankCardNo() {
        return bankCardNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.bank_card_no
     *
     * @param bankCardNo the value for user.bank_card_no
     *
     * @mbg.generated
     */
    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo == null ? null : bankCardNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.bank_name
     *
     * @return the value of user.bank_name
     *
     * @mbg.generated
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.bank_name
     *
     * @param bankName the value for user.bank_name
     *
     * @mbg.generated
     */
    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.bank_address
     *
     * @return the value of user.bank_address
     *
     * @mbg.generated
     */
    public String getBankAddress() {
        return bankAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.bank_address
     *
     * @param bankAddress the value for user.bank_address
     *
     * @mbg.generated
     */
    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress == null ? null : bankAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.is_system
     *
     * @return the value of user.is_system
     *
     * @mbg.generated
     */
    public Integer getIsSystem() {
        return isSystem;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.is_system
     *
     * @param isSystem the value for user.is_system
     *
     * @mbg.generated
     */
    public void setIsSystem(Integer isSystem) {
        this.isSystem = isSystem;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.is_mentor
     *
     * @return the value of user.is_mentor
     *
     * @mbg.generated
     */
    public Integer getIsMentor() {
        return isMentor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.is_mentor
     *
     * @param isMentor the value for user.is_mentor
     *
     * @mbg.generated
     */
    public void setIsMentor(Integer isMentor) {
        this.isMentor = isMentor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.is_funded
     *
     * @return the value of user.is_funded
     *
     * @mbg.generated
     */
    public Integer getIsFunded() {
        return isFunded;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.is_funded
     *
     * @param isFunded the value for user.is_funded
     *
     * @mbg.generated
     */
    public void setIsFunded(Integer isFunded) {
        this.isFunded = isFunded;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.is_qualified
     *
     * @return the value of user.is_qualified
     *
     * @mbg.generated
     */
    public Integer getIsQualified() {
        return isQualified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.is_qualified
     *
     * @param isQualified the value for user.is_qualified
     *
     * @mbg.generated
     */
    public void setIsQualified(Integer isQualified) {
        this.isQualified = isQualified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.is_deleted
     *
     * @return the value of user.is_deleted
     *
     * @mbg.generated
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.is_deleted
     *
     * @param isDeleted the value for user.is_deleted
     *
     * @mbg.generated
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.gmt_created
     *
     * @return the value of user.gmt_created
     *
     * @mbg.generated
     */
    public LocalDateTime getGmtCreated() {
        return gmtCreated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.gmt_created
     *
     * @param gmtCreated the value for user.gmt_created
     *
     * @mbg.generated
     */
    public void setGmtCreated(LocalDateTime gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.gmt_modified
     *
     * @return the value of user.gmt_modified
     *
     * @mbg.generated
     */
    public LocalDateTime getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.gmt_modified
     *
     * @param gmtModified the value for user.gmt_modified
     *
     * @mbg.generated
     */
    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }
}