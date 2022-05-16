package com.acc.brand.interceptor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import com.acc.brand.annotation.AllowAnnonymous;
import com.acc.brand.constant.StatusType;
import com.acc.brand.response.ResponseAcc;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class RequestValidationInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		AllowAnnonymous allowAnnonymous = ((HandlerMethod) handler).getMethod().getAnnotation((AllowAnnonymous.class));

		if (allowAnnonymous != null) {
			return true;
		}

		Map<String, String> headerMap = getHeaderMap();
		List<String> headerList = headerMap.entrySet().stream().filter(
				e -> request.getHeader(e.getKey()) != null && request.getHeader(e.getKey()).equals(e.getValue()))
				.map(Map.Entry::getKey).collect(Collectors.toList());

		int headerMapSize = headerMap.size();
		int headerListSize = headerList.size();

		if (headerListSize < headerMapSize) {
			setAuthorizationFailedResponse(response);
			return false;
		} else {
			return true;
		}

	}

	private void setAuthorizationFailedResponse(HttpServletResponse response) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		ResponseAcc msg = ResponseAcc.buildResponse(new ArrayList(), StatusType.AUTHORIZATION_FAILED.getCode(),
				StatusType.AUTHORIZATION_FAILED.getMessage());
		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.getWriter().write(mapper.writeValueAsString(msg));
	}

	private Map<String, String> getHeaderMap() {
		Map<String, String> headerMap = new HashMap();
		headerMap.put("X-Content-Type-Options", "nosniff");
		headerMap.put("X-XSS-Protection", "1; mode=block");
		headerMap.put("Strict-Transport-Security", "max-age=31536000; includeSubDomains; preload");
		headerMap.put("X-Frame-Options", "SAMEORIGIN");
		return headerMap;
	}

}
