package hibernate.service;

import java.util.List;

public interface classService {
    List<hibernate.entity.Class> getClasses();

    hibernate.entity.Class getClass(int classId);

    void saveClass(hibernate.entity.Class aClass);
}
