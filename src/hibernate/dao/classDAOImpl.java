package hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class classDAOImpl implements classDAO{
    @Autowired
    private SessionFactory factory;

    @Override
    public List<hibernate.entity.Class> getClasses() {
        Session session = factory.getCurrentSession();

        List<hibernate.entity.Class> list = session.createQuery("from hibernate.entity.Class", hibernate.entity.Class.class).getResultList();

        return list;
    }

    @Override
    public hibernate.entity.Class getClass(int id) {
        Session session = factory.getCurrentSession();

        return session.get(hibernate.entity.Class.class, id);
    }

    @Override
    public void saveClass(hibernate.entity.Class aClass) {
        Session session = factory.getCurrentSession();

        session.save(aClass);
    }
}
