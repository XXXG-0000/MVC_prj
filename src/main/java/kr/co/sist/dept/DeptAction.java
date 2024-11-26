package kr.co.sist.dept;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.action.Action;

/**
 * Action에 implement 되어야 웹에 올라갈 수 있다.
 */
public class DeptAction implements Action {

	private String moveURL;
	private boolean forwardFlag;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeptService ds = DeptService.getInstance();
		
		List<DeptDomain> list = ds.searchAllDept();
		//업무처리한 결과를 사용자에게 보여주기 위해 적절한 scope 객체에 할당한다.
		request.setAttribute("deptList", list);
		
		//View 페이지 설정
		moveURL = "dept/dept_list.jsp";
		//이동방식 설정
		forwardFlag = true;
		
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
