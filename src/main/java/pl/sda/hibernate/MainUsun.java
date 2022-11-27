package pl.sda.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

public class MainUsun {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Scanner scanner = new Scanner(System.in);
            System.out.println("Co chcesz usunąc, student czy ocena?");
            String encjaUsuwana = scanner.nextLine();
            if (encjaUsuwana.equalsIgnoreCase("ocena")) {

                System.out.println("Podaj id studenta którego chcesz usunąć");
                String id = scanner.nextLine();
                Long ocenaId = Long.parseLong(id);

                Ocena ocena = session.get(Ocena.class, ocenaId);
                if (ocena != null) {

                    session.remove(ocena);
                } else {
                    System.err.println("Ocena nie istnieje");
                }
            } else if (encjaUsuwana.equalsIgnoreCase("student")) {
                System.out.println("Podaj id studenta którego chcesz usunąć");
                String idStudenta = scanner.nextLine();
                Long studentId = Long.parseLong(idStudenta);

                Student student = session.get(Student.class, studentId);
                if (student != null) {
                    if (!student.getOceny().isEmpty()) {
                        for (Ocena ocenaStudenta : student.getOceny()) {
                            session.remove(ocenaStudenta);
                        }
                    }
                    session.remove(student);
                }else{
                    System.out.println("nie ma takiego studenta");
                }
            }
            System.out.println("nie ma takiej komendy");
            transaction.commit();
        } catch (Exception ioe) {
            System.err.println("wyjątek");
        }
    }
}

