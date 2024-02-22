<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row">
<form name="empForm" method="post" action="addUser" class="comments-form contact-form">
                <div class="col-lg-12">
                    <h1 class="page-header">Add New User</h1>
                </div>
                
                <div class="col-lg-12">
                
                  <div class="col-lg-6">
                
                    <div class="form-group"> 
                     <label for="exampleSelect1">First Name</label>                       
                      <input type="text" class="form-control" placeholder="Your Name" name="first_name">
                    </div>
                    <div class="form-group">  
                    <label for="exampleSelect1">Last Name</label>                        
                      <input type="text" class="form-control" placeholder="Last Name" name="last_name">
                    </div>
                     <div class="form-group"> 
                     <label for="exampleSelect1">Username</label>                         
                      <input type="text" class="form-control" placeholder="Username" name="username">
                    </div>
                     <div class="form-group"> 
                     <label for="exampleSelect1">Password</label>                         
                      <input type="password" class="form-control" placeholder="Subject" name="password">
                    </div>
                    
                    <div class="form-group">
                    <label for="exampleSelect1">Country</label>
                    <select class="form-control" id="exampleSelect1" name="countryMaster.country_id">
                      <c:forEach var="country" items="${countryMasterList}" varStatus="status">
                      <option value="${country.country_id}">${country.country_name}</option>
                      </c:forEach>
                    </select>
                  </div>
                  
                   <div class="form-group">
                    <label for="exampleSelect1">City  </label>
                    <select class="form-control" id="exampleSelect1" name="cityMaster.city_id">
                    
                    <c:forEach var="city" items="${cityMasterList}" varStatus="status">
                    <option value="${city.city_id}">${city.city_name}</option>
                    </c:forEach>
                    </select>
                  </div>
                    
                  <div class="form-group">    
                  <label >Address  </label>                    
                      <textarea placeholder="Address" rows="3" class="form-control" name="address"></textarea>
                    </div>  
                     <div class="form-group">    
                  <input type="submit" value="Add New User" class="comment-btn btn btn-primary ">
                    </div>  
                  
                </div>
                
                 </div>
                </form>
             </div>