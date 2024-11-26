package day1125;

import java.util.HashMap;
import java.util.Map;

public class UseMap {

	public static void main(String[] args) {
		//1. Map 생성(찾아서 사용)
		Map<String, Object> map = new HashMap<String, Object>();
		//2. 값 할당
		map.put("kim", new JiHoon());
		map.put("lee", new InHyeok());
		map.put("byeon", new JoonSu());
		
		String key = "lee";
		//3. key에 해당하는 값 찾기
		//4. 사용
		if("kim".equals(key)) {
			JiHoon ji = (JiHoon)map.get(key);			
			System.out.println(ji.execute());
		}//end if
		
		if("lee".equals(key)) {
			InHyeok ih = (InHyeok)map.get(key);			
			System.out.println(ih.execute());
		}//end if
		
		if("byeon".equals(key)) {
			JoonSu js = (JoonSu)map.get(key);			
			System.out.println(js.execute());
		}//end if
		
	}//main

}//class
