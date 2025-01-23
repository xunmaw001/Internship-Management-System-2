package com.entity.vo;

import com.entity.ShixunEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 实训方向
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shixun")
public class ShixunVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 实训方向名称
     */

    @TableField(value = "shixun_name")
    private String shixunName;


    /**
     * 实训方向编号
     */

    @TableField(value = "shixun_uuid_number")
    private String shixunUuidNumber;


    /**
     * 实训方向照片
     */

    @TableField(value = "shixun_photo")
    private String shixunPhoto;


    /**
     * 实训方向类型
     */

    @TableField(value = "shixun_types")
    private Integer shixunTypes;


    /**
     * 实训方向介绍
     */

    @TableField(value = "shixun_content")
    private String shixunContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "shixun_delete")
    private Integer shixunDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：实训方向名称
	 */
    public String getShixunName() {
        return shixunName;
    }


    /**
	 * 获取：实训方向名称
	 */

    public void setShixunName(String shixunName) {
        this.shixunName = shixunName;
    }
    /**
	 * 设置：实训方向编号
	 */
    public String getShixunUuidNumber() {
        return shixunUuidNumber;
    }


    /**
	 * 获取：实训方向编号
	 */

    public void setShixunUuidNumber(String shixunUuidNumber) {
        this.shixunUuidNumber = shixunUuidNumber;
    }
    /**
	 * 设置：实训方向照片
	 */
    public String getShixunPhoto() {
        return shixunPhoto;
    }


    /**
	 * 获取：实训方向照片
	 */

    public void setShixunPhoto(String shixunPhoto) {
        this.shixunPhoto = shixunPhoto;
    }
    /**
	 * 设置：实训方向类型
	 */
    public Integer getShixunTypes() {
        return shixunTypes;
    }


    /**
	 * 获取：实训方向类型
	 */

    public void setShixunTypes(Integer shixunTypes) {
        this.shixunTypes = shixunTypes;
    }
    /**
	 * 设置：实训方向介绍
	 */
    public String getShixunContent() {
        return shixunContent;
    }


    /**
	 * 获取：实训方向介绍
	 */

    public void setShixunContent(String shixunContent) {
        this.shixunContent = shixunContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getShixunDelete() {
        return shixunDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setShixunDelete(Integer shixunDelete) {
        this.shixunDelete = shixunDelete;
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
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
