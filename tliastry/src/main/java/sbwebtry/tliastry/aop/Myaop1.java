package sbwebtry.tliastry.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/*
* 将AOP类标记为@Component并纳入Spring的IoC容器管理，
* 可以让Spring框架自动代理和织入这些AOP类到目标对象中，
* 以实现横切关注点的功能。这样可以确保AOP类能够被正确地初始化、
* 管理和应用到目标对象中。
* */
@Slf4j
@Component
@Aspect//表示是AOP类
public class Myaop1 {
    @Around("execution(* sbwebtry.tliastry.service.*.*(..))")//表示两层的包之后任意参数的
    public Object recordTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long begin = System.currentTimeMillis();
        Object object = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        log.info(proceedingJoinPoint.getSignature() + "执行花了{}ms",end - begin);
        return object;
    }
}
