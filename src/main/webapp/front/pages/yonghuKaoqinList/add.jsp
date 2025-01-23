<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>学生考勤详情添加</title>
    <!-- bootstrap样式，地图插件使用 -->
    <link rel="stylesheet" href="../../css/bootstrap.min.css" />
    <link rel="stylesheet" href="../../layui/css/layui.css">
    <!-- 样式 -->
    <link rel="stylesheet" href="../../css/style.css" />
    <!-- 主题（主要颜色设置） -->
    <link rel="stylesheet" href="../../css/theme.css" />
    <!-- 通用的css -->
    <link rel="stylesheet" href="../../css/common.css" />
</head>
<style>
    html::after {
        position: fixed;
        top: 0;
        right: 0;
        left: 0;
        bottom: 0;
        content: '';
        display: block;
        background-attachment: fixed;
        background-size: cover;
        background-position: center;
        z-index: -1;
    }
    #swiper {
        overflow: hidden;
        margin: 0 auto;
    }
    #swiper .layui-carousel-ind li {
        width: 20px;
        height: 10px;
        border-width: 0;
        border-style: solid;
        border-color: rgba(0,0,0,.3);
        border-radius: 6px;
        background-color: #f7f7f7;
        box-shadow: 0 0 6px rgba(255,0,0,.8);
    }
    #swiper .layui-carousel-ind li.layui-this {
        width: 30px;
        height: 10px;
        border-width: 0;
        border-style: solid;
        border-color: rgba(0,0,0,.3);
        border-radius: 6px;
    }

    button, button:focus {
        outline: none;
    }

    .data-add-container .add .layui-select-title .layui-unselect {
        padding: 0 12px;
        height: 40px;
        font-size: 15px;
        border-radius: 4px;
        border-width: 1px;
        border-style: solid;
        text-align: center;
    }
    .data-add-container .add .layui-form-item {
        display: flex;
        align-items: center;
        justify-content: center;
    }
    .data-add-container .layui-form-pane .layui-form-item[pane] .layui-form-label {
        margin: 0;
        position: inherit;
        background: transparent;
        border: 0;
    }
    .data-add-container .add .layui-input-block {
        margin: 0;
        flex: 1;
    }
    .data-add-container .layui-form-pane .layui-form-item[pane] .layui-input-inline {
        margin: 0;
        flex: 1;
        display: flex;
    }
</style>
<body style="background: #fff; ">
    <div id="app">
        <div class="data-add-container  sub_borderColor" :style='{"padding":"20px","margin":"30px auto","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"10px","borderWidth":"1px","borderStyle":"solid"}'>

            <form class="layui-form layui-form-pane add" lay-filter="myForm">
                <!-- 级联表 学生 -->
                <!--<div class="layui-form-item main_borderColor" :style='{"padding":"10px","boxShadow":"0 0 0px rgba(255,0,0,.8)","margin":"0 0 10px 0","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"1px","borderWidth":"0 0 1px 0","borderStyle":"solid"}'>
                    <label  :style='{"width":"auto","borderColor": "rgba(255, 255, 255, 0)","padding":"0 12px 0 0","backgroundColor":"rgba(255, 255, 255, 0)","fontSize":"15px","color":"#333","textAlign":"left"}' class="layui-form-label">
                        学生：
                    </label>
                    <div class="layui-input-block">
                        <select name="yonghuId" id="yonghuId" lay-filter="yonghuId">
                            <option value="">请选择</option>
                            <option v-for="(item,index) in yonghuList" v-bind:key="index" :value="item.id" :selected="detail.yonghuId == item.id?true:false" :key="item.id">{{ item.yonghuName }}</option>
                        </select>
                    </div>
                </div>-->
                <!-- 级联表 考勤 -->
                <div class="layui-form-item main_borderColor" :style='{"padding":"10px","boxShadow":"0 0 0px rgba(255,0,0,.8)","margin":"0 0 10px 0","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"1px","borderWidth":"0 0 1px 0","borderStyle":"solid"}'>
                    <label  :style='{"width":"auto","borderColor": "rgba(255, 255, 255, 0)","padding":"0 12px 0 0","backgroundColor":"rgba(255, 255, 255, 0)","fontSize":"15px","color":"#333","textAlign":"left"}' class="layui-form-label">
                        考勤：
                    </label>
                    <div class="layui-input-block">
                        <select name="yonghuKaoqinId" id="yonghuKaoqinId" lay-filter="yonghuKaoqinId">
                            <option value="">请选择</option>
                            <option v-for="(item,index) in yonghuKaoqinList" v-bind:key="index" :value="item.id" :selected="detail.yonghuKaoqinId == item.id?true:false" :key="item.id">{{ item.yonghuKaoqinName }}</option>
                        </select>
                    </div>
                </div>
    <!-- 当前表的 -->
                <!-- 级联表的表id -->
                <input type="hidden" :value="detail.yonghuId" id="yonghuId" name="yonghuId"/>
                <!-- 级联表的表id -->
<%--                <input type="hidden" :value="detail.yonghuKaoqinId" id="yonghuKaoqinId" name="yonghuKaoqinId"/>--%>
                <div class="layui-form-item main_borderColor" :style='{"padding":"10px","boxShadow":"0 0 0px rgba(255,0,0,.8)","margin":"0 0 10px 0","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"1px","borderWidth":"0 0 1px 0","borderStyle":"solid"}'>
                    <label  :style='{"width":"auto","borderColor": "rgba(255, 255, 255, 0)","padding":"0 12px 0 0","backgroundColor":"rgba(255, 255, 255, 0)","fontSize":"15px","color":"#333","textAlign":"left"}' class="layui-form-label">
                        打卡状态：
                    </label>
                    <div class="layui-input-block">
                        <select name="yonghuKaoqinListTypes" id="yonghuKaoqinListTypes" lay-filter="yonghuKaoqinListTypes">
                            <option value="">请选择</option>
                            <option v-for="(item,index) in yonghuKaoqinListTypesList" v-bind:key="index" :value="item.codeIndex" :selected="detail.yonghuKaoqinListTypes == item.codeIndex?true:false" :key="item.codeIndex">{{ item.indexName }}</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item main_borderColor" :style='{"padding":"10px","boxShadow":"0 0 0px rgba(255,0,0,.8)","margin":"0 0 10px 0","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"1px","borderWidth":"0 0 1px 0","borderStyle":"solid"}'>
                    <div class="layui-input-block" style="text-align: right;">
                        <button :style='{"padding":"0 10px","boxShadow":"0 0 0px rgba(255,0,0,.5)","margin":"0 10px","borderColor":"#ccc","backgroundColor":"rgba(75, 92, 196, 1)","color":"#fff","borderRadius":"8px","borderWidth":"0","width":"25%","fontSize":"14px","borderStyle":"solid","height":"44px"}' class="layui-btn btn-submit" lay-submit lay-filter="thisSubmit">提交</button>
                    </div>
                </div>

            </form>
        </div>
    </div>

    <script src="../../layui/layui.js"></script>
    <script src="../../js/vue.js"></script>
    <!-- 引入element组件库 -->
    <script src="../../xznstatic/js/element.min.js"></script>
    <!-- 引入element样式 -->
    <link rel="stylesheet" href="../../xznstatic/css/element.min.css">
    <!-- 组件配置信息 -->
    <script src="../../js/config.js"></script>
    <!-- 扩展插件配置信息 -->
    <script src="../../modules/config.js"></script>
    <!-- 工具方法 -->
    <script src="../../js/utils.js"></script>
    <!-- 校验格式工具类 -->
    <script src="../../js/validate.js"></script>
    <!-- 地图 -->
    <script type="text/javascript" src="../../js/jquery.js"></script>
    <script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=ca04cee7ac952691aa67a131e6f0cee0"></script>
    <script type="text/javascript" src="../../js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../../js/bootstrap.AMapPositionPicker.js"></script>

    <script>
        var jquery = $;

        var vue = new Vue({
            el: '#app',
            data: {
                //项目路径
                baseUrl:"",
                dataList: [],
                ro:{
                    yonghuId: false,
                    yonghuKaoqinId: false,
                    yonghuKaoqinListTypes: false,
                    insertTime: false,
                    updateTime: false,
                    createTime: false,
                },
                detail: {
                    yonghuId: '',
                    yonghuKaoqinId: '',
                    yonghuKaoqinListTypes: '',//数字
                    yonghuKaoqinListValue: '',//数字对应的值
                    insertTime: '',
                    updateTime: '',
                    createTime: '',
                },
                yonghuList:[],//级联表列表 学生
                yonghu: {},//级联表单个 学生
                yonghuKaoqinList:[],//级联表列表 考勤
                yonghuKaoqin: {},//级联表单个 考勤

                // 下拉框
                yonghuKaoqinListTypesList: [],

                centerMenu: centerMenu
            },
            updated: function() {
                layui.form.render('select', 'myForm');
            },
            computed: {
            },
            methods: {
                jump(url) {
                    jump(url)
                }
            }
        })


        layui.use(['layer', 'element', 'carousel', 'http', 'jquery', 'form', 'upload', 'laydate','tinymce'], function() {
            var layer = layui.layer;
            var element = layui.element;
            var carousel = layui.carousel;
            var http = layui.http;
            var jquery = layui.jquery;
            var form = layui.form;
            var upload = layui.upload;
            var laydate = layui.laydate;
            var tinymce = layui.tinymce;
            vue.baseUrl = http.baseurl

            localStorage.setItem("goUtl","./pages/yonghuKaoqinList/list.jsp")

            //var yonghuId = http.getParam('yonghuId');
            let yonghuId = localStorage.getItem("yonghuId")
            if(yonghuId != null && yonghuId != ""){
                //单个 学生查询
                initializationYonghu(yonghuId);
            }
            //列表 学生查询
            initializationYonghuList();
            //var yonghuKaoqinId = http.getParam('yonghuKaoqinId');
            let yonghuKaoqinId = localStorage.getItem("yonghuKaoqinId")
            if(yonghuKaoqinId != null && yonghuKaoqinId != ""){
                //单个 考勤查询
                initializationYonghuKaoqin(yonghuKaoqinId);
            }
            //列表 考勤查询
            initializationYonghuKaoqinList();
            // 下拉框
            // 打卡状态的查询和初始化
            yonghuKaoqinListTypesSelect();

           // 上传文件
            // 日期效验规则及格式
            dateTimePick();
            // 表单效验规则
            form.verify({
                // 正整数效验规则
                integer: [
                    /^[1-9][0-9]*$/
                    ,'必须是正整数'
                ]
                // 小数效验规则
                ,double: [
                    /^[1-9][0-9]{0,5}(\.[0-9]{1,2})?$/
                    ,'最大整数位为6为,小数最大两位'
                ]
            });

            // session独取
            let table = localStorage.getItem("userTable");
            http.request(table+"/session", 'get', {}, function (data) {
                // 表单赋值
                //form.val("myForm", data.data);
                // data = data.data;
                for (var key in data) {
                    vue.detail[table+"Id"] = data.id
                }
            });

            //修改
            if(http.getParam('yonghuKaoqinListId')){
                http.request(`yonghuKaoqinList/info/${http.getParam('yonghuKaoqinListId')}`, 'get', {}, function(data) {
                    vue.detail = data.data
                });
            }

            // 提交
            form.on('submit(thisSubmit)', function (data) {
                data = data.field;
                data["yonghuId"]= localStorage.getItem("userid");
                if(http.getParam('yonghuKaoqinListId')){
                    data["id"]= http.getParam('yonghuKaoqinListId')
                }
                // 提交数据
                http.requestJson(`yonghuKaoqinList/${http.getParam("yonghuKaoqinListId")?"update":"add"}`, 'post', data, function (res) {
                    if(res.code == 0){
                        layer.msg('提交成功', {
                            time: 2000,
                            icon: 6
                        }, function () {
                            vue.jump("../yonghuKaoqinList/list.jsp");
                                http.remove('yonghuKaoqinListId')
                            // back();
                        });
                    }else{
                        layer.msg(res.msg, {
                            time: 5000,
                            icon: 5
                        });
                    }
                });
                return false
            });

        });
        // 日期框初始化
        function dateTimePick(){
            var myDate = new Date();  //获取当前时间
            /*
                ,change: function(value, date, endDate){
                    value       得到日期生成的值，如：2017-08-18
                    date        得到日期时间对象：{year: 2017, month: 8, date: 18, hours: 0, minutes: 0, seconds: 0}
                    endDate     得结束的日期时间对象，开启范围选择（range: true）才会返回。对象成员同上。
            */
            // 打卡时间的开始时间和结束时间的效验及格式
            var updateTime = layui.laydate.render({
                elem: '#updateTime'
	            ,type: 'datetime'
                ,btns: ['clear', 'confirm']
                ,min:myDate.toLocaleString()
                ,change: function(value, date, endDate){
                    vue.detail.updateTime = value;
                }
            });
        }




       // 打卡状态的查询
       function yonghuKaoqinListTypesSelect() {
           //填充下拉框选项
           layui.http.request("dictionary/page?page=1&limit=100&sort=&order=&dicCode=yonghu_kaoqin_list_types", "GET", {}, (res) => {
               if(res.code == 0){
                   vue.yonghuKaoqinListTypesList = res.data.list;
               }
           });
       }



        //单个 学生查询
        function initializationYonghu(id){
            layui.http.request("yonghu/detail/" + id, 'get', {}, function (res) {
                if(res.code ==0){
                    vue.yonghu = res.data;
                    vue.detail.yonghuId=vue.yonghu.id//赋值给detail
                }
            });
        }
        //列表 学生查询
        function initializationYonghuList(){
            layui.http.request("yonghu/page?page=1&limit=100&sort=&order=", 'get', {}, function (res) {
                if(res.code ==0){
                    vue.yonghuList = res.data.list;
                }
            });
        }
        //单个 考勤查询
        function initializationYonghuKaoqin(id){
            layui.http.request("yonghuKaoqin/detail/" + id, 'get', {}, function (res) {
                if(res.code ==0){
                    vue.yonghuKaoqin = res.data;
                    vue.detail.yonghuKaoqinId=vue.yonghuKaoqin.id//赋值给detail
                }
            });
        }
        //列表 考勤查询
        function initializationYonghuKaoqinList(){
            layui.http.request("yonghuKaoqin/page?page=1&limit=100&sort=&order=", 'get', {}, function (res) {
                if(res.code ==0){
                    vue.yonghuKaoqinList = res.data.list;
                }
            });
        }
    </script>
</body>
</html>
