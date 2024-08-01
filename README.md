# SOLID

INTEGRANTES DEL GRUPO: Juan David Cetina Gómez, Juliana Isabel Espinel Cortés y Ana Lucía Quintero Vargas.

OBJETIVOS DEL TRABAJO: identificar los principios SOLID violados en las clases indicadas y codificar su solución para su cumplimiento.


=== VIOLACIONES PRINCIPIOS SOLID ===


+ SINGLE RESPONSABILITY PRINCIPLE (SRP):

1 - Tanto la interfaz EmployeeOperations como la clase EmployeeManager (que implementa de la primera) violan este principio al asumir varias responsabilidades a la vez, como: agregar y remover un empleado, calcular salario y guardar en un archivo. Principalmente, esto hace que la clase pueda verse modificada por varias razones y no solo una, haciendo que su código sea más propenso a errores y se dificulte su mantenimiento.

2 - En la clase SalaryCalculator se viola este principio, ya que se le esta asumiendo la responsabilidad adicional de crear una instancia para un objeto de otra clase.

+ OPEN/CLOSED PRINCIPLE (OCP):

3 -

+ LISKOV'S SUBSTITUTION PRINCIPLE (LSP):

4 - Con relación a la clase PartTimeEmployee, el hecho de que esta sobreescriba un método heredado para arrojar una excepción, indica que esta clase hija no puede llegar a ser intercambiable por su clase padre al no funcionar de la forma esperada.

+ INTERFACE SEGREGATION PRINCIPLE (ISP):

5 - La clase PartTimeEmployee, la cual extiende de la clase Employee, viola este principio al sobreescribir un método que realmente no necesita, haciendo que directamente se arroje una excepción al momento de ser llamado. Lo ideal es que la clase PartTimeEmployee no se vea forzada a implementar un método que no necesita por su clase padre.

+ DEPENDENCY INVERSION PRINCIPLE (DIP):

6 - En la clase SalaryCalculator, se viola este principio debido a que se mantene un fuerte acoplamiento (dependencia) con otra clase, por hacerse una instancia de un objeto dentro de su método de calculateSalary.


=== CÓDIGOS DE SOLUCIÓN ===


+ SINGLE RESPONSABILITY PRINCIPLE (SRP):

1 - En cuanto a la clase EmployeeManager, se pueden mover los métodos de calculateSalary y saveToFile a otras dos clases distintas para que solo se maneje la responsabilidad de agregar o eliminar un empleado.

[PONER CÓDIGO]

+ OPEN/CLOSED PRINCIPLE (OCP):

2 - 


+ LISKOV'S SUBSTITUTION PRINCIPLE (LSP):

3 - 

+ INTERFACE SEGREGATION PRINCIPLE (ISP):

4 - Con relación a la clase PartTimeEmployee, se ve conveniente hacer que esta implemente de una interfaz más específica que le permita tener solo los métodos que realmente necesita.

[PONER CÓDIGO]

+ DEPENDENCY INVERSION PRINCIPLE (DIP):

5 - Para la clase SalaryCalculator se sugiere pasar el objeto de EmployeeManager por medio del constructor en lugar de instanciarse directamente en su método de calculateSalary.

[PONER CÓDIGO] 
