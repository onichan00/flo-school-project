package com.hva.helios.data;

import com.hva.helios.models.user.Specialist;
import com.hva.helios.models.user.skill.Skill;
import com.hva.helios.models.user.skill.UserSkill;
import com.hva.helios.repositories.EntityRepository;
//import com.hva.helios.repositories.user.SpecialistJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SkillData {
    Random random = new Random();
    ArrayList<UserSkill> skills;

    /**
     *
     */

    Skill skill1 = new Skill("OFFICE FRONT-END [MS Office Access]");
    Skill skill2 = new Skill("OFFICE FRONT-END [MS Office Excel]");
    Skill skill3 = new Skill("OFFICE FRONT-END [MS Office Access VBA]");
    Skill skill4 = new Skill("OFFICE FRONT-END [MS Office Excel VBA]");
    Skill skill5 = new Skill("OFFICE FRONT-END [MS Power Query]");
    Skill skill6 = new Skill("OFFICE FRONT-END [MS Power BI]");
    Skill skill7 = new Skill("OFFICE FRONT-END [MS Powerpivot]");
    Skill skill8 = new Skill("OFFICE FRONT-END [MS Office Word]");
    Skill skill9 = new Skill("OFFICE FRONT-END [MS Office Word VBA]");
    Skill skill10 = new Skill("OFFICE FRONT-END [MS Office Outlook]");
    Skill skill11 = new Skill("OFFICE FRONT-END [MS Office Outlook VBA]");
    Skill skill12 = new Skill("BACK-END  [MS SQL-Server");
    Skill skill13 = new Skill("BACK-END  [MS SQL-Server Stored Procedures]");
    Skill skill14 = new Skill("BACK-END  [MS SQL-Server Views]");
    Skill skill15 = new Skill("BACK-END  [MY SQL]");
    Skill skill16 = new Skill("BACK-END  [MY SQL Workbench]");
    Skill skill17 = new Skill("BACK-END  [MS Azure]");
    Skill skill18 = new Skill("BACK-END  [Oracle]");
    Skill skill19 = new Skill("DATABASE [Filemaker]");
    Skill skill20 = new Skill("DATABASE [Filemaker Script]");
    Skill skill21 = new Skill("DATABASE [Filemaker Server]");
    Skill skill22 = new Skill("DATABASE [MS VB.NET]");
    Skill skill23 = new Skill("DATABASE [MS Visual Basic]");
    Skill skill24 = new Skill("DATABASE [Microsoft Dynamics 365]");
    Skill skill25 = new Skill("DATABASE [Microsoft Dynamics 365 for Operations]");
    Skill skill26 = new Skill("WEB BASED FRONT-END [Javascript]");
    Skill skill27 = new Skill("WEB BASED FRONT-END [Java]");
    Skill skill28 = new Skill("WEB BASED FRONT-END [PhP]");
    Skill skill29 = new Skill("WEB BASED FRONT-END [ASP.NET]");
    Skill skill30 = new Skill("WEB BASED FRONT-END [Google Apps]");
    Skill skill31 = new Skill("WEB BASED FRONT-END [Google Apps Script]");
    Skill skill32 = new Skill("WEB BASED FRONT-END [PowerApps]");
    Skill skill33 = new Skill("WEB BASED FRONT-END [Flow]");
    Skill skill34 = new Skill("WEB BASED FRONT-END [HTML]");
    Skill skill35 = new Skill("WEB BASED FRONT-END [CSS]");
    Skill skill36 = new Skill("BACK-END [Microsoft Dynamics AX]");
    Skill skill37 = new Skill("DATABASE [Sharepoint]");
    Skill skill38 = new Skill("WEB BASED FRONT-END [C#]");
    Skill skill39 = new Skill("WEB BASED FRONT-END [C++/CLI (Managed)]");
    Skill skill40 = new Skill("WEB BASED FRONT-END [F#]");
    Skill skill41 = new Skill("WEB BASED FRONT-END [Q#]");
    Skill skill42 = new Skill("BACK-END  [Windows PowerShell (Core)]");
    Skill skill43 = new Skill("WEB BASED FRONT-END [.NET Core]");
    Skill skill44 = new Skill("WEB BASED FRONT-END [Angular/AngularJS]");
    Skill skill45 = new Skill("BACK-END  [.NET Framework]");
    Skill skill46 = new Skill("BACK-END  [XML - XAML]");
    Skill skill47 = new Skill("WEB BASED FRONT-END [Bootstrap]");
    Skill skill48 = new Skill("WEB BASED FRONT-END [Mendix]");
    Skill skill49 = new Skill("WEB BASED FRONT-END [OutSystems]");
    Skill skill50 = new Skill("Werkwijze [Agile]");
    Skill skill51 = new Skill("Werkwijze [Scrum]");
    Skill skill52 = new Skill("Werkwijze [Lean]");
    Skill skill53 = new Skill("Werkwijze [Kanban]");
    Skill skill54 = new Skill("Werkwijze [Extreme Programming (XP)]");
    Skill skill55 = new Skill("Power BI [Overall]");
    Skill skill56 = new Skill("Power BI [DAX]");
    Skill skill57 = new Skill("Power BI [M Language]");
    Skill skill58 = new Skill("Power BI [Grafisch]");
    Skill skill59 = new Skill("Power BI [Power Query]");
    Skill skill60 = new Skill("Power BI [Power Query]");
    Skill skill61 = new Skill("Power BI [Power BI Beheer]");
    Skill skill62 = new Skill("Power BI [Datamodellering]");
    Skill skill63 = new Skill("Power BI [Data analyse]");
    Skill skill64 = new Skill("Business Intelligence [Tableau]");
    Skill skill65 = new Skill("Business Intelligence [Qlik]");
    Skill skill66 = new Skill("Business Intelligence [SAP]");
    Skill skill67 = new Skill("Business Intelligence [SAS]");
    Skill skill68 = new Skill("Business Intelligence [Oracle]");
    Skill skill69 = new Skill("Business Intelligence [Salesforce]");
    Skill skill70 = new Skill("Business Intelligence [Thoughtspot]");
    Skill skill71 = new Skill("Business Intelligence [Yellowfin]");
    Skill skill72 = new Skill("Business Intelligence [Sisense]");
    Skill skill73 = new Skill("Business Intelligence [Microstrategy]");
    Skill skill74 = new Skill("Business Intelligence [TIBCO Software]");
    Skill skill75 = new Skill("Business Intelligence [Looker]");
    Skill skill76 = new Skill("Business Intelligence [Information Builders]");
    Skill skill77 = new Skill("WEB BASED FRONT-END [Power Automate]");
    Skill skill78 = new Skill("WEB BASED FRONT-END [Power Platform]");
    Skill skill79 = new Skill("Business Intelligence [IBM ]");
    Skill skill80 = new Skill("Business Intelligence [Birst]");
    Skill skill81 = new Skill("Business Intelligence [Domo]");
    Skill skill82 = new Skill("Business Intelligence [Pyramid Analytics]");
    Skill skill83 = new Skill("DATABASE [Rij 10]");

//    UserSkill userSkill1 = new UserSkill(skill1, random.nextInt(5), specialistEntityRepository.findById(26));
//    UserSkill userSkill2 = new UserSkill(skill2, random.nextInt(5), specialistEntityRepository.findById(26));
//    UserSkill userSkill3 = new UserSkill(skill3, random.nextInt(5), specialistEntityRepository.findById(26));
//    UserSkill userSkill4 = new UserSkill(skill4, random.nextInt(5), specialistEntityRepository.findById(26));
//    UserSkill userSkill5 = new UserSkill(skill5, random.nextInt(5), specialistEntityRepository.findById(26));

    public SkillData() {
//        this.skills = new ArrayList<>(List.of(userSkill1, userSkill2, userSkill3, userSkill4, userSkill5));
    }

    public ArrayList<UserSkill> getUserSkills() {
        return skills;
    }

    public ArrayList<Skill> getAvailableSkills() {
        return new ArrayList<>(List.of(skill1, skill2, skill3, skill4, skill5, skill6, skill7, skill7, skill8, skill9, skill10
                , skill11, skill12, skill13, skill14, skill15, skill16, skill17, skill18, skill19, skill20, skill21, skill22, skill23
                , skill24, skill25, skill26, skill27, skill28, skill29, skill30, skill31, skill32, skill33, skill34, skill35, skill36
                , skill37, skill38, skill39, skill40, skill41, skill42, skill43, skill44, skill45, skill46, skill47, skill48, skill49
                , skill50, skill51, skill52, skill53, skill54, skill55, skill56, skill57, skill58, skill59, skill60, skill61, skill62
                , skill63, skill64, skill65, skill66, skill67, skill68, skill69, skill70, skill71, skill72, skill72, skill73, skill74
                , skill75, skill76, skill77, skill78, skill79, skill80, skill81, skill82, skill83
        ));
    }

    public ArrayList<UserSkill> getRandomSkills(int amount) {
        ArrayList<UserSkill> tempSkills = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            tempSkills.add(skills.get(random.nextInt(skills.size())));
        }

        return tempSkills;
    }
}
