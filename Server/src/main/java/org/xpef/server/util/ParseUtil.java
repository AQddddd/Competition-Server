package org.xpef.server.util;

import com.alibaba.fastjson.JSONObject;
import org.xpef.server.model.bo.Student;
import org.xpef.server.model.po.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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



    public static List<Integer> coverToIntegerList(String str){

        return Arrays.stream(str.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(coverToIntegerList("1,2,3"));
    }
}
