package springxml.beans;

public class classInfo {
    private int classId;
    private String name;
    private String description;

    public classInfo() {

    }

    public int getClassId(){
        return this.classId;
    }
    public String getName(){
        return this.name;
    }
    public String getDescription(){
        return this.description;
    }

    public void setClassId(int id){
        this.classId = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setDescription(String desc){
        this.description = desc;
    }
}