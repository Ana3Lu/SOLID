import com.example.demo.unsolid.EmployeeManager;
public class ReportGenerator {

    private Report report;

    public ReportGenerator(Report report) {
        this.report = report;
    }

    public void generateReport(EmployeeManager employeeManager) {
        System.out.println("Generando reporte");
        this.report.generarReporte();
    }


}

