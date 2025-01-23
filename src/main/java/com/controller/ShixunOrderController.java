
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 实训方向报名
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shixunOrder")
public class ShixunOrderController {
    private static final Logger logger = LoggerFactory.getLogger(ShixunOrderController.class);

    private static final String TABLE_NAME = "shixunOrder";

    @Autowired
    private ShixunOrderService shixunOrderService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private ChengjiService chengjiService;//成绩
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private FenbanService fenbanService;//分班
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private LaoshiService laoshiService;//任课老师
    @Autowired
    private ShixunService shixunService;//实训方向
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private YonghuKaoqinService yonghuKaoqinService;//学生考勤
    @Autowired
    private YonghuKaoqinListService yonghuKaoqinListService;//学生考勤详情
    @Autowired
    private ZuoyeService zuoyeService;//作业
    @Autowired
    private ZuoyeTijiaoService zuoyeTijiaoService;//作业提交
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("任课老师".equals(role))
            params.put("laoshiId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = shixunOrderService.queryPage(params);

        //字典表数据转换
        List<ShixunOrderView> list =(List<ShixunOrderView>)page.getList();
        for(ShixunOrderView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShixunOrderEntity shixunOrder = shixunOrderService.selectById(id);
        if(shixunOrder !=null){
            //entity转view
            ShixunOrderView view = new ShixunOrderView();
            BeanUtils.copyProperties( shixunOrder , view );//把实体数据重构到view中
            //级联表 实训方向
            //级联表
            ShixunEntity shixun = shixunService.selectById(shixunOrder.getShixunId());
            if(shixun != null){
            BeanUtils.copyProperties( shixun , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setShixunId(shixun.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(shixunOrder.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ShixunOrderEntity shixunOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shixunOrder:{}",this.getClass().getName(),shixunOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            shixunOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        shixunOrder.setCreateTime(new Date());
        shixunOrder.setInsertTime(new Date());
        shixunOrderService.insert(shixunOrder);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShixunOrderEntity shixunOrder, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,shixunOrder:{}",this.getClass().getName(),shixunOrder.toString());
        ShixunOrderEntity oldShixunOrderEntity = shixunOrderService.selectById(shixunOrder.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            shixunOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            shixunOrderService.updateById(shixunOrder);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ShixunOrderEntity> oldShixunOrderList =shixunOrderService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        shixunOrderService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<ShixunOrderEntity> shixunOrderList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ShixunOrderEntity shixunOrderEntity = new ShixunOrderEntity();
//                            shixunOrderEntity.setShixunId(Integer.valueOf(data.get(0)));   //实训方向 要改的
//                            shixunOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            shixunOrderEntity.setShixunOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            shixunOrderEntity.setInsertTime(date);//时间
//                            shixunOrderEntity.setCreateTime(date);//时间
                            shixunOrderList.add(shixunOrderEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        shixunOrderService.insertBatch(shixunOrderList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = shixunOrderService.queryPage(params);

        //字典表数据转换
        List<ShixunOrderView> list =(List<ShixunOrderView>)page.getList();
        for(ShixunOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShixunOrderEntity shixunOrder = shixunOrderService.selectById(id);
            if(shixunOrder !=null){


                //entity转view
                ShixunOrderView view = new ShixunOrderView();
                BeanUtils.copyProperties( shixunOrder , view );//把实体数据重构到view中

                //级联表
                    ShixunEntity shixun = shixunService.selectById(shixunOrder.getShixunId());
                if(shixun != null){
                    BeanUtils.copyProperties( shixun , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShixunId(shixun.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(shixunOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ShixunOrderEntity shixunOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,shixunOrder:{}",this.getClass().getName(),shixunOrder.toString());
            ShixunEntity shixunEntity = shixunService.selectById(shixunOrder.getShixunId());
            if(shixunEntity == null){
                return R.error(511,"查不到该实训方向");
            }
            // Double shixunNewMoney = shixunEntity.getShixunNewMoney();

            if(false){
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            shixunOrder.setShixunOrderTypes(101); //设置订单状态为已报名
            shixunOrder.setYonghuId(userId); //设置订单支付人id
            shixunOrder.setInsertTime(new Date());
            shixunOrder.setCreateTime(new Date());
                shixunOrderService.insert(shixunOrder);//新增订单


            return R.ok();
    }


    /**
    * 取消报名
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

            ShixunOrderEntity shixunOrder = shixunOrderService.selectById(id);//当前表service
            Integer shixunId = shixunOrder.getShixunId();
            if(shixunId == null)
                return R.error(511,"查不到该实训方向");
            ShixunEntity shixunEntity = shixunService.selectById(shixunId);
            if(shixunEntity == null)
                return R.error(511,"查不到该实训方向");

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            Double zhekou = 1.0;

                //计算金额
                //计算所获得积分
                Double buyJifen = 0.0;





            shixunOrder.setShixunOrderTypes(102);//设置订单状态为已取消报名
            shixunOrderService.updateById(shixunOrder);//根据id更新
            yonghuService.updateById(yonghuEntity);//更新用户信息
            shixunService.updateById(shixunEntity);//更新订单中实训方向的信息

            return R.ok();
    }

    /**
     * 同意报名
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id  , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        ShixunOrderEntity  shixunOrderEntity = shixunOrderService.selectById(id);
        YonghuEntity yonghuEntity = yonghuService.selectById(shixunOrderEntity.getYonghuId());
        yonghuEntity.setYonghuTypes(1);
        shixunOrderEntity.setShixunOrderTypes(103);//设置订单状态为已同意报名
        shixunOrderService.updateById( shixunOrderEntity);
        yonghuService.updateById(yonghuEntity);
        return R.ok();
    }


}

