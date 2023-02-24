<%-- 
    Document   : editFollowUp
    Created on : Jan 9, 2016, 2:47:56 PM
    Author     : HP
--%>
<%@include file="counsellor/include/header.jsp"%>

<form class="form-horizontal col-lg-6" action="<%=getServletContext().getContextPath()%>/updateFollowUp.html" method="POST" style="margin-top: 50px; margin-left: 50px">
    <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Update the Follow Up</strong></div>
    <div class="form-group">
        <input type="hidden" id="id" name="id" value="${followUp.getFollowUpId()}">
        <input type="hidden" id="id2" name="leadId" value="${followUp.getLeadId()}">
        <label for="name" class="col-sm-3 control-label">Lead Name</label>
        <div class="col-sm-8">
            <input type="text" name="name" class="form-control" id="name" placeholder=" Lead Name" value="${followUp.getName()}" required="">
        </div>
    </div>
    <div class="form-group">
        <label for="followDate" class="col-sm-3 control-label">Next follow up date</label>
        <div class="col-sm-8">
            <input type="text" name="date" class="form-control" id="datepicker" placeholder="Select Date" required="" value="${followUp.getDate()}">
        </div>
    </div>
    <div class="form-group">
        <label for="followUpNo" class="col-sm-3 control-label">Follow Up Numbers</label>
        <div class="col-sm-8">
            <input type="text" name="nfollowUpNo" class="form-control" id="location" placeholder="Total Number of follow ups" value="${followUp.getFollowUpNo()}" disabled>
            <input type="hidden" name="followUpNo" value="${followUp.getFollowUpNo()}">
        </div>
    </div>

    <div class="form-group">
        <label for="followUpNo" class="col-sm-3 control-label">Status</label>
        <div class="col-sm-8">
            <select class="form-control" name="status">
                <option value="1" ${followUp.getStatusId() eq 1 ? ' selected="selected"' : ''}>Active</option>
                <option value="2" ${followUp.getStatusId() eq 2 ? ' selected="selected"' : ''}>Dismissed</option>
                <option value="3" ${followUp.getStatusId() eq 3 ? ' selected="selected"' : ''}>Expire</option>
                <option value="4" ${followUp.getStatusId() eq 4 ? ' selected="selected"' : ''}>Postponed</option>
            </select>
        </div>
    </div>


    <div class="form-group">
        <label for="feedback" class="col-sm-3 control-label">Feedback</label>
        <div class="col-sm-8">
            <textarea class="form-control" rows="5" name="feedback" maxlength="200">${followUp.getFeedback()}</textarea>
            <!--<input type="name" name="location" class="form-control" id="location" placeholder="location">-->
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-5 col-sm-10">
            <button type="submit" class="btn btn-default">Update</button>
        </div>
    </div>
</form>

<script>
    $(function () {
        $("#datepicker").datepicker({
//appendText:"(yy-mm-dd)",
            dateFormat: "yy-mm-dd",
            altField: "#datepicker-4",
            altFormat: "DD, d MM, yy"
        });

    });
</script>
<%@include file="counsellor/include/footer.jsp"%>