<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>实训方向详情页</title>
    <link rel="stylesheet" href="../../layui/css/layui.css">
    <!-- 样式 -->
    <link rel="stylesheet" href="../../css/style.css"/>
    <!-- 主题（主要颜色设置） -->
    <link rel="stylesheet" href="../../css/theme.css"/>
    <!-- 通用的css -->
    <link rel="stylesheet" href="../../css/common.css"/>
    <link rel="stylesheet" href="../../xznstatic/css/bootstrap.min.css">
</head>
<style>
    .particulars {
        width: 90%;
        background-color: #fff;
        border-bottom: 1px dotted var(--publicMainColor);
        padding: 10px 0;
    }

    .dataExhibition {
        display: inline-block;
        width: 60%;
    }

    .displayBianhao {
        display: inline-block;
        width: auto;
    }

    .detail-tab .layui-tab-card>.layui-tab-title .layui-this{
        border: 2px dotted var(--publicMainColor);
        background-color: #fff;
        color: #000;
    }</style>
<body>

    <div id="app">
<div style="width: 1000px;margin: 10px auto;height: auto;">
    <div style="border: 1px  dotted var(--publicMainColor);border-radius: 15px;margin-top:25px;height: 50px;line-height: 50px;padding-left: 15px;display: flex;justify-content: space-between;align-items: center;padding-right: 15px;">
        <span>
            <a style="color: #000;" href="../home/home.jsp">
                首页
            </a>/
            <a>
                <cite style="color: #815476;">
                    {{title}}
                </cite>
            </a>
        </span>
    </div>
    <div style="display: flex;margin-top: 20px;">
        <!-- 详情介绍 -->
        <div style="width: 50%;height: auto;">
            <div class="particulars" style="text-align: center;font-size: 18px;">
                <span>{{title}}</span>
            </div>
                  <div v-if="detail.shixunUuidNumber" class="particulars">
                      <span class="displayBianhao">实训方向编号:</span>
                      <span class="dataExhibition"> {{detail.shixunUuidNumber}} </span>
                  </div>
                  <div v-if="detail.shixunTypes" class="particulars">
                      <span class="displayBianhao">实训方向类型:</span>
                      <span class="dataExhibition"> {{detail.shixunValue}} </span>
                  </div>
        </div>
        <!-- 图片 -->
        <div style="width: 50%;height: auto;">
            <div>
                <div v-if="swiperList.length" v-for="(item,index) in swiperList" :key="index">
                    <img style="width: 100%;height: 100%;object-fit:cover;" :src="baseUrl+item" />
                </div>
            </div>
        </div>
    </div>
    <!-- 按钮 -->
    <div style="width: 100%;">
        <div  style="display: flex;margin-top: 30px;justify-content: center;border-bottom:1px dotted var(--publicMainColor) ;border-top:1px dotted var(--publicMainColor) ;padding: 20px;align-items: center;">
<%--            <button style="height:auto;"--%>
<%--                    :style='{"padding":"0","boxShadow":"0 0 6px rgba(255,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,.3)","backgroundColor":"rgba(244, 121, 131, 1)","color":"#666","borderRadius":"4px 0 0 4px","borderWidth":"1px","width":"34px","lineHeight":"34px","fontSize":"14px","borderStyle":"solid"}'--%>
<%--                    type="button" @click="buyNumber>0?buyNumber--:buyNumber"--%>
<%--                    class="layui-btn layui-btn-primary">--%>
<%--                ---%>
<%--            </button>--%>
<%--            <input style="text-align:center;padding:10px 20px;width:300px;"--%>
<%--                   :style='{"padding":"0","boxShadow":"0 0 6px rgba(255,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,.3)","backgroundColor":"rgba(255, 242, 223, 1)","color":"rgba(255, 45, 81, 1)","borderRadius":"0","borderWidth":"1px 0","width":"44px","lineHeight":"34px","fontSize":"14px","borderStyle":"solid"}'--%>
<%--                   type="number" v-model="buyNumber" id="buyNumber" name="buyNumber" class="layui-input"--%>
<%--                   disabled="disabled" />--%>
<%--            <button style="height:auto;"--%>
<%--                    :style='{"padding":"0","boxShadow":"0 0 6px rgba(255,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,.3)","backgroundColor":"rgba(68, 206, 246, 1)","color":"#666","borderRadius":"0 4px 4px 0","borderWidth":"1px","width":"34px","lineHeight":"34px","fontSize":"14px","borderStyle":"solid"}'--%>
<%--                    type="button" @click="buyNumber++" class="layui-btn layui-btn-primary">--%>
<%--                +--%>
<%--            </button>--%>
            <button v-if="user.yonghuTypes==2" @click="addShixunOrder()" style="height:auto;"
                    :style='{"padding":"0 10px","boxShadow":"0 0 0px rgba(255,0,0,.3)","margin":"0 5px","borderColor":"rgba(0,0,0,.3)","backgroundColor":"rgba(23, 124, 176, 1)","color":"rgba(255, 255, 255, 1)","borderRadius":"6px","borderWidth":"0","width":"auto","lineHeight":"40px","fontSize":"16px","borderStyle":"solid"}'
                    type="button" class="layui-btn btn-submit">
                立即报名
            </button>
            <!--
             <button @click="shixunYuyue()" style="height:auto;" :style='{"padding":"0 10px","boxShadow":"0 0 0px rgba(255,0,0,.3)","margin":"0 5px","borderColor":"rgba(0,0,0,.3)","backgroundColor":"rgba(23, 124, 176, 1)","color":"rgba(255, 255, 255, 1)","borderRadius":"6px","borderWidth":"0","width":"auto","lineHeight":"40px","fontSize":"16px","borderStyle":"solid"}' type="button" class="layui-btn btn-submit">
                 立即预约
             </button>
        -->
        </div>
    </div>

    <!-- 视频 -->


    <!-- 评论 -->
    <div class="layui-row detail-tab" style="border: none;box-shadow: none;">
        <div class="layui-tab layui-tab-card" style="overflow: hidden;border: none; box-shadow: none;">
            <ul class="layui-tab-title " :style='{"backgroundColor":"#fff","fontSize":"14px"}' style="color: var(--publicMainColor);border: none;">
                <li class="layui-this">实训方向介绍</li>
                <li></li>
            </ul>

            <div class="layui-tab-content" style="border: 1px dotted var(--publicMainColor);border-radius: 15px;margin-top: 10px;margin-bottom: 50px;">
                <div class="layui-tab-item layui-show">
                    <div v-html="myFilters(detail.shixunContent)"></div>
                </div>
            </div>
        </div>
    </div>
</div>    </div>


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

    <script>
        Vue.prototype.myFilters= function (msg) {
            if(msg != null){
                return msg.replace(/\n/g, "<br>");
            }else{
                return "";
            }
        };
        var vue = new Vue({
            el: '#app',
            data: {
                //当前登录用户信息
                user:{},
                // 轮播图
                swiperList: [],//用于当前表的图片
                // 数据详情
                detail: {
                    id: 0
                },
                // 商品标题
                title: '',
                totalScore: 0,//评分
                baseUrl:"",//路径
                storeupFlag: 0,//收藏 [0为收藏 1已收藏]
                //系统推荐
                shixunRecommendList: [],
    <!-- 是订单并且非座位才有购物车 -->
                // 加入购物车数量
                buyNumber: 1,
                // 当前详情页表
                detailTable: 'shixun',
            },
            methods: {
                //分享
                share(){
                    let element = createElement("http://localhost:8080/shixunguanlixitong/front/index.jsp?url="+"./pages/shixun/detail.jsp?id="+this.id);
                    element.select();
                    element.setSelectionRange(0, element.value.length);
                    document.execCommand('copy');
                    element.remove();
                    layui.layer.msg('复制分享页面成功,快去分享吧!', {time: 2000,icon: 6});
                },

                jump(url) {
                    jump(url)
                },
                isAuth(tablename, button) {
                    return isFrontAuth(tablename, button)
                },
                //预约
                shixunYuyue(){
                    let _this = this;
                    // localStorage.setItem('shixunId', _this.detail.id);
                    // _this.jump("../shixunOrder/add.jsp");

                    let data={
                        shixunId:_this.detail.id,
                        yonghuId:localStorage.getItem("userid"),
                        shixunOrderYesnoTypes:1,
                    }
                    // 提交数据
                    layui.http.requestJson('shixunOrder/add', 'post', data, function (res) {
                        if(res.code == 0) {
                            layui.layer.msg('预约成功', {
                                time: 2000,
                                icon: 6
                            }, function () {
                                _this.jump("../shixunOrder/list.jsp");
                            });
                        }else{
                            layui.layer.msg(res.msg, {
                                time: 5000,
                                icon: 5
                            });
                        }
                    });
                },
                // 立即购买
                addShixunOrder() {
                                                                                                          // 库存限制
                    if (this.detail.shixunKucunNumber > 0 && this.detail.shixunKucunNumber < this.buyNumber) {
                        layui.layer.msg(`实训方向库存不足`, {
                            time: 2000,
                            icon: 5
                        });
                        return false;
                    }
                    // 保存到storage中，在确认下单页面中获取要购买的商品
                localStorage.setItem('shixuns', JSON.stringify([{
                        shixunId: vue.detail.id,
                    shixunName: vue.detail.shixunName,
                    shixunUuidNumber: vue.detail.shixunUuidNumber,
                    shixunPhoto: vue.detail.shixunPhoto,
                    shixunTypes: vue.detail.shixunTypes,
                    shixunContent: vue.detail.shixunContent,
                    shixunDelete: vue.detail.shixunDelete,
                    createTime: vue.detail.createTime,
                        buyNumber: this.buyNumber,
                    yonghuId: localStorage.getItem('userid'),
                }]));
                    // 跳转到确认下单页面
                    jump('../shixunOrder/confirm.jsp');
                },

                }
        });

        layui.use(['layer', 'form', 'element', 'carousel', 'http', 'jquery', 'laypage', 'util'], function () {
            var layer = layui.layer;
            var util = layui.util;
            var element = layui.element;
            var form = layui.form;
            var carousel = layui.carousel;
            var http = layui.http;
            var jquery = layui.jquery;
            var laypage = layui.laypage;
            vue.baseUrl = http.baseurl

            localStorage.setItem("goUtl","./pages/shixun/detail.jsp?id="+ http.getParam('id'))

            var limit = 10;

            let table = localStorage.getItem("userTable");
            if(table){
                http.request(table+"/session", 'get', {}, function (data) {
                    vue.user = data.data;
                });
            }

            // 数据ID
            var id = http.getParam('id');
            vue.detail.id = id;
            // 数据信息
            http.request(`${vue.detailTable}/detail/` + id, 'get', {}, function (res) {
                // 详情信息
                vue.detail = res.data;
                vue.title = vue.detail.shixunName;
                vue.detail.shixunContent = vue.detail.shixunContent.replaceAll("src=\"upload/","src=\""+vue.baseUrl+"upload/");
                // 轮播图片
                vue.swiperList = vue.detail.shixunPhoto ? vue.detail.shixunPhoto.split(",") : [];
                // 轮播图
                vue.$nextTick(() => {
                    carousel.render({
                        elem: '#swiper',
                        width: '420px',
                        height: '400px',
                        arrow: 'hover',
                        anim: 'default',
                        autoplay: 'true',
                        interval: '3000',
                        indicator: 'inside'
                    });
                });

            });


            // 系统推荐
            http.request(`shixun/gexingtuijian`, 'get', {
                page: 1,
                limit: 5,
                shixunTypes: vue.detail.shixunTypes,
                shixunDelete: 1,
            }, function (res) {
                vue.shixunRecommendList = res.data.list;
            });

        });
    </script>
</body>
</html>
