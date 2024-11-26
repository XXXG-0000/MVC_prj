package kr.co.sist.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.action.Action;
import kr.co.sist.book.BookAction;
import kr.co.sist.dept.DeptAction;
import kr.co.sist.main.MainAction;
import kr.co.sist.redirect.RedirectAction;

/**
 * 진입점: 
 * 1. 요청에 대한 실행될 XxxAction(웹 파라메터 받기, 응답할 페이지명 반환, 페이지 이동 방식, 
 * 								업무 로직 구현 실행하는 클래스를 사용)을 찾아 실행하는 일
 * 2. 액션이 반환하는 값들을 받아서
 * 3. JSP로 이동
 */
@SuppressWarnings("serial")
public class MainController extends HttpServlet {
	
	private static Map<String, Action> map = new HashMap<String, Action>();
	private String defaultURL;
	
	
	/**
	 * 생성자를 만들고 코드를 넣으면 해당 코드는 한 번만 실행된다.
	 */
	//public void init() {// 최초 접속자가 맵에 객체를 생성하여 할당?
	//{	//  instance 영역: 객체가 생성될 때 자동으로 한번만 실행되는 영역
	static {// static 영역: 클래스가 실행되면 자동으로 한 번만 실행되는 영역
		map.put("M001", new MainAction());
		map.put("B001", new BookAction());
		map.put("R001", new RedirectAction());
		map.put("S001", new DeptAction());
	}
	
	public void init() {
		ServletConfig sc = getServletConfig();//static이 아니므로 static외에 기입

		defaultURL = sc.getInitParameter("protocol") + sc.getInitParameter("serverName") + sc.getInitParameter("contextRoot");

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cmd = request.getParameter("cmd");
		
		if(cmd == null || !map.containsKey(cmd)) {
			cmd = "M001";
		}//end if

		Action action = map.get(cmd);
		action.execute(request, response);
		String moveURL = action.moveURL();
		boolean isFlag = action.isForward();
		
		ServletContext application = getServletContext();
		application.setAttribute("defaultURL", defaultURL);
		
		movePage(request, response, moveURL, isFlag);
		
	}//doPost
	
	/**
	 * 페이지 이동
	 * @param request
	 * @param response
	 * @param moveURL
	 * @param isForward
	 * @throws ServletException
	 * @throws IOException
	 */
	public void movePage(HttpServletRequest request, HttpServletResponse response, 
			String moveURL, boolean isForward) throws ServletException, IOException {
		if(isForward) {
			RequestDispatcher rd = request.getRequestDispatcher(moveURL);
			rd.forward(request, response);
		} else {
			response.sendRedirect(moveURL);
		}//end else
	}//movePage

}//class
