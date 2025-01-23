package com.entity.model;

import com.entity.ShixunEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 实训方向
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShixunModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 实训方向名称
     */
    private String shixunName;


    /**
     * 实训方向编号
     */
    private String shixunUuidNumber;


    /**
     * 实训方向照片
     */
    private String shixunPhoto;


    /**
     * 实训方向类型
     */
    private Integer shixunTypes;


    /**
     * 实训方向介绍
     */
    private String shixunContent;


    /**
     * 逻辑删除
     */
    private Integer shixunDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
