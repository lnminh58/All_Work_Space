<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    
 <body>

        <div class="container view-pro5">
            <section class="container">
                <div class="col-sm-3 view-avatar">
                    <div class="container avatar-defaul">
                    	<div class="container-avatar-pencil">
                    		<div class="topright-avatar">
                                <a type="button"  data-toggle="modal" data-target=".bs-example-modal-sm">
                                    <i class="fa fa-pencil-square avatar" style="font-size:34px"></i>
                                </a>
                                <div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
                                  <div class="modal-dialog modal-sm " role="document">
                                    <div class="modal-content">

                                      <form class="container upload-avatar">
                                              <input type="file" name="avatar" multiple>
                                            </form>
                                      <div class="panel-body">
                                        Upload image
                                      </div>
                                      <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                <button type="button" class="btn btn-primary">Save</button>
                                      </div>
                                    </div>
                                  </div>
                                </div>
                            </div>
                    	
                            <img src="${user.profile.getImage() }" class="business-item--cover__large-profile"/> 
                            
                         </div>   
                    </div>
                    
                     
                    
                    <form class="container description-profile">
                        <div class="form-group">
                          <label class="container"for="comment">Discription</label>
                          <textarea class="form-control" rows="5" id="comment" placeholder="Write some thing for yourself"></textarea>
                        </div>
                      </form>
                </div>
                
                <div class="col-sm-9">
                	<row>
	                    <h3 class="container name-group">
	                     ${user.profile.getFirstName() } ${user.profile.getLastName() }
	                            <i class="fa fa-star" style="font-size:24px;color:#ffcc00;"></i>
	                            <i class="fa fa-star" style="font-size:24px;color:#ffcc00;"></i>
	                            <i class="fa fa-star" style="font-size:24px;color:#ffcc00;"></i>
	                            <i class="fa fa-star-half-full" style="font-size:24px;color:#ffcc00;"></i>
	                
	                    </h3>
                    </row>
                    <form>
                        <row class="view-name">
                            <div class="col-sm-6">
                                            <label for="type">First Name</label>
                                            <input type="text" class="form-control" id="firstname" placeholder="${user.profile.getFirstName() }">
                            </div>
                            <div class="col-sm-5">
                                           <label for="type">Last Name</label>
                                            <input type="text" class="form-control" id="lastname" placeholder="${user.profile.getLastName() }">
                             </div>
                         </row> 
                        
             
                        <row>
                        <div class="col-sm-11 view-business--tag">
                            <label for="type">Business</label>     
                            <div class="input-group tag-group">
                                <div data-location-name="74000" class="tag-content list-categories left linked-categories">
                                <c:forEach items="${user.listBusinesses}" var="business">
                                    <span class="category-tag linked-category">${business.name}&nbsp;</span>
                                    <a href="#">
                                          <span class="glyphicon glyphicon-remove"></span>
                                        </a>
                                </c:forEach>
                                </div>
                                <span class="input-group-btn btn-add-profile">
                                            		<button class="btn btn-success" type="button">Add</button>
                                          		</span>
                            </div><!-- /input-group -->
                        </div>
                        </row>
                        <row>
                        <div class="col-sm-11 view-business--tag">
                            <label for="type">Address</label>     
                            <div class="input-group tag-group">
                                <div data-location-name="74000" class="tag-content list-categories left linked-categories">
                                    <c:forEach items="${user.listLocations}" var="location">
                                    <span class="category-tag linked-category">${location.number}-${location.street}-${location.city}-${location.country};</span>
                                    <a href="#">
                                          <span class="glyphicon glyphicon-remove"></span>
                                        </a>
                                    </c:forEach>    
                                </div>
                                <span class="input-group-btn btn-add-profile">
                                            		<button class="btn btn-success" type="button">Add</button>
                                          		</span>
                            </div><!-- /input-group -->
                        </div>
                        </row>
                        
                        
                        <row>
                        <div class="col-sm-6">
                                        <label for="email">Email</label>
                                        <div class="input-group">
                                          <input id="user-email" type="text" data-rule-required="true" maxlength="250" value="${user.profile.getEmail() }" readonly="" class="form-control" aria-required="true" aria-invalid="false">
                                          <span class="input-group-btn">
                                            <button class="btn btn-success" type="button">Change</button>
                                          </span>
                                </div><!-- /input-group -->
                                   </div>
                                   <div class="col-sm-5">
                                       <label for="phone">Phone</label>
                                       <div class="input-group">
                                          <input id="user-phone-number" type="text" maxlength="250" readonly="" class="phoneInput form-control" autocomplete="off" placeholder="${user.profile.getPhone() }">
                                          <span class="input-group-btn">
                                            <button class="btn btn-success" type="button">Change</button>
                                          </span>
                                        </div><!-- /input-group -->
                                   </div>
                        </row>  
                        <row>
                            <div class="col-sm-4 action-save">
                                <button type="submit" class="btn btn-submit-save-profile">Save Profile</button>
                            </div>           
                        </row>    
                    </form>    
                </div>
                 
               <div class="fb-comments" data-href="https://www.facebook.com/huy.le.v" data-numposts="5" data-width="900px"></div>
                
            </section>
        </div>     
        
         
    </body>