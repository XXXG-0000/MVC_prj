package kr.co.sist.dept;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.sist.dao.MyBatisHandler;

public class DeptDAO {
	private static DeptDAO dDAO;
	
	private DeptDAO() {
		
	}
	
	public static DeptDAO getInstance() {
		if(dDAO == null) {
			dDAO = new DeptDAO();
		}//end if
		return dDAO;
	}//getInstance
	
	public List<DeptDomain> selectAllDept() throws PersistenceException {
		List<DeptDomain> list = null;
		
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession handler = mbh.getHandler();
		
		try {
			//parameterType이 없으므로 매개변수가 하나인 selectList method를 사용
			list = handler.selectList("kr.co.sist.dept.selectAllDept");
		} finally {
			mbh.closeHandler(handler);
		}//end finally
		
		
		return list;
	}//selectAllDept
	
}//class
