package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 分班
 *
 * @author 
 * @email
 */
@TableName("fenban")
public class FenbanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FenbanEntity() {

	}

	public FenbanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 老师
     */
    @ColumnInfo(comment="老师",type="int(11)")
    @TableField(value = "laoshi_id")

    private Integer laoshiId;


    /**
     * 实训方向
     */
    @ColumnInfo(comment="实训方向",type="int(11)")
    @TableField(value = "shixun_id")

    private Integer shixunId;


    /**
     * 分班名称
     */
    @ColumnInfo(comment="分班名称",type="varchar(200)")
    @TableField(value = "fenban_name")

    private String fenbanName;


    /**
     * 分班编号
     */
    @ColumnInfo(comment="分班编号",type="varchar(200)")
    @TableField(value = "fenban_uuid_number")

    private String fenbanUuidNumber;


    /**
     * 分班照片
     */
    @ColumnInfo(comment="分班照片",type="varchar(200)")
    @TableField(value = "fenban_photo")

    private String fenbanPhoto;


    /**
     * 分班类型
     */
    @ColumnInfo(comment="分班类型",type="int(11)")
    @TableField(value = "fenban_types")

    private Integer fenbanTypes;


    /**
     * 分班介绍
     */
    @ColumnInfo(comment="分班介绍",type="text")
    @TableField(value = "fenban_content")

    private String fenbanContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "fenban_delete")

    private Integer fenbanDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间   listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：老师
	 */
    public Integer getLaoshiId() {
        return laoshiId;
    }
    /**
	 * 设置：老师
	 */

    public void setLaoshiId(Integer laoshiId) {
        this.laoshiId = laoshiId;
    }
    /**
	 * 获取：实训方向
	 */
    public Integer getShixunId() {
        return shixunId;
    }
    /**
	 * 设置：实训方向
	 */

    public void setShixunId(Integer shixunId) {
        this.shixunId = shixunId;
    }
    /**
	 * 获取：分班名称
	 */
    public String getFenbanName() {
        return fenbanName;
    }
    /**
	 * 设置：分班名称
	 */

    public void setFenbanName(String fenbanName) {
        this.fenbanName = fenbanName;
    }
    /**
	 * 获取：分班编号
	 */
    public String getFenbanUuidNumber() {
        return fenbanUuidNumber;
    }
    /**
	 * 设置：分班编号
	 */

    public void setFenbanUuidNumber(String fenbanUuidNumber) {
        this.fenbanUuidNumber = fenbanUuidNumber;
    }
    /**
	 * 获取：分班照片
	 */
    public String getFenbanPhoto() {
        return fenbanPhoto;
    }
    /**
	 * 设置：分班照片
	 */

    public void setFenbanPhoto(String fenbanPhoto) {
        this.fenbanPhoto = fenbanPhoto;
    }
    /**
	 * 获取：分班类型
	 */
    public Integer getFenbanTypes() {
        return fenbanTypes;
    }
    /**
	 * 设置：分班类型
	 */

    public void setFenbanTypes(Integer fenbanTypes) {
        this.fenbanTypes = fenbanTypes;
    }
    /**
	 * 获取：分班介绍
	 */
    public String getFenbanContent() {
        return fenbanContent;
    }
    /**
	 * 设置：分班介绍
	 */

    public void setFenbanContent(String fenbanContent) {
        this.fenbanContent = fenbanContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getFenbanDelete() {
        return fenbanDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setFenbanDelete(Integer fenbanDelete) {
        this.fenbanDelete = fenbanDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间   listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间   listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Fenban{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", laoshiId=" + laoshiId +
            ", shixunId=" + shixunId +
            ", fenbanName=" + fenbanName +
            ", fenbanUuidNumber=" + fenbanUuidNumber +
            ", fenbanPhoto=" + fenbanPhoto +
            ", fenbanTypes=" + fenbanTypes +
            ", fenbanContent=" + fenbanContent +
            ", fenbanDelete=" + fenbanDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
