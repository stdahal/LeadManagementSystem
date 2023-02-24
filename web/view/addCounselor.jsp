<%@include file="admin/include/header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form class="form-horizontal col-lg-8" action="<%=getServletContext().getContextPath()%>/AddCounselor.html"  method="POST" style="margin-top: 50px; margin-left: 50px">
    <label class="text-success" style="font-size:20px">${message.success}</label>
    <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Fill The Form Below to add Counselor</strong></div>
    <div class="form-group">
        <label for="name" class="col-sm-3 control-label">Counselor Name</label>
        <div class="col-sm-8">
            <input type="text" name="counselorName" class="form-control" id="name" placeholder="Full Name" required="">

        </div>
    </div>

    <div class="form-group">
        <label for="contact" class="col-sm-3 control-label">Contact number</label>
        <div class="col-sm-8">
            <input type="number" name="contact" class="form-control" id="contact" placeholder="Enter contact number" required="">

        </div>
    </div>
    <div class="form-group">
        <label for="addresss" class="col-sm-3 control-label">Address</label>
        <div class="col-sm-8">
            <input type="text" name="add" class="form-control" id="add" placeholder="Enter address" required="">

        </div>
    </div>
    <div class="form-group">
        <label for="email" class="col-sm-3 control-label">Email</label>
        <div class="col-sm-8">
            <input type="email" name="email" class="form-control" id="email" placeholder="Enter email" required="">

        </div>
    </div>
    <div class="form-group">
        <label for="email" class="col-sm-3 control-label">Password</label>
        <div class="col-sm-8">
            <input type="password" name="pass" class="form-control" id="email" placeholder="Enter password" required="">

        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-5 col-sm-10">
            <button type="submit" class="btn btn-default">Submit</button>
        </div>
    </div>

</form>







<%@include file="admin/include/footer.jsp" %>                                   

