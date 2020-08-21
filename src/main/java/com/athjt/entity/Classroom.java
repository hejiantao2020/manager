/* https://github.com/orange1438 */
package com.athjt.entity;

import java.io.Serializable;

/** 
 * @author orange1438 code generator
 * date:2020/08/21 20:13
 */
public class Classroom implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = -4956579878276531161L;

    /** 
     * 班级ID
     */ 
    private Integer id;

    /** 
     * 课程ID
     */ 
    private Integer courseId;

    /** 
     * 班级名称
     */ 
    private String className;

    /** 
     * 获取 班级ID classroom.id
     * @return 班级ID
     */
    public final Integer getId() {
        return id;
    }

    /** 
     * 设置 班级ID classroom.id
     * @param id 班级ID
     */
    public final void setId(Integer id) {
        this.id = id;
    }

    /** 
     * 获取 课程ID classroom.course_id
     * @return 课程ID
     */
    public final Integer getCourseId() {
        return courseId;
    }

    /** 
     * 设置 课程ID classroom.course_id
     * @param courseId 课程ID
     */
    public final void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    /** 
     * 获取 班级名称 classroom.class_name
     * @return 班级名称
     */
    public final String getClassName() {
        return className;
    }

    /** 
     * 设置 班级名称 classroom.class_name
     * @param className 班级名称
     */
    public final void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", id=").append(id);
        sb.append(", courseId=").append(courseId);
        sb.append(", className=").append(className);
        sb.append("]");
        return sb.toString();
    }
}