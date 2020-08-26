/* https://github.com/orange1438 */
package com.athjt.entity;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/** 
 * @author orange1438 code generator
 * date:2020/08/21 20:13
 */
public class Student implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 6609066925640417309L;

    /** 
     */
	@Id
    private Integer id;

    /** 
     * 用户昵称
     */ 
    private String userName;

    /** 
     * 性别  默认：0
     */ 
    private Integer sex;

    /** 
     * 电话号码
     */ 
    private String mobile;

    /** 
     * 密码
     */ 
    private String loginPassword;

    /** 
     * 删除状态(0-未删除;1-已删除)  默认：0
     */ 
    private Integer deleted;

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
     * 该记录创建时间
     */ 
    private Date createTime;

    /** 
     * 更新时间
     */ 
    private Date updateTime;

    /** 
     * 获取 student.id
     * @return student.id
     */
    public final Integer getId() {
        return id;
    }

    /** 
     * 设置 student.id
     * @param id student.id
     */
    public final void setId(Integer id) {
        this.id = id;
    }

    /** 
     * 获取 用户昵称 student.user_name
     * @return 用户昵称
     */
    public final String getUserName() {
        return userName;
    }

    /** 
     * 设置 用户昵称 student.user_name
     * @param userName 用户昵称
     */
    public final void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /** 
     * 获取 性别 student.sex
     * @return 性别
     */
    public final Integer getSex() {
        return sex;
    }

    /** 
     * 设置 性别 student.sex
     * @param sex 性别
     */
    public final void setSex(Integer sex) {
        this.sex = sex;
    }

    /** 
     * 获取 电话号码 student.mobile
     * @return 电话号码
     */
    public final String getMobile() {
        return mobile;
    }

    /** 
     * 设置 电话号码 student.mobile
     * @param mobile 电话号码
     */
    public final void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /** 
     * 获取 密码 student.login_password
     * @return 密码
     */
    public final String getLoginPassword() {
        return loginPassword;
    }

    /** 
     * 设置 密码 student.login_password
     * @param loginPassword 密码
     */
    public final void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword == null ? null : loginPassword.trim();
    }

    /** 
     * 获取 删除状态(0-未删除;1-已删除) student.deleted
     * @return 删除状态(0-未删除;1-已删除)
     */
    public final Integer getDeleted() {
        return deleted;
    }

    /** 
     * 设置 删除状态(0-未删除;1-已删除) student.deleted
     * @param deleted 删除状态(0-未删除;1-已删除)
     */
    public final void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    /** 
     * 获取 课程ID student.course_id
     * @return 课程ID
     */
    public final Integer getCourseId() {
        return courseId;
    }

    /** 
     * 设置 课程ID student.course_id
     * @param courseId 课程ID
     */
    public final void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    /** 
     * 获取 课程名称 student.course_name
     * @return 课程名称
     */
    public final String getCourseName() {
        return courseName;
    }

    /** 
     * 设置 课程名称 student.course_name
     * @param courseName 课程名称
     */
    public final void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    /** 
     * 获取 班级ID student.classroom_id
     * @return 班级ID
     */
    public final Integer getClassroomId() {
        return classroomId;
    }

    /** 
     * 设置 班级ID student.classroom_id
     * @param classroomId 班级ID
     */
    public final void setClassroomId(Integer classroomId) {
        this.classroomId = classroomId;
    }

    /** 
     * 获取 班级名称 student.classroom_name
     * @return 班级名称
     */
    public final String getClassroomName() {
        return classroomName;
    }

    /** 
     * 设置 班级名称 student.classroom_name
     * @param classroomName 班级名称
     */
    public final void setClassroomName(String classroomName) {
        this.classroomName = classroomName == null ? null : classroomName.trim();
    }

    /** 
     * 获取 是否购买课程(0-未购买;1-已购买) student.buy_status
     * @return 是否购买课程(0-未购买;1-已购买)
     */
    public final Integer getBuyStatus() {
        return buyStatus;
    }

    /** 
     * 设置 是否购买课程(0-未购买;1-已购买) student.buy_status
     * @param buyStatus 是否购买课程(0-未购买;1-已购买)
     */
    public final void setBuyStatus(Integer buyStatus) {
        this.buyStatus = buyStatus;
    }

    /** 
     * 获取 该记录创建时间 student.create_time
     * @return 该记录创建时间
     */
    public final Date getCreateTime() {
        return createTime;
    }

    /** 
     * 设置 该记录创建时间 student.create_time
     * @param createTime 该记录创建时间
     */
    public final void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /** 
     * 获取 更新时间 student.update_time
     * @return 更新时间
     */
    public final Date getUpdateTime() {
        return updateTime;
    }

    /** 
     * 设置 更新时间 student.update_time
     * @param updateTime 更新时间
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
        sb.append(", userName=").append(userName);
        sb.append(", sex=").append(sex);
        sb.append(", mobile=").append(mobile);
        sb.append(", loginPassword=").append(loginPassword);
        sb.append(", deleted=").append(deleted);
        sb.append(", courseId=").append(courseId);
        sb.append(", courseName=").append(courseName);
        sb.append(", classroomId=").append(classroomId);
        sb.append(", classroomName=").append(classroomName);
        sb.append(", buyStatus=").append(buyStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}