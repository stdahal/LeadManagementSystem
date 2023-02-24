
<%@include file="topManager/include/header.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Counselor Reports </h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Counselor Report
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <div class="table-responsive">
                    <table class="table table-striped table-bordered table-hover" id="userTable">
                        <thead>
                            <tr>
                                <th>Counselor ID</th>
                                <th>Counselor Name</th>
                                <th>Lead Name</th>
                                <th>Follow Up No</th>
                                <th>Status</th>
                                <th> Semester</th>
                            </tr>
                        </thead>
                        <tbody>
<!-- Retrieving the records sent in the request parameter 'counselorReport' and displaying in the table -->
                            <c:forEach items="${counselorReport}" var="counselor">
                                <tr>
                                   
                        <td><c:out value="${counselor.counselorId}" /></td>
                        <td><c:out value="${counselor.counselorName}"/></td>
                        <td><c:out value="${counselor.leadName}" /></td>
                        <td><c:out value="${counselor.followNumber}" /></td>
                        <td><c:out value="${counselor.status}" /></td>
                        <td><c:out value="${counselor.semester}" /></td>                  
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
