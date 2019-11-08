package com.bimforest.ems.aop;

import com.bimforest.ems.annotation.OperationLog;
import com.bimforest.ems.common.CommonResponse;
import com.bimforest.ems.common.enums.ResponseTypeEnums;
import com.bimforest.ems.common.utils.JsonUtil;
import com.bimforest.ems.common.utils.UserSessionUtils;
import com.bimforest.ems.modules.log.entity.SysLog;
import com.bimforest.ems.modules.log.mapper.SysLogMapper;
import com.bimforest.ems.modules.log.service.SysLogService;
import com.sun.xml.internal.bind.v2.model.core.EnumConstant;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author youngyanjun
 * @date 2019-11-04 13:11
 */
@Order(3)
@Component
@Aspect
public class LogAspect {
    @Resource
    UserSessionUtils userSessionUtils;
    @Resource
    SysLogService sysLogService;
    @Resource
    SysLogMapper sysLogMapper;

    //配置切点连接的自定义注解
    @Around("@annotation(com.bimforest.ems.annotation.OperationLog)")
    public Object saveLgoAroundAdvice(ProceedingJoinPoint pjp) {
        // 1.方法执行前的处理，相当于前置通知
        // 获取方法签名
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        // 获取方法
        Method method = methodSignature.getMethod();
        // 获取方法上面的注解
        OperationLog logAnno = method.getAnnotation(OperationLog.class);
        // 获取操作描述的属性值
        String action = logAnno.action();//用户行为--操作行为
        String module = logAnno.module();//操作模块
        SysLog sysLog = new SysLog(); //创建日志对象
        //获取操作的用户
        //设置操作的用
        sysLog.setModule(module);    //设置对象的modle属性
        sysLog.setAction(action);   //设置用户的action属性
        Object result = null;
        try {
            result = pjp.proceed();
            Signature signature = pjp.getSignature();
            //对象转换
            CommonResponse commonResponse = (CommonResponse) result;
            //成功记录日志，否则什么也不做，，例如新增校验数据不合法，不记录日志
            if (commonResponse.getStatus().equals(ResponseTypeEnums.SUCCESS)) {
                //插入日志
                sysLogMapper.insert(sysLog);
            }
        } catch (Throwable throwable) {
        } finally {
        }
        return result;
    }

}
