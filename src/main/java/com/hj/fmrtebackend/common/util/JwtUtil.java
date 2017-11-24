package com.hj.fmrtebackend.common.util;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;



public class JwtUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);
	
	/**
	 * 헤더에서 토큰 가져오기
	 * @param request
	 * @return
	 */
	public static String getToken(HttpServletRequest request) {
		String token = "";

		String header = request.getHeader("Authorization");
		token = header.split(" ")[1];
	
		return token;
	}
	
	/**
	 * 토큰에서 값 가져오기
	 * @param token
	 * @param claimName
	 * @return
	 */
	public static String decodeToken(String token, String claimName) {
		
		DecodedJWT jwt = JWT.decode(token);
		String value = jwt.getClaim(claimName).asString();
		//logger.debug("### value = {}",value);
		return value;	
	}
	
	/**
	 * 토큰에서 username 가져오기
	 * @param request
	 * @return
	 */
	public static String getUsername(HttpServletRequest request) {
		return decodeToken(getToken(request),"sub");
	}
}
