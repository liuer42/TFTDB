package springxml;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import springxml.beans.champion;
import springxml.beans.classInfo;
import springxml.services.validate;

public class SpringApp {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        champion Champ = context.getBean("champion", champion.class);
        classInfo classInfo = context.getBean("classInfo", classInfo.class);
        validate validate = context.getBean("validate", validate.class);

        System.out.println("ChampID: " + Champ.getChampId() +
                            "\nName: " + Champ.getName() +
                            "\nClass: " + Champ.getClassId().getName() +
                            "\nOrigin: " + Champ.getOrigin() +
                            "\nCost: " + Champ.getCost() +
                            "\nHealth: " + Champ.getHealth() +
                            "\nArmor: " + Champ.getArmor() +
                            "\nMagic Resist: " + Champ.getMr() +
                            "\nRange: " + Champ.getRange() +
                            "\nAbility: " + Champ.getAbilityName() +
                            "\nDescription: " + Champ.getAbilityDesc() + "\n");

        System.out.println("ID: " + classInfo.getClassId() + "\nName: " + classInfo.getName() + "\nDescription: " + classInfo.getDescription());
        //testing the validate service
        System.out.println(validate.validate(classInfo.getName()));

        String nullName = null;
        System.out.println(validate.validate(nullName));

        context.close();
    }
}