package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.FenbanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 分班
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("fenban")
public class FenbanView extends FenbanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 分班类型的值
	*/
	@ColumnInfo(comment="分班类型的字典表值",type="varchar(200)")
	private String fenbanValue;

	//级联表 任课老师
		/**
		* 老师姓名
		*/

		@ColumnInfo(comment="老师姓名",type="varchar(200)")
		private String laoshiName;
		/**
		* 老师手机号
		*/

		@ColumnInfo(comment="老师手机号",type="varchar(200)")
		private String laoshiPhone;
		/**
		* 老师身份证号
		*/

		@ColumnInfo(comment="老师身份证号",type="varchar(200)")
		private String laoshiIdNumber;
		/**
		* 老师头像
		*/

		@ColumnInfo(comment="老师头像",type="varchar(200)")
		private String laoshiPhoto;
		/**
		* 电子邮箱
		*/

		@ColumnInfo(comment="电子邮箱",type="varchar(200)")
		private String laoshiEmail;
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

	//重复字段
			/**
			* 重复字段 的types
			*/
			@ColumnInfo(comment="重复字段 的types",type="Integer")
			private Integer sexTypes;
				@ColumnInfo(comment="重复字段 的值",type="varchar(200)")
				private String sexValue;


	public FenbanView() {

	}

	public FenbanView(FenbanEntity fenbanEntity) {
		try {
			BeanUtils.copyProperties(this, fenbanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 分班类型的值
	*/
	public String getFenbanValue() {
		return fenbanValue;
	}
	/**
	* 设置： 分班类型的值
	*/
	public void setFenbanValue(String fenbanValue) {
		this.fenbanValue = fenbanValue;
	}


	//级联表的get和set 任课老师

		/**
		* 获取： 老师姓名
		*/
		public String getLaoshiName() {
			return laoshiName;
		}
		/**
		* 设置： 老师姓名
		*/
		public void setLaoshiName(String laoshiName) {
			this.laoshiName = laoshiName;
		}

		/**
		* 获取： 老师手机号
		*/
		public String getLaoshiPhone() {
			return laoshiPhone;
		}
		/**
		* 设置： 老师手机号
		*/
		public void setLaoshiPhone(String laoshiPhone) {
			this.laoshiPhone = laoshiPhone;
		}

		/**
		* 获取： 老师身份证号
		*/
		public String getLaoshiIdNumber() {
			return laoshiIdNumber;
		}
		/**
		* 设置： 老师身份证号
		*/
		public void setLaoshiIdNumber(String laoshiIdNumber) {
			this.laoshiIdNumber = laoshiIdNumber;
		}

		/**
		* 获取： 老师头像
		*/
		public String getLaoshiPhoto() {
			return laoshiPhoto;
		}
		/**
		* 设置： 老师头像
		*/
		public void setLaoshiPhoto(String laoshiPhoto) {
			this.laoshiPhoto = laoshiPhoto;
		}

		/**
		* 获取： 电子邮箱
		*/
		public String getLaoshiEmail() {
			return laoshiEmail;
		}
		/**
		* 设置： 电子邮箱
		*/
		public void setLaoshiEmail(String laoshiEmail) {
			this.laoshiEmail = laoshiEmail;
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

	//重复字段
			/**
			* 获取： 重复字段 的types
			*/
			public Integer getSexTypes() {
			return sexTypes;
			}
			/**
			* 设置： 重复字段 的types
			*/
			public void setSexTypes(Integer sexTypes) {
			this.sexTypes = sexTypes;
			}
				public String getSexValue() {
				return sexValue;
				}
				public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
				}

	@Override
	public String toString() {
		return "FenbanView{" +
			", fenbanValue=" + fenbanValue +
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
			", laoshiName=" + laoshiName +
			", laoshiPhone=" + laoshiPhone +
			", laoshiIdNumber=" + laoshiIdNumber +
			", laoshiPhoto=" + laoshiPhoto +
			", laoshiEmail=" + laoshiEmail +
			"} " + super.toString();
	}
}
