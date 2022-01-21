package com.example.springbootdemo.utils.validate;

import com.example.springbootdemo.vo.BaseStudent;
import com.example.springbootdemo.vo.Student;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 分组校验表单
 *
 * @author liyongsheng
 * @date 2022/01/20 08:37
 **/
public class StudentGroupProvider<T extends BaseStudent> implements DefaultGroupSequenceProvider<T> {

    public StudentGroupProvider() {
        System.out.println("llys 123");
    }

    @Override
    public List<Class<?>> getValidationGroups(T baseStudent) {
        List<Class<?>> defaultGroupSequence = new ArrayList<>();

        if (baseStudent != null && baseStudent.getFatherAge() == 1) {
            defaultGroupSequence.add(GroupA.class);
        } else {
            defaultGroupSequence.add(GroupB.class);
        }
        // 必须要有当前类，不然报错
        defaultGroupSequence.add(getTClass());

        return defaultGroupSequence;
    }

    /**
     * 获取T.class
     * @author liyongsheng
     * @date 2022/1/20 16:59
     * @since 1.0.0
     * @return java.lang.Class
     */
    public Class getTClass() {
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
        return (Class)params[0];
    }
    public static void main(String[] args) {
        System.out.println(new StudentGroupProvider<Student>(){}.getTClass());
    }

}
