package hibernate.oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class Task {

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int item = 0;
        while (item != 4) {
            SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Employee.class)
                    .addAnnotatedClass(Detail.class)
                    .buildSessionFactory();
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Выберите действие, которое хотите совершить с таблицей Сотрудники/Подробности:" +
                    "\n\t1. Добавить запись" +
                    "\n\t2. Удалить запись" +
                    "\n\t3. Просмотреть все записи" +
                    "\n\t4. Завершить работу с таблицей");
            item = scanner.nextInt();
            if (item < 1 || item > 4) {
                System.out.println("Некорректный ввод");
            } else if (item == 1) {
                System.out.println("Ввод данных сотрудника...");
                Employee employee = Employee.scan();
                System.out.println("Добавение записи...");
                session.save(employee);
                System.out.println("Запись добавлена!");
            } else if (item == 2) {
                System.out.print("Введите id записи, которую хотите удалить: ");
                int id = scanner.nextInt();
                System.out.println("Удаление записи...");
                Employee employee = session.get(Employee.class, id);
                session.delete(employee);
                System.out.println("Запись удалена!");
            } else if (item == 3) {
                List<Employee> allEmployees = session.createQuery("from Employee").list();
                System.out.println("Вывод всех записей...");
                allEmployees.forEach(System.out::println);
            }
            session.getTransaction().commit();
            factory.close();
        }
    }
}
