public class Bookkeeping {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook(10);

        employeeBook.addEmployee("Петров", "Иван", "Сидорович", 1, 1000);
        employeeBook.addEmployee("Нечаев", "Петр", "Васильевич", 1, 2000);
        employeeBook.addEmployee("Сидоров", "Василий", "Петрович", 1, 3000);
        employeeBook.addEmployee("Бекетова", "Анна", "Васильевнв", 2, 50000);
        employeeBook.addEmployee("Зарев", "Михаил", "Артурович", 2, 8000);
        employeeBook.addEmployee("Пушкин", "Александр", "Сергеевич", 3, 70000);
        employeeBook.addEmployee("Сиськин", "Гиви", "Карэнович", 3, 75000);
        employeeBook.addEmployee("Могелева", "Кристина", "Андреевна", 4, 25000);
        employeeBook.addEmployee("Веселова", "Маргарита", "Кирилловна", 1, 21000);


        System.out.println(employeeBook.dataOfEmployees());
        employeeBook.deleteEmployeeById(3);
        System.out.println(employeeBook.dataOfEmployees());
        employeeBook.deleteEmployeeByFullName("Нечаев Петр Васильевич");
        System.out.println(employeeBook.dataOfEmployees());

        System.out.println(employeeBook.dataOfEmployees());
        employeeBook.modifySalaryByFullName("Зарев Михаил Артурович", 100);
        System.out.println(employeeBook.dataOfEmployees());

        System.out.println(employeeBook.dataOfEmployees());
        employeeBook.modifyDepartmentByFullName("Зарев Михаил Артурович", 6);
        System.out.println(employeeBook.dataOfEmployees());

        System.out.println(employeeBook.listOfEmployeesAllDepartment());


    }


}