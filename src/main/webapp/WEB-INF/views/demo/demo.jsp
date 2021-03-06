<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<fmt:requestEncoding value="utf-8"/>

<%-- <%@ include file="/WEB-INF/views/common/header.jsp" %> --%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="Demo" name="pageTitle"/>
</jsp:include>

	<style>
	div#demo-container{
		width:550px;
		padding:15px;
		margin:0 auto;
		border:1px solid lightgray;
		border-radius: 10px;
	}
	</style>

		<div id="demo-container">
		<!-- https://getbootstrap.com/docs/4.1/components/forms/#readonly-plain-text -->
		<form id="devFrm">
			<div class="form-group row">
				<label for="devName" class="col-sm-2 col-form-label">이름</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="devName" name="devName" required>
				</div>
			</div>
			<div class="form-group row">
			  <label for="devCareer" class="col-sm-2 col-form-label">개발경력</label>
			  <div class="col-sm-10">
				<input type="number" class="form-control" id="devCareer" name="devCareer" value="0" required>
			  </div>
			</div>
			<div class="form-group row">
				<label for="devEmail" class="col-sm-2 col-form-label">이메일</label>
				<div class="col-sm-10">
					<input type="email" class="form-control" id="devEmail" name="devEmail" required>
				</div>
			</div>
			<!-- https://getbootstrap.com/docs/4.1/components/forms/#inline -->
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">성별</label>
				<div class="col-sm-10">
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" name="devGender" id="devGender0" value="M">
						<label class="form-check-label" for="devGender0">남</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" name="devGender" id="devGender1" value="F">
						<label class="form-check-label" for="devGender1">여</label>
					</div>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">개발언어</label>
				<div class="col-sm-10">
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="checkbox" name="devLang" id="devLang0" value="Java">
						<label class="form-check-label" for="devLang0">Java</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="checkbox" name="devLang" id="devLang1" value="C">
						<label class="form-check-label" for="devLang1">C</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="checkbox" name="devLang" id="devLang2" value="Javascript">
						<label class="form-check-label" for="devLang2">Javascript</label>
					</div>
				</div>
			</div>
		</form>
	
		<!--https://getbootstrap.com/docs/4.0/components/list-group/#links-and-buttons-->
		<div class="list-group">
			<button type="button" onclick="demo1();" class="list-group-item list-group-item-action">파라미터 핸들링 - HttpServletRequest</button>
			<button type="button" onclick="demo2();" class="list-group-item list-group-item-action">파라미터 핸들링 - @RequestParam</button>
			<button type="button" onclick="demo3();" class="list-group-item list-group-item-action">파라미터 핸들링 - Command객체</button>
			<button type="button" onclick="demo4();" class="list-group-item list-group-item-action">파라미터 핸들링 - ViewModel</button>
			<button type="button" onclick="demo5();" class="list-group-item list-group-item-action">파라미터 핸들링 - insertDev</button>
		</div>
	</div>
	
	<script>
		function demo1(){
			$("#devFrm").attr("action","${pageContext.request.contextPath}/demo/demo1.do").submit();
			
		}
		function demo2(){
			$("#devFrm").attr("action","${pageContext.request.contextPath}/demo/demo2.do").submit();
			
		}
		function demo3(){
			$("#devFrm").attr("action","${pageContext.request.contextPath}/demo/demo3.do").submit();
			
		}
		function demo4(){
			$("#devFrm").attr("action","${pageContext.request.contextPath}/demo/demo4.do").submit();
			
		}
		function demo5(){
			$("#devFrm").attr("action","${pageContext.request.contextPath}/demo/demo5.do")
			.attr("method","POST").submit();
			
		}
	</script>
	
<jsp:include page="/WEB-INF/views/common/footer.jsp" />
