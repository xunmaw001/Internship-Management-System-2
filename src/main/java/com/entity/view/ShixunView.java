package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ShixunEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 实训方向
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("shixun")
public class ShixunView extends ShixunEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 实训方向类型的值
	*/
	@ColumnInfo(comment="实训方向类型的字典表值",type="varchar(200)")
	private String shixunValue;




	public ShixunView() {

	}

	public ShixunView(ShixunEntity shixunEntity) {
		try {
			BeanUtils.copyProperties(this, shixunEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 实训方向类型的值
	*/
	public String getShixunValue() {
		return shixunValue;
	}
	/**
	* 设置： 实训方向类型的值
	*/
	public void setShixunValue(String shixunValue) {
		this.shixunValue = shixunValue;
	}




	@Override
	public String toString() {
		return "ShixunView{" +
			", shixunValue=" + shixunValue +
			"} " + super.toString();
	}
}
