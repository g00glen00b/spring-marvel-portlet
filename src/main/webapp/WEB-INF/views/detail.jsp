<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<div ng-controller="CharacterCtrl" class="marvel-app">
	<div class="ui items">
		<div class="item" ng-if="character == null">
			<div class="image">
				<img src="/wps/PA_Marvel/assets/img/nodetails.png" />
			</div>
			<div class="content">
				<div class="description">You need to pick a character first.</div>
			</div>
		</div>
  		<div class="item" ng-if="character != null">
			<div class="image">
				<img ng-src="{{character.thumbnail | Thumbnail }}" />
			</div>
			<div class="content">
				<div class="meta">Updated {{character.modified | Timeago}}</div>
				<div class="name">{{character.name}}</div>
				<p class="description">{{character.description}}</p>
				<div class="extra">
					{{character.comics.available}} comics / {{character.stories.available}} stories / {{character.events.available }} events
				</div>
			</div>
		</div>
	</div>
</div>
	
<jsp:include page="fragments/scripts.jsp" />