package hibernate;

import hibernate.entity.Champion;
import hibernate.entity.Class;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateApp {

    private SessionFactory factory;

    public HibernateApp() {
        factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Champion.class)
                .addAnnotatedClass(Class.class)
                .buildSessionFactory();
    }

    public void close() {factory.close();}

    public static void main(String[] args) {
        HibernateApp app = new HibernateApp();

        try {
            //makes a champion and assigns a class
            app.createChampion();

            //reads champions by a classid type
            app.readChampionsByClass(4);

            //makes a new class with description
            app.createClass();

            //updates a champions class by id
            app.updateChampion();

            //deletes a champion by champid
            //app.deleteChampion(404);

            //deletes a class by classid
            //app.deleteClass(501);


        } finally {
            app.close();
        }
    }

    private void createChampion() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        //created already
        /*Champion aChampion = new Champion("Olaf", "Glacial", 5, "100 / 200 / 300", 20, 20, 3, "Berserker Rage", "Olaf gains attack speed and lifesteal, and becomes immune to crowd control until the end of the battle.");*/

        Champion aChampion = new Champion("Renekton", "Desert", 3, "600 / 1080 / 2160", 20, 20, 1, "Cull the Meek", "Renekton swings his blade, dealing damage to nearby enemies and restoring health.");

        Class aClass = session.get(Class.class, 601);

        aChampion.setClassId(aClass);
        aClass.add(aChampion);

        session.save(aChampion);

        session.getTransaction().commit();
    }

    private void readChampionsByClass(int classId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Class champClasses = session.get(Class.class, classId);
        System.out.println(champClasses);
        for (Champion aChampion : champClasses.getChampions()) {
            System.out.println(aChampion);
        }

        session.getTransaction().commit();
    }

    private void updateChampion() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        session.createQuery("update Champion set cost = 5 where champId = 6").executeUpdate();

        session.getTransaction().commit();

    }

    private void deleteChampion(int champId) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Champion aChampion = session.get(Champion.class, champId);
        if (aChampion != null)
            session.delete(aChampion);

        session.getTransaction().commit();

    }

    private void createClass() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Class aClass = new Class("Alchemist", "Alchemists ignore collision and never stop moving.");
        session.save(aClass);

        session.getTransaction().commit();
    }

    private void readClass(int classId) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Class champClasses = session.get(Class.class, classId);
        System.out.println(champClasses);
    }

    private void updateClass() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        List<Class> classList =
        session.createQuery("from Classes order by name asc").getResultList();
        classList.get(0).setName("Test Classname");

        session.getTransaction().commit();
    }

    private void deleteClass(int classId) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Class aClass = session.get(Class.class, classId);
        if (aClass != null)
            session.delete(aClass);

        session.getTransaction().commit();

    }
}
