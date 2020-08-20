/* https://github.com/orange1438 */
package com.athjt.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/** 
 * @author orange1438 code generator
 * date:2020/08/20 16:13
 */
@Table(name = "resource")
public class Resource implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 3207693858522061132L;

    /** 
     * 资源主键ID
     */
    @Id
    private Integer id;

    /** 
     * 资源名称
     */ 
    private String resourceName;

    /** 
     * 资源上传原路径
     */ 
    private String resourceLocalUrl;

    /** 
     * 资源上传目标路径
     */ 
    private String resourceUploadUrl;

    /** 
     * 创建时间
     */ 
    private Date createTime;

    /** 
     * 修改时间
     */ 
    private Date updateTime;

    /** 
     * 获取 资源主键ID resource.id
     * @return 资源主键ID
     */
    public final Integer getId() {
        return id;
    }

    /** 
     * 设置 资源主键ID resource.id
     * @param id 资源主键ID
     */
    public final void setId(Integer id) {
        this.id = id;
    }

    /** 
     * 获取 资源名称 resource.resource_name
     * @return 资源名称
     */
    public final String getResourceName() {
        return resourceName;
    }

    /** 
     * 设置 资源名称 resource.resource_name
     * @param resourceName 资源名称
     */
    public final void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    /** 
     * 获取 资源上传原路径 resource.resource_local_url
     * @return 资源上传原路径
     */
    public final String getResourceLocalUrl() {
        return resourceLocalUrl;
    }

    /** 
     * 设置 资源上传原路径 resource.resource_local_url
     * @param resourceLocalUrl 资源上传原路径
     */
    public final void setResourceLocalUrl(String resourceLocalUrl) {
        this.resourceLocalUrl = resourceLocalUrl == null ? null : resourceLocalUrl.trim();
    }

    /** 
     * 获取 资源上传目标路径 resource.resource_upload_url
     * @return 资源上传目标路径
     */
    public final String getResourceUploadUrl() {
        return resourceUploadUrl;
    }

    /** 
     * 设置 资源上传目标路径 resource.resource_upload_url
     * @param resourceUploadUrl 资源上传目标路径
     */
    public final void setResourceUploadUrl(String resourceUploadUrl) {
        this.resourceUploadUrl = resourceUploadUrl == null ? null : resourceUploadUrl.trim();
    }

    /** 
     * 获取 创建时间 resource.create_time
     * @return 创建时间
     */
    public final Date getCreateTime() {
        return createTime;
    }

    /** 
     * 设置 创建时间 resource.create_time
     * @param createTime 创建时间
     */
    public final void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /** 
     * 获取 修改时间 resource.update_time
     * @return 修改时间
     */
    public final Date getUpdateTime() {
        return updateTime;
    }

    /** 
     * 设置 修改时间 resource.update_time
     * @param updateTime 修改时间
     */
    public final void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", id=").append(id);
        sb.append(", resourceName=").append(resourceName);
        sb.append(", resourceLocalUrl=").append(resourceLocalUrl);
        sb.append(", resourceUploadUrl=").append(resourceUploadUrl);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}