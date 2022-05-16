package com.acc.brand.annotation;

import java.util.ArrayList;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import com.acc.brand.constant.StatusType;
import com.acc.brand.request.SearchRequest;
import com.acc.brand.response.ResponseAcc;
import com.acc.brand.util.AccStringUtils;
 
@Aspect
@Component
public class SearchValidationAspect {
	@Around("@annotation(SearchValidation) ")
	public Object validate(ProceedingJoinPoint joinPoint) throws Throwable {
		SearchRequest search = (SearchRequest) joinPoint.getArgs()[0];
		String pSearch = search.getGetListFilterUnitBrand().getPsearch();

		if (StringUtils.hasLength(pSearch)) {
			if (pSearch.length() <= 10) {
				if (AccStringUtils.containSpecialCharacter(pSearch)) {
					return ResponseAcc.buildResponse(new ArrayList(), StatusType.RESULT_FAILED.getCode(),
							StatusType.RESULT_FAILED.getMessage());
				}
			} else {
				return ResponseAcc.buildResponse(new ArrayList(), StatusType.RESULT_FAILED.getCode(),
						StatusType.RESULT_FAILED.getMessage());
			}
		}
		Object result = joinPoint.proceed();
		return result;
	}
}
