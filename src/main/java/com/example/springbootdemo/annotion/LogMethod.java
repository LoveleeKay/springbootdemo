package com.example.springbootdemo.annotion;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER}) //声明应用在属性上
@Retention(RetentionPolicy.RUNTIME) //运行期生效
@Documented //Java Doc
public @interface LogMethod {
    String value() default "";
}
