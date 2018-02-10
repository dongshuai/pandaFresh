package com.pf.app.api.util;

import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 
* @ClassName: JwtUtil 
* @Description: token生成及解析类
* @author jcwang
* @date 2017年8月10日 上午9:17:43 
*
 */
public class JwtUtil {
	
	/**
	 * 由字符串生成加密key
	 * @return
	 */
	private static SecretKey generalKey(){
		String stringKey = Constant.JWT_SECRET;
		byte[] encodedKey = Base64.decodeBase64(stringKey);
	    SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
	    return key;
	}

	/**
	 * 创建token
	 * @param id    个人信息主键
	 * @param name  登录名
	 * @param times 登录时间
	 * @return token
	 * @throws Exception
	 */
	public static String createJWT(Long id, String name, long times)  {
		Map<String,Object> user = new HashMap<String,Object>();
		user.put(Constant.ID_COLUMN, id);
		user.put(Constant.NAME_COLUMN, name);
		user.put(Constant.NEW_TIMES, String.valueOf(times));
        String subject = JSONObject.toJSONString(user);
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		SecretKey key = generalKey();
		Date now = new Date(times);
		JwtBuilder builder = Jwts.builder()
			.setId(Constant.JWT_ID)
			.setIssuedAt(now) //创建时间
			.setSubject(subject) //主题，个人的一些信息
//			.setIssuer(issuer) //发送谁
//			.setAudience(audience) //个人签名
		    .signWith(signatureAlgorithm, key);
		//添加Token过期时间
//		if (ttlMillis >= 0) {
//		    long expMillis = nowMillis + ttlMillis;
//		    Date exp = new Date(expMillis);
//		    builder.setExpiration(exp)
//		    .setNotBefore(now);
//		}
		return builder.compact();
	}
	
	/**
	 * 解密token
	 * @param jwt token
	 * @throws Exception
	 */
	public static Claims parseJWT(String jwt) throws Exception{
		SecretKey key = generalKey();
		Claims claims = Jwts.parser()         
		   .setSigningKey(key)
		   .parseClaimsJws(jwt).getBody();
		return claims;
	}
	
}
