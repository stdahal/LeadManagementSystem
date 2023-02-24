
<%@include file="topManager/include/header.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Leads Status Report</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Leads Status Report
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <div class="table-responsive">
                    <table class="table table-striped table-bordered table-hover" id="userTable">
                        <thead>
                            <tr>
                                
                                <th>Lead Name</th>
                                <th>Contact Number</th>
                                <th>Address</th>
                                <th>Email</th>
                                <th>Status</th>
                                <th>Semester</th>
                                <th>Feedbacks</th>
                                <th>Total follow ups</th>
                             
                                
                            </tr>
                        </thead>
                        <tbody>
<!-- Retrieving the records sent in the request parameter 'leads' and displaying in the table -->
                            <c:set value="0" var="count" scope="page"/>
                               <c:forEach items="${leads}" var="lead">

                                <c:set value="${count+1}" var="count" scope="page"/>
                                <tr class="odd gradeX">
                                    <td>${lead.getName() }</td>
                                    <td>${lead.getContact()}</td>
                                    <td>${lead.getAdd()}</td>
                                    <td>${lead.getEmail()}</td>
                                    <td>${lead.getStatus()}</td>                        
                                    <td>${lead.getSemesterName()}</td>
                                    <td>${lead.getFeedback()}</td>                        
                                    <td>${lead.getFollowUpNo()}</td>
                                    
                                </tr>
                                 </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
        $('#userTable').dataTable();
    });
</script>
<%@include file="topManager/include/footer.jsp"%>
