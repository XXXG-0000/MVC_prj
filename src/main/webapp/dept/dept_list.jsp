<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="DeptAction에서 제공하는 데이터를 보여주는 페이지"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${ defaultURL }common/css/main_20240911.css">

<!-- bootstrap CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

<!-- jQuery CDN 시작 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>


<style type="text/css">
/* CSS영역 => CSS 디자인 코드 작성 */

</style>
<script type="text/javascript">
/* JS 영역 => JS 코드 작성 */
$(function(){
	
}); // ready

</script>
</head>
<body>
<div id="wrap">
<!-- HTML 영역 => HTML 태그 작성, CSS 정의한 디자인 적용, JS에서 동적인 디자인 생성 보여주는 일, JS에서 HTML Form Control에 입력된 값을 
	유효성 검증 수행 => onxxx속성 사용 -->
	<table class="table table-hover">
	<thead>
	<tr>
		<th style="width: 10%">번호</th>
		<th style="width: 20%">부서번호</th>
		<th style="width: 30%">부서명</th>
		<th style="width: 30%">위치</th>
		<th style="width: 10%">상태</th>
	</tr>
	</thead>
	<tbody>
	<c:if test="${ empty requestScope.deptList }">
	<tr>
		<td colspan="5" style="text-align: center">조회된 부서 정보가 존재하지 않습니다.</td>
	</tr>
	</c:if>
	<c:forEach var="dept" items="${ requestScope.deptList }" varStatus="i">
		<tr>
		<td><c:out value="${ i.count }" /></td>
		<td><c:out value="${ dept.deptno }" /></td>
		<td><c:out value="${ dept.dname }" /></td>
		<td><c:out value="${ dept.loc }" /></td>
		<td><c:out value="${ dept.status }" /></td>
		</tr>
	</c:forEach>	
	<tr></tr>
	</tbody>
	</table>
</div>
</body>
</html>