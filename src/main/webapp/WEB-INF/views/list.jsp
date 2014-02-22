<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<div ng-controller="CharactersCtrl" class="marvel-app">
	<c:choose>
		<c:when test="${isConfigured}">
			<div class="ui icon message" ng-if="model.data.data == null && !failed">
				<i class="loading icon"></i>
		  		<div class="content">
					<div class="header">Loading...</div>
		    		<p>The list is being loaded, please wait a bit longer.</p>
		  		</div>
			</div>
			<div class="ui error icon message" ng-if="failed">
				<i class="warning icon"></i>
				<div class="content">
					<div class="header">Something went wrong</div>
					<p>Something went wrong while loading the list. Are you sure you provided the right <strong>API keys</strong>?</p>
				</div>
			</div>
			<div ng-if="model.data.data != null">
				<div class="ui divided list">
			  		<div class="item" ng-repeat="character in model.data.data.results">
			    		<img class="ui avatar image" ng-src="{{character.thumbnail | Thumbnail }}">
			    		<div class="content">
			      			<div class="header">
			      				<a href="#" ng-click="setActive(character)">{{character.name}}</a>
			      			</div>
						</div>
					</div>
				</div>
				<div class="ui icon paging buttons">
					<div class="ui button" ng-if="isNotFirstPage()" ng-click="setPage(model.page - 1)">
			  			<i class="left arrow icon"></i>
					</div>
					<div class="ui button" ng-if="isNotLastPage()" ng-click="setPage(model.page + 1)">
			  			<i class="right arrow icon"></i>
					</div>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<div class="ui warning message">
				<div class="header">Configure portlet</div>
  				This portlet requires some extra configuration. Open the page in <strong>Edit mode</strong> and choose <strong>Configure</strong> from the portlet menu options.
			</div>
		</c:otherwise>
	</c:choose>
</div>

<script type="text/javascript">
	var MARVEL_SERVICE_URL = MARVEL_SERVICE_URL || { };
	MARVEL_SERVICE_URL.CHARACTERS = MARVEL_SERVICE_URL.CHARACTERS || '<portlet:resourceURL id="characters" />';
</script>
<jsp:include page="fragments/scripts.jsp" />