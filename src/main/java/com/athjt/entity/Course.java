/* https://github.com/orange1438 */
package com.athjt.entity;

import java.io.Serializable;

/** 
 * @author orange1438 code generator
 * date:2020/08/21 20:13
 */
public class Course implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = -8083943255272642488L;

    /** 
     * 课程ID
     */ 
    private Integer id;

    /** 
     * 课程名称
     */ 
    private String name;

    /** 
     * 获取 课程ID course.id
     * @return 课程ID
     */
    public final Integer getId() {
        return id;
    }

    /** 
     * 设置 课程ID course.id
     * @param id 课程ID
     */
    public final void setId(Integer id) {
        this.id = id;
    }

    /** 
     * 获取 课程名称 course.name
     * @return 课程名称
     */
    public final String getName() {
        return name;
    }

    /** 
     * 设置 课程名称 course.name
     * @param name 课程名称
     */
    public final void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append("]");
        return sb.toString();
    }
}