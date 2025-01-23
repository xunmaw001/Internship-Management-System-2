
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
 * 实训方向
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shixun")
public class ShixunController {
    private static final Logger logger = LoggerFactory.getLogger(ShixunController.class);

    private static final String TABLE_NAME = "shixun";

    @Autowired
    private ShixunService shixunService;


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
    private ShixunOrderService shixunOrderService;//实训方向报名
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
        params.put("shixunDeleteStart",1);params.put("shixunDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = shixunService.queryPage(params);

        //字典表数据转换
        List<ShixunView> list =(List<ShixunView>)page.getList();
        for(ShixunView c:list){
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
        ShixunEntity shixun = shixunService.selectById(id);
        if(shixun !=null){
            //entity转view
            ShixunView view = new ShixunView();
            BeanUtils.copyProperties( shixun , view );//把实体数据重构到view中
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
    public R save(@RequestBody ShixunEntity shixun, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shixun:{}",this.getClass().getName(),shixun.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ShixunEntity> queryWrapper = new EntityWrapper<ShixunEntity>()
            .eq("shixun_name", shixun.getShixunName())
            .eq("shixun_types", shixun.getShixunTypes())
            .eq("shixun_delete", shixun.getShixunDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShixunEntity shixunEntity = shixunService.selectOne(queryWrapper);
        if(shixunEntity==null){
            shixun.setShixunDelete(1);
            shixun.setInsertTime(new Date());
            shixun.setCreateTime(new Date());
            shixunService.insert(shixun);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShixunEntity shixun, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,shixun:{}",this.getClass().getName(),shixun.toString());
        ShixunEntity oldShixunEntity = shixunService.selectById(shixun.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(shixun.getShixunPhoto()) || "null".equals(shixun.getShixunPhoto())){
                shixun.setShixunPhoto(null);
        }

            shixunService.updateById(shixun);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ShixunEntity> oldShixunList =shixunService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<ShixunEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ShixunEntity shixunEntity = new ShixunEntity();
            shixunEntity.setId(id);
            shixunEntity.setShixunDelete(2);
            list.add(shixunEntity);
        }
        if(list != null && list.size() >0){
            shixunService.updateBatchById(list);
        }

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
            List<ShixunEntity> shixunList = new ArrayList<>();//上传的东西
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
                            ShixunEntity shixunEntity = new ShixunEntity();
//                            shixunEntity.setShixunName(data.get(0));                    //实训方向名称 要改的
//                            shixunEntity.setShixunUuidNumber(data.get(0));                    //实训方向编号 要改的
//                            shixunEntity.setShixunPhoto("");//详情和图片
//                            shixunEntity.setShixunTypes(Integer.valueOf(data.get(0)));   //实训方向类型 要改的
//                            shixunEntity.setShixunContent("");//详情和图片
//                            shixunEntity.setShixunDelete(1);//逻辑删除字段
//                            shixunEntity.setInsertTime(date);//时间
//                            shixunEntity.setCreateTime(date);//时间
                            shixunList.add(shixunEntity);


                            //把要查询是否重复的字段放入map中
                                //实训方向编号
                                if(seachFields.containsKey("shixunUuidNumber")){
                                    List<String> shixunUuidNumber = seachFields.get("shixunUuidNumber");
                                    shixunUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> shixunUuidNumber = new ArrayList<>();
                                    shixunUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("shixunUuidNumber",shixunUuidNumber);
                                }
                        }

                        //查询是否重复
                         //实训方向编号
                        List<ShixunEntity> shixunEntities_shixunUuidNumber = shixunService.selectList(new EntityWrapper<ShixunEntity>().in("shixun_uuid_number", seachFields.get("shixunUuidNumber")).eq("shixun_delete", 1));
                        if(shixunEntities_shixunUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ShixunEntity s:shixunEntities_shixunUuidNumber){
                                repeatFields.add(s.getShixunUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [实训方向编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        shixunService.insertBatch(shixunList);
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
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<ShixunView> returnShixunViewList = new ArrayList<>();

        //查询订单
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = shixunOrderService.queryPage(params1);
        List<ShixunOrderView> orderViewsList =(List<ShixunOrderView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(ShixunOrderView orderView:orderViewsList){
            Integer shixunTypes = orderView.getShixunTypes();
            if(typeMap.containsKey(shixunTypes)){
                typeMap.put(shixunTypes,typeMap.get(shixunTypes)+1);
            }else{
                typeMap.put(shixunTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("shixunTypes",type);
            PageUtils pageUtils1 = shixunService.queryPage(params2);
            List<ShixunView> shixunViewList =(List<ShixunView>)pageUtils1.getList();
            returnShixunViewList.addAll(shixunViewList);
            if(returnShixunViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = shixunService.queryPage(params);
        if(returnShixunViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnShixunViewList.size();//要添加的数量
            List<ShixunView> shixunViewList =(List<ShixunView>)page.getList();
            for(ShixunView shixunView:shixunViewList){
                Boolean addFlag = true;
                for(ShixunView returnShixunView:returnShixunViewList){
                    if(returnShixunView.getId().intValue() ==shixunView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnShixunViewList.add(shixunView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnShixunViewList = returnShixunViewList.subList(0, limit);
        }

        for(ShixunView c:returnShixunViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnShixunViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = shixunService.queryPage(params);

        //字典表数据转换
        List<ShixunView> list =(List<ShixunView>)page.getList();
        for(ShixunView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShixunEntity shixun = shixunService.selectById(id);
            if(shixun !=null){


                //entity转view
                ShixunView view = new ShixunView();
                BeanUtils.copyProperties( shixun , view );//把实体数据重构到view中

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
    public R add(@RequestBody ShixunEntity shixun, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,shixun:{}",this.getClass().getName(),shixun.toString());
        Wrapper<ShixunEntity> queryWrapper = new EntityWrapper<ShixunEntity>()
            .eq("shixun_name", shixun.getShixunName())
            .eq("shixun_uuid_number", shixun.getShixunUuidNumber())
            .eq("shixun_types", shixun.getShixunTypes())
            .eq("shixun_delete", shixun.getShixunDelete())
//            .notIn("shixun_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShixunEntity shixunEntity = shixunService.selectOne(queryWrapper);
        if(shixunEntity==null){
            shixun.setShixunDelete(1);
            shixun.setInsertTime(new Date());
            shixun.setCreateTime(new Date());
        shixunService.insert(shixun);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

