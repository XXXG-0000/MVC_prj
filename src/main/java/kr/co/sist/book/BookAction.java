package kr.co.sist.book;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.sist.action.Action;

public class BookAction implements Action {

	private String moveURL;
	private boolean forwardFlag;
	
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService bs = new  BookService();
		List<String> list = bs.bookList();
		//업무처리한 결과(list)를 JSP로 보내기 위해서 scope 객체 사용
		//request, session, application
		request.setAttribute("bookList", list);
		moveURL = "book/book_list.jsp";
		forwardFlag = true;
		/*
		HttpSession session = request.getSession();
		session.setAttribute("bookList", list);
		
		ServletContext application = request.getServletContext();
		application.setAttribute("bookList", list);
		*/
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
