public class EmployeeBook {
    private int numberOfEmployees;
    private Employee[] employeesBook;

    public EmployeeBook(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
        this.employeesBook = new Employee[numberOfEmployees];
    }

    @Override
    public String toString() {
        return "EmployeeBook: " +
                "numberOfEmployees=" + numberOfEmployees +
                ", employees=\n{\n" + dataOfEmployees() +
                "}\n";
    }

    public void addEmployee(String surname, String name, String middleName, int department, int salary) {
        int firstNullInBase = firstNullInBase();
        if (firstNullInBase >= 0) {
            employeesBook[firstNullInBase] = new Employee(surname, name, middleName, department, salary);
        }
    }

    public void deleteEmployeeById(int id) {
        boolean deleted = false;
        for (int i = 0; i < employeesBook.length; i++) {
            if (checkFilled(i) && employeesBook[i].getId() == id) {
                employeesBook[i] = null;
                deleted = true;
            }
        }
        if (deleted == false) {
            System.out.printf("Сотрудник с id %d не существует.\n", id);
        }


    }

    public void deleteEmployeeByFullName(String fullName) {
        int count = 0;
        int id = 0;
        for (int i = 0; i < employeesBook.length; i++) {
            if (checkFilled(i) && employeesBook[i].getFullName().equals(fullName)) {
                count++;
                id = employeesBook[i].getId();
            }
        }
        if (count == 1 && id != 0) {
            deleteEmployeeById(id);
        } else if (count == 0) {
            System.out.printf("Сотрудника с Ф.И.О. %s не существует.\n", fullName);
        } else if (count > 1) {
            System.out.printf("Обнаружено несколько сотрудников с Ф.И.О. %s. " +
                    "Используйте id для операции.\n", fullName);
        }


    }

    public void modifySalaryByById(int id, int salary) {
        boolean modify = false;
        for (int i = 0; i < employeesBook.length; i++) {
            if (checkFilled(i) && employeesBook[i].getId() == id) {
                employeesBook[i].setSalary(salary);
                modify = true;
            }
        }
        if (modify == false) {
            System.out.printf("Сотрудник с id %d не существует.\n", id);
        }
    }

    public void modifySalaryByFullName(String fullName, int salary) {
        int count = 0;
        int id = 0;
        for (int i = 0; i < employeesBook.length; i++) {
            if (checkFilled(i) && employeesBook[i].getFullName().equals(fullName)) {
                count++;
                id = employeesBook[i].getId();
            }
        }
        if (count == 1 && id != 0) {
            modifySalaryByById(id, salary);
        } else if (count == 0) {
            System.out.printf("Сотрудника с Ф.И.О. %s не существует.\n", fullName);
        } else if (count > 1) {
            System.out.printf("Обнаружено несколько сотрудников с Ф.И.О. %s. " +
                    "Используйте id для операции.\n", fullName);
        }


    }

    public void modifyDepartmentByById(int id, int department) {
        boolean modify = false;
        for (int i = 0; i < employeesBook.length; i++) {
            if (checkFilled(i) && employeesBook[i].getId() == id) {
                employeesBook[i].setDepartment(department);
                modify = true;
            }
        }
        if (modify == false) {
            System.out.printf("Сотрудник с id %d не существует.\n", id);
        }


    }

    public void modifyDepartmentByFullName(String fullName, int department) {
        int count = 0;
        int id = 0;
        for (int i = 0; i < employeesBook.length; i++) {
            if (checkFilled(i) && employeesBook[i].getFullName().equals(fullName)) {
                count++;
                id = employeesBook[i].getId();
            }
        }
        if (count == 1 && id != 0) {
            modifyDepartmentByById(id, department);
        } else if (count == 0) {
            System.out.printf("Сотрудника с Ф.И.О. %s не существует.\n", fullName);
        } else if (count > 1) {
            System.out.printf("Обнаружено несколько сотрудников с Ф.И.О. %s. " +
                    "Используйте id для операции.\n", fullName);
        }


    }


    public String dataOfEmployees() {
        int firstEnterInBase = firstEnterInBase();
        if (firstEnterInBase == -1) {
            return "None";
        }

        String dataOfEmployees = "";

        for (int i = firstEnterInBase; i < employeesBook.length; i++) {
            if (checkFilled(i)) {
                dataOfEmployees += employeesBook[i] + "\n";
            }
        }

        return dataOfEmployees;
    }


    public String listOfEmployees() {
        int firstEnterInBase = firstEnterInBase();
        if (firstEnterInBase == -1) {
            return "None";
        }

        String listOfEmployees = "";

        for (int i = firstEnterInBase; i < employeesBook.length; i++) {
            if (checkFilled(i)) {
                listOfEmployees += employeesBook[i].getFullName() + "\n";
            }
        }

        return listOfEmployees;
    }


    public String listOfEmployeesInDepartment(int department) {
        int firstEnterInBaseDepartment = firstEnterInBaseDepartment(department);
        if (firstEnterInBaseDepartment == -1) {
            return "None";
        }
        String listOfEmployeesInDepartment = "";

        for (int i = firstEnterInBaseDepartment; i < employeesBook.length; i++) {
            if (checkFilled(i) && employeesBook[i].getDepartment() == department) {
                listOfEmployeesInDepartment += "id " + employeesBook[i].getId() + ", Ф.И.О." +
                        employeesBook[i].getFullName() + ", зарплата " + employeesBook[i].getSalary() + "\n";
            }
        }

        return listOfEmployeesInDepartment;
    }


    public String listOfEmployeesAllDepartment() {
        int firstEnterInBase = firstEnterInBase();
        if (firstEnterInBase == -1) {
            return "None";
        }
        String listOfEmployeesAllDepartment = "";
        for (int j = 0; j <= maxDepartment(); j++) {
            for (int i = firstEnterInBase; i < employeesBook.length; i++) {
                if (checkFilled(i) && employeesBook[i].getDepartment() == j) {
                    listOfEmployeesAllDepartment += "Отдел " + employeesBook[i].getDepartment() +
                            ", Ф.И.О. " + employeesBook[i].getFullName() + ", id " + employeesBook[i].getId() + "\n";
                }
            }
        }
        return listOfEmployeesAllDepartment;
    }


    public int summSalary() {
        int firstEnterInBase = firstEnterInBase();
        if (firstEnterInBase == -1) {
            return 0;
        }

        int summSalary = 0;

        for (int i = firstEnterInBase; i < employeesBook.length; i++) {
            if (checkFilled(i)) {
                summSalary += employeesBook[i].getSalary();
            }
        }

        return summSalary;
    }


    public int summSalaryInDepartment(int department) {
        int firstEnterInBaseDepartment = firstEnterInBaseDepartment(department);
        if (firstEnterInBaseDepartment == -1) {
            return 0;
        }

        int summSalary = 0;

        for (int i = firstEnterInBaseDepartment; i < employeesBook.length; i++) {
            if (checkFilled(i) && employeesBook[i].getDepartment() == department) {
                summSalary += employeesBook[i].getSalary();
            }
        }

        return summSalary;
    }


    public String findEmployeesMinSalary() {
        int firstEnterInBase = firstEnterInBase();
        if (firstEnterInBase == -1) {
            return "None";
        }

        int minSalary = employeesBook[firstEnterInBase].getSalary();
        int indexEmployeesMinSalary = firstEnterInBase;

        for (int i = firstEnterInBase; i < employeesBook.length; i++) {
            if (checkFilled(i) && employeesBook[i].getSalary() < minSalary) {
                minSalary = employeesBook[i].getSalary();
                indexEmployeesMinSalary = i;
            }

        }

        return employeesBook[indexEmployeesMinSalary].getFullName();
    }


    public String findEmployeesMinSalaryInDepartment(int department) {
        int firstEnterInBaseDepartment = firstEnterInBaseDepartment(department);
        if (firstEnterInBaseDepartment == -1) {
            return "None";
        }

        int minSalary = employeesBook[firstEnterInBaseDepartment].getSalary();
        int indexEmployeesMinSalary = firstEnterInBaseDepartment;

        for (int i = firstEnterInBaseDepartment; i < employeesBook.length; i++) {
            if (checkFilled(i) && employeesBook[i].getDepartment() == department &&
                    employeesBook[i].getSalary() < minSalary) {
                minSalary = employeesBook[i].getSalary();
                indexEmployeesMinSalary = i;
            }

        }

        return employeesBook[indexEmployeesMinSalary].getFullName();
    }


    public String findEmployeesMaxSalary() {
        int firstEnterInBase = firstEnterInBase();
        if (firstEnterInBase == -1) {
            return "None";
        }
        int maxSalary = employeesBook[firstEnterInBase].getSalary();
        int indexEmployeesMaxSalary = firstEnterInBase;

        for (int i = firstEnterInBase; i < employeesBook.length; i++) {
            if (checkFilled(i) && employeesBook[i].getSalary() > maxSalary) {
                maxSalary = employeesBook[i].getSalary();
                indexEmployeesMaxSalary = i;
            }

        }

        return employeesBook[indexEmployeesMaxSalary].getFullName();
    }


    public String findEmployeesMaxSalaryInDepartment(int department) {
        int firstEnterInBaseDepartment = firstEnterInBaseDepartment(department);
        if (firstEnterInBaseDepartment == -1) {
            return "None";
        }

        int maxSalary = employeesBook[firstEnterInBaseDepartment].getSalary();
        int indexEmployeesMaxSalary = firstEnterInBaseDepartment;

        for (int i = firstEnterInBaseDepartment; i < employeesBook.length; i++) {
            if (checkFilled(i) && employeesBook[i].getDepartment() == department &&
                    employeesBook[i].getSalary() > maxSalary) {
                maxSalary = employeesBook[i].getSalary();
                indexEmployeesMaxSalary = i;
            }

        }

        return employeesBook[indexEmployeesMaxSalary].getFullName();
    }


    public int avarageSalary() {
        int firstEnterInBase = firstEnterInBase();
        if (firstEnterInBase == -1) {
            return 0;
        }

        int countEmployees = 0;
        int summSalary = summSalary();

        for (int i = firstEnterInBase; i < employeesBook.length; i++) {
            if (checkFilled(i)) {
                countEmployees++;
            }
        }

        return Math.round(summSalary / countEmployees);
    }


    public int avarageSalaryInDepartment(int department) {
        int summSalaryInDepartment = summSalaryInDepartment(department);
        if (summSalaryInDepartment == 0) {
            return 0;
        }

        int countEmployees = 0;

        for (int i = 0; i < employeesBook.length; i++) {
            if (checkFilled(i) && employeesBook[i].getDepartment() == department) {
                countEmployees++;
            }
        }

        return Math.round(summSalaryInDepartment / countEmployees);
    }


    public void indexingSalaryEmployee(Employee employee, int percent) {
        if (employee != null) {
            employee.setSalary((employee.getSalary() * percent / 100) + employee.getSalary());
        }
    }


    public void indexingSalaryAllEmployee(int percent) {
        for (int i = 0; i < employeesBook.length; i++) {
            indexingSalaryEmployee(employeesBook[i], percent);
        }
    }


    public void indexingSalaryAllEmployeeInDepartment(int percent, int department) {
        for (int i = 0; i < employeesBook.length; i++) {
            if (checkFilled(i) && employeesBook[i].getDepartment() == department) {
                indexingSalaryEmployee(employeesBook[i], percent);
            }
        }
    }


    public String listOfLessSalary(int lessSalary) {
        int firstEnterInBase = firstEnterInBase();
        if (firstEnterInBase == -1) {
            return "None";
        }

        String listOfLessSalary = "";

        for (int i = 0; i < employeesBook.length; i++) {
            if (checkFilled(i) && employeesBook[i].getSalary() < lessSalary) {
                listOfLessSalary += "id " + employeesBook[i].getId() + ", Ф.И.О." + employeesBook[i].getFullName() +
                        ", отдел " + employeesBook[i].getDepartment() + ", зарплата " + employeesBook[i].getSalary() + "\n";
            }
        }

        return listOfLessSalary;
    }


    public String listOfMoreSalary(int moreSalary) {
        int firstEnterInBase = firstEnterInBase();
        if (firstEnterInBase == -1) {
            return "None";
        }

        String listOfMoreSalary = "";

        for (int i = 0; i < employeesBook.length; i++) {

            if (checkFilled(i) && employeesBook[i].getSalary() >= moreSalary) {
                listOfMoreSalary += "id " + employeesBook[i].getId() + ", Ф.И.О." + employeesBook[i].getFullName() +
                        ", отдел " + employeesBook[i].getDepartment() + ", зарплата " + employeesBook[i].getSalary() + "\n";
            }
        }

        return listOfMoreSalary;
    }


    private int firstEnterInBase() {
        for (int i = 0; i < employeesBook.length; i++) {
            if (checkFilled(i)) {
                return i;
            }
        }
        System.out.println("Запись в базе отсутствует.");
        return -1;
    }


    private int firstEnterInBaseDepartment(int department) {
        for (int i = 0; i < employeesBook.length; i++) {
            if (checkFilled(i) && employeesBook[i].getDepartment() == department) {
                return i;
            }
        }
        System.out.println("Запись в базе отсутствует.");
        return -1;
    }

    private int firstNullInBase() {
        for (int i = 0; i < employeesBook.length; i++) {
            if (employeesBook[i] == null) {
                return i;
            }
        }
        System.out.println("В базе сотрудников нет места для записи!");
        return -1;
    }

    private boolean checkFilled(int i) {
        if (employeesBook[i] == null) {
            return false;
        }

        return true;
    }


    private int maxDepartment() {
        int firstEnterInBase = firstEnterInBase();
        if (firstEnterInBase == -1) {
            return -1;
        }

        int maxDepartment = employeesBook[firstEnterInBase].getDepartment();

        for (int i = firstEnterInBase; i < employeesBook.length; i++) {

            if (checkFilled(i) && employeesBook[i].getDepartment() > maxDepartment) {
                maxDepartment = employeesBook[i].getDepartment();
            }
        }

        return maxDepartment;
    }

}
