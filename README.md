# SOLID

INTEGRANTES DEL GRUPO: Juan David Cetina Gómez, Juliana Isabel Espinel Cortés y Ana Lucía Quintero Vargas.

OBJETIVOS DEL TRABAJO: identificar los principios SOLID violados en las clases indicadas y codificar su solución para su cumplimiento.


=== VIOLACIONES PRINCIPIOS SOLID ===


1 - SINGLE RESPONSABILITY PRINCIPLE (SRP):

+ Tanto la interfaz EmployeeOperations como la clase EmployeeManager (que implementa de la primera) violan este principio al asumir varias responsabilidades a la vez, como: agregar y remover un empleado, calcular salario y guardar en un archivo. Principalmente, esto hace que la clase pueda verse modificada por varias razones y no solo una, haciendo que su código sea más propenso a errores y se dificulte su mantenimiento.

+ En la clase SalaryCalculator se viola este principio, ya que se le esta asumiendo la responsabilidad adicional de crear una instancia para un objeto de otra clase.

+ Se viola este principio en la clase ReportGenerator, ya que tiene como múltiple responsabilidad el tener métodos que permiten generar reportes en diferentes formatos. 

2 - OPEN/CLOSED PRINCIPLE (OCP):

+ En la clase ReportGenerator también se llega a violar este principio, debido a que si en un futuro se desea modificar o implementar nuevos formatos para presentar los informes, se debe manipular el código existente en la clase, haciendo que no cerrada para su modificación y no sea abierta a una fácil extensión.

3 - LISKOV'S SUBSTITUTION PRINCIPLE (LSP):

+ Con relación a la clase PartTimeEmployee, el hecho de que esta sobreescriba un método heredado para arrojar una excepción, indica que esta clase hija no puede llegar a ser intercambiable por su clase padre al no funcionar de la forma esperada.

4 - INTERFACE SEGREGATION PRINCIPLE (ISP):

+ La clase PartTimeEmployee, la cual extiende de la clase Employee, viola este principio al sobreescribir un método que realmente no necesita, haciendo que directamente se arroje una excepción al momento de ser llamado. Lo ideal es que la clase PartTimeEmployee no se vea forzada a implementar un método que no necesita por su clase padre.

5 - DEPENDENCY INVERSION PRINCIPLE (DIP):

+ En la clase SalaryCalculator, se viola este principio debido a que se mantene un fuerte acoplamiento (dependencia) con otra clase, por hacerse una instancia de un objeto dentro de su método de calculateSalary.


=== CÓDIGOS DE SOLUCIÓN ===


1 - SINGLE RESPONSABILITY PRINCIPLE (SRP):

+ En cuanto a la clase EmployeeManager, se pueden mover los métodos de calculateSalary y saveToFile a otras dos clases distintas para que solo se maneje la responsabilidad de agregar o eliminar un empleado.

+ Para que la clase ReportGenerator cumpla también con este principio, se divide sus responsabilidades en dos clases específicas (ReportExcel y ReportPDF), las cuales implementan de la interface Report.

2 - OPEN/CLOSED PRINCIPLE (OCP):

+ Se vió conveniente crear la interface Report y las clases ReportPDF y ReportExcel; asimismo, se modificó la clase ReportGenerator, para que se respete este principio.

+ Con relación a los reportes, crear la interface Report e implementar las clases ReportExcel y ReportPDF permiten cumplir con este principio. Esto debido a que se permite crear nuevas clases que implementen de la interface Report, haciendo que en un futuro se puedan añadir nuevos formatos de reporte (abierto a la extensión), sin que todo este proceso llegue a alterar el código existente.
  
3 - LISKOV'S SUBSTITUTION PRINCIPLE (LSP):

+ Con relación a la clase PartTimeEmployee, para que se cumpla el principio de Liskov, es necesario que la clase PartTimeEmployee implemente getName de una manera válida.

4 - INTERFACE SEGREGATION PRINCIPLE (ISP):

+ La clase PartTimeEmployee no necesita el método getName, por ende, Empployee está definiendo métodos innecesarios para ser implementados dentro de esta clase, por lo que se puede definir una interfaz que use el método getName para que sea implementado en las clases necesarias.

5 - DEPENDENCY INVERSION PRINCIPLE (DIP):

+ Para la clase SalaryCalculator se sugiere pasar el objeto de EmployeeManager por medio del constructor en lugar de instanciarse directamente en su método de calculateSalary.