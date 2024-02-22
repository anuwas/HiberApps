<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="row">
<form class="comments-form contact-form" name="empForm" method="post" action="editUser">
<input type="hidden" name="user_id" value="${userMaster.getUser_id()}">
                <div class="col-lg-12">
                    <h1 class="page-header">Edit User</h1>
                </div>
                
                <div class="col-lg-12">
                
                  <div class="col-lg-6">
                
                    <div class="form-group"> 
                     <label for="exampleSelect1">First Name</label>                       
                      <input type="text" class="form-control" placeholder="Your Name" name="first_name" value="${userMaster.getFirst_name()}">
                    </div>
                    <div class="form-group">  
                    <label for="exampleSelect1">Last Name</label>                        
                      <input type="text" class="form-control" placeholder="Last Name" name="last_name" value="${userMaster.getLast_name()}">
                    </div>
                     <div class="form-group"> 
                     <label for="exampleSelect1">Username</label>                         
                      <input type="text" class="form-control" placeholder="Username" name="username" value="${userMaster.getUsername()}">
                    </div>
                     <div class="form-group"> 
                     <label for="exampleSelect1">Password</label>                         
                      <input type="password" class="form-control" placeholder="Subject" name="password" value="${userMaster.getPassword()}">
                    </div>
                    
                    <div class="form-group"> 
                     <label for="exampleSelect1">Phone Number</label>                         
                      <input type="text" class="form-control" placeholder="Phone Number" name="phone_number" value="${userMaster.getPhone_number()}">
                    </div>
                    
                    <div class="form-group">
                    <label for="exampleSelect1">Country</label>
                    <select class="form-control" id="exampleSelect1" name="countryMaster.country_id">
                      <c:forEach var="country" items="${countryMasterList}" varStatus="status">
                      <option  value="${country.country_id}" <c:if test="${country.country_id == userMaster.countryMaster.country_id}"> selected="selected" </c:if> >${country.country_name}</option>
                      </c:forEach>
                    </select>
                  </div>
                  
                   <div class="form-group">
                    <label for="exampleSelect1">City  </label>
                    <select class="form-control" id="exampleSelect1" name="cityMaster.city_id">
                       <c:forEach var="city" items="${cityMasterList}" varStatus="status">
                    	<option value="${city.city_id}" <c:if test="${city.city_id == userMaster.cityMaster.city_id}"> selected="selected" </c:if>>${city.city_name}</option>
                    	</c:forEach>
                    </select>
                  </div>
                    
                  <div class="form-group">    
                  <label >Address  </label>                    
                      <textarea placeholder="Address" rows="3" class="form-control" name="address">${userMaster.getAddress()}</textarea>
                    </div>  
                     <div class="form-group">    
                  <input type="submit" value="Update" class="comment-btn btn btn-primary ">
                    </div>  
                  
                </div>
                
                
                 </div>
                </form>
             </div>