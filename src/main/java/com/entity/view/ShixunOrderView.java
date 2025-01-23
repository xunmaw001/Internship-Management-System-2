package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ShixunOrderEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 实训方向报名
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("shixun_order")
public class ShixunOrderView extends ShixunOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 订单类型的值
	*/
	@ColumnInfo(comment="订单类型的字典表值",type="varchar(200)")
	private String shixunOrderValue;

	//级联表 实训方向
		/**
		* 实训方向名称
		*/

		@ColumnInfo(comment="实训方向名称",type="varchar(200)")
		private String shixunName;
		/**
		* 实训方向编号
		*/

		@ColumnInfo(comment="实训方向编号",type="varchar(200)")
		private String shixunUuidNumber;
		/**
		* 实训方向照片
		*/

		@ColumnInfo(comment="实训方向照片",type="varchar(200)")
		private String shixunPhoto;
		/**
		* 实训方向类型
		*/
		@ColumnInfo(comment="实训方向类型",type="int(11)")
		private Integer shixunTypes;
			/**
			* 实训方向类型的值
			*/
			@ColumnInfo(comment="实训方向类型的字典表值",type="varchar(200)")
			private String shixunValue;
		/**
		* 实训方向介绍
		*/

		@ColumnInfo(comment="实训方向介绍",type="text")
		private String shixunContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer shixunDelete;
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 实训方向
		*/
		@ColumnInfo(comment="实训方向",type="int(11)")
		private Integer yonghuTypes;
			/**
			* 实训方向的值
			*/
			@ColumnInfo(comment="实训方向的字典表值",type="varchar(200)")
			private String yonghuValue;
		/**
		* 电子邮箱
		*/

		@ColumnInfo(comment="电子邮箱",type="varchar(200)")
		private String yonghuEmail;



	public ShixunOrderView() {

	}

	public ShixunOrderView(ShixunOrderEntity shixunOrderEntity) {
		try {
			BeanUtils.copyProperties(this, shixunOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 订单类型的值
	*/
	public String getShixunOrderValue() {
		return shixunOrderValue;
	}
	/**
	* 设置： 订单类型的值
	*/
	public void setShixunOrderValue(String shixunOrderValue) {
		this.shixunOrderValue = shixunOrderValue;
	}


	//级联表的get和set 实训方向

		/**
		* 获取： 实训方向名称
		*/
		public String getShixunName() {
			return shixunName;
		}
		/**
		* 设置： 实训方向名称
		*/
		public void setShixunName(String shixunName) {
			this.shixunName = shixunName;
		}

		/**
		* 获取： 实训方向编号
		*/
		public String getShixunUuidNumber() {
			return shixunUuidNumber;
		}
		/**
		* 设置： 实训方向编号
		*/
		public void setShixunUuidNumber(String shixunUuidNumber) {
			this.shixunUuidNumber = shixunUuidNumber;
		}

		/**
		* 获取： 实训方向照片
		*/
		public String getShixunPhoto() {
			return shixunPhoto;
		}
		/**
		* 设置： 实训方向照片
		*/
		public void setShixunPhoto(String shixunPhoto) {
			this.shixunPhoto = shixunPhoto;
		}
		/**
		* 获取： 实训方向类型
		*/
		public Integer getShixunTypes() {
			return shixunTypes;
		}
		/**
		* 设置： 实训方向类型
		*/
		public void setShixunTypes(Integer shixunTypes) {
			this.shixunTypes = shixunTypes;
		}


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

		/**
		* 获取： 实训方向介绍
		*/
		public String getShixunContent() {
			return shixunContent;
		}
		/**
		* 设置： 实训方向介绍
		*/
		public void setShixunContent(String shixunContent) {
			this.shixunContent = shixunContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getShixunDelete() {
			return shixunDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setShixunDelete(Integer shixunDelete) {
			this.shixunDelete = shixunDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}
		/**
		* 获取： 实训方向
		*/
		public Integer getYonghuTypes() {
			return yonghuTypes;
		}
		/**
		* 设置： 实训方向
		*/
		public void setYonghuTypes(Integer yonghuTypes) {
			this.yonghuTypes = yonghuTypes;
		}


			/**
			* 获取： 实训方向的值
			*/
			public String getYonghuValue() {
				return yonghuValue;
			}
			/**
			* 设置： 实训方向的值
			*/
			public void setYonghuValue(String yonghuValue) {
				this.yonghuValue = yonghuValue;
			}

		/**
		* 获取： 电子邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 电子邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}


	@Override
	public String toString() {
		return "ShixunOrderView{" +
			", shixunOrderValue=" + shixunOrderValue +
			", shixunName=" + shixunName +
			", shixunUuidNumber=" + shixunUuidNumber +
			", shixunPhoto=" + shixunPhoto +
			", shixunContent=" + shixunContent +
			", shixunDelete=" + shixunDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
