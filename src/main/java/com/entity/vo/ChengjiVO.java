package com.entity.vo;

import com.entity.ChengjiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 成绩
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("chengji")
public class ChengjiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 成绩名称
     */

    @TableField(value = "chengji_name")
    private String chengjiName;


    /**
     * 成绩编号
     */

    @TableField(value = "chengji_uuid_number")
    private String chengjiUuidNumber;


    /**
     * 成绩照片
     */

    @TableField(value = "chengji_photo")
    private String chengjiPhoto;


    /**
     * 成绩类型
     */

    @TableField(value = "chengji_types")
    private Integer chengjiTypes;


    /**
     * 分数
     */

    @TableField(value = "chengji_fenshu")
    private Integer chengjiFenshu;


    /**
     * 备注
     */

    @TableField(value = "chengji_content")
    private String chengjiContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "chengji_delete")
    private Integer chengjiDelete;


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
	 * 设置：成绩名称
	 */
    public String getChengjiName() {
        return chengjiName;
    }


    /**
	 * 获取：成绩名称
	 */

    public void setChengjiName(String chengjiName) {
        this.chengjiName = chengjiName;
    }
    /**
	 * 设置：成绩编号
	 */
    public String getChengjiUuidNumber() {
        return chengjiUuidNumber;
    }


    /**
	 * 获取：成绩编号
	 */

    public void setChengjiUuidNumber(String chengjiUuidNumber) {
        this.chengjiUuidNumber = chengjiUuidNumber;
    }
    /**
	 * 设置：成绩照片
	 */
    public String getChengjiPhoto() {
        return chengjiPhoto;
    }


    /**
	 * 获取：成绩照片
	 */

    public void setChengjiPhoto(String chengjiPhoto) {
        this.chengjiPhoto = chengjiPhoto;
    }
    /**
	 * 设置：成绩类型
	 */
    public Integer getChengjiTypes() {
        return chengjiTypes;
    }


    /**
	 * 获取：成绩类型
	 */

    public void setChengjiTypes(Integer chengjiTypes) {
        this.chengjiTypes = chengjiTypes;
    }
    /**
	 * 设置：分数
	 */
    public Integer getChengjiFenshu() {
        return chengjiFenshu;
    }


    /**
	 * 获取：分数
	 */

    public void setChengjiFenshu(Integer chengjiFenshu) {
        this.chengjiFenshu = chengjiFenshu;
    }
    /**
	 * 设置：备注
	 */
    public String getChengjiContent() {
        return chengjiContent;
    }


    /**
	 * 获取：备注
	 */

    public void setChengjiContent(String chengjiContent) {
        this.chengjiContent = chengjiContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getChengjiDelete() {
        return chengjiDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setChengjiDelete(Integer chengjiDelete) {
        this.chengjiDelete = chengjiDelete;
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
