<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<fmt:requestEncoding value="utf-8"/>

<%-- <%@ include file="/WEB-INF/views/common/header.jsp" %> --%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="" name="pageTitle"/>
</jsp:include>

		<style>
		div#enroll-container{width:400px; margin:0 auto; text-align:center;}
		div#enroll-container input, div#enroll-container select {margin-bottom:10px;}
		</style>

		<div id="enroll-container">
			<form name="memberEnrollFrm" action="${pageContext.request.contextPath}/member/memberEnrollEnd.do" method="post" onsubmit="return enrollValidate();" >
				<input type="text" class="form-control" placeholder="아이디 (4글자이상)" name="memberId" id="memberId_" required>
				<input type="password" class="form-control" placeholder="비밀번호" name="password" id="password_" required>
				<input type="password" class="form-control" placeholder="비밀번호확인" id="password2" required>
				<input type="text" class="form-control" placeholder="이름" name="memberName" id="memberName" required>
				<input type="number" class="form-control" placeholder="나이" name="age" id="age">
				<input type="email" class="form-control" placeholder="이메일" name="email" id="email" required>
				<input type="tel" class="form-control" placeholder="전화번호 (예:01012345678)" name="phone" id="phone" maxlength="11" required>
				<input type="text" class="form-control" placeholder="주소" name="address" id="address">
				<select class="form-control" name="gender" required>
					<option value="" disabled selected>성별</option>
					<option value="M">남</option>
					<option value="F">여</option>
				</select>
				<div class="form-check-inline form-check">
					취미 : &nbsp; 
					<input type="checkbox" class="form-check-input" name="hobby" id="hobby0" value="운동"><label for="hobby0" class="form-check-label">운동</label>&nbsp;
					<input type="checkbox" class="form-check-input" name="hobby" id="hobby1" value="등산"><label for="hobby1" class="form-check-label">등산</label>&nbsp;
					<input type="checkbox" class="form-check-input" name="hobby" id="hobby2" value="독서"><label for="hobby2" class="form-check-label">독서</label>&nbsp;
					<input type="checkbox" class="form-check-input" name="hobby" id="hobby3" value="게임"><label for="hobby3" class="form-check-label">게임</label>&nbsp;
					<input type="checkbox" class="form-check-input" name="hobby" id="hobby4" value="여행"><label for="hobby4" class="form-check-label">여행</label>&nbsp;
				</div>
				<br />
				<input type="submit" class="btn btn-outline-success" value="가입" >&nbsp;
				<input type="reset" class="btn btn-outline-success" value="취소">
			</form>
		</div>
		
		<script>
			function enrollValidate(){
				var idRegExp = /^[a-zA-Z0-9]{4,12}$/;
				var emailRegExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
				var phoneRegExp = /^\d{3}-\d{3,4}-\d{4}$/;
				
				var memberId = document.getElementById("memberId_");
				
				console.log(idRegExp.test(memberId.value));
				
				//memberId길이 4글자 이상 여부 확인
				if(!idRegExp.test(memberId.value)){
					alert("아이디가 올바르지 않습니다..");
					return false;
				}
				/* //password 공백 여부 확인
				if("#password_".value.trim().length==0 || "#password_".value.trim()==""){
					return false;
				}
				else{
					//password와 password확인 일치 여부 확인
					if("#password" !== "#password2"){
						alert("비밀번호가 일치하지 않습니다.");
						return false;
					}
				}
				//이메일 유효성 검사
				if(!emailRegExp.test("#email".trim().value)){
					alert("이메일이 올바르지 않습니다.");
					return false;
				} */
				
				return true;
			}

		</script>

<jsp:include page="/WEB-INF/views/common/footer.jsp" />
