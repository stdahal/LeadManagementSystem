
<%@include file="topManager/include/header.jsp"%>

<form class="form-horizontal col-lg-6" action="<%=getServletContext().getContextPath()%>/dwreport.html" method="POST" style="margin-top: 50px; margin-left: 50px">
    <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Update the Follow Up</strong></div>
    
    <div class="form-group">
        <label for="fromDate" class="col-sm-3 control-label"> From Date </label>
        <div class="col-sm-8">
            <input type="text" name="fromDate" class="form-control" id="datepicker" placeholder="Select Date" required="" value="">
        </div>
    </div>
     <div class="form-group">
        <label for="toDate" class="col-sm-3 control-label"> To Date </label>
        <div class="col-sm-8">
            <input type="text" name="toDate" class="form-control" id="datepicker1" placeholder="Select Date" required="" value="">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-5 col-sm-10">
            <button type="reset" class="btn btn-default">Reset</button>
            <button type="submit" class="btn btn-default">Submit</button>
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
     $(function () {
        $("#datepicker1").datepicker({
//appendText:"(yy-mm-dd)",
            dateFormat: "yy-mm-dd",
            altField: "#datepicker-4",
            altFormat: "DD, d MM, yy"
        });

    });
</script>
<%@include file="counsellor/include/footer.jsp"%>
