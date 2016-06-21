package io.crowdcode.speedbay.auction.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.crowdcode.speedbay.common.AnsiColor.blue;


/**
 * @author Ingo Düppe (Crowdcode)
 */
@Aspect
public class LoggingAdvice {

    private static final Logger log = LoggerFactory.getLogger(LoggingAdvice.class);

    @Around("execution(* io.crowdcode.speedbay.auction.*.*.*(..))")
    public Object basicLogging(ProceedingJoinPoint pjp) throws Throwable {
        log.info(blue("starting method {}"), pjp.toString());
        Object retVal = pjp.proceed();
        return retVal;
    }

}
