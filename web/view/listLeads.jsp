
<%@include file="counsellor/include/header.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Users</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                List of All Leads
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
                                <th style="width:80px;">Edit</th>
                            </tr>
                        </thead>
                        <tbody>
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
                                    <td>
                                        <a href="editLead.html?id=${lead.getLeadId()}">
                                            <button type="button" class="btn btn-info col-lg-12">
                                                <i class="fa fa-edit"></i>
                                            </button>
                                        </a>

                                    </td>
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
<%@include file="counsellor/include/footer.jsp"%>
