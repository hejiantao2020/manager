/* https://github.com/orange1438 */
package com.athjt.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

/** 
 * @author orange1438 code generator
 * date:2020/08/20 16:13
 */
@Table(name = "base_info")
public class BaseInfo implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 385705595949118761L;

    /** 
     * 主键ID
     */
    @Id
    private Integer id;

    /** 
     * 单选
     */ 
    private String redio;

    /** 
     * 多选
     */ 
    private String checkbox;

    /** 
     * 下拉
     */ 
    private String selectChoice;

    /** 
     * 开始时间
     */ 
    private Date startLiveTime;

    /** 
     * 结束时间
     */ 
    private Date endLiveTime;

    /** 
     * 逻辑删除0-未删除;1-已删除  默认：0
     */ 
    private Integer deleted;

    /** 
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;

    /** 
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date updateTime;

    /** 
     * 资源ID  默认：0
     */
    @Column(name = "resource_id")
    private Integer resourceId;

    /** 
     * 获取 主键ID base_info.id
     * @return 主键ID
     */
    public final Integer getId() {
        return id;
    }

    /** 
     * 设置 主键ID base_info.id
     * @param id 主键ID
     */
    public final void setId(Integer id) {
        this.id = id;
    }

    /** 
     * 获取 单选 base_info.redio
     * @return 单选
     */
    public final String getRedio() {
        return redio;
    }

    /** 
     * 设置 单选 base_info.redio
     * @param redio 单选
     */
    public final void setRedio(String redio) {
        this.redio = redio == null ? null : redio.trim();
    }

    /** 
     * 获取 多选 base_info.checkbox
     * @return 多选
     */
    public final String getCheckbox() {
        return checkbox;
    }

    /** 
     * 设置 多选 base_info.checkbox
     * @param checkbox 多选
     */
    public final void setCheckbox(String checkbox) {
        this.checkbox = checkbox == null ? null : checkbox.trim();
    }
    
    public String getSelectChoice() {
        return selectChoice;
    }
    
    public BaseInfo setSelectChoice(String selectChoice) {
        this.selectChoice = selectChoice;
        return this;
    }
    
    /**
     * 获取 开始时间 base_info.start_live_time
     * @return 开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    public final Date getStartLiveTime() {
        return startLiveTime;
    }

    /** 
     * 设置 开始时间 base_info.start_live_time
     * @param startLiveTime 开始时间
     */
    public final void setStartLiveTime(Date startLiveTime) {
        this.startLiveTime = startLiveTime;
    }

    /** 
     * 获取 结束时间 base_info.end_live_time
     * @return 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    public final Date getEndLiveTime() {
        return endLiveTime;
    }

    /** 
     * 设置 结束时间 base_info.end_live_time
     * @param endLiveTime 结束时间
     */
    public final void setEndLiveTime(Date endLiveTime) {
        this.endLiveTime = endLiveTime;
    }

    /** 
     * 获取 逻辑删除0-未删除;1-已删除 base_info.deleted
     * @return 逻辑删除0-未删除;1-已删除
     */
    public final Integer getDeleted() {
        return deleted;
    }

    /** 
     * 设置 逻辑删除0-未删除;1-已删除 base_info.deleted
     * @param deleted 逻辑删除0-未删除;1-已删除
     */
    public final void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    /** 
     * 获取 创建时间 base_info.create_time
     * @return 创建时间
     */
    public final Date getCreateTime() {
        return createTime;
    }

    /** 
     * 设置 创建时间 base_info.create_time
     * @param createTime 创建时间
     */
    public final void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /** 
     * 获取 修改时间 base_info.update_time
     * @return 修改时间
     */
    public final Date getUpdateTime() {
        return updateTime;
    }

    /** 
     * 设置 修改时间 base_info.update_time
     * @param updateTime 修改时间
     */
    public final void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /** 
     * 获取 资源ID base_info.resource_id
     * @return 资源ID
     */
    public final Integer getResourceId() {
        return resourceId;
    }

    /** 
     * 设置 资源ID base_info.resource_id
     * @param resourceId 资源ID
     */
    public final void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", id=").append(id);
        sb.append(", redio=").append(redio);
        sb.append(", checkbox=").append(checkbox);
        sb.append(", selectChoice=").append(selectChoice);
        sb.append(", startLiveTime=").append(DateFormatUtils.format(startLiveTime,"yyyy-MM-dd"));
        sb.append(", endLiveTime=").append(DateFormatUtils.format(endLiveTime,"yyyy-MM-dd"));
        sb.append(", deleted=").append(deleted);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", resourceId=").append(resourceId);
        sb.append("]");
        return sb.toString();
    }
}