package egovframework.let.shop.user.util;

import java.util.UUID;

public class CommonUtils {
	public static String getRandomString(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}//해킹방지용 이름 저장 방식
