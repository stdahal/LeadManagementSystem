<%-- 
    Document   : editLead
    Created on : Jan 9, 2016, 2:47:56 PM
    Author     : HP
--%>
<%@include file="topManager/include/header.jsp"%>

<form class="form-horizontal col-lg-6" action="<%=getServletContext().getContextPath()%>/statusReport.html" method="POST" style="margin-top: 50px; margin-left: 50px">
    <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Update Lead's details </strong></div>
    <div class="form-group">
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
            <div class="col-sm-offset-5 col-sm-10">
                <button type="submit" class="btn btn-default">Submit</button>
            </div>
        </div>
</form>


<%@include file="topManager/include/footer.jsp"%>