package aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Order(5)
public class AllMethodsAspect {

    @Before("aop.aspects.Pointcuts.pointcutAllMethodsAdvice()")
    public void beforeAllMethodsAdvice(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Работа сотрудника библиотеки...");
        System.out.println("Работает метод: " + signature.getName()
                + "\nВозвращаемое значение: " + signature.getReturnType()
                + "\nАргументы: " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("---------------------------------------------------------------");
    }
}
