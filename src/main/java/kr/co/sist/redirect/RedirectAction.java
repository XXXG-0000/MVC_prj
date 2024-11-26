package kr.co.sist.redirect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.action.Action;

public class RedirectAction implements Action {
	
	private String moveURL;
	private boolean forwardFlag;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//forward: URI 사용 - JSP만 가능
		//redirect: URL 사용 - HTML, JSP 모두 사용 가능
		 moveURL = "http://192.168.10.212./MVC_prj/index.jsp";
		 forwardFlag = false;
	}

	@Override
	public String moveURL() {
		return moveURL;
	}

	@Override
	public boolean isForward() {
		return forwardFlag;
	}

}
