package kr.co.sist.book;

import java.util.ArrayList;
import java.util.List;

/**
 * 업무로직을 처리하는 클래스
 */
public class BookService {
	public List<String> bookList(){
		List<String> list = new ArrayList<String>();
		
		list.add("이것이 자바다");
		list.add("HTML5 웹프로그래밍입문");
		list.add("JSP&amp;Servlet 웹 프로그래밍 입문 + 활용");
		list.add("데이터베이스 개론과 실습");
		
		return list;
	}
}
