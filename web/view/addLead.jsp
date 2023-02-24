<%@include file="counsellor/include/header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/listSemester"/>

<form class="form-horizontal col-lg-8" action="<%=getServletContext().getContextPath()%>/registerLead.html"  method="POST" style="margin-top: 50px; margin-left: 50px">
    <label class="text-success" style="font-size:20px">${msg.successMsg}</label>
    <label class="errorColor">${message.status}</label>
    <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Fill The Form Below</strong></div>
    <div class="form-group">
        <label for="name" class="col-sm-3 control-label">Lead Name</label>
        <div class="col-sm-8">
            <input type="text" name="leadName" class="form-control" id="name" placeholder="Full Name" required="">

        </div>
    </div>

    <div class="form-group">
        <label for="contact" class="col-sm-3 control-label">Contact number</label>
        <div class="col-sm-8">
            <input type="number" name="contact" class="form-control" id="contact" placeholder="Enter contact number" required="">

        </div>
    </div>
    <div class="form-group">
        <label for="location" class="col-sm-3 control-label">Address</label>
        <div class="col-sm-8">
            <input type="text" name="add" class="form-control" id="add" placeholder="Enter address" required="">

        </div>
    </div>
    <div class="form-group">
        <label for="location" class="col-sm-3 control-label">Email</label>
        <div class="col-sm-8">
            <input type="email" name="email" class="form-control" id="email" placeholder="Enter email" required="">

        </div>
    </div>
    <div class="form-group">
        <label for="status" class="col-sm-3 control-label">Status</label>
        <div class="col-sm-8">
            <select class="form-control" name="status">
                <c:forEach items="${status}" var="statusVariable">
                    <option value="${statusVariable.statusId}">${statusVariable.status}</option>
                </c:forEach>                                               
            </select>
        </div>
    </div>
    <div class="form-group">
        <label for="semester" class="col-sm-3 control-label">Semester</label>
        <div class="col-sm-8">
            
            <!-- The semesterID is sent as the semester is chosen from the table -->
            <select class="form-control" name="semester">
                <c:forEach items="${semester}" var="semester">
                    <option value="${semester.semesterId}">${semester.semesterName}</option>
                </c:forEach>
            </select>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-5 col-sm-10">
            <button type="submit" class="btn btn-default">Submit</button>
        </div>
    </div>
</form>







<%@include file="counsellor/include/footer.jsp" %>                                   

