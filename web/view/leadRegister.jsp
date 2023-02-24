<%@include file="include/header.jsp" %>


        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Forms</h1>
                </div>              
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Please fill the form to add new lead
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form role="form" action="<%=getServletContext().getContextPath()%>/registerLead.html">
                                        <div class="form-group">
                                            <label>Lead Name</label>
                                            <input class="form-control" placeholder="Enter Name" name="leadName">   
                                        </div>
                                        <div class="form-group">
                                            <label>Address</label>
                                            <input class="form-control" placeholder="Enter address" name="add">   
                                        </div>
                                        <div class="form-group">
                                            <label>Email</label>
                                            <input class="form-control" placeholder="Enter email" name="email">
                                        </div>
                                        <div class="form-group">
                                            <label>Contact number</label>
                                            <input class="form-control" placeholder="Enter contact number" name="contact">
                                        </div>
                                        <div class="form-group">
                                           <label>Number of Follow-ups </label>
                                            <select class="form-control" name="followUp">
                                                <option>1</option>
                                                <option>2</option>
                                                <option>3</option>
                                                <option>4</option>
                                                <option>5</option>
						<option>6</option>
                                                <option>7</option>
                                                <option>8</option>
                                            </select>
                                        </div>
					<div class="form-group">
                                            <label>Status</label>
                                            <select class="form-control" name="status">
                                                <option>Active</option>
                                                <option>Expired</option>
                                                <option>Dismissed</option>
                                                <option>Postponed</option>                                                
                                            </select>
                                        </div>                                       
                                        <div class="form-group">
                                            <label>Lead's feedback</label>
                                            <textarea class="form-control" rows="3" name="feedback"></textarea>
                                        </div>
                                        <button type="submit" class="btn btn-default">Submit form</button>
                                        <button type="reset" class="btn btn-default">Reset</button>
                                    </form>
                                </div>
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
     
<%@include file="include/footer.jsp" %>                                   
