package com.entity.model;

import com.entity.FenbanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 分班
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FenbanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 老师
     */
    private Integer laoshiId;


    /**
     * 实训方向
     */
    private Integer shixunId;


    /**
     * 分班名称
     */
    private String fenbanName;


    /**
     * 分班编号
     */
    private String fenbanUuidNumber;


    /**
     * 分班照片
     */
    private String fenbanPhoto;


    /**
     * 分班类型
     */
    private Integer fenbanTypes;


    /**
     * 分班介绍
     */
    private String fenbanContent;


    /**
     * 逻辑删除
     */
    private Integer fenbanDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show3 listShow
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
	 * 获取：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
