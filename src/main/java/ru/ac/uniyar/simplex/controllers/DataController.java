package ru.ac.uniyar.simplex.controllers;

public class DataController {

    private Integer variables;

    private Integer limitations;

    private String taskType;

    public void refresh() {
        variables = null;
        limitations = null;
        taskType = null;
    }

    public boolean isSettingsGot() {
        return variables != null && limitations != null && taskType != null;
    }

    public int getVariables() {
        return variables;
    }

    public void setVariables(Integer variables) {
        this.variables = variables;
    }

    public int getLimitations() {
        return limitations;
    }

    public void setLimitations(Integer limitations) {
        this.limitations = limitations;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }
}
