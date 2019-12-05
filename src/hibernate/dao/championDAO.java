package hibernate.dao;

import hibernate.entity.Champion;

import java.util.List;

public interface championDAO {

    List<Champion> getChampions();

    Champion getChampion(int champId);

    void saveChampion(Champion aChamp);

    void deleteChampion(int champId);

    List<Champion> getChampionByName(String theSearchTerm);
}
