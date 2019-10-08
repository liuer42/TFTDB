package springxml.beans;

public class champion {
    private int champId;
    private String name;
    private classInfo classId;
    private String origin;
    private int cost;
    private String health;
    private int armor;
    private int mr;
    private int range;
    private String abilityName;
    private String abilityDesc;

    public champion() {

    }

    public int getChampId(){
        return this.champId;
    }
    public String getName(){
        return this.name;
    }
    public classInfo getClassId(){
        return this.classId;
    }
    public String getOrigin(){
        return this.origin;
    }
    public int getCost(){
        return this.cost;
    }
    public String getHealth(){
        return this.health;
    }
    public int getArmor(){
        return this.armor;
    }
    public int getMr(){
        return this.mr;
    }
    public int getRange(){
        return this.range;
    }
    public String getAbilityName(){
        return this.abilityName;
    }
    public String getAbilityDesc(){
        return this.abilityDesc;
    }

    public void setChampId(int id){
        this.champId = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setClassId(classInfo id){
        this.classId = id;
    }
    public void setOrigin(String origin){
        this.origin = origin;
    }
    public void setCost(int cost){
        this.cost = cost;
    }
    public void setHealth(String health){
        this.health = health;
    }
    public void setArmor(int armor){
        this.armor = armor;
    }
    public void setMr(int mr){
        this.mr = mr;
    }
    public void setRange(int range){
        this.range = range;
    }
    public void setAbilityName(String an){
        this.abilityName = an;
    }
    public void setAbilityDesc(String ad){
        this.abilityDesc = ad;
    }


}

