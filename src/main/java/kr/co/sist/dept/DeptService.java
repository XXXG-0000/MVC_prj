package kr.co.sist.dept;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

public class DeptService {
	private static DeptService ds;
	
	private DeptService() {
		
	}
	
	public static DeptService getInstance() {
		if(ds == null) {
			ds = new DeptService();
		}//end if
		
		return ds;
	}//DeptService
	
	public List<DeptDomain> searchAllDept() {
		List<DeptDomain> list = null;
		DeptDAO dDAO = DeptDAO.getInstance();
		
		try {
			list = dDAO.selectAllDept();			
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		
		return list;
	}//searchAllDept
}
