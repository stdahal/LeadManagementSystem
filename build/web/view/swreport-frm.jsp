

<%@include file="topManager/include/header.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form class="form-horizontal col-lg-6" name="swForm" action="<%=getServletContext().getContextPath()%>/swreport.html" method="POST" style="margin-top: 50px; margin-left: 50px">
    <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Update Lead's details </strong></div>
    <div class="form-group">
        <div class="form-group">
            <label for="status" class="col-sm-3 control-label">Select Semester </label>
            <div class="col-sm-8">
                <select class="form-control" name="selectedSemester">
                    <option value="none">--Select--</option>
                    <c:forEach items="${semesters}" var="semester">
                        <option value="<c:out value="${semester.semesterId}" />"><c:out value="${semester.session} ${semester.year}" /></<option>
                        </c:forEach>   
                </select>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-5 col-sm-10">
                <button type="submit" name="submit" value="produce" class="btn btn-default">Submit</button>
            </div>
        </div>
</form>


<%@include file="topManager/include/footer.jsp"%>
