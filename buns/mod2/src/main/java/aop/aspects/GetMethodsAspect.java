package aop.aspects;

import aop.Book;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(10)
public class GetMethodsAspect {

    @Around("aop.aspects.Pointcuts.pointcutGetBookAdvice()")
    public Object aroundGetBookAdvice(ProceedingJoinPoint joinPoint)
            throws Throwable {
        System.out.println("Попытка получить книгу...");
        Object targetMethodResult = null;
        try {
            targetMethodResult = joinPoint.proceed();
            System.out.println("Книга получена");
        } catch (Throwable throwable) {
            targetMethodResult = new Book("Неизвестная книга", "Неизвестный автор");
            System.out.println("Данной книги нет в библиотеке");
        }
        System.out.println("---------------------------------------------------------------");
        return targetMethodResult;
    }
}
