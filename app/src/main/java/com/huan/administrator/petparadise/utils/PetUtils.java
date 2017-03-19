package com.huan.administrator.petparadise.utils;

import com.alibaba.fastjson.JSON;
import com.huan.administrator.petparadise.MyApp;
import com.huan.administrator.petparadise.R;
import com.huan.administrator.petparadise.bean.Pet;
import com.huan.administrator.petparadise.bean.PetSkill;

import java.util.List;

/**
 * Created by Administrator on 2017/3/17.
 */
public class PetUtils {

    private static List<Pet> list_pet;
    private static List<PetSkill> list_petSkill;

    /**
     * @return
     */
    public static Pet generatePet() {
        Pet pet = new Pet();
        pet.setLeve(0);
        pet.setDamage((int) Math.random() * 100);
        pet.setHealthPoint((int) Math.random() * 500);
        pet.setMagicPoint((int) Math.random() * 500);
        return pet;
    }

    public static int getPetHeadByType(int type) {
        switch (type) {
            case 0:
                return R.drawable.s_vs_105;
            case 1:
                return R.drawable.s_vs_105;
            default:
                return R.drawable.s_vs_105;
        }
    }

    public static Pet getPetByType(int type) {
        if (list_pet == null) {
            list_pet = getAllPet();
        }
        for (Pet pet : list_pet) {
            if (pet.getType() == type) {
                return pet;
            }
        }
        return null;
    }

    public static String getPetNameByType(int type) {
        if (list_pet == null) {
            list_pet = getAllPet();
        }
        for (Pet pet : list_pet) {
            if (pet.getType() == type) {
                return pet.getName();
            }
        }
        return null;
    }

    public static PetSkill getPetSkillByType(int type) {
        if (list_petSkill == null) {
            list_petSkill = getAllPetSkill();
        }
        for (PetSkill pet : list_petSkill) {
            if (pet.getType() == type) {
                return pet;
            }
        }
        return null;
    }

    public static List<Pet> getAllPet() {
        String gameStr = null;
        try {
            //Constants.APP_PATH_Map+"/test.map"
            gameStr = FileUtils.getFromAssets2(MyApp.mcontext, "PetResource.json");
        } catch (Exception e) {
            e.printStackTrace();
        }
        list_pet = JSON.parseArray(gameStr, Pet.class);
        return list_pet;
    }

    public static List<PetSkill> getAllPetSkill() {
        String gameStr = null;
        try {
            //Constants.APP_PATH_Map+"/test.map"
            gameStr = FileUtils.getFromAssets2(MyApp.mcontext, "PetSkillResource.json");
        } catch (Exception e) {
            e.printStackTrace();
        }
        list_petSkill = JSON.parseArray(gameStr, PetSkill.class);
        return list_petSkill;
    }
}
