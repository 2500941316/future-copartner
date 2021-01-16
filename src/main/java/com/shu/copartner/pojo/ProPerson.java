package com.shu.copartner.pojo;

import java.io.Serializable;
import java.util.Date;

public class ProPerson implements Serializable {
    private Long id;

    private String address;

    private Integer age;

    private Date birthday;

    private String campus;

    private String company;

    private String department;

    private String education;

    private String educationbackground;

    private String email;

    private String experiencestring;

    private String isgraduate;

    private String major;

    private String photourl;

    private String resumeurl;

    private String sex;

    private String username;

    private String vediourl;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus == null ? null : campus.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getEducationbackground() {
        return educationbackground;
    }

    public void setEducationbackground(String educationbackground) {
        this.educationbackground = educationbackground == null ? null : educationbackground.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getExperiencestring() {
        return experiencestring;
    }

    public void setExperiencestring(String experiencestring) {
        this.experiencestring = experiencestring == null ? null : experiencestring.trim();
    }

    public String getIsgraduate() {
        return isgraduate;
    }

    public void setIsgraduate(String isgraduate) {
        this.isgraduate = isgraduate == null ? null : isgraduate.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public String getPhotourl() {
        return photourl;
    }

    public void setPhotourl(String photourl) {
        this.photourl = photourl == null ? null : photourl.trim();
    }

    public String getResumeurl() {
        return resumeurl;
    }

    public void setResumeurl(String resumeurl) {
        this.resumeurl = resumeurl == null ? null : resumeurl.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getVediourl() {
        return vediourl;
    }

    public void setVediourl(String vediourl) {
        this.vediourl = vediourl == null ? null : vediourl.trim();
    }
}