package org.xpef.server.util;

import com.alibaba.fastjson.JSONObject;
import org.xpef.server.model.bo.Student;
import org.xpef.server.model.po.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParseUtil {

    /**
     * 对象转化，将user转化为所需类型，前提必须实现相应构造函数
     */
    public static<T> List<T> parseFromUser(List<User> users,Class<T> clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (users==null||users.isEmpty()){
            return Collections.emptyList();
        }
        List<T> res=new ArrayList<>(users.size());
        for (User user : users) {
            Constructor<T> con=clazz.getConstructor(User.class);
            T t=(T)con.newInstance(user);
            res.add(t);
        }
        return res;
    }


    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        User user=new User();
        user.setId(11);
        user.setEmail("1111");
        List<Student> s= parseFromUser(Collections.singletonList(user),Student.class);
        System.out.println(JSONObject.toJSONString(s.get(0)));
    }
}
