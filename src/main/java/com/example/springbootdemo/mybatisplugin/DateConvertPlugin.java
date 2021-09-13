package com.example.springbootdemo.mybatisplugin;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Map;
import java.util.Properties;

@Slf4j
@Intercepts({@Signature(type = ResultSetHandler.class, method = "handleResultSets", args = { Statement.class }),
        @Signature(type = ParameterHandler.class, method = "setParameters", args = { PreparedStatement.class }),
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class })})
public class DateConvertPlugin implements Interceptor {
    public Object intercept(Invocation invocation) throws Throwable {
        Object target = invocation.getTarget();
        if (target instanceof ResultSetHandler) {
            log.info("instance of ResultSetHandler");
            ResultSetHandler resultSetHandler = (ResultSetHandler) target;
        } else if (target instanceof ParameterHandler) {
            log.info("instance of ParameterHandler");
            ParameterHandler parameterHandler = (ParameterHandler) target;
            Map<String, Object> paramMap = (Map)parameterHandler.getParameterObject();
            paramMap.put("id", 4);
        }else if (target instanceof StatementHandler){
            StatementHandler statementHandler = (StatementHandler) target;
            log.info("instance of StatementHandler");
        } else {
            log.error("Invalid Interceptor type, type={}", target.getClass().getName());
        }
        return invocation.proceed();
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }
    public void setProperties(Properties properties) {
    }
}
