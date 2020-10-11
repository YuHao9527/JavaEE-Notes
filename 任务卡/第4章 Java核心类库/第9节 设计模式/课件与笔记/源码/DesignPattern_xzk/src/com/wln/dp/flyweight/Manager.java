package com.wln.dp.flyweight;

public class Manager implements Employee{

    private String tiltle="部门经理";
    private String department;
    private String reportContent;

    @Override
    public void report() {
        System.out.println(reportContent);
    }

    public Manager(String department) {
        this.department = department;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }
}
