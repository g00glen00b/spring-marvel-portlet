<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<c:set var="comic" value="comics" />
<div ng-controller="DetailListCtrl" class="marvel-app">
	<div class="ui items">
		<div class="small item" ng-init="type = '${type}'">
			<div class="content">
				<div class="name">
					<c:choose>
						<c:when test="${type == comic}">Comics</c:when>
						<c:otherwise>Series</c:otherwise>
					</c:choose>
				</div>
				<div class="description" ng-if="model.character != null && model.character.${type}.available != 0">
					<div ng-repeat="item in model.character.${type}.items | StartFrom: model.listItem | limitTo: 1">
						{{item.name}}
					</div>
				</div>
				<div class="description" ng-if="model.character != null && model.character.${type}.available == 0">
					There are no ${type}.
				</div>
				<div class="description" ng-if="model.character == null">
					You need to pick a character first.
				</div>
				<div class="ui icon paging buttons" ng-if="model.character != null && model.character.${type}.available != 0">
					<div class="ui button" ng-if="model.listItem != 0" ng-click="model.listItem=model.listItem-1">
			  			<i class="left arrow icon"></i>
					</div>
					<div class="ui button" ng-if="model.listItem != model.character.${type}.items.length - 1"
						ng-click="model.listItem=model.listItem+1">
			  			<i class="right arrow icon"></i>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="fragments/scripts.jsp" />