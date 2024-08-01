# SOLID

INTEGRANTES DEL GRUPO: Juan David Cetina Gomez, Juliana Isabel Espinel Cortes y Ana Lucia Quintero Vargas.

OBJETIVOS DEL TRABAJO: identificar los principios SOLID violados en unas clases presentadas y codificar su solucion para su cumplimiento.


=== VIOLACIONES PRINCIPIOS SOLID ===


+ SINGLE RESPONSABILITY PRINCIPLE (SRP):

1 - Por un lado, tanto la interfaz EmployeeOperations como la clase EmployeeManajer(que implementa de la primera) violan este principio al tomar en cuenta y asumir varias responsabilidades a la vez como: agregar y remover un empleado, calcular salario y guardar en un archivo. Principalmente, esto hace que la clase pueda verse modificada por varias razones y no solo una, haciendo que su codigo sea mas propenso a errores y se dificulte su mantenimiento.

2 - En la clase SalaryCalculator se viola este principio, ya que se le esta asumiendo la responsabilidad adicional de crear una instancia para un objeto de otra clase.

+ OPEN/CLOSED PRINCIPLE (OCP):

3 -

+ LISKOV'S SUBSTITUTION PRINCIPLE (LSP):

4 - Con relacion a la clase PartTimeEmployee, el hecho de que esta sobreescriba un metodo heredado para arrojar una excepcion, indica que esta clase hija no puede llegar a ser intercambiable por su clase padre al no funcionar de la forma esperada.

+ INTERFACE SEGREGATION PRINCIPLE (ISP):

5 - La clase PartTimeEmployee, la cual extiende de la clase Employee, viola este principio al sobreescribir un metodo que realmente no necesita, haciendo que directamente se arroje una excepcion al momento de ser llamado. Lo ideal es que la clase PartTimeEmployee no se vea forzada por su clase padre a implementar un metodo que no necesita.

+ DEPENDENCY INVERSION PRINCIPLE (DIP):

6 - En la clase SalaryCalculator, se viola este principio debido a que se mantene un fuerte acoplamiento (dependencia) con otra clase, por hacerse una instancia de un objeto dentro de su metodo de calculateSalary.


=== CODIGOS DE SOLUCION ===


+ SINGLE RESPONSABILITY PRINCIPLE (SRP):

1 - En cuanto a la clase EmployeeManager, se puede mover los metodos de calculateSalary y saveToFile a otras dos clases distintas.

[PONER CODIGO]

+ OPEN/CLOSED PRINCIPLE (OCP):

2 - 


+ LISKOV'S SUBSTITUTION PRINCIPLE (LSP):

3 - 

+ INTERFACE SEGREGATION PRINCIPLE (ISP):

4 - En relacion con la clase PartTimeEmployee, se ve conveniente hacer que esta implemente de una interfaz mas especifica que le permita tener solo los metodos que realmente necesita.

[PONER CODIGO]

+ DEPENDENCY INVERSION PRINCIPLE (DIP):

5 - Para la clase SalaryCalculator, se sugiere pasar el objeto de EmployeeManager por medio del constructor en lugar de instanciarse directamente en su metodo de calculateSalary.

[PONER CODIGO]