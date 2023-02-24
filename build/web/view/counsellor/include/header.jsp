<%-- 

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title> Lead Management </title>

        <!-- Bootstrap Core CSS -->
        <link href="<%=getServletContext().getContextPath()%>/assets/css/css/bootstrap.min.css" rel="stylesheet"/>

        <!-- MetisMenu CSS -->
        <link href="<%=getServletContext().getContextPath()%>/assets/css/css/plugins/metisMenu/metisMenu.min.css" rel="stylesheet"/>

        <!-- Timeline CSS -->
        <link href="<%=getServletContext().getContextPath()%>/assets/css/css/plugins/timeline.css" rel="stylesheet"/>

        <!-- Custom CSS -->
        <link href="<%=getServletContext().getContextPath()%>/assets/css/css/sb-admin-2.css" rel="stylesheet"/>

        <!-- Morris Charts CSS -->
        <link href="<%=getServletContext().getContextPath()%>/assets/css/css/plugins/morris.css" rel="stylesheet"/>

        <!-- Custom Fonts -->
        <link href="<%=getServletContext().getContextPath()%>/assets/fonts/fonts/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>

        <!-- DataTables CSS -->
        <link href="<%=getServletContext().getContextPath()%>/assets/css/css/plugins/dataTables.bootstrap.css" rel="stylesheet"/>
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- jQuery Version 1.11.0 -->
        <script src="<%=getServletContext().getContextPath()%>/assets/js/js/jquery-1.11.0.js"></script>
        <link href="<%=getServletContext().getContextPath()%>/assets/css/datepicker.css" rel="stylesheet"/>
        <script src="<%=getServletContext().getContextPath()%>/assets/js/jquery-ui.js"></script>
        <link href="<%=getServletContext().getContextPath()%>/assets/js/jquery-ui.css" rel="stylesheet"/>
        <!-- DataTables JavaScript -->
        <script src="<%=getServletContext().getContextPath()%>/assets/js/js/plugins/dataTables/jquery.dataTables.js"></script>
        <script src="<%=getServletContext().getContextPath()%>/assets/js/js/plugins/dataTables/dataTables.bootstrap.js"></script>
    </head>
    <body>
        <div id="wrapper">

            <!-- Navigation -->
            <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <h4 style="margin-left:600px">Welcome <%= session.getAttribute("role")%></h4>
                </div>
                <!-- /.navbar-header -->
                <div class="navbar-header col-lg-3 navbar-right">
                    <!-- <span class="col-xs-9" text-right">
                                              <h4>Welcome <%= session.getAttribute("role")%></h4>
                                        </span>-->
                    <ul class="nav navbar-top-links navbar-right">

                        <!-- /.dropdown -->

                        <!-- /.dropdown -->
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-user">

                                <li><a href="<%=getServletContext().getContextPath()%>/index.jsp"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                                </li>
                            </ul>
                            <!-- /.dropdown-user -->
                        </li>
                        <!-- /.dropdown -->
                    </ul>
                </div>
                <!-- /.navbar-top-links -->

                <div class="navbar-default sidebar" role="navigation">
                    <div class="sidebar-nav navbar-collapse">
                        <ul class="nav" id="side-menu">

                            <li>
                                <a href="#" style="font-size: 18px"><i class="fa fa-group fa-fw"></i> Manage Leads <span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="<%=getServletContext().getContextPath()%>/view/addLead.jsp">Add Lead</a>
                                    </li>
                                    <li>
                                        <a href="<%=getServletContext().getContextPath()%>/ListLeads.html">List Leads </a>
                                    </li>
                                </ul>
                                <!-- /.nav-second-level -->
                            </li>
                            <li>
                                <a href="<%=getServletContext().getContextPath()%>/followUp.html" style="font-size: 18px"><i class="fa fa-user fa-fw"></i> Manage Follow Up <span class="fa arrow"></span></a>
                                <!-- /.nav-second-level -->
                            </li>
                            


                        </ul>
                    </div>
                    <!-- /.sidebar-collapse -->
                </div>
                <!-- /.navbar-static-side -->
            </nav>



            <div id="page-wrapper">

