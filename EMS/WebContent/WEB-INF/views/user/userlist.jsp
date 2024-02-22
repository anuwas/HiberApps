<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="row">
   <div class="col-lg-12">
      <h1 class="page-header">User List</h1>
   </div>
   <div class="col-lg-12">
      <div class="table-responsive">
         <table class="table table-bordered table-striped">
            <colgroup>
               <col class="col-xs-1">
               <col class="col-xs-2">
            </colgroup>
            <thead>
               <tr>
                  <th>S.No.</th>
                  <th>First Name</th>
                  <th>Last Name</th>
                  <th>Country</th>
                  <th>City</th>
                  <th>Status</th>
                  <th><button type="button" class="btn btn-success" id="add_new_user">Add New User</button></th>
               </tr>
            </thead>
            <tbody>
               <c:forEach var="item" items="${itemList}" varStatus="status">
                  <tr>
                     <th scope="row">${status.index + 1}</th>
                     <td>${item.getFirst_name()}</td>
                     <td>${item.getLast_name()}</td>
                     <td>${item.getCountryMaster().getCountry_name()}</td>
                     <td>${item.getCityMaster().getCity_name()}</td>
                     <td align="center"><a href="#"><img src="img/clear.png"></a></td>
                     <td><button type="button" class="btn btn-success edit_userBtn_cls" id="edit_user_${item.getUser_id()}">Edit</button>
                     &nbsp;<button type="button" class="btn btn-success">Delete</button>
                     </td>
                  </tr>
               </c:forEach>
               <!--  
                  <tr style="text-align: center;">
                     <td></td>
                     <td></td>
                     <td></td>
                     <td></td>
                     <td></td>
                     <td style="text-align: center;">
                     <a href="editUser?id=${item.getUser_id()}">Edit</a> &nbsp; 
                     <a href="deleteUser?id=${item.getUser_id()}">Delete</a></td>        
                   </tr>
                    -->
            </tbody>
         </table>
      </div>
   </div>
</div>
<script src="js/custom.js"></script>