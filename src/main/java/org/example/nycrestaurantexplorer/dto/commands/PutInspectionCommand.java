package org.example.nycrestaurantexplorer.dto.commands;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Objects;

public class PutInspectionCommand {
    private Timestamp inspectionDate;

    private String grade;

    private String criticalFlag;

    public PutInspectionCommand(Timestamp inspectionDate, String grade, String criticalFlag) {
        this.inspectionDate = inspectionDate;
        this.grade = grade;
        this.criticalFlag = criticalFlag;
    }

    public PutInspectionCommand() {
    }

    public Timestamp getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(Timestamp inspectionDate) {
        this.inspectionDate = inspectionDate;
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
        return Objects.equals(getInspectionDate(), that.getInspectionDate()) && Objects.equals(getGrade(), that.getGrade()) && Objects.equals(getCriticalFlag(), that.getCriticalFlag());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInspectionDate(), getGrade(), getCriticalFlag());
    }
}
