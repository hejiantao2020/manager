/* https://github.com/orange1438 */
package com.athjt.entity;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/** 
 * 学生与课程关系表 student_course
 * @author orange1438 code generator
 * date:2020/08/24 16:50
 */
@Table(name = "student_course")
public class StudentCourse implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 2996779473504432772L;

    /** 
     */ 
    private Integer id;

    /** 
     * 学生id
     */ 
    private Integer studentId;

    /** 
     * 课程ID  默认：0
     */ 
    private Integer courseId;

    /** 
     * 课程名称
     */ 
    private String courseName;

    /** 
     * 班级ID  默认：0
     */ 
    private Integer classroomId;

    /** 
     * 班级名称
     */ 
    private String classroomName;

    /** 
     * 是否购买课程(0-未购买;1-已购买)  默认：0
     */ 
    private Integer buyStatus;

    /** 
     * 创建时间
     */ 
    private Date createTime;

    /** 
     * 更新时间
     */ 
    private Date updateTime;

    /** 
     * 逻辑删除  默认：0
     */ 
    private Byte deleted;
    private String studentName;
    private String studentMobile;
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StudentCourse{");
        sb.append("id=").append(id);
        sb.append(", studentId=").append(studentId);
        sb.append(", courseId=").append(courseId);
        sb.append(", courseName='").append(courseName).append('\'');
        sb.append(", classroomId=").append(classroomId);
        sb.append(", classroomName='").append(classroomName).append('\'');
        sb.append(", buyStatus=").append(buyStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleted=").append(deleted);
        sb.append(", studentName='").append(studentName).append('\'');
        sb.append(", studentMobile='").append(studentMobile).append('\'');
        sb.append('}');
        return sb.toString();
    }
    
  
    
    public String getStudentName() {
        return studentName;
    }
    
    public StudentCourse setStudentName(String studentName) {
        this.studentName = studentName;
        return this;
    }
    
    public String getStudentMobile() {
        return studentMobile;
    }
    
    public StudentCourse setStudentMobile(String studentMobile) {
        this.studentMobile = studentMobile;
        return this;
    }
    
    /**
     * 获取 student_course.id
     * @return student_course.id
     */
    public final Integer getId() {
        return id;
    }

    /** 
     * 设置 student_course.id
     * @param id student_course.id
     */
    public final void setId(Integer id) {
        this.id = id;
    }

    /** 
     * 获取 学生id student_course.student_id
     * @return 学生id
     */
    public final Integer getStudentId() {
        return studentId;
    }

    /** 
     * 设置 学生id student_course.student_id
     * @param studentId 学生id
     */
    public final void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    /** 
     * 获取 课程ID student_course.course_id
     * @return 课程ID
     */
    public final Integer getCourseId() {
        return courseId;
    }

    /** 
     * 设置 课程ID student_course.course_id
     * @param courseId 课程ID
     */
    public final void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    /** 
     * 获取 课程名称 student_course.course_name
     * @return 课程名称
     */
    public final String getCourseName() {
        return courseName;
    }

    /** 
     * 设置 课程名称 student_course.course_name
     * @param courseName 课程名称
     */
    public final void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    /** 
     * 获取 班级ID student_course.classroom_id
     * @return 班级ID
     */
    public final Integer getClassroomId() {
        return classroomId;
    }

    /** 
     * 设置 班级ID student_course.classroom_id
     * @param classroomId 班级ID
     */
    public final void setClassroomId(Integer classroomId) {
        this.classroomId = classroomId;
    }

    /** 
     * 获取 班级名称 student_course.classroom_name
     * @return 班级名称
     */
    public final String getClassroomName() {
        return classroomName;
    }

    /** 
     * 设置 班级名称 student_course.classroom_name
     * @param classroomName 班级名称
     */
    public final void setClassroomName(String classroomName) {
        this.classroomName = classroomName == null ? null : classroomName.trim();
    }

    /** 
     * 获取 是否购买课程(0-未购买;1-已购买) student_course.buy_status
     * @return 是否购买课程(0-未购买;1-已购买)
     */
    public final Integer getBuyStatus() {
        return buyStatus;
    }

    /** 
     * 设置 是否购买课程(0-未购买;1-已购买) student_course.buy_status
     * @param buyStatus 是否购买课程(0-未购买;1-已购买)
     */
    public final void setBuyStatus(Integer buyStatus) {
        this.buyStatus = buyStatus;
    }

    /** 
     * 获取 创建时间 student_course.create_time
     * @return 创建时间
     */
    public final Date getCreateTime() {
        return createTime;
    }

    /** 
     * 设置 创建时间 student_course.create_time
     * @param createTime 创建时间
     */
    public final void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /** 
     * 获取 更新时间 student_course.update_time
     * @return 更新时间
     */
    public final Date getUpdateTime() {
        return updateTime;
    }

    /** 
     * 设置 更新时间 student_course.update_time
     * @param updateTime 更新时间
     */
    public final void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /** 
     * 获取 逻辑删除 student_course.deleted
     * @return 逻辑删除
     */
    public final Byte getDeleted() {
        return deleted;
    }

    /** 
     * 设置 逻辑删除 student_course.deleted
     * @param deleted 逻辑删除
     */
    public final void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }
    
}