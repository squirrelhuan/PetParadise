package com.huan.administrator.petparadise.bean;

/**
 * 宠物技能
 * Created by Administrator on 2017/3/18.
 */
public class PetSkill {
    private int Type;
    /**
     * 低级，高级，无等级
     */
    private int SkillClass;
    private String HeadImage;
    private String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }

    public String getHeadImage() {
        return HeadImage;
    }

    public void setHeadImage(String headImage) {
        HeadImage = headImage;
    }

    public int getSkillClass() {
        return SkillClass;
    }

    public void setSkillClass(int skillClass) {
        SkillClass = skillClass;
    }

    public interface PetSkillClass{
        int Low = 1;
        int High = 2;
        int None = 3;
    }
}
