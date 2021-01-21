package com.shu.copartner.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class ProRegister implements Serializable {
    private Long id;

    private String auth;

    private Integer applystatus;

    private String advice;

    private String phone;

    private Date applydate;

    private Date birthday;

    private String campus;

    private String company;

    private String education;

    private Date gradutedate;

    private String major;

    private String workername;

    private String description;

    private Boolean supervisor;

    private String name;

    private String department;

    private String sex;

    private Date admissiondate;

    private String studentnumber;

    private String teachernumber;

    private String mail;

    private String expectproject;

    private String expectstudent;

    private String expectother;

    private String labelperson;

    private String labelalumnus;

    private String labelalumnicompany;

    private String labelincubator;

    private String labelinstitutions;

    private String labelother;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth == null ? null : auth.trim();
    }

    public Integer getApplystatus() {
        return applystatus;
    }

    public void setApplystatus(Integer applystatus) {
        this.applystatus = applystatus;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice == null ? null : advice.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getApplydate() {
        return applydate;
    }

    public void setApplydate(Date applydate) {
        this.applydate = applydate;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getAdmissiondate() {
        return admissiondate;
    }

    public void setAdmissiondate(Date admissiondate) {
        this.admissiondate = admissiondate;
    }

    public String getStudentnumber() {
        return studentnumber;
    }

    public void setStudentnumber(String studentnumber) {
        this.studentnumber = studentnumber == null ? null : studentnumber.trim();
    }

    public String getTeachernumber() {
        return teachernumber;
    }

    public void setTeachernumber(String teachernumber) {
        this.teachernumber = teachernumber == null ? null : teachernumber.trim();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
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
}