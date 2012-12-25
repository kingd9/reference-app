package org.daneking.profile.common.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class LoggingAspect {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Around("execution(* org.daneking..*.*(..))")
	public Object logTimeMethod(final ProceedingJoinPoint joinPoint) throws Throwable {

		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		Object retVal = joinPoint.proceed();

		stopWatch.stop();

		StringBuffer logMessage = new StringBuffer();
		logMessage.append(joinPoint.getTarget().getClass().getName());
		logMessage.append(".");
		logMessage.append(joinPoint.getSignature().getName());
		logMessage.append("(");
		// append args
		Object[] args = joinPoint.getArgs();
		for (Object arg : args) {
			logMessage.append(arg).append(",");
		}
		if (args.length > 0) {
			logMessage.deleteCharAt(logMessage.length() - 1);
		}

		logMessage.append(")");
		logMessage.append(" execution time: ");
		logMessage.append(stopWatch.getTotalTimeMillis());
		logMessage.append(" ms");
		log.info(logMessage.toString());
		return retVal;
	}

}
