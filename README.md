# SOLID

INTEGRANTES DEL GRUPO: Juan David Cetina Gómez, Juliana Isabel Espinel Cortés y Ana Lucía Quintero Vargas.

OBJETIVOS DEL TRABAJO: identificar los principios SOLID violados en las clases indicadas y codificar su solución para su cumplimiento.


=== VIOLACIONES PRINCIPIOS SOLID ===


1 - SINGLE RESPONSABILITY PRINCIPLE (SRP):

+ Tanto la interfaz EmployeeOperations como la clase EmployeeManager (que implementa de la primera) violan este principio al asumir varias responsabilidades a la vez como: agregar y remover un empleado, calcular salario y poder guardar en un archivo. Principalmente, esto hace que la clase pueda verse modificada por varias razones y no solo una, haciendo que su código sea más propenso a errores y se dificulte su mantenimiento.

+ En la clase SalaryCalculator se viola este principio, ya que se le esta asumiendo la responsabilidad adicional de crear una instancia para un objeto de otra clase.

+ Se viola este principio en la clase ReportGenerator, ya que tiene como múltiple responsabilidad el tener métodos que permiten generar reportes en diferentes formatos. 

2 - OPEN/CLOSED PRINCIPLE (OCP):

+ En la clase ReportGenerator también se llega a violar este principio, debido a que si en un futuro se desea modificar los formatos ya establecidos o implementar nuevos formatos para presentar los reportes, se debe manipular el código existente en esta clase, haciendo que no sea cerrada para su modificación y no sea abierta a una fácil extensión.

3 - LISKOV'S SUBSTITUTION PRINCIPLE (LSP):

+ Con relación a la clase PartTimeEmployee, el hecho de que esta sobreescriba un método heredado para arrojar una excepción, indica que esta clase hija no puede llegar a ser intercambiable por su clase padre al no funcionar de la forma esperada.

4 - INTERFACE SEGREGATION PRINCIPLE (ISP):

+ La clase PartTimeEmployee, la cual extiende de la clase Employee, viola este principio al sobreescribir un método que realmente no necesita, haciendo que directamente se arroje una excepción al momento de ser llamado. Lo ideal es que la clase PartTimeEmployee no se vea forzada a implementar un método que no necesita por su clase padre.

5 - DEPENDENCY INVERSION PRINCIPLE (DIP):

+ En la clase SalaryCalculator, se viola este principio debido a que se mantene un fuerte acoplamiento (dependencia) con otra clase, por hacerse una instancia de un objeto dentro de su método de calculateSalary.


=== CÓDIGOS DE SOLUCIÓN ===


1 - SINGLE RESPONSABILITY PRINCIPLE (SRP):

+ En cuanto a la clase EmployeeManager, se pueden mover los métodos de calculateSalary y saveToFile a otras dos clases concretas distintas, para que así solo se maneje desde EmployeeManager la responsabilidad de gestionar empleados, es decir, de poder agregar o eliminarlos. Esto implica tener que quitar esos mismos métodos de la interfaz EmployeeOperations de la cual implementa la clase EmployeeManager.

+ + Por un lado, se modifica la clase SalaryCalculator para que solo tenga el método calculateSalary y que se encargue exclusivamente del cálculo del salario (evitando la responsabilidad de tener que instanciar un EmployeeManager). 

+ + Por otro lado, debido a que el método de saveToFile tampoco se encuentra relacionado con la gestión de empleados sino con la persistencia de datos, se transfiere esta responsabilidad a la nueva clase EmployeePersistence.

+ Para que la clase ReportGenerator cumpla también con este principio, se dividen sus responsabilidades en dos nuevas clases concretas que son ReportExcel y ReportPDF, las cuales implementan de la nueva interfaz Report, mediente la cual las fuerza a implementar el método generarReporte, que recibe como parámetro una instancia de EmployeeManager (como estaba originalmente en los métodos de ReportGenerator).

2 - OPEN/CLOSED PRINCIPLE (OCP):

+ Con relación a los reportes, se crea la interfaz Report y se implementa las clases ReportExcel y ReportPDF para que se pueda cumplir con este principio, debido a que esto permite crear nuevas clases que puedan implementar de la interfaz Report y así se pueda añadir nuevos formatos de reporte en un futuro (abierto a la extensión), sin que esta acción llegue a alterar el código existente de las clases involucradas como ReportGenerator.
  
3 - LISKOV'S SUBSTITUTION PRINCIPLE (LSP):

+ Dentro del método constructor de la clase ReportGenerator, al momento de ejecución, el parámetro puede instanciarse tanto como ReportExcel como ReportPDF de acuerdo a lo que se reciba (polimorfismo). Esto permite cumplir con este principio, al poder permitirse esta sustitución sin que esto conlleve a un mal funcionamiento del método.

4 - INTERFACE SEGREGATION PRINCIPLE (ISP):

+ Debido a que la clase PartTimeEmployee no necesita el método getName que le hereda su clase padre, se puede cortar esta relación padre-hijo entre las clases y separar los métodos de getName y getDepartament en nuevas interfaces distintas, que en este caso son las interfaces NamedEmployee y DeparmentEmployee. Esto permite que las clases que vayan a implementar de ellas, solo utilicen los métodos que realmente necesitan; por lo que, se hace necesario que la clase Employee implemente ambas interfaces y, en cambio, la clase PartTimeEmployee solo implemente de DeparmentEmployee.

5 - DEPENDENCY INVERSION PRINCIPLE (DIP):

+ Se hace que los módulos de bajo nivel, como lo son las clases ReportExcel y ReportPDF, implementen de la interfaz Report para que así la clase ReportGenerator solo dependa de este. Lo anterior permite que los módulos de alto nivel no dependan de las de bajo nivel, permitiendo bajar el nivel de acoplamiento entre las clases.

+ Por como estaba originalmente la clase SalaryCalculator, debido a que este instanciaba un EmployeeManager, se sugirió pasar el objeto de EmployeeManager por medio del constructor y así poder quedarse como atributo privado de la clase en lugar de instanciarse directamente en su método de calculateSalary (inyección de dependencias). Sin embargo, este código solución ya no es implementado debido a que se cambió la responsabilidad de la clase calculateSalary, para que esta solo tenga el proósito de calcular el salario de los empleados.