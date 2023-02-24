<%-- 
    Document   : editLead
    Created on : Jan 9, 2016, 2:47:56 PM
    Author     : HP
--%>
<%@include file="counsellor/include/header.jsp"%>

<form class="form-horizontal col-lg-6" action="<%=getServletContext().getContextPath()%>/updateLead.html" method="POST" style="margin-top: 50px; margin-left: 50px">
    <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Update Lead's details </strong></div>
    <div class="form-group">
        <input type="hidden" id="id" name="id" value="${lead.getLeadId()}">

        <label for="name" class="col-sm-3 control-label">Lead Name</label>
        <div class="col-sm-8">
            <input type="text" name="name" class="form-control" id="name" placeholder=" Lead Name" value="${lead.getName()}">
        </div>
    </div>
    <div class="form-group">
        <label for="contact" class="col-sm-3 control-label">Contact Number</label>
        <div class="col-sm-8">
            <input type="text" name="contact" class="form-control" id="datepicker" placeholder="Enter Contact" required="" value="${lead.getContact()}">
        </div>
    </div>
    <div class="form-group">
        <label for="address" class="col-sm-3 control-label">Address</label>
        <div class="col-sm-8">
            <input type="text" name="address" class="form-control" id="location" placeholder="Enter address" value="${lead.getAdd()}">
        </div>
    </div>
    <div class="form-group">
        <label for="email" class="col-sm-3 control-label">Email</label>
        <div class="col-sm-8">
            <input type="email" name="email" class="form-control" id="location" placeholder="Enter email" value="${lead.getEmail()}">
        </div>
    </div>

    <div class="form-group">
        <label for="status" class="col-sm-3 control-label">Status</label>
        <div class="col-sm-8">
            <select class="form-control" name="status">
                <option value="1">Active</option>
                <option value="2">Dismissed</option>
                <option value="3">PostPoned</option>
                <option value="4">Expire</option>
                <option value="5">Student</option>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label for="semester" class="col-sm-3 control-label">Semester</label>
        <div class="col-sm-8">
            <select class="form-control" name="semester">
                <option value="1">First Semester </option>
                <option value="2">Second Semester </option>
                <option value="3">Third Semester</option>
                <option value="4">Fourth Semester</option>
                <option value="5">Fifth Semester</option>
                <option value="6">Sixth Semester</option>

            </select>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-5 col-sm-10">
            <button type="submit" class="btn btn-default">Update</button>
        </div>
    </div>
</form>


<%@include file="counsellor/include/footer.jsp"%>