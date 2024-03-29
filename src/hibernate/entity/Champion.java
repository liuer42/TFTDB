package hibernate.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Champions")
public class Champion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="champid")
    private int champId;

    @Column(name="name")
    @NotNull(message = "required")
    private String champName;

    // a class type can have many champions but a champion can only be one class type
    //eager fetch type loads up the relationship before being called by a getter
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="class")
    private hibernate.entity.Class className;

    @Column(name="origin")
    private String origin;

    @Column(name="cost")
    private int cost;

    @Column(name="health")
    private String health;

    @Column(name="armor")
    private int armor;

    @Column(name="magicresist")
    private int magicResist;

    @Column(name="range")
    private int range;

    @Column(name="abilityname")
    private String abilityName;

    @Column(name="abilitydesc")
    private String abilityDesc;

    public Champion() {

    }

    public Champion(String name, String origin, int cost, String health, int armor, int magicResist, int range, String abilityName, String abilityDesc) {
        this.champName = name;
        this.origin = origin;
        this.cost = cost;
        this.health = health;
        this.armor = armor;
        this.magicResist = magicResist;
        this.range = range;
        this.abilityName = abilityName;
        this.abilityDesc = abilityDesc;
    }

    @Override
    public String toString() {
        return "Champion{" +
                "champId=" + champId +
                ", className=" + className +
                ", name='" + champName + '\'' +
                ", origin='" + origin + '\'' +
                ", cost=" + cost +
                ", health='" + health + '\'' +
                ", armor=" + armor +
                ", magicResist=" + magicResist +
                ", range=" + range +
                ", abilityName='" + abilityName + '\'' +
                ", abilityDesc='" + abilityDesc + '\'' +
                '}';
    }




    public int getChampId() {
        return champId;
    }

    public void setChampId(int champId) {
        this.champId = champId;
    }

    public Class getClassName() {
        return className;
    }

    public void setClassId(Class className) {
        this.className = className;
    }

    public String getChampName() {
        return champName;
    }

    public void setChampName(String champName) {
        this.champName = champName;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getMagicResist() {
        return magicResist;
    }

    public void setMagicResist(int magicResist) {
        this.magicResist = magicResist;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public String getAbilityName() {
        return abilityName;
    }

    public void setAbilityName(String abilityName) {
        this.abilityName = abilityName;
    }

    public String getAbilityDesc() {
        return abilityDesc;
    }

    public void setAbilityDesc(String abilityDesc) {
        this.abilityDesc = abilityDesc;
    }
}
