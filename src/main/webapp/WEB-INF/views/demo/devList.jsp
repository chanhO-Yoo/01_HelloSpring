<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="Dev 목록" name="pageTitle"/>
</jsp:include>
<table class="table">
    <tr>
      <th scope="col">번호</th>
      <th scope="col">이름</th>
      <th scope="col">경력</th>
      <th scope="col">이메일</th>
      <th scope="col">성별</th>
      <th scope="col">개발가능언어</th>
    </tr>
    
    <c:forEach items="${list }" var="dev">
    	<tr>
			<td>${dev.devNo }</td>
			<td>${dev.devName }</td>
			<td>${dev.devCareer }년</td>
			<td>${dev.devEmail }</td>
			<td>${dev.devGender=='M'?'남':dev.devGender=='F'?'여':'미입력' }</td>
			<td>
				<c:forEach items="${dev.devLang }" var="lang" varStatus="vs">
					${lang }${vs.last?"":", " }
				</c:forEach>
			</td>
    	
    	</tr>
    </c:forEach>
   
</table>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
