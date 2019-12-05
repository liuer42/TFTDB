package hibernate.service;

import hibernate.dao.championDAO;
import hibernate.entity.Champion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class championServiceImpl implements championService{
    @Autowired
    private championDAO championDAO;

    @Override
    @Transactional
    public List<Champion> getChampions() {
        return championDAO.getChampions();
    }

    @Override
    public Champion getChampion(int champId) {
        return championDAO.getChampion(champId);
    }

    @Override
    @Transactional
    public void saveChampion(Champion aChamp) {
        championDAO.saveChampion(aChamp);
    }

    @Override
    @Transactional
    public void deleteChampion(int champId) {
        championDAO.deleteChampion(champId);
    }

    @Override
    public List<Champion> getChampionByName(String theSearchTerm) {
        return championDAO.getChampionByName(theSearchTerm);
    }
}
