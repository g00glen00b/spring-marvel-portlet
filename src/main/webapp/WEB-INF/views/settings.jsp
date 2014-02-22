<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<portlet:actionURL var="go">
	<portlet:param name="action" value="saveSettings"/>
</portlet:actionURL>
<form:form commandName="api" method="POST" action="${go}" cssClass="ui form segment ${not empty errors ? 'error' : ''}">
	<c:if test="${success}">
		<div class="ui success icon message">
			<i class="settings icon"></i>
			<div class="content">
				<div class="header">Portlet configured</div>
				<p>The portlet is now configured. Choose <strong>Back</strong> from the portlet menu options and go back to <strong>view mode</strong>.</p>
			</div>
		</div>
	</c:if>
	<c:if test="${not empty errors}">
		<div class="ui error icon message">
			<i class="warning icon"></i>
			<div class="content">
				<div class="header">Something went wrong</div>
				<p>${errors}</p>
			</div>
		</div>
	</c:if>
	<spring:bind path="publicKey">
		<div class="field ${status.error ? 'error' : ''}">
	    	<label>Public key</label>
	    	<form:input path="publicKey" />
	    	<form:errors path="publicKey" cssClass="ui red pointing above ui label" />
	  	</div>
  	</spring:bind>
  	<spring:bind path="privateKey">
	  	<div class="field ${status.error ? 'error' : ''}">
	    	<label>Private key</label>
	    	<form:input path="privateKey" />
	    	<form:errors path="privateKey" cssClass="ui red pointing above ui label" />
	  	</div>
  	</spring:bind>
  	<button class="ui blue submit button" type="submit" name="submitKeys" value="Save">Submit</button>
</form:form>

<jsp:include page="fragments/scripts.jsp" />