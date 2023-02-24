
<%@include file="admin/include/header.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Counselors</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                List of All Counselors
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <div class="table-responsive">
                    <table class="table table-striped table-bordered table-hover" id="userTable">
                        <thead>
                            <tr>
                                
                                 <th>Counselor Name</th>
                                <th>Address</th>
                                <th>Contact Number</th>
                                <th>Email</th>
                                <th style="width:80px;">Edit</th>
                                <th style="width:80px;">Delete</th>
                                
                            </tr>
                        </thead>
                        <tbody>
                            <c:set value="0" var="count" scope="page"/>
                               <c:forEach items="${counselors}" var="counselor">

                                <c:set value="${count+1}" var="count" scope="page"/>
                                <tr class="odd gradeX">
                                    <td>${counselor. getCounselorName() }</td>
                                    <td>${counselor.getContact()}</td>
                                    <td>${counselor.getCounselorAdd() }</td>
                                    <td>${counselor.getEmail()}</td>
                                    
                                    <td>
                                        <a href="editCounselor.html?id=${counselor. getCounselorId()}">
                                            <button type="button" class="btn btn-info col-lg-12">
                                                <i class="fa fa-edit"></i>
                                            </button>
                                        </a>

                                    </td>
                                    <td>
                                        <a href="deleteCounselor.html?id=${counselor. getCounselorId()}" onclick="return confirm('Are you sure you want to delete?')">
                                            <button type="button" class="btn btn-danger col-lg-12">
                                                <i class="fa fa-times"></i>
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
<%@include file="admin/include/footer.jsp"%>
