<!-- Body of the Home page -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<section id="content">
	<article id="search-area">
		<div class="bacground-search">
			<div class="slide effect">
				<img alt="partnerShip"
					src="/partnership-web/resource/images/home-page/JOBS.jpg" />
			</div>
			<div class="slide effect">
				<img alt="partnerShip"
					src="/partnership-web/resource/images/home-page/job2.jpg" />
			</div>
			<div class="slide effect">
				<img alt="partnerShip"
					src="/partnership-web/resource/images/home-page/job-banner.jpg" />
			</div>
		</div>
		<!--                end class bacground-search-->
		<div class="search">
			<div class="logo-search">

				<img class="logo-search-position" alt="parnerShip"
					src="/partnership-web/resource/images/logo/logo-search-position.png">

			</div>
			<form class="form-search row" action="search" method="get">
				<div class="search-business col-md-5 col-xs-5">
					<div class="box-sizing">
						<i class="fa fa-user fa-3x" aria-hidden="true"></i> <input
							type="text" name="name" placeholder="Search business" />
					</div>
				</div>
				<div class="search-location col-md-5 col-xs-5">
					<div class="box-sizing">
						<i class="fa fa-street-view fa-3x" aria-hidden="true"></i> <input
							type="text" name="city" placeholder="Search location" />
					</div>
				</div>
				<button class="btn btn-success col-md-2 col-xs-2" type="submit"
					value="Search businesses">Search businesses</button>
			</form>
		</div>

	</article>
	<article id="suggest-area">
		<div class="suggest-bar">

			<div class="suggest active" onclick="toPage(0 )">The
				Commandables of This Week</div>
			<div class="suggest" onclick="toPage(1 )">The Commandables of
				This Month</div>
			<div class="suggest" onclick="toPage(2 )">The Commandables on
				Top</div>

		</div>
		<div class="suggest-users row" >
			<c:forEach var="users" items="${usersSuggest}">
				<div class="mini-profile col-md-6 col-xs-6 col-md-6">
					<div class="profile-content row">
						<div class="left-profile col-md-4">
							<img class="img-pro" alt="ten"
								src="/partnership-web/resource/images/home-page/user.png"
								style="width: 100%; height: 100%; background-color: #aaa;">
							<div class="vote-area">
								<a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a>
								<a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a>
								<a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a>
								<a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a>
								<a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a>


							</div>

							<button type="button" class="contact btn btn-success"
								value="contact">CONTACT</button>
						</div>
						<div class="right-profile col-md-8">
							<div class="name-partner">
								<h4 style="font-weight: bold;">Name:</h4>
								<h4>${users.username}</h4>
							</div>
							<div class="experience">
								<h4 style="font-weight: bold;">Experience :</h4>
								<c:forEach var="experence" items="${users.listBusinesses}">		
										<h4>${experence.experience}</h4>
								</c:forEach>
							</div>
							<div class="projects-finished">
								<h4 style="font-weight: bold;">Projects finished:</h4>
								
								<c:forEach var="projectfinished" items="${users.projects}">
<%-- 									<c:choose> --%>
<%-- 										<c:when test="${param.enter=='1'}">        --%>
<%-- 										</c:when> --%>
<%-- 										<c:otherwise>        --%>
<%-- 										</c:otherwise> --%>
<%-- 									</c:choose> --%>
									<c:if test="${projectfinished.status != 0}">
										<h4>${projectfinished.name}</h4>
									</c:if>
								</c:forEach>
								
							</div>
						</div>
					</div>
					<!-- 				end profile-content -->
				</div>
				<!-- 		end user profile  -->
			</c:forEach>


		</div>
<!-- 		end suggest-users -->
	</article>
</section>

