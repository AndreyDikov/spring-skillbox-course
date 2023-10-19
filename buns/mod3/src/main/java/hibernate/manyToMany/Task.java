package hibernate.manyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class Task {

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int item = 0;
        while (item != 7) {
            SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Children.class)
                    .addAnnotatedClass(Section.class)
                    .buildSessionFactory();
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Выберите действие, которое хотите совершить с таблицей Дети/Секции:" +
                    "\n\t1. Добавить запись о ребенке" +
                    "\n\t2. Удалить запись о ребенке" +
                    "\n\t3. Добавить запись о секции" +
                    "\n\t4. Удалить запись о секции" +
                    "\n\t5. Добавить ребенка в секцию" +
                    "\n\t6. Просмотреть все записи" +
                    "\n\t7. Завершить работу с таблицей");
            item = scanner.nextInt();
            if (item < 1 || item > 7) {
                System.out.println("Некорректный ввод");
            } else if (item == 1) {
                Children children = Children.scan();
                session.save(children);
            } else if (item == 2) {
                System.out.print("Введите id записи о ребенке, которую хотите удалить: ");
                int id = scanner.nextInt();
                session.delete(session.get(Children.class, id));
            } else if (item == 3) {
                Section section = Section.scan();
                session.save(section);
            } else if (item == 4) {
                System.out.print("Введите id записи о секции, которую хотите удалить: ");
                int id = scanner.nextInt();
                session.delete(session.get(Section.class, id));
            } else if (item == 5) {
                System.out.print("Введите id ребенка: ");
                int childId = scanner.nextInt();
                System.out.print("Введите id секции: ");
                int sectionId = scanner.nextInt();
                Children child = session.get(Children.class, childId);
                Section section = session.get(Section.class, sectionId);
                if (child != null && section != null) {
                    section.addChildren(child);
                } else {
                    System.out.println("Ребенок или секция не найдены!");
                }
            } else if (item == 6) {
                System.out.println("CHILDREN:");
                List<Children> children = session.createQuery("from Children", Children.class).getResultList();
                children.forEach(System.out::println);
                System.out.println("\nSECTIONS:");
                List<Section> sections = session.createQuery("from Section", Section.class).getResultList();
                sections.forEach(System.out::println);
                System.out.println("\nCHILDREN-SECTIONS:");
                children.forEach(c -> {
                    System.out.println("ID: " + c.getId() + ": ");
                    c.getSections().forEach(System.out::println);
                });
            }
            session.getTransaction().commit();
            factory.close();
        }
    }
}
