package com.huan.administrator.petparadise.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/3/17.
 */
public class Pet implements Serializable {
    private String Name;
    private String HeadImage;
    private String ShowImage;
    private List<PetSkill> Skills;
    /**
     * 类型
     */
    private int Type;
    /**
     * 级别
     */
    private int Leve;
    /**
     * 气血
     */
    private int HealthPoint;
    /**
     * 伤害
     */
    private int Damage;
    /**
     * 魔力值
     */
    private int MagicPoint;
    /**
     * 速度
     */
    private int speed;
    /**
     * 生命
     */
    private int life;
    /**
     * 经验值
     */
    private int Experience;
    /**
     * 评分
     */
    private int Grade;

    public String getHeadImage() {
        return HeadImage;
    }

    public void setHeadImage(String headImage) {
        HeadImage = headImage;
    }

    public String getShowImage() {
        return ShowImage;
    }

    public void setShowImage(String showImage) {
        ShowImage = showImage;
    }

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

    public int getGrade() {
        return Grade;
    }

    public void setGrade(int grade) {
        Grade = grade;
    }

    public int getDamage() {
        return Damage;
    }

    public void setDamage(int damage) {
        Damage = damage;
    }

    public int getExperience() {
        return Experience;
    }

    public void setExperience(int experience) {
        Experience = experience;
    }

    public int getHealthPoint() {
        return HealthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        HealthPoint = healthPoint;
    }

    public int getLeve() {
        return Leve;
    }

    public void setLeve(int leve) {
        Leve = leve;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getMagicPoint() {
        return MagicPoint;
    }

    public void setMagicPoint(int magicPoint) {
        MagicPoint = magicPoint;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public List<PetSkill> getSkills() {
        return Skills;
    }

    public void setSkills(List<PetSkill> skills) {
        Skills = skills;
    }
}
