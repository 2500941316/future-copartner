package com.shu.copartner.pojo;

import java.io.Serializable;
import java.util.Date;

public class ProPerson implements Serializable {
    private Long personid;

    private Date birthday;

    private String campus;

    private String company;

    private String education;

    private String name;

    private Date gradutedate;

    private String major;

    private String resumeurl;

    private String sex;

    private String workername;

    private String description;

    private Boolean supervisor;

    private String expectproject;

    private String expectstudent;

    private String expectother;

    private String labelperson;

    private String labelalumnus;

    private String labelalumnicompany;

    private String labelincubator;

    private String labelinstitutions;

    private String labelother;

    private String phone;

    private String address;

    private String email;

    private Date logindate;

    private String auth;

    // 表中没有该字段，临时使用该变量，将数据传到前端
    private String imageUrl;

    private static final long serialVersionUID = 1L;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getPersonid() {
        return personid;
    }

    public void setPersonid(Long personid) {
        this.personid = personid;
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

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getGradutedate() {
        return gradutedate;
    }

    public void setGradutedate(Date gradutedate) {
        this.gradutedate = gradutedate;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
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

    public String getWorkername() {
        return workername;
    }

    public void setWorkername(String workername) {
        this.workername = workername == null ? null : workername.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Boolean getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Boolean supervisor) {
        this.supervisor = supervisor;
    }

    public String getExpectproject() {
        return expectproject;
    }

    public void setExpectproject(String expectproject) {
        this.expectproject = expectproject == null ? null : expectproject.trim();
    }

    public String getExpectstudent() {
        return expectstudent;
    }

    public void setExpectstudent(String expectstudent) {
        this.expectstudent = expectstudent == null ? null : expectstudent.trim();
    }

    public String getExpectother() {
        return expectother;
    }

    public void setExpectother(String expectother) {
        this.expectother = expectother == null ? null : expectother.trim();
    }

    public String getLabelperson() {
        return labelperson;
    }

    public void setLabelperson(String labelperson) {
        this.labelperson = labelperson == null ? null : labelperson.trim();
    }

    public String getLabelalumnus() {
        return labelalumnus;
    }

    public void setLabelalumnus(String labelalumnus) {
        this.labelalumnus = labelalumnus == null ? null : labelalumnus.trim();
    }

    public String getLabelalumnicompany() {
        return labelalumnicompany;
    }

    public void setLabelalumnicompany(String labelalumnicompany) {
        this.labelalumnicompany = labelalumnicompany == null ? null : labelalumnicompany.trim();
    }

    public String getLabelincubator() {
        return labelincubator;
    }

    public void setLabelincubator(String labelincubator) {
        this.labelincubator = labelincubator == null ? null : labelincubator.trim();
    }

    public String getLabelinstitutions() {
        return labelinstitutions;
    }

    public void setLabelinstitutions(String labelinstitutions) {
        this.labelinstitutions = labelinstitutions == null ? null : labelinstitutions.trim();
    }

    public String getLabelother() {
        return labelother;
    }

    public void setLabelother(String labelother) {
        this.labelother = labelother == null ? null : labelother.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getLogindate() {
        return logindate;
    }

    public void setLogindate(Date logindate) {
        this.logindate = logindate;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth == null ? null : auth.trim();
    }

    @Override
    public String toString() {
        return "ProPerson{" +
                "personid=" + personid +
                ", birthday=" + birthday +
                ", campus='" + campus + '\'' +
                ", company='" + company + '\'' +
                ", education='" + education + '\'' +
                ", name='" + name + '\'' +
                ", gradutedate=" + gradutedate +
                ", major='" + major + '\'' +
                ", resumeurl='" + resumeurl + '\'' +
                ", sex='" + sex + '\'' +
                ", workername='" + workername + '\'' +
                ", description='" + description + '\'' +
                ", supervisor=" + supervisor +
                ", expectproject='" + expectproject + '\'' +
                ", expectstudent='" + expectstudent + '\'' +
                ", expectother='" + expectother + '\'' +
                ", labelperson='" + labelperson + '\'' +
                ", labelalumnus='" + labelalumnus + '\'' +
                ", labelalumnicompany='" + labelalumnicompany + '\'' +
                ", labelincubator='" + labelincubator + '\'' +
                ", labelinstitutions='" + labelinstitutions + '\'' +
                ", labelother='" + labelother + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", logindate=" + logindate +
                ", auth='" + auth + '\'' +
                '}';
    }
}