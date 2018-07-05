<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>
<tiles:getAsString name="title"></tiles:getAsString>
 </title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath }/templates/cnews/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/templates/cnews/js/cufon-yui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/templates/cnews/js/arial.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/templates/cnews/js/cuf_run.js"></script>
</head>
<tiles:insertAttribute name="header"></tiles:insertAttribute>
<div class="body">
	<div class="body_resize">
		<div class="left">
			<tiles:insertAttribute name="content"></tiles:insertAttribute>
		</div>
		<div class="right">
			<tiles:insertAttribute name="right-bar"></tiles:insertAttribute>
		</div>
		<div class="clr"></div>
	</div>
</div>
<div class="footer">
	<tiles:insertAttribute name="footer"></tiles:insertAttribute>