package hibernate.service;

import hibernate.dao.classDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class classServiceImpl implements classService{
    @Autowired
    private classDAO classDAO;

    @Override
    @Transactional
    public List<hibernate.entity.Class> getClasses() {
        return classDAO.getClasses();
    }

    @Override
    @Transactional
    public hibernate.entity.Class getClass(int id) {
        return classDAO.getClass(id);
    }

    @Override
    @Transactional
    public void saveClass(hibernate.entity.Class aClass) {
        classDAO.saveClass(aClass);
    }
}
