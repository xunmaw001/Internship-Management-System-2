<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="true" %>
<!-- 个人中心 -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>确认报名</title>
    <link rel="stylesheet" href="../../layui/css/layui.css">
    <!-- 样式 -->
    <link rel="stylesheet" href="../../css/style.css" />
    <!-- 主题（主要颜色设置） -->
    <link rel="stylesheet" href="../../css/theme.css" />
    <!-- 通用的css -->
    <link rel="stylesheet" href="../../css/common.css" />
</head>
<style>
    img{ max-width: 100%;}
    .page-order-comfirm{ width: 1200px; margin: 0 auto;}

    .section-con{ background:#FFFFFF; padding:10px 30px; color:#363636; margin-bottom:20px;}
    .sec-title-border{ border-bottom:1px solid #f5f5f5; margin-bottom:20px; height:32px;}
    .sec-title-border h3{ color:#373737; font-size:16px; line-height:2; margin:0; font-weight:600; display:inline;}
    .sec-title-border a.right{ float:right; color:#5b5b5b; padding-right:10px; padding-top:8px; text-decoration:none;}
    .sec-title-border a:hover{ text-decoration:underline;}
    .sec-title-border span{ margin-left:20px; display:inline; color:#bcbcbc;  }
    .sec-title-noborder{border-bottom:none;}
    .mark{ color: #f00;}
    .addressAddBox{padding:0 3px;}
    .div-form-gw{margin-bottom:10px;}
    .addr-add-form .div-form-gw label{ display:block; margin-bottom:5px;}
    .input-gw{ background:#f3f3f3; padding:8px; border:none;}
    .input-gw220{ width:220px;}
    .input-gw150{ width:153px;}
    .input-gw480{ width:480px;}
    .div-three .div-three-item{ float:left; margin-right:10px;}
    .div-half .div-half-item{ float:left; margin-right:24px;}
    .btn-gray-gw{ background:#f3f3f3; border:1px solid #dddddd; color:#363636; border-radius:3px; -moz-border-radius:3px; -webkit-border-radius:3px; padding:7px 12px; }
    .btn-gray-gw:hover{ background-color:#f9f9f9;}
    .addressBox{margin-bottom:15px; margin-left: -7px; margin-right: -7px;}
    .addressBox .address-item{ float:left; width:50%;line-height:2; color:#848383; cursor:pointer;}
    .addressBox .address-item:nth-child(2n+1){ clear: both;}
    .addressBox .address-item .address-item-in{ padding:15px 60px 15px 30px;margin:0 7px 15px 7px;border:2px solid #c5c5c5; position: relative;}
    /*.addressBox .address-item.selected .address-item-in{ border-color:var(--publicSubColor);}*/
    .addressBox .address-item .delete{ display:none;position: absolute; right: 15px; top:15px;}
    .addressBox .address-item .delete .icon_delete{ display: block; width: 18px; height: 18px;background: url(../images/delete.png) no-repeat center;}
    .addressBox .address-item:hover .delete{ display: block;}
    .style-list ul,.style-list li{ list-style:none;}
    .style-list li{ float:left; cursor:pointer; padding:8px 40px; border:1px solid #c5c5c5; margin-right:35px; font-size:110%; text-align:center;  }
    .addressBox .address-item .selected{border-color:var(--publicSubColor);}
    .style-list li.selected{border-color:var(--publicSubColor);}
    .delivery,.pay{ margin-bottom:50px;}
    .orderC-tb{margin-bottom:12px;line-height:1.8;}
    .orderC-tb,.orderC-tb a{color:#3e3e3e;}
    .orderC-tb a:hover{ color:#000;}
    .orderC-tb th{ background:#F5F5F5;  padding:6px 8px; text-align:center; font-weight:normal;}
    .orderC-tb td{  text-align:center; border-bottom:1px solid #f5f5f5;}
    .orderC-tb th.text-left,.orderC-tb td.text-left{text-align:left;}
    .orderC-tb th.text-right,.orderC-tb td.text-right{text-align:right;}
    .orderC-tb-border{ border:1px solid #cccccc;}
    .orderC-tb-border td{ border:1px solid #dddddd; border-top:0; padding:0;}
    .orderC-tb .check_td{ padding:0 0 0 10px; text-align:left;}
    .order-gw{padding:15px 8px;}
    .order-gw .order-img{width:60px; height:60px; border:1px solid #cccccc; float:left;}
    .order-gw .order-img img{width: 100%; height: 100%;}
    .order-gw .order-sum{ margin-left:80px;}
    .order-gw .order-sum h2{ font-size:14px; font-weight:normal; margin:0;margin-top: 20px}
    .order-gw .order-sum p{line-height:1.2;}
    .orderC-tb-border td .order-gw{border-bottom:1px solid #dddddd;}
    .orderC-tb-border td .order-gw:last-child{ border-bottom:0;}
    .orderC-tb .paymonney{border-bottom:1px solid #f5f5f5;}
    .orderC-tb .paymonney,.orderC-tb .payway,.orderC-tb .payStatue-tb,.orderC-tb .time{color:#c6c6c6;}
    .orderC-tb .timeA{padding-right:40px;}
    .orderC-total{ float:right; padding:23px 20px 0 0; font-size:115%;}
    .orderC-total>div{ padding-bottom:15px; }
    .orderC-total .order-t,.orderC-total .order-fare{ color:#a2a2a2;}
    .orderC-total .order-sum{color:var(--publicSubColor);}
    .orderC-total .order-sum .fontBig{ font-size:130%; /*font-family:'微软雅黑',microsoft yahei;*/ font-weight:bold;}
    .orderC-total dl{display:table;}
    .orderC-total dl dd{display:table-cell;}
    .orderC-total dl .dl_ddL{  text-align:right; }
    .orderC-total dl .dl_ddR{  text-align:left; padding-left:35px;}
    .order-submit{ text-align:right; margin-top:30px; margin-bottom:40px;}
    .order-submit a{margin-right:20px;}
    .order-submit a.a_back{ color:#a2a2a2;}
    .order-submit a.a_back:hover{ color:#666;}
    .btn-red{display:inline-block; background:var(--publicSubColor); color:#fff !important; border-radius:3px; -moz-border-radius:3px; -webkit-border-radius:3px; text-decoration:none !important;}
    .btn-red:hover{ background-color:#E82D3A;}
    .order-submit a.btn-submit{padding:8px 30px; font-size:115%;margin-left: 900px}
    .select-gw{width:100%;text-align:left;background:#f3f3f3; border: 0; color:#363636;padding:8px 30px 8px 10px;}

    .delivery,.pay{ margin-bottom:50px;}
    .clearfix:after{ content:""; display:block; clear:both; height:0; visibility:hidden;}
    .clearfix{ zoom:1;}
</style>
<body>

<div id="app">
    <div style="height: 100px;width: 1140px;margin: 0 auto;">
        <h1 style="font-size: 30px;margin-top: 35px;float: left;width: 150px">确认下单 </h1>
        <el-steps :active="2" finish-status="success" simple style="margin-top: 20px;float: right;width: 500px">
            <el-step title="选实训方向" ></el-step>
            <el-step title="确认方向" ></el-step>
            <el-step title="完成报名" ></el-step>
        </el-steps>
    </div>

    <div class="page-order-comfirm">
        <div class="section-con">


            <div class="sec-title-border clearfix">
                <h3>列表详情</h3>
            </div>
            <div class="orderBox">
                <div class="orderC-table">
                    <table cellspacing="0" cellpadding="0" border="0" width="100%" class="orderC-tb">
                        <thead>
                        <tr>
                            <th width="30%">名称</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr v-for="(item,index) in dataList" v-bind:key="index">
                            <td class="text-left">
                                <div class="order-gw clearfix">
                                    <div class="order-img"><img :src="baseUrl+item.shixunPhoto"/></div>
                                    <div class="order-sum">
                                        <h2>{{item.shixunName}}</h2>
                                    </div>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>

<%--                    <div class="orderC-total" v-if="this.shixunOrderPaymentTypes == 1">--%>
<%--                        <div class="order-t">--%>
<%--                            <dl class="clearfix">--%>
<%--                                <dd class="dl_ddL">总&nbsp; &nbsp;价：</dd>--%>
<%--                                <dd class="dl_ddR">￥{{totalMoney.toFixed(2)}}</dd>--%>
<%--                            </dl>--%>
<%--                        </div>--%>
<%--                        <div class="order-sum">--%>
<%--                            <dl class="clearfix">--%>
<%--                                <dd class="dl_ddL">实付总额：</dd>--%>
<%--                                <dd class="dl_ddR"><span class="fontBig">￥{{(totalMoney * zhekou).toFixed(2)}}</span></dd>--%>
<%--                            </dl>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="orderC-total" v-if="this.shixunOrderPaymentTypes == 2">--%>
<%--                        <div class="order-t">--%>
<%--                            <dl class="clearfix">--%>
<%--                                <dd class="dl_ddL">总&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价：</dd>--%>
<%--                                <dd class="dl_ddR">{{totalMoney.toFixed(2)}}积分</dd>--%>
<%--                            </dl>--%>
<%--                        </div>--%>
<%--                       <!-- <div class="order-sum">--%>
<%--                            <dl class="clearfix">--%>
<%--                                <dd class="dl_ddL">实付总额：</dd>--%>
<%--                                <dd class="dl_ddR"><span class="fontBig">{{(totalMoney * zhekou).toFixed(2)}}积分</span></dd>--%>
<%--                            </dl>--%>
<%--                        </div>-->--%>
<%--                    </div>--%>

                    <div class="order-submit" >
                        <a @click="payClick()" class="btn-red btn-submit">确定报名</a>
                    </div>

                </div>
            </div>
        </div>
    </div>


</div>

		<!-- layui -->
		<script src="../../layui/layui.js"></script>
		<!-- vue -->
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

		<script>
            var vue = new Vue({
                el: '#app',
                data: {
                    //项目路径
                    baseUrl:"",
                    dataList: [],
                    shixunOrderTime:new Date(),
                    shixunOrderPaymentTypes: 1,
                    zhekou:1,
                    // 当前用户信息
                    user: {}
                },
                computed: {
                    totalMoney: function() {
                        var total = 0;
                        for (var item of this.dataList) {
                            total += item.shixunNewMoney * item.buyNumber
                        }
                        return total;
                    }
                },
                methods: {
                    jump(url) {
                        jump(url)
                    }
                    // 正常下单，生成订单，减少余额，添加积分，减少库存，修改状态已支付
                    ,payClick() {
                    let data={
                        buyNumber:JSON.parse(localStorage.getItem('shixuns'))[0].buyNumber,
                        shixunId:JSON.parse(localStorage.getItem('shixuns'))[0].shixunId,
                        shixuns:localStorage.getItem('shixuns'),
			            yonghuId: localStorage.getItem('userid'),
                    }
                        // 获取商品详情信息
                        layui.http.requestJson(`shixunOrder/add`, 'POST', data, (res) => {
                            if(res.code == 0){
                                layui.layer.msg('下单成功', {
                                    time: 2000,
                                    icon: 6
                                },function (){
                                    window.location.href='../shixunOrder/list.jsp';
                                });
                            }else{
                                layui.layer.msg(res.msg, {
                                    time: 2000,
                                    icon: 5
                                });
                            }
                        });
                    }
                }
            });

            layui.use(['layer', 'element', 'carousel', 'http', 'jquery', 'form', 'upload'], function() {
                var layer = layui.layer;
                var element = layui.element;
                var carousel = layui.carousel;
                var http = layui.http;
                var jquery = layui.jquery;
                var form = layui.form;
                var upload = layui.upload;
                vue.baseUrl = http.baseurl

                // 充值
                jquery('#btn-recharge').click(function(e) {
                    layer.open({
                        type: 2,
                        title: '用户充值',
                        area: ['900px', '600px'],
                        content: '../shop-recharge/recharge.jsp'
                    });
                });

                // 获取实训方向购买的清单列表
				var shixuns = localStorage.getItem('shixuns');
				// 转换成json类型，localstorage保存的是string数据
				vue.dataList = JSON.parse(shixuns);

                // 用户当前用户信息
                let table = localStorage.getItem("userTable");
                if (!table) {
                    layer.msg('请先登录', {
                        time: 2000,
                        icon: 5
                    }, function () {
                        window.parent.location.href = '../login/login.jsp';
                    });
                }
                http.request(`yonghu/session`, 'get', {}, function(data) {
                    vue.user = data.data;
                    // 用户当前用户折扣信息
                    http.request('dictionary/page', 'get', {
                        dicCode: "huiyuandengji_types",
                        dicName: "会员等级类型",
                        codeIndexStart: vue.user.huiyuandengjiTypes,
                        codeIndexEnd: vue.user.huiyuandengjiTypes,
                    }, function(res) {
                        if(res.data.list.length >0){
                            vue.zhekou = res.data.list[0].beizhu;
                        }
                    })
                });
            });
        </script>
	</body>
</html>
