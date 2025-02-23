package xyz.vvrf.sci.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * sci
 *
 * @author ruifeng.wen
 * @date 2/23/25
 */

@Aspect
@Component
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    // 定义切点，这里匹配所有 public 方法，你可以根据实际情况修改切点表达式
    @Pointcut("execution(public * your.package.interfaces.*.*(..))") // 替换 your.package.interfaces 为你的接口所在包
    public void interfaceMethodPointcut() {
    }

    @Before("interfaceMethodPointcut()")
    public void log вход(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        logger.info("接口方法 {} 入参: {}", methodName, Arrays.toString(args));
    }

    @AfterReturning(pointcut = "interfaceMethodPointcut()", returning = "result")
    public void log выход(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("接口方法 {} 出参: {}", methodName, result);
    }

    @AfterThrowing(pointcut = "interfaceMethodPointcut()", throwing = "e")
    public void log exception(JoinPoint joinPoint, Throwable e) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        logger.error("接口方法 {} 执行异常，入参: {}, 异常信息: ", methodName, Arrays.toString(args), e);
    }
}
