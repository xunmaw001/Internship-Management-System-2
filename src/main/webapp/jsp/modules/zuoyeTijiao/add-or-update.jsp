<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <%@ include file="../../static/head.jsp" %>
    <link href="http://www.bootcss.com/p/bootstrap-datetimepicker/bootstrap-datetimepicker/css/datetimepicker.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-select.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" charset="utf-8">
        window.UEDITOR_HOME_URL = "${pageContext.request.contextPath}/resources/ueditor/"; //UEDITOR_HOME_URL、config、all这三个顺序不能改变
    </script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.all.min.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<style>
    .error {
        color: red;
    }
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
                    <ul id="navUl" class="navbar-nav mr-auto"></ul>
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
                        <li class="breadcrumb-item active">编辑作业提交</li>
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
                            <!-- 级联表的字段 -->
                                    <div class="form-group col-md-6 aaaaaa laoshi">
                                        <label>任课老师</label>
                                        <div>
                                            <select style="width: 450px" id="laoshiSelect" name="laoshiSelect"
                                                    class="selectpicker form-control"  data-live-search="true"
                                                    title="请选择" data-header="请选择" data-size="5" data-width="650px">
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6 laoshi">
                                        <label>老师姓名</label>
                                        <input style="width: 450px" id="laoshiName" name="laoshiName" placeholder="老师姓名" class="form-control" readonly>
                                    </div>
                                    <div class="form-group col-md-6 laoshi">
                                        <label>老师手机号</label>
                                        <input style="width: 450px" id="laoshiPhone" name="laoshiPhone" placeholder="老师手机号" class="form-control" readonly>
                                    </div>
                                    <div class="form-group col-md-6 laoshi">
                                        <label>老师头像</label>
                                        <img id="laoshiPhotoImg" src="" width="100" height="100">
                                    </div>
                                    <div class="form-group col-md-6 aaaaaa yonghu">
                                        <label>用户</label>
                                        <div>
                                            <select style="width: 450px" id="yonghuSelect" name="yonghuSelect"
                                                    class="selectpicker form-control"  data-live-search="true"
                                                    title="请选择" data-header="请选择" data-size="5" data-width="650px">
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6 yonghu">
                                        <label>用户姓名</label>
                                        <input style="width: 450px" id="yonghuName" name="yonghuName" placeholder="用户姓名" class="form-control" readonly>
                                    </div>
                                    <div class="form-group col-md-6 yonghu">
                                        <label>用户手机号</label>
                                        <input style="width: 450px" id="yonghuPhone" name="yonghuPhone" placeholder="用户手机号" class="form-control" readonly>
                                    </div>
                                    <div class="form-group col-md-6 yonghu">
                                        <label>用户头像</label>
                                        <img id="yonghuPhotoImg" src="" width="100" height="100">
                                    </div>
                                    <div class="form-group col-md-6 yonghu">
                                        <label>实训方向</label>
                                        <input style="width: 450px" id="yonghuValue" name="yonghuValue" placeholder="实训方向" class="form-control" readonly>
                                    </div>
                                    <div class="form-group col-md-6 aaaaaa zuoye">
                                        <label>作业</label>
                                        <div>
                                            <select style="width: 450px" id="zuoyeSelect" name="zuoyeSelect"
                                                    class="selectpicker form-control"  data-live-search="true"
                                                    title="请选择" data-header="请选择" data-size="5" data-width="650px">
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6 zuoye">
                                        <label>作业名称</label>
                                        <input style="width: 450px" id="zuoyeName" name="zuoyeName" placeholder="作业名称" class="form-control" readonly>
                                    </div>
                                    <div class="form-group col-md-6 zuoye">
                                        <label>作业编号</label>
                                        <input style="width: 450px" id="zuoyeUuidNumber" name="zuoyeUuidNumber" placeholder="作业编号" class="form-control" readonly>
                                    </div>
                                    <div class="form-group col-md-6 zuoye">
                                        <label>作业封面</label>
                                        <img id="zuoyePhotoImg" src="" width="100" height="100">
                                    </div>
                                    <div class="form-group col-md-6 zuoye">
                                        <label>作业类型</label>
                                        <input style="width: 450px" id="zuoyeValue" name="zuoyeValue" placeholder="作业类型" class="form-control" readonly>
                                    </div>
                            <!-- 当前表的字段 -->
                                    <input id="updateId" name="id" type="hidden">
                                    <div class="form-group col-md-6 zuoyeTijiaoUuidNumberDiv">
                                        <label>报名唯一编号</label>
                                        <input style="width: 450px" id="zuoyeTijiaoUuidNumber" name="zuoyeTijiaoUuidNumber" class="form-control"
                                               placeholder="报名唯一编号">
                                    </div>
                                <input id="zuoyeId" name="zuoyeId" type="hidden">
                                <input id="laoshiId" name="laoshiId" type="hidden">
                                <input id="yonghuId" name="yonghuId" type="hidden">
                                    <div class="form-group col-md-6 zuoyeTijiaoTextDiv">
                                        <label>内容</label>
                                        <textarea style="width: 450px"  id="zuoyeTijiaoText" name="zuoyeTijiaoText" class="form-control"placeholder="内容"></textarea>
                                    </div>
                                    <div class="form-group col-md-6 zuoyeShangchuanFileDiv">
                                        <label>作业上传</label>
                                        <input name="file" type="file" class="form-control-file" id="zuoyeShangchuanFileupload">
                                        <label id="zuoyeShangchuanFileName"></label>
                                        <input name="zuoyeShangchuanFile" id="zuoyeShangchuanFile-input" type="hidden">
                                    </div>
                                    <div class="form-group col-md-6 zuoyeTijiaoPigaiDiv">
                                        <label>批改分数</label>
                                        <input style="width: 450px" id="zuoyeTijiaoPigai" name="zuoyeTijiaoPigai" class="form-control"
                                               onchange="integerChickValue(this)"  placeholder="批改分数">
                                    </div>

                                    <div class="form-group-1 col-md-6 mb-3" style="display: flex;flex-wrap: wrap;">
                                        <button id="submitBtn" type="button" class="btn btn-primary btn-lg">提交</button>
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
<script src="${pageContext.request.contextPath}/resources/js/jquery.fileupload.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.form.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/validate/jquery.validate.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/resources/js/validate/messages_zh.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/resources/js/validate/card.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/resources/js/datetimepicker/bootstrap-datetimepicker.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap-select.js" type="text/javascript" charset="utf-8"></script>
<!-- <script src="${pageContext.request.contextPath}/resources/js/laydate.js"></script> -->
<script>
    <%@ include file="../../utils/menu.jsp"%>
    <%@ include file="../../static/setMenu.js"%>
    <%@ include file = "../../static/utils.js" %>
    <%@ include file="../../utils/baseUrl.jsp"%>

    var sessionTable = window.sessionStorage.getItem("accountTableName");//登录账户所在表名
    var role         = window.sessionStorage.getItem("role");//权限
    var userId       = window.sessionStorage.getItem("userId");//当前登录人的id
    var tableName = "zuoyeTijiao";
    var pageType = "add-or-update";
    var updateId = "";
    var ruleForm = {};


    // 下拉框数组
        <!-- 当前表的下拉框数组 -->
    var zuoyeTijiaoYesnoTypesOptions = [];
        <!-- 级联表的下拉框数组 -->
    var laoshiOptions = [];
    var yonghuOptions = [];
    var zuoyeOptions = [];

    // 文件上传
    function upload() {

        <!-- 当前表的文件上传 -->

        $('#zuoyeShangchuanFileupload').fileupload({
            url: baseUrl + 'file/upload',
            headers: {token: window.sessionStorage.getItem("token")},
            dataType: 'json',
            done: function (e, data) {
                document.getElementById('zuoyeShangchuanFile-input').setAttribute('value', baseUrl + 'file/download?fileName=' + data.result.file);
                document.getElementById('zuoyeShangchuanFileName').innerHTML = "上传成功!";
            }
        });


    }

    // 表单提交
    function submit() {
        if (validform() == true && compare() == true) {
            let data = {};
            getContent();
            if(window.sessionStorage.getItem('role') != '作业'){//当前登录用户不为这个
                if($("#zuoyeId") !=null){
                    var zuoyeId = $("#zuoyeId").val();
                    if(zuoyeId == null || zuoyeId =='' || zuoyeId == 'null'){
                        layui.layer.msg("作业不能为空", {time: 2000,icon: 5});
                        return;
                    }
                }
            }
            if(window.sessionStorage.getItem('role') != '任课老师'){//当前登录用户不为这个
                if($("#laoshiId") !=null){
                    var laoshiId = $("#laoshiId").val();
                    if(laoshiId == null || laoshiId =='' || laoshiId == 'null'){
                        layui.layer.msg("老师不能为空", {time: 2000,icon: 5});
                        return;
                    }
                }
            }
            if(window.sessionStorage.getItem('role') != '用户'){//当前登录用户不为这个
                if($("#yonghuId") !=null){
                    var yonghuId = $("#yonghuId").val();
                    if(yonghuId == null || yonghuId =='' || yonghuId == 'null'){
                        layui.layer.msg("用户不能为空", {time: 2000,icon: 5});
                        return;
                    }
                }
            }
            let value = $('#addOrUpdateForm').serializeArray();
            $.each(value, function (index, item) {
                data[item.name] = item.value;
            });
            var urlParam;
            var successMes = '';
            if (updateId != null && updateId != "null" && updateId != '') {
                urlParam = 'update';
                successMes = '修改成功';
            } else {
                urlParam = 'save';
                    successMes = '添加成功';

            }
            httpJson("zuoyeTijiao/" + urlParam, "POST", data, (res) => {
                if(res.code == 0){
                    window.sessionStorage.removeItem('addzuoyeTijiao');
                    window.sessionStorage.removeItem('updateId');
                    let flag = true;
                    if (flag) {
                        layui.layer.msg(successMes, {time: 2000,icon: 5});
                    }
                    if (window.sessionStorage.getItem('onlyme') != null && window.sessionStorage.getItem('onlyme') == "true") {
                        window.sessionStorage.removeItem('onlyme');
                        window.sessionStorage.setItem("reload","reload");
                        window.parent.location.href = "${pageContext.request.contextPath}/index.jsp";
                    } else {
                        window.location.href = "list.jsp";
                    }
                }
            });
        } else {
            layui.layer.msg("表单未填完整或有错误", {time: 2000,icon: 5});
        }
    }

    // 查询列表
        <!-- 查询当前表的所有列表 -->
        function zuoyeTijiaoYesnoTypesSelect() {
            //填充下拉框选项
            http("dictionary/page?page=1&limit=100&sort=&order=&dicCode=zuoye_tijiao_yesno_types", "GET", {}, (res) => {
                if(res.code == 0){
                    zuoyeTijiaoYesnoTypesOptions = res.data.list;
                }
            });
        }
        <!-- 查询级联表的所有列表 -->
        function laoshiSelect() {
            //填充下拉框选项
            http("laoshi/page?page=1&limit=100&sort=&order=", "GET", {}, (res) => {
                if(res.code == 0){
                    laoshiOptions = res.data.list;
                }
            });
        }

        function laoshiSelectOne(id) {
            http("laoshi/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                    ruleForm = res.data;
                    laoshiShowImg();
                    laoshiShowVideo();
                    laoshiDataBind();
                }
            });
        }
        function yonghuSelect() {
            //填充下拉框选项
            http("yonghu/page?page=1&limit=100&sort=&order=", "GET", {}, (res) => {
                if(res.code == 0){
                    yonghuOptions = res.data.list;
                }
            });
        }

        function yonghuSelectOne(id) {
            http("yonghu/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                    ruleForm = res.data;
                    yonghuShowImg();
                    yonghuShowVideo();
                    yonghuDataBind();
                }
            });
        }
        function zuoyeSelect() {
            //填充下拉框选项
            http("zuoye/page?page=1&limit=100&sort=&order=", "GET", {}, (res) => {
                if(res.code == 0){
                    zuoyeOptions = res.data.list;
                }
            });
        }

        function zuoyeSelectOne(id) {
            http("zuoye/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                    ruleForm = res.data;
                    zuoyeShowImg();
                    zuoyeShowVideo();
                    zuoyeDataBind();
                }
            });
        }



    // 初始化下拉框
    <!-- 初始化当前表的下拉框 -->
        function initializationZuoyeTijiaoYesnoTypesSelect(){
            var zuoyeTijiaoYesnoTypesSelect = document.getElementById('zuoyeTijiaoYesnoTypesSelect');
            if(zuoyeTijiaoYesnoTypesSelect != null && zuoyeTijiaoYesnoTypesOptions != null  && zuoyeTijiaoYesnoTypesOptions.length > 0 ){
                zuoyeTijiaoYesnoTypesSelect.options.length=0;
                for (var i = 0; i < zuoyeTijiaoYesnoTypesOptions.length; i++) {
                    zuoyeTijiaoYesnoTypesSelect.add(new Option(zuoyeTijiaoYesnoTypesOptions[i].indexName,zuoyeTijiaoYesnoTypesOptions[i].codeIndex));
                }
            }
        }

        function initializationlaoshiSelect() {
            var laoshiSelect = document.getElementById('laoshiSelect');
            if(laoshiSelect != null && laoshiOptions != null  && laoshiOptions.length > 0 ) {
                for (var i = 0; i < laoshiOptions.length; i++) {
                        laoshiSelect.add(new Option(laoshiOptions[i].laoshiName, laoshiOptions[i].id));
                }

                $("#laoshiSelect").change(function(e) {
                        laoshiSelectOne(e.target.value);
                });
            }

        }

        function initializationyonghuSelect() {
            var yonghuSelect = document.getElementById('yonghuSelect');
            if(yonghuSelect != null && yonghuOptions != null  && yonghuOptions.length > 0 ) {
                for (var i = 0; i < yonghuOptions.length; i++) {
                        yonghuSelect.add(new Option(yonghuOptions[i].yonghuName, yonghuOptions[i].id));
                }

                $("#yonghuSelect").change(function(e) {
                        yonghuSelectOne(e.target.value);
                });
            }

        }

        function initializationzuoyeSelect() {
            var zuoyeSelect = document.getElementById('zuoyeSelect');
            if(zuoyeSelect != null && zuoyeOptions != null  && zuoyeOptions.length > 0 ) {
                for (var i = 0; i < zuoyeOptions.length; i++) {
                        zuoyeSelect.add(new Option(zuoyeOptions[i].zuoyeName, zuoyeOptions[i].id));
                }

                $("#zuoyeSelect").change(function(e) {
                        zuoyeSelectOne(e.target.value);
                });
            }

        }



    // 下拉框选项回显
    function setSelectOption() {

        <!-- 当前表的下拉框回显 -->
        var zuoyeTijiaoYesnoTypesSelect = document.getElementById("zuoyeTijiaoYesnoTypesSelect");
        if(zuoyeTijiaoYesnoTypesSelect != null && zuoyeTijiaoYesnoTypesOptions != null  && zuoyeTijiaoYesnoTypesOptions.length > 0 ) {
            for (var i = 0; i < zuoyeTijiaoYesnoTypesOptions.length; i++) {
                if (zuoyeTijiaoYesnoTypesOptions[i].codeIndex == ruleForm.zuoyeTijiaoYesnoTypes) {//下拉框value对比,如果一致就赋值汉字
                        zuoyeTijiaoYesnoTypesSelect.options[i].selected = true;
                }
            }
        }
        <!--  级联表的下拉框回显  -->
            var laoshiSelect = document.getElementById("laoshiSelect");
            if(laoshiSelect != null && laoshiOptions != null  && laoshiOptions.length > 0 ) {
                for (var i = 0; i < laoshiOptions.length; i++) {
                    if (laoshiOptions[i].id == ruleForm.laoshiId) {//下拉框value对比,如果一致就赋值汉字
                        laoshiSelect.options[i+1].selected = true;
                        $("#laoshiSelect" ).selectpicker('refresh');
                    }
                }
            }
            var yonghuSelect = document.getElementById("yonghuSelect");
            if(yonghuSelect != null && yonghuOptions != null  && yonghuOptions.length > 0 ) {
                for (var i = 0; i < yonghuOptions.length; i++) {
                    if (yonghuOptions[i].id == ruleForm.yonghuId) {//下拉框value对比,如果一致就赋值汉字
                        yonghuSelect.options[i+1].selected = true;
                        $("#yonghuSelect" ).selectpicker('refresh');
                    }
                }
            }
            var zuoyeSelect = document.getElementById("zuoyeSelect");
            if(zuoyeSelect != null && zuoyeOptions != null  && zuoyeOptions.length > 0 ) {
                for (var i = 0; i < zuoyeOptions.length; i++) {
                    if (zuoyeOptions[i].id == ruleForm.zuoyeId) {//下拉框value对比,如果一致就赋值汉字
                        zuoyeSelect.options[i+1].selected = true;
                        $("#zuoyeSelect" ).selectpicker('refresh');
                    }
                }
            }
    }


    // 填充富文本框
    function setContent() {

        <!-- 当前表的填充富文本框 -->
    }
    // 获取富文本框内容
    function getContent() {
        <!-- 获取当前表的富文本框内容 -->
    }
    function jiaofei() {
        window.location.href = "../../pay.jsp";
    }
    function exit() {
        window.sessionStorage.removeItem("updateId");
        window.sessionStorage.removeItem('addzuoyeTijiao');
        window.location.href = "list.jsp";
    }
    // 表单校验
    function validform() {
        return $("#addOrUpdateForm").validate({
            rules: {
                zuoyeTijiaoUuidNumber: "required",
                zuoyeId: "required",
                laoshiId: "required",
                yonghuId: "required",
                zuoyeTijiaoText: "required",
                zuoyeShangchuanFile: "required",
                zuoyeTijiaoYesnoTypes: "required",
                zuoyeTijiaoPigai: "required",
            },
            messages: {
                zuoyeTijiaoUuidNumber: "报名唯一编号不能为空",
                zuoyeId: "作业不能为空",
                laoshiId: "老师不能为空",
                yonghuId: "用户不能为空",
                zuoyeTijiaoText: "内容不能为空",
                zuoyeShangchuanFile: "作业上传不能为空",
                zuoyeTijiaoYesnoTypes: "提交状态不能为空",
                zuoyeTijiaoPigai: "批改分数不能为空",
            }
        }).form();
    }

    // 获取当前详情
    function getDetails() {
        var addzuoyeTijiao = window.sessionStorage.getItem("addzuoyeTijiao");
        if (addzuoyeTijiao != null && addzuoyeTijiao != "" && addzuoyeTijiao != "null") {
            //注册表单验证
            $(validform());
            $("#zuoyeTijiaoUuidNumber").val(new Date().getTime()+Math.ceil(Math.random()*10));//设置唯一号
                $(".zuoyeTijiaoYesnoTypesDiv").remove();
                $(".zuoyeTijiaoYesnoTextDiv").remove();

            $('#submitBtn').text('新增');

        } else {
            $('#submitBtn').text('修改');
            if(window.sessionStorage.getItem('accountTableName') =='zuoyeTijiao'){
                updateId = window.sessionStorage.getItem('userId');//登录用户查看自己的信息
            }else{
                updateId = window.sessionStorage.getItem('updateId');//获取修改传过来的id
            }
            window.sessionStorage.removeItem('updateId');
            http("zuoyeTijiao/info/" + updateId, "GET", {}, (res) => {
                if(res.code == 0)
                {
                    ruleForm = res.data
                    // 是/否下拉框回显
                    setSelectOption();
                    // 设置图片src
                    showImg();
                    // 设置视频src
                    showVideo();
                    // 数据填充
                    dataBind();
                    // 富文本框回显
                    setContent();
                    //注册表单验证
                    $(validform());
                }

            });
        }
    }

    // 清除可能会重复渲染的selection
    function clear(className) {
        var elements = document.getElementsByClassName(className);
        for (var i = elements.length - 1; i >= 0; i--) {
            elements[i].parentNode.removeChild(elements[i]);
        }
    }

    function dateTimePick() {

    }


    function dataBind() {


    <!--  级联表的数据回显  -->
        laoshiDataBind();
        yonghuDataBind();
        zuoyeDataBind();


    <!--  当前表的数据回显  -->
        $("#updateId").val(ruleForm.id);
        $("#zuoyeTijiaoUuidNumber").val(ruleForm.zuoyeTijiaoUuidNumber);
        $("#zuoyeId").val(ruleForm.zuoyeId);
        $("#laoshiId").val(ruleForm.laoshiId);
        $("#yonghuId").val(ruleForm.yonghuId);
        $("#zuoyeTijiaoText").val(ruleForm.zuoyeTijiaoText);
        $("#zuoyeTijiaoPigai").val(ruleForm.zuoyeTijiaoPigai);

    }
    <!--  级联表的数据回显  -->
    function laoshiDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#laoshiId").val(ruleForm.id);

        $("#laoshiName").val(ruleForm.laoshiName);
        $("#laoshiPhone").val(ruleForm.laoshiPhone);
        $("#laoshiIdNumber").val(ruleForm.laoshiIdNumber);
        $("#laoshiEmail").val(ruleForm.laoshiEmail);
    }

    function yonghuDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#yonghuId").val(ruleForm.id);

        $("#yonghuName").val(ruleForm.yonghuName);
        $("#yonghuPhone").val(ruleForm.yonghuPhone);
        $("#yonghuIdNumber").val(ruleForm.yonghuIdNumber);
        $("#yonghuValue").val(ruleForm.yonghuValue);
        $("#yonghuEmail").val(ruleForm.yonghuEmail);
    }

    function zuoyeDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#zuoyeId").val(ruleForm.id);

        $("#laoshiId").val(ruleForm.laoshiId);
        $("#zuoyeName").val(ruleForm.zuoyeName);
        $("#zuoyeUuidNumber").val(ruleForm.zuoyeUuidNumber);
        $("#zuoyeValue").val(ruleForm.zuoyeValue);
        $("#zuoyeContent").val(ruleForm.zuoyeContent);
    }


    //图片显示
    function showImg() {
        <!--  当前表的图片  -->

        <!--  级联表的图片  -->
        laoshiShowImg();
        yonghuShowImg();
        zuoyeShowImg();
    }


    <!--  级联表的图片  -->

    function laoshiShowImg() {
        $("#laoshiPhotoImg").attr("src",baseUrl+ruleForm.laoshiPhoto);
    }


    function yonghuShowImg() {
        $("#yonghuPhotoImg").attr("src",baseUrl+ruleForm.yonghuPhoto);
    }


    function zuoyeShowImg() {
        $("#zuoyePhotoImg").attr("src",baseUrl+ruleForm.zuoyePhoto);
    }



    //视频回显
    function showVideo() {
    <!--  当前表的视频  -->

    <!--  级联表的视频  -->
        laoshiShowVideo();
        yonghuShowVideo();
        zuoyeShowVideo();
    }


    <!--  级联表的视频  -->

    function laoshiShowVideo() {
        $("#laoshiPhotoV").attr("src",baseUrl+ruleForm.laoshiPhoto);
    }

    function yonghuShowVideo() {
        $("#yonghuPhotoV").attr("src",baseUrl+ruleForm.yonghuPhoto);
    }

    function zuoyeShowVideo() {
        $("#zuoyePhotoV").attr("src",baseUrl+ruleForm.zuoyePhoto);
    }



    $(document).ready(function () {
        //设置右上角用户名
        $('.dropdown-menu h5').html(window.sessionStorage.getItem('username'))
        //设置项目名
        $('.sidebar-header h3 a').html(projectName)
        //设置导航栏菜单
        setMenu();
        $('#exitBtn').on('click', function (e) {
            e.preventDefault();
            exit();
        });
        //初始化时间插件
        dateTimePick();
        //查询所有下拉框
            <!--  当前表的下拉框  -->
            zuoyeTijiaoYesnoTypesSelect();

            <!-- 查询级联表的下拉框(用id做option,用名字及其他参数做名字级联修改) -->
            laoshiSelect();
            yonghuSelect();
            zuoyeSelect();



        // 初始化下拉框
            <!--  初始化当前表的下拉框  -->
            initializationZuoyeTijiaoYesnoTypesSelect();
            <!--  初始化级联表的下拉框  -->
            initializationlaoshiSelect();
            initializationyonghuSelect();
            initializationzuoyeSelect();

        $(".selectpicker" ).selectpicker('refresh');
        getDetails();
        //初始化上传按钮
        upload();
    <%@ include file="../../static/myInfo.js"%>
                $('#submitBtn').on('click', function (e) {
                    e.preventDefault();
                    //console.log("点击了...提交按钮");
                    submit();
                });
        readonly();
        window.sessionStorage.removeItem('addzuoyeTijiao');
    });

    function readonly() {
        if (window.sessionStorage.getItem('role') == '管理员') {
            //$('#jifen').attr('readonly', 'readonly');
            //$('#role').attr('style', 'pointer-events:none;width:450px;');
        }
		else if (window.sessionStorage.getItem('role') == '用户') {
            // $(".aaaaaa").remove();
            $(".yonghu").remove();//删除当前用户的信息
        }
		else if (window.sessionStorage.getItem('role') == '任课老师') {
            // $(".aaaaaa").remove();
            $(".laoshi").remove();//删除当前用户的信息
        }
        else{
            // alert("未知情况.......");
            // var replyTextUeditor = UE.getEditor('replyTextEditor');
            // replyTextUeditor.ready(function () {
            //     replyTextUeditor.setDisabled('fullscreen');
            // });
        }
    }


        layui.use(['layer' , 'jquery' , 'laydate'], function() {
            var layer = layui.layer;
            var jquery = layui.jquery;
            var laydate = layui.laydate;

        var insertTime = laydate.render({
            elem: '#insertTime-input'
            ,type: 'datetime'
        });
			// layui.layer.msg("输入不合法", {time: 2000,icon: 5});
			//    5失败 6成功
        });


        //比较大小
        function compare() {
            var largerVal = null;
            var smallerVal = null;
            if (largerVal != null && smallerVal != null) {
                if (largerVal <= smallerVal) {
                    alert(smallerName + '不能大于等于' + largerName);
                    return false;
                }
            }
            return true;
        }
    // 用户登出
    <%@ include file="../../static/logout.jsp"%>
</script>
</body>

</html>
