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
 * 成绩
 *
 * @author 
 * @email
 */
@TableName("chengji")
public class ChengjiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ChengjiEntity() {

	}

	public ChengjiEntity(T t) {
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
     * 成绩名称
     */
    @ColumnInfo(comment="成绩名称",type="varchar(200)")
    @TableField(value = "chengji_name")

    private String chengjiName;


    /**
     * 成绩编号
     */
    @ColumnInfo(comment="成绩编号",type="varchar(200)")
    @TableField(value = "chengji_uuid_number")

    private String chengjiUuidNumber;


    /**
     * 成绩照片
     */
    @ColumnInfo(comment="成绩照片",type="varchar(200)")
    @TableField(value = "chengji_photo")

    private String chengjiPhoto;


    /**
     * 成绩类型
     */
    @ColumnInfo(comment="成绩类型",type="int(11)")
    @TableField(value = "chengji_types")

    private Integer chengjiTypes;


    /**
     * 分数
     */
    @ColumnInfo(comment="分数",type="int(11)")
    @TableField(value = "chengji_fenshu")

    private Integer chengjiFenshu;


    /**
     * 备注
     */
    @ColumnInfo(comment="备注",type="text")
    @TableField(value = "chengji_content")

    private String chengjiContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "chengji_delete")

    private Integer chengjiDelete;


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
	 * 获取：成绩名称
	 */
    public String getChengjiName() {
        return chengjiName;
    }
    /**
	 * 设置：成绩名称
	 */

    public void setChengjiName(String chengjiName) {
        this.chengjiName = chengjiName;
    }
    /**
	 * 获取：成绩编号
	 */
    public String getChengjiUuidNumber() {
        return chengjiUuidNumber;
    }
    /**
	 * 设置：成绩编号
	 */

    public void setChengjiUuidNumber(String chengjiUuidNumber) {
        this.chengjiUuidNumber = chengjiUuidNumber;
    }
    /**
	 * 获取：成绩照片
	 */
    public String getChengjiPhoto() {
        return chengjiPhoto;
    }
    /**
	 * 设置：成绩照片
	 */

    public void setChengjiPhoto(String chengjiPhoto) {
        this.chengjiPhoto = chengjiPhoto;
    }
    /**
	 * 获取：成绩类型
	 */
    public Integer getChengjiTypes() {
        return chengjiTypes;
    }
    /**
	 * 设置：成绩类型
	 */

    public void setChengjiTypes(Integer chengjiTypes) {
        this.chengjiTypes = chengjiTypes;
    }
    /**
	 * 获取：分数
	 */
    public Integer getChengjiFenshu() {
        return chengjiFenshu;
    }
    /**
	 * 设置：分数
	 */

    public void setChengjiFenshu(Integer chengjiFenshu) {
        this.chengjiFenshu = chengjiFenshu;
    }
    /**
	 * 获取：备注
	 */
    public String getChengjiContent() {
        return chengjiContent;
    }
    /**
	 * 设置：备注
	 */

    public void setChengjiContent(String chengjiContent) {
        this.chengjiContent = chengjiContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getChengjiDelete() {
        return chengjiDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setChengjiDelete(Integer chengjiDelete) {
        this.chengjiDelete = chengjiDelete;
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
        return "Chengji{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", laoshiId=" + laoshiId +
            ", chengjiName=" + chengjiName +
            ", chengjiUuidNumber=" + chengjiUuidNumber +
            ", chengjiPhoto=" + chengjiPhoto +
            ", chengjiTypes=" + chengjiTypes +
            ", chengjiFenshu=" + chengjiFenshu +
            ", chengjiContent=" + chengjiContent +
            ", chengjiDelete=" + chengjiDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
