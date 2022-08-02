package com.epam.jeka.aoploggingexample;


import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BenchmarkSupportAspect {


    @Around("@within(Benchmark) || @annotation(Benchmark)")
    @SneakyThrows
    public Object handleBenchmarkMethods(ProceedingJoinPoint pjp){
        System.out.println("***BENCHMARK STARTED for method "+pjp.getTarget().getClass()+" "+pjp.getSignature());
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Benchmark annotation = signature.getMethod().getAnnotation(Benchmark.class);
        System.out.println(annotation.name());
        long start = System.nanoTime();
        Object retVal = pjp.proceed();
        long end = System.nanoTime();
        System.out.println(end-start);
        System.out.println("***BENCHMARK ENDED for method "+pjp.getTarget().getClass()+" "+pjp.getSignature());
        return retVal;
    }

}
