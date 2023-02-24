
<%@include file="topManager/include/header.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Counselor-wise Reports </h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Counselor-wise Report
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <div class="table-responsive">
                    <table class="table table-striped table-bordered table-hover" id="userTable">
                        <thead>
                            <tr>
                                <th>Lead ID</th>
                                <th>Lead Name</th>
                                <th>Lead Contact</th>
                                <th>Lead Address</th>
                                <th>Lead Email</th>
                                <th>Lead Added Date</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${leads}" var="lead">
                                <tr>
                                   
                        <td><c:out value="${lead.leadId}" /></td>
                        <td><c:out value="${lead.name}"/></td>
                        <td><c:out value="${lead.contact}" /></td>
                        <td><c:out value="${lead.add}" /></td>
                        <td><c:out value="${lead.email}" /></td>
                        <td><c:out value="${lead.registerDate}" /></td>                  
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
