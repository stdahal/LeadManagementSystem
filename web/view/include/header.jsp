<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Manage Lead System</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%=getServletContext().getContextPath()%>/assets/css/bootstrap.min.css" rel="stylesheet" />
   

    <!-- MetisMenu CSS -->
    <link href="<%=getServletContext().getContextPath()%>/assets/css/plugins/metisMenu/metisMenu.min.css" rel="stylesheet"/>
    
    <!-- Timeline CSS -->
   <link href="<%=getServletContext().getContextPath()%>/assets/css/plugins/timeline.css" rel="stylesheet"/>
    

    <!-- Custom CSS -->
     <link href="<%=getServletContext().getContextPath()%>/assets/css/sb-admin-2.css" rel="stylesheet"/>

    <!-- Morris Charts CSS -->
     <link href="<%=getServletContext().getContextPath()%>/assets/css/plugins/morris.css" rel="stylesheet"/>
     <link href="<%=getServletContext().getContextPath()%>/assets/css/plugins/dataTables.bootstrap.css" rel="stylesheet"/>
     <script src="<%=getServletContext().getContextPath()%>/assets/js/plugins/dataTables/dataTables.bootstrap.js"></script>
     <script src="<%=getServletContext().getContextPath()%>/assets/js/plugins/dataTables/jquery.dataTables.js"></script>
     <script src="<%=getServletContext().getContextPath()%>/assets/js/jquery-1.11.0.js"></script>

    <!-- Custom Fonts -->
    <link href="<%=getServletContext().getContextPath()%>/assets/font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" />
    
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

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
                <a class="navbar-brand" href="index.html">Lead Management System </a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
               
                
               
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li class="divider"></li>
                        <li><a href="<%=getServletContext().getContextPath()%>/logout.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>Manage Counselor <span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="flot.html">Add Counselor</a>
                                </li>
                                <li>
                                    <a href="morris.html">List Counselor </a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="tables.html"><i class="fa fa-table fa-fw"></i> Manage Leads </a>
                        </li>
                        <li>
                            <a href="<%=getServletContext().getContextPath()%>/view/addLead.jsp"><i class="fa fa-edit fa-fw"></i> Add new Lead</a>
                        </li>
                        <li>
                            <a href="<%=getServletContext().getContextPath()%>/view/listLeads.jsp"><i class="fa fa-edit fa-fw"></i> List total Leads</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-wrench fa-fw"></i> Reports <span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="panels-wells.html">Counselor Report </a>
                                </li>
                                <li>
                                    <a href="buttons.html">Active Lead Report</a>
                                </li>
                                <li>
                                    <a href="notifications.html">Notifications</a>
                                </li>
                                <li>
                                    <a href="typography.html">Typography</a>
                                </li>
                                <li>
                                    <a href="grid.html">Grid</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-sitemap fa-fw"></i> Multi-Level Dropdown<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="#">Second Level Item</a>
                                </li>
                                <li>
                                    <a href="#">Second Level Item</a>
                                </li>
                                <li>
                                    <a href="#">Third Level <span class="fa arrow"></span></a>
                                    <ul class="nav nav-third-level">
                                        <li>
                                            <a href="#">Third Level Item</a>
                                        </li>
                                        <li>
                                            <a href="#">Third Level Item</a>
                                        </li>
                                        <li>
                                            <a href="#">Third Level Item</a>
                                        </li>
                                        <li>
                                            <a href="#">Third Level Item</a>
                                        </li>
                                    </ul>
                                    <!-- /.nav-third-level -->
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-files-o fa-fw"></i> Sample Pages<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="blank.html">Blank Page</a>
                                </li>
                                <li>
                                    <a href="login.html">Login Page</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

 

            <!-- /.row -->

            <!-- /.row -->
   
            <!-- /.row -->
   
        <!-- /#page-wrapper -->

    
    <!-- /#wrapper -->

    <!-- jQuery Version 1.11.0 -->
    