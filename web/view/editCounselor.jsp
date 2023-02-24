<%-- 
    Document   : editFollowUp
    Created on : Jan 9, 2016, 2:47:56 PM
    Author     : HP
--%>
<%@include file="admin/include/header.jsp"%>

<form class="form-horizontal col-lg-6" action="<%=getServletContext().getContextPath()%>/updateCounselor.html" method="POST" style="margin-top: 50px; margin-left: 50px">
    <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Update Counselor's details </strong></div>
    <div class="form-group">
        <input type="hidden" id="id" name="id" value="${counselor.getCounselorId()}">

        <label for="name" class="col-sm-3 control-label">Counselor Name</label>
        <div class="col-sm-8">
            <input type="text" name="name" class="form-control" id="name" placeholder=" Counselor Name" value="${counselor.getCounselorName()}">
        </div>
    </div>
     <div class="form-group">
        <label for="address" class="col-sm-3 control-label">Address</label>
        <div class="col-sm-8">
            <input type="text" name="add" class="form-control" id="location" placeholder="Enter address" value="${counselor.getCounselorAdd()}">
        </div>
    </div>
    <div class="form-group">
        <label for="contact" class="col-sm-3 control-label">Contact Number</label>
        <div class="col-sm-8">
            <input type="text" name="contact" class="form-control" id="datepicker" placeholder="Enter Contact" required="" value="${counselor.getContact()}">
        </div>
    </div>
   
    <div class="form-group">
        <label for="email" class="col-sm-3 control-label">Email</label>
        <div class="col-sm-8">
            <input type="email" name="email" class="form-control" id="location" placeholder="Enter email" value="${counselor.getEmail()}">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-5 col-sm-10">
            <button type="submit" class="btn btn-default">Update</button>
        </div>
    </div>
</form>


<%@include file="admin/include/footer.jsp"%>