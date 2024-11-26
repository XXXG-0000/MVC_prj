package kr.co.sist.dept;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DeptDomain {
	private int deptno;
	private String dname, loc, status;
}
