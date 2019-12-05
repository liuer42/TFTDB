package hibernate.dao;

import java.util.List;

public interface classDAO {
    List<hibernate.entity.Class> getClasses();

    hibernate.entity.Class getClass(int id);

    void saveClass(hibernate.entity.Class aClass);
}
