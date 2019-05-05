package com.nxs.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @program: spring-annotation
 * @description: 日志切面类
 * @author: NieXiaoshuang
 * @create: 2019-05-04 14:50
 * @Aspect 告诉 spring当前类是一个切面类
 **/
@Aspect
public class LogAspects {

    /**
     * 抽取公共的切入点表达式
     * 1.本类引用
     * 2.其它切面引用 方法全名
     */
    @Pointcut("execution(public int com.nxs.aop.MathCalculator.div(int,int))")
    public void pointCut(){}

    /**
     * @Before 在目标方法之前切入
     * 切入点表达式（指定在哪个方法切入）
     */
    @Before("execution(public int com.nxs.aop.MathCalculator.div(int,int))")
//    @Before("public int com.nxs.aop.MathCalculator.*(..)")
    public void logStart(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName() + "运行...参数列表：{"+ Arrays.asList(args)+"}");
    }

    @After("execution(public int com.nxs.aop.MathCalculator.div(int,int))")
    public void logEnd(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName() + "结束...");
    }

    /**
     * 多个参数 joinPoint必须放在第一位
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturn(JoinPoint joinPoint,Object result){
        System.out.println(joinPoint.getSignature().getName() + "正常返回...运行结果：{"+result+"}");
    }

    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void logException(JoinPoint joinPoint,Exception exception){
        System.out.println(joinPoint.getSignature().getName() + "异常...异常信息：{"+exception+"}");
    }
}
