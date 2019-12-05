package hibernate.dao;

import hibernate.entity.Champion;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class championDAOImpl implements championDAO {
    @Autowired
    private SessionFactory factory;

    @Override
    public List<Champion> getChampions() {
        Session session = factory.getCurrentSession();

        List<Champion> list = session.createQuery("from Champion", Champion.class).getResultList();

        return list;
    }

    @Override
    public Champion getChampion(int champId) {
        return null;
    }

    @Override
    public void saveChampion(Champion aChamp) {
        Session session;
        try {
            session = factory.getCurrentSession();
        } catch (HibernateException e) {
            session = factory.openSession();
        }

        session.saveOrUpdate(aChamp);
    }

    @Override
    public void deleteChampion(int champId) {
        Session session = factory.getCurrentSession();

        Query<Champion> query = session.createQuery("delete from Champion where id = :champIdToDelete");

        query.setParameter("champIdToDelete", champId);

        query.executeUpdate();
    }

    @Override
    public List<Champion> getChampionByName(String theSearchTerm) {
        Session session;
        Query query;
        try {
            session = factory.getCurrentSession();
        } catch (HibernateException e) {
            session = factory.openSession();
        }

        if(theSearchTerm != null) {
            query = session.createQuery("from Champion where lower(name) like :searchTerm");

            theSearchTerm = "%" + theSearchTerm.toLowerCase() + "%";

            query.setParameter("searchTerm", theSearchTerm);

        }
        else {
            query = session.createQuery("from Champion", Champion.class);
        }
        return query.getResultList();
    }
}
