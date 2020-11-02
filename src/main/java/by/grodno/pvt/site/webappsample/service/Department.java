package by.grodno.pvt.site.webappsample.service;

public class Department {
    private Integer depNumber;
    private String nameDept;

    public Department(Integer depNumber, String nameDept) {
        this.depNumber = depNumber;
        this.nameDept = nameDept;
    }

    public Integer getDepNumber() {
        return depNumber;
    }

    public String getNameDept() {
        return nameDept;
    }

    public void setDepNumber(Integer depNumber) {
        this.depNumber = depNumber;
    }

    public void setNameDept(String nameDept) {
        this.nameDept = nameDept;
    }
}
