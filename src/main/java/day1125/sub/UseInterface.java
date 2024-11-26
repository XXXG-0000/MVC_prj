package day1125.sub;

import java.util.HashMap;
import java.util.Map;


public class UseInterface {

	public static void main(String[] args) {
		//1. Map 생성
		Map<String, Person> map = new HashMap<String, Person>();
		//2. Map의 값 설정
		map.put("kim", new JiHoon());
		map.put("lee", new InHyeok());
		map.put("byeon", new JoonSu());
		
		//3. 키를 사용하는 객체 생성: 객체 다형성
		String key = "byeon";
		
		if(map.containsKey(key)) {
			Person person = map.get(key);
			//4. 찾아낸 객체를 사용
			System.out.println(person.execute());
		}//end if
		
	}//main

}//class
