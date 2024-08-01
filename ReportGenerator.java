package com.example.demo.unsolid;

public class ReportGenerator {

    private Report report;

    public ReportGenerator(Report report) {
        this.report = report;
    }

    public void generateReport(EmployeeManager employeeManager) {
        System.out.println("Generando reporte");
        report.generarReporte(employeeManager);
    }
}
