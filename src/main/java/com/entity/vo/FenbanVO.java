package com.entity.vo;

import com.entity.FenbanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 分班
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("fenban")
public class FenbanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 老师
     */

    @TableField(value = "laoshi_id")
    private Integer laoshiId;


    /**
     * 实训方向
     */

    @TableField(value = "shixun_id")
    private Integer shixunId;


    /**
     * 分班名称
     */

    @TableField(value = "fenban_name")
    private String fenbanName;


    /**
     * 分班编号
     */

    @TableField(value = "fenban_uuid_number")
    private String fenbanUuidNumber;


    /**
     * 分班照片
     */

    @TableField(value = "fenban_photo")
    private String fenbanPhoto;


    /**
     * 分班类型
     */

    @TableField(value = "fenban_types")
    private Integer fenbanTypes;


    /**
     * 分班介绍
     */

    @TableField(value = "fenban_content")
    private String fenbanContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "fenban_delete")
    private Integer fenbanDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：老师
	 */
    public Integer getLaoshiId() {
        return laoshiId;
    }


    /**
	 * 获取：老师
	 */

    public void setLaoshiId(Integer laoshiId) {
        this.laoshiId = laoshiId;
    }
    /**
	 * 设置：实训方向
	 */
    public Integer getShixunId() {
        return shixunId;
    }


    /**
	 * 获取：实训方向
	 */

    public void setShixunId(Integer shixunId) {
        this.shixunId = shixunId;
    }
    /**
	 * 设置：分班名称
	 */
    public String getFenbanName() {
        return fenbanName;
    }


    /**
	 * 获取：分班名称
	 */

    public void setFenbanName(String fenbanName) {
        this.fenbanName = fenbanName;
    }
    /**
	 * 设置：分班编号
	 */
    public String getFenbanUuidNumber() {
        return fenbanUuidNumber;
    }


    /**
	 * 获取：分班编号
	 */

    public void setFenbanUuidNumber(String fenbanUuidNumber) {
        this.fenbanUuidNumber = fenbanUuidNumber;
    }
    /**
	 * 设置：分班照片
	 */
    public String getFenbanPhoto() {
        return fenbanPhoto;
    }


    /**
	 * 获取：分班照片
	 */

    public void setFenbanPhoto(String fenbanPhoto) {
        this.fenbanPhoto = fenbanPhoto;
    }
    /**
	 * 设置：分班类型
	 */
    public Integer getFenbanTypes() {
        return fenbanTypes;
    }


    /**
	 * 获取：分班类型
	 */

    public void setFenbanTypes(Integer fenbanTypes) {
        this.fenbanTypes = fenbanTypes;
    }
    /**
	 * 设置：分班介绍
	 */
    public String getFenbanContent() {
        return fenbanContent;
    }


    /**
	 * 获取：分班介绍
	 */

    public void setFenbanContent(String fenbanContent) {
        this.fenbanContent = fenbanContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getFenbanDelete() {
        return fenbanDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setFenbanDelete(Integer fenbanDelete) {
        this.fenbanDelete = fenbanDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
