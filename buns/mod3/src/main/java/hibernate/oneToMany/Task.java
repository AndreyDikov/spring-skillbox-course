package hibernate.oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class Task {

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int item = 0;
        while (item != 5) {
            SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Employee.class)
                    .addAnnotatedClass(Department.class)
                    .buildSessionFactory();
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Выберите действие, которое хотите совершить с таблицей Сотрудники/Департаменты:" +
                    "\n\t1. Добавить запись о сотруднике" +
                    "\n\t2. Добавить запись о департаменте" +
                    "\n\t3. Удалить запись о сотруднике" +
                    "\n\t4. Просмотреть все записи" +
                    "\n\t5. Завершить работу с таблицей");
            item = scanner.nextInt();
            if (item < 1 || item > 6) {
                System.out.println("Некорректный ввод");
            } else if (item == 1) {
                Employee employee = Employee.scan();
                System.out.print("Введите ID департамента: ");
                int departmentId = scanner.nextInt();
                Department department = session.get(Department.class, departmentId);
                if (department != null) {
                    employee.setDepartment(department);
                    session.save(employee);
                } else {
                    System.out.println("Департамент не найден, работник не добавлен!");
                }
            } else if (item == 2) {
                Department department = Department.scan();
                session.save(department);
            } else if (item == 3) {
                System.out.print("Введите ID сотрудника: ");
                int employeeId = scanner.nextInt();
                session.delete(session.get(Employee.class, employeeId));
            } else if (item == 4) {
                List<Department> departments = session.createQuery("from Department").list();
                departments.forEach((department)
                        -> System.out.println(department.toString(true)));
            }
            session.getTransaction().commit();
            factory.close();
        }
    }
}
