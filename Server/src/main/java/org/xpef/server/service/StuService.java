package org.xpef.server.service;

import org.springframework.stereotype.Service;
import org.xpef.server.model.bo.Student;
import org.xpef.server.util.Result;

import java.util.List;


public interface StuService {

    /**
     * 获取所有未删除学生
     */
    public List<Student> getAllStudents(int type);

    public List<Student> getStuByNames(List<String> stuNames);

    public List<Student> getStuByIds(List<Integer> ids);

    public List<Student> getStuByMentorName(String mentorName);

    public Result<Boolean> createStudent(Student student);

    public Result<Boolean> importInfo(List<Student> students);

    public Boolean isStuExist(Student student);

    public Student getStuByEmail(String email);

    public Boolean updateStuInfo(Student student);

    public Boolean delete(Integer id);


}
