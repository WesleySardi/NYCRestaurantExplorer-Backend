package org.example.nycrestaurantexplorer.dto.commands;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Objects;

public class PutInspectionCommand {
    private Integer id;
    private Timestamp inspectionDate;
    private Timestamp recordDate;
    private String grade;
    private String criticalFlag;

    public PutInspectionCommand() {
    }

    public PutInspectionCommand(Integer id, Timestamp inspectionDate, Timestamp recordDate, String grade, String criticalFlag) {
        this.id = id;
        this.inspectionDate = inspectionDate;
        this.recordDate = recordDate;
        this.grade = grade;
        this.criticalFlag = criticalFlag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(Timestamp inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public Timestamp getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Timestamp recordDate) {
        this.recordDate = recordDate;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getCriticalFlag() {
        return criticalFlag;
    }

    public void setCriticalFlag(String criticalFlag) {
        this.criticalFlag = criticalFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PutInspectionCommand that = (PutInspectionCommand) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getInspectionDate(), that.getInspectionDate()) && Objects.equals(getRecordDate(), that.getRecordDate()) && Objects.equals(getGrade(), that.getGrade()) && Objects.equals(getCriticalFlag(), that.getCriticalFlag());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getInspectionDate(), getRecordDate(), getGrade(), getCriticalFlag());
    }
}
