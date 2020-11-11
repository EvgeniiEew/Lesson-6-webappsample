package by.grodno.pvt.site.webappsample.service;

import java.util.Date;

public class UserDep {
    private Integer id;
    private String firstName;
    private String lastName;
    private Double salary;
    private Date birthdate;
    private boolean male;
    private Integer depNumber;
    private Integer idDept;
    private String nameDept;

    public UserDep(Integer id, String firstName, String lastName, Double salary, Date birthdate, boolean male, Integer depNumber, Integer idDept, String nameDept) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.birthdate = birthdate;
        this.male = male;
        this.depNumber = depNumber;
        this.idDept = idDept;
        this.nameDept = nameDept;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Double getSalary() {
        return salary;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public boolean isMale() {
        return male;
    }

    public Integer getDepNumber() {
        return depNumber;
    }

    public Integer getIdDept() {
        return idDept;
    }

    public String getNameDept() {
        return nameDept;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public void setDepNumber(Integer depNumber) {
        this.depNumber = depNumber;
    }

    public void setIdDept(Integer idDept) {
        this.idDept = idDept;
    }

    public void setNameDept(String nameDept) {
        this.nameDept = nameDept;
    }
}
