package com.dao;

import com.entity.ShixunOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShixunOrderView;

/**
 * 实训方向报名 Dao 接口
 *
 * @author 
 */
public interface ShixunOrderDao extends BaseMapper<ShixunOrderEntity> {

   List<ShixunOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
