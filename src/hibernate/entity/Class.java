package hibernate.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="classes")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="classid")
    private int classId;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    //eager fetch type loads up the relationship before being called by a getter
    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "className", fetch=FetchType.EAGER)
    private List<Champion> champions;

    public Class() {

    }

    public Class(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Class{" +
                "classId=" + classId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public void add(Champion tempChamp){
        if (champions == null)
            champions = new ArrayList<>();
        champions.add(tempChamp);
        tempChamp.setClassId(this);
    }

    public List<Champion> getChampions() {
        return champions;
    }

    public void setChampions(List<Champion> champions) {
        this.champions = champions;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
