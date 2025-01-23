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
 * 实训方向
 *
 * @author 
 * @email
 */
@TableName("shixun")
public class ShixunEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShixunEntity() {

	}

	public ShixunEntity(T t) {
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
     * 实训方向名称
     */
    @ColumnInfo(comment="实训方向名称",type="varchar(200)")
    @TableField(value = "shixun_name")

    private String shixunName;


    /**
     * 实训方向编号
     */
    @ColumnInfo(comment="实训方向编号",type="varchar(200)")
    @TableField(value = "shixun_uuid_number")

    private String shixunUuidNumber;


    /**
     * 实训方向照片
     */
    @ColumnInfo(comment="实训方向照片",type="varchar(200)")
    @TableField(value = "shixun_photo")

    private String shixunPhoto;


    /**
     * 实训方向类型
     */
    @ColumnInfo(comment="实训方向类型",type="int(11)")
    @TableField(value = "shixun_types")

    private Integer shixunTypes;


    /**
     * 实训方向介绍
     */
    @ColumnInfo(comment="实训方向介绍",type="text")
    @TableField(value = "shixun_content")

    private String shixunContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "shixun_delete")

    private Integer shixunDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
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
	 * 获取：实训方向名称
	 */
    public String getShixunName() {
        return shixunName;
    }
    /**
	 * 设置：实训方向名称
	 */

    public void setShixunName(String shixunName) {
        this.shixunName = shixunName;
    }
    /**
	 * 获取：实训方向编号
	 */
    public String getShixunUuidNumber() {
        return shixunUuidNumber;
    }
    /**
	 * 设置：实训方向编号
	 */

    public void setShixunUuidNumber(String shixunUuidNumber) {
        this.shixunUuidNumber = shixunUuidNumber;
    }
    /**
	 * 获取：实训方向照片
	 */
    public String getShixunPhoto() {
        return shixunPhoto;
    }
    /**
	 * 设置：实训方向照片
	 */

    public void setShixunPhoto(String shixunPhoto) {
        this.shixunPhoto = shixunPhoto;
    }
    /**
	 * 获取：实训方向类型
	 */
    public Integer getShixunTypes() {
        return shixunTypes;
    }
    /**
	 * 设置：实训方向类型
	 */

    public void setShixunTypes(Integer shixunTypes) {
        this.shixunTypes = shixunTypes;
    }
    /**
	 * 获取：实训方向介绍
	 */
    public String getShixunContent() {
        return shixunContent;
    }
    /**
	 * 设置：实训方向介绍
	 */

    public void setShixunContent(String shixunContent) {
        this.shixunContent = shixunContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getShixunDelete() {
        return shixunDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setShixunDelete(Integer shixunDelete) {
        this.shixunDelete = shixunDelete;
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
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Shixun{" +
            ", id=" + id +
            ", shixunName=" + shixunName +
            ", shixunUuidNumber=" + shixunUuidNumber +
            ", shixunPhoto=" + shixunPhoto +
            ", shixunTypes=" + shixunTypes +
            ", shixunContent=" + shixunContent +
            ", shixunDelete=" + shixunDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
