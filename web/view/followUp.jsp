
<%@include file="counsellor/include/header.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Follow-Up Details</h1>
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
                                <th>Feedback</th>
                                <th>Follow Up No</th>
                                <th>Semester</th>
                                <th style="width:80px;">Follow-Up</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:set value="0" var="count" scope="page"/>
                            <c:forEach items="${followUp}" var="follow">

                                <c:set value="${count+1}" var="count" scope="page"/>
                                <tr class="odd gradeX">
                                    <td>${follow.getName() }</td>
                                    <td>${follow.getContact()}</td>
                                    <td>${follow.getAdd()}</td>
                                    <td>${follow.getEmail()}</td>
                                    <td>${follow.getStatus()}</td>
                                    <td>${follow.getFeedback()}</td>
                                    <td>${follow.getFollowUpNo()}</td>
                                    <td>${follow.getSemesterName()}</td>
                                    <td>
                                        <a href="editFollowUp.html?id=${follow.getFollowUpId()}">
                                            <button type="button" class="btn btn-warning col-lg-12">
                                                <i>Check Follow up</i>
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
