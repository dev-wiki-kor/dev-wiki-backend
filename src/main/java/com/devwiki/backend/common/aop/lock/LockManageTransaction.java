package com.devwiki.backend.common.aop.lock;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;

@Component
public class LockManageTransaction {
	@Transactional(value = Transactional.TxType.REQUIRES_NEW)
	Object proceed(final ProceedingJoinPoint joinPoint) throws Throwable {
		return joinPoint.proceed();
	}
}
