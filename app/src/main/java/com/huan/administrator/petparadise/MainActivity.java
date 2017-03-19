package com.huan.administrator.petparadise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.huan.administrator.petparadise.adapter.PetsAdapter;
import com.huan.administrator.petparadise.adapter.PetsSkillAdapter;
import com.huan.administrator.petparadise.bean.Pet;
import com.huan.administrator.petparadise.bean.PetSkill;
import com.huan.administrator.petparadise.utils.FileUtils;
import com.huan.administrator.petparadise.utils.PetUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        PetUtils.generatePet();

        initView();

    }
    @Bind(R.id.tv_pet_Name)
    TextView tv_pet_Name;
    @Bind(R.id.tv_pet_Leve)
    TextView tv_pet_Leve;

   @Bind(R.id.gridview_pets)
    GridView gridview_pets;
    @Bind(R.id.gridview_kill)
    GridView gridview_kill;
    @Bind(R.id.ll_jichu_01)
    LinearLayout ll_jichu_01;
    @Bind(R.id.ll_jichu_02)
    LinearLayout ll_jichu_02;
    @Bind(R.id.rg_jichu_menu)
    RadioGroup rg_jichu_menu;
    @Bind(R.id.iv_pet_show)
    ImageView iv_pet_show;
    PetsAdapter adapter_pets;
    PetsSkillAdapter adapter_pets_skill;
    List<Pet> pets = new ArrayList<Pet>();
    Pet pet_c;//当前宠物
    List<PetSkill> Skills;

    private void initView() {
        for (int i = 0; i < 15; i++) {
            Pet p = new Pet();
            p = PetUtils.getPetByType(i%13);
            p.setLeve(i);
            int count_skill = (int)(Math.random()*100)%13;
            List<PetSkill> skills = new ArrayList<PetSkill>();
            for (int j=0;j<count_skill;j++){
                PetSkill petSkill = new PetSkill();
                petSkill = PetUtils.getPetSkillByType(i%4);
                //petSkill.setHeadImage("xixue.png");
                //petSkill.setSkillClass(j%3);
                skills.add(petSkill);
            }
            String aaa = JSON.toJSON(skills).toString();
            p.setSkills(skills);
            pets.add(p);
        }
        pet_c = pets.get(0);
        String petHeadName = "pet/"+pet_c.getHeadImage();
        iv_pet_show.setImageDrawable(FileUtils.loadImageFromAsserts(petHeadName));
        String aa = JSON.toJSON(pets).toString();
        System.out.println(JSON.toJSON(pets).toString());
        adapter_pets = new PetsAdapter(this, pets);
        gridview_pets.setAdapter(adapter_pets);
        gridview_pets.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setPet_c(pets.get(position));
            }
        });
        Skills =  pet_c.getSkills();
        adapter_pets_skill = new PetsSkillAdapter(this,Skills);
        gridview_kill.setAdapter(adapter_pets_skill);
        rg_jichu_menu.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_jichu_01:
                        ll_jichu_01.setVisibility(View.VISIBLE);
                        ll_jichu_02.setVisibility(View.GONE);
                        break;
                    case R.id.rb_jichu_02:
                        ll_jichu_01.setVisibility(View.GONE);
                        ll_jichu_02.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        break;
                }
            }
        });
    }

    public Pet getPet_c() {
        return pet_c;
    }

    public void setPet_c(Pet pet_c) {
        this.pet_c = pet_c;
        String petHeadName = "pet/"+pet_c.getHeadImage();
        iv_pet_show.setImageDrawable(FileUtils.loadImageFromAsserts(petHeadName));
        tv_pet_Name.setText(pet_c.getName());
        tv_pet_Leve.setText(pet_c.getLeve()+"级");
        Skills.clear();
        for (PetSkill skill :  pet_c.getSkills()){
            Skills.add(skill);
        }
        adapter_pets_skill.notifyDataSetChanged();
    }
}
