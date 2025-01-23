<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <%@ include file="../../static/head.jsp" %>
    <link href="http://www.bootcss.com/p/bootstrap-datetimepicker/bootstrap-datetimepicker/css/datetimepicker.css"
          rel="stylesheet">
    <script type="text/javascript" charset="utf-8">
        window.UEDITOR_HOME_URL = "${pageContext.request.contextPath}/resources/ueditor/"; //UEDITOR_HOME_URL、config、all这三个顺序不能改变
    </script>
    <script src="${pageContext.request.contextPath}/resources/ueditor/ueditor.config.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/resources/ueditor/ueditor.all.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/resources/ueditor/lang/zh-cn/zh-cn.js" type="text/javascript" charset="utf-8"></script>
</head>
<style>

</style>
<body>
    <!-- Pre Loader -->
    <div class="loading">
        <div class="spinner">
            <div class="double-bounce1"></div>
            <div class="double-bounce2"></div>
        </div>
    </div>
    <!--/Pre Loader -->
<div class="wrapper">
    <!-- Page Content -->
    <div id="content">
        <!-- Top Navigation -->
        <%@ include file="../../static/topNav.jsp" %>
        <!-- Menu -->
        <div class="container menu-nav">
            <nav class="navbar navbar-expand-lg lochana-bg text-white">
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="ti-menu text-white"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto" id="navUl">

                    </ul>
                </div>
            </nav>
        </div>
        <!-- /Menu -->
        <!-- Breadcrumb -->
        <!-- Page Title -->
        <div class="container mt-0">
            <div class="row breadcrumb-bar">
                <div class="col-md-6">
                    <h3 class="block-title">编辑作业提交</h3>
                </div>
                <div class="col-md-6">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="${pageContext.request.contextPath}/index.jsp">
                                <span class="ti-home"></span>
                            </a>
                        </li>
                        <li class="breadcrumb-item">作业提交管理</li>
                        <li class="breadcrumb-item active">作业提交登记</li>
                    </ol>
                </div>
            </div>
        </div>
        <!-- /Page Title -->

        <!-- /Breadcrumb -->
        <!-- Main Content -->
        <div class="container">

            <div class="row">
                <!-- Widget Item -->
                <div class="col-md-12">
                    <div class="widget-area-2 lochana-box-shadow">
                        <h3 class="widget-title">作业提交信息</h3>
                        <form id="addOrUpdateForm">
                            <div class="form-row">
                            <!-- 级联表所有字段 -->

                                        <div class="form-group col-md-6">
                                            <label>老师姓名</label>
                                            <input style="width: 450px" id="laoshiName" name="laoshiName" class="form-control"
                                                   v-model="ruleForm.laoshiName" readonly>
                                        </div>


                                        <div class="form-group col-md-6">
                                            <label>老师手机号</label>
                                            <input style="width: 450px" id="laoshiPhone" name="laoshiPhone" class="form-control"
                                                   v-model="ruleForm.laoshiPhone" readonly>
                                        </div>


                                    <div class="form-group col-md-6">
                                        <label>老师头像</label>
                                        <img id="laoshiPhotoImg" width="100" height="100">
                                    </div>

                                        <div class="form-group col-md-6">
                                            <label>用户姓名</label>
                                            <input style="width: 450px" id="yonghuName" name="yonghuName" class="form-control"
                                                   v-model="ruleForm.yonghuName" readonly>
                                        </div>


                                        <div class="form-group col-md-6">
                                            <label>用户手机号</label>
                                            <input style="width: 450px" id="yonghuPhone" name="yonghuPhone" class="form-control"
                                                   v-model="ruleForm.yonghuPhone" readonly>
                                        </div>


                                    <div class="form-group col-md-6">
                                        <label>用户头像</label>
                                        <img id="yonghuPhotoImg" width="100" height="100">
                                    </div>

                                    <div class="form-group col-md-6">
                                        <label>实训方向</label>
                                        <input style="width: 450px" id="yonghuValue" name="yonghuValue" class="form-control"
                                               v-model="ruleForm.yonghuValue" readonly>
                                    </div>



                                        <div class="form-group col-md-6">
                                            <label>作业名称</label>
                                            <input style="width: 450px" id="zuoyeName" name="zuoyeName" class="form-control"
                                                   v-model="ruleForm.zuoyeName" readonly>
                                        </div>


                                        <div class="form-group col-md-6">
                                            <label>作业编号</label>
                                            <input style="width: 450px" id="zuoyeUuidNumber" name="zuoyeUuidNumber" class="form-control"
                                                   v-model="ruleForm.zuoyeUuidNumber" readonly>
                                        </div>


                                    <div class="form-group col-md-6">
                                        <label>作业封面</label>
                                        <img id="zuoyePhotoImg" width="100" height="100">
                                    </div>

                                    <div class="form-group col-md-6">
                                        <label>作业类型</label>
                                        <input style="width: 450px" id="zuoyeValue" name="zuoyeValue" class="form-control"
                                               v-model="ruleForm.zuoyeValue" readonly>
                                    </div>


                            <!-- 本表所有字段 -->



                                    <input id="updateId" name="id" type="hidden">

                                    <div class="form-group col-md-6">
                                        <label>报名唯一编号</label>
                                        <input style="width: 450px" id="zuoyeTijiaoUuidNumber" name="zuoyeTijiaoUuidNumber" class="form-control"
                                               v-model="ruleForm.zuoyeTijiaoUuidNumber" readonly>
                                    </div>

                                <input id="zuoyeId" name="zuoyeId" v-model="ruleForm.zuoyeId" readonly type="hidden">
                                <input id="laoshiId" name="laoshiId" v-model="ruleForm.laoshiId" readonly type="hidden">
                                <input id="yonghuId" name="yonghuId" v-model="ruleForm.yonghuId" readonly type="hidden">

                                    <div class="form-group col-md-6">
                                        <label>内容</label>
                                        <input style="width: 450px" id="zuoyeTijiaoText" name="zuoyeTijiaoText" class="form-control"
                                               v-model="ruleForm.zuoyeTijiaoText" readonly>
                                    </div>


                                <div class="form-group col-md-6">
                                    <label>提交状态</label>
                                    <input style="width: 450px" id="zuoyeTijiaoYesnoValue" name="zuoyeTijiaoYesnoValue" class="form-control"
                                           v-model="ruleForm.zuoyeTijiaoYesnoValue" readonly>
                                </div>

                                    <div class="form-group col-md-6">
                                        <label>批改分数</label>
                                        <input style="width: 450px" id="zuoyeTijiaoPigai" name="zuoyeTijiaoPigai" class="form-control"
                                               v-model="ruleForm.zuoyeTijiaoPigai" readonly>
                                    </div>

                                <div class="form-group col-md-12 mb-3">
                                    <button id="exitBtn" type="button" class="btn btn-primary btn-lg">返回</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- /Widget Item -->
            </div>
        </div>
        <!-- /Main Content -->
    </div>
    <!-- /Page Content -->
</div>
<!-- Back to Top -->
<a id="back-to-top" href="#" class="back-to-top">
    <span class="ti-angle-up"></span>
</a>
<!-- /Back to Top -->
<%@ include file="../../static/foot.jsp" %>
<script src="${pageContext.request.contextPath}/resources/js/vue.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.ui.widget.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.form.js"></script>

<script>
    <%@ include file="../../utils/menu.jsp"%>
    <%@ include file="../../static/setMenu.js"%>
    <%@ include file="../../utils/baseUrl.jsp"%>

    var sessionTable = window.sessionStorage.getItem("accountTableName");//登录账户所在表名
    var role         = window.sessionStorage.getItem("role");//权限
    var userId       = window.sessionStorage.getItem("userId");//当前登录人的id
    var tableName = "zuoyeTijiao";
    var pageType = "add-or-update";
    var updateId = "";

    var zuoyeTijiaoYesnoTypesOptions = [];

    var ruleForm = {};
    var vm = new Vue({
        el: '#addOrUpdateForm',
        data: {
            ruleForm: {},
        },
        beforeCreate: function () {
            var id = window.sessionStorage.getItem("updateId");
            if (id != null && id != "" && id != "null") {
                $.ajax({
                    type: "GET",
                    url: baseUrl + "zuoyeTijiao/info/" + id,
                    beforeSend: function (xhr) {
                        xhr.setRequestHeader("token", window.sessionStorage.getItem('token'));
                    },
                    success: function (res) {
                        if (res.code == 0) {
                            vm.ruleForm = res.data;
                            ruleForm = res.data;
                            showImg();
                            setContent();
                        } else if (res.code == 401) {
                        <%@ include file="../../static/toLogin.jsp"%>
                        } else {
                            alert(res.msg)
                        }
                    },
                });
            }
        },
        methods: {}
    });


    // 填充富文本框
    function setContent() {

    }

    //图片显示
    function showImg() {
        $("#laoshiPhotoImg").attr("src", baseUrl+ruleForm.laoshiPhoto);
        $("#yonghuPhotoImg").attr("src", baseUrl+ruleForm.yonghuPhoto);
        $("#zuoyePhotoImg").attr("src", baseUrl+ruleForm.zuoyePhoto);
    }

    function exit() {
        window.sessionStorage.removeItem("updateId");
        window.sessionStorage.removeItem('addzuoyeTijiao');
        window.location.href = "list.jsp";
    }

    // 下载
    function download(fileName) {
        var url = baseUrl+'file/download?fileName='+fileName;
        window.open(url);
    }

    //设置下载
    function setDownloadBtn() {
        var zuoyeShangchuanFileUrl = "download('" + ruleForm.zuoyeShangchuanFile + "')";
        $("#zuoyeShangchuanFile").attr("onclick", zuoyeShangchuanFileUrl);

    }

    $(document).ready(function () {
        //设置右上角用户名
        $('.dropdown-menu h5').html(window.sessionStorage.getItem('username'))
        //设置项目名
        $('.sidebar-header h3 a').html(projectName)
        setMenu();
        $('#exitBtn').on('click', function (e) {
            e.preventDefault();
            exit();
        });


    <%@ include file="../../static/myInfo.js"%>
    });
    // 用户登出
    <%@ include file="../../static/logout.jsp"%>
</script>
</body>

</html>
