package com.dao;

import com.entity.ShixunEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShixunView;

/**
 * 实训方向 Dao 接口
 *
 * @author 
 */
public interface ShixunDao extends BaseMapper<ShixunEntity> {

   List<ShixunView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
