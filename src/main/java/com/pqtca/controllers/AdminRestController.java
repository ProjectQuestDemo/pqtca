package com.pqtca.controllers;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pqtca.models.Application;
import com.pqtca.repos.ApplicationRepo;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;

@RestController
public class AdminRestController {
    private final ApplicationRepo appDao;

    public AdminRestController(ApplicationRepo appDao) {
        this.appDao = appDao;
    }

    /*  Admin Specific REST Mappings and Methods  */
    /* ****************************************** */
    /* ***************START********************** */
    /* ****************************************** */
    @GetMapping("/complete")
    public @ResponseBody String apps () {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Application> apps = appDao.findAll();
        return gson.toJson(apps);
    }


    @GetMapping("/pending")
    public @ResponseBody String pending () {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Application> apps = appDao.findApplicationsByFEmpIdLike("");
        return gson.toJson(apps);
    }

    @GetMapping("/show={id}")
    public @ResponseBody String pendingApp (@PathVariable Long id) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Application app = appDao.findOne(id);
        return gson.toJson(app);
    }

    @GetMapping("/graphEthnicity")
    @ResponseBody
    public String getGraphEthnicity() {
        Gson gson = new Gson();
        HashMap<String, Long> map = new HashMap<>();
        map.put("White", appDao.countByAEthnicity("White"));
        map.put("Black", appDao.countByAEthnicity("Black"));
        map.put("Hispanic", appDao.countByAEthnicity("Hispanic"));
        map.put("Asian/pacific islander", appDao.countByAEthnicity("Asian/pacific islander"));
        map.put("Other", appDao.countByAEthnicity("Other"));
        map.put("Two or more", appDao.countByAEthnicity("Two or more"));

        return gson.toJson(map);
    }
    // used for pie chart, city graphing
    @GetMapping("/graphCity")
    @ResponseBody
    public String getGraphCity() {
        Gson gson = new Gson();
        HashMap<String, Long> map = new HashMap<>();
        map.put("San Antonio", appDao.countByBCity("San Antonio"));
        map.put("Austin", appDao.countByBCity("Austin"));
        map.put("Houston", appDao.countByBCity("Houston"));
        map.put("Dallas", appDao.countByBCity("Dallas"));
        map.put("Boerne", appDao.countByBCity("Boerne"));
        map.put("Fredericksburg", appDao.countByBCity("Fredericksburg"));
        map.put("Castroville", appDao.countByBCity("Castroville"));
        map.put("Corpus Christi", appDao.countByBCity("Corpus Christi"));
        map.put("New Braunfels", appDao.countByBCity("New Braunfels"));
        map.put("Poteet", appDao.countByBCity("Poteet"));
        map.put("South Padre Island", appDao.countByBCity("South Padre Island"));

        return gson.toJson(map);
    }

    // used for pie chart, marital graphing
    @GetMapping("/graphMarital")
    @ResponseBody
    public String getGraphMaritalStatus() {
        Gson gson = new Gson();
        HashMap<String, Long> map = new HashMap<>();
        map.put("Single", appDao.countByDMaritalStatus("Single"));
        map.put("Married", appDao.countByDMaritalStatus("Married"));
        map.put("Separated", appDao.countByDMaritalStatus("Separated"));
        map.put("Divorced", appDao.countByDMaritalStatus("Divorced"));

        return gson.toJson(map);
    }

    // used for pie chart, family stat graphing
    @GetMapping("/graphFam")
    @ResponseBody
    public String getGraphFamilyStatus() {
        Gson gson = new Gson();
        HashMap<String, Long> map = new HashMap<>();
        map.put("Parent in two parent family", appDao.countByDfamilyStatus("Parent in two parent family"));
        map.put("Single Parent", appDao.countByDfamilyStatus("Single Parent"));
        map.put("Other family member", appDao.countByDfamilyStatus("Other family member"));
        map.put("Non-dependent individual", appDao.countByDfamilyStatus("Non-dependent individual"));

        return gson.toJson(map);
    }

    // used for pie chart, drug test graphing
    @GetMapping("/graphDrug")
    @ResponseBody
    public String getGraphDrug() {
        Gson gson = new Gson();
        HashMap<String, Long> map = new HashMap<>();
        map.put("Consented To Drug Test", appDao.countByEDrugTest(true));
        map.put("Did Not Consent To Drug Test", appDao.countByEDrugTest(false));

        return gson.toJson(map);
    }

    // used for pie chart,federal aid graphing
    @GetMapping("/graphAid")
    @ResponseBody
    public String getGraphFedAid() {
        Gson gson = new Gson();
        HashMap<String, Long> map = new HashMap<>();
        map.put("Receives TANF", appDao.countByETanf(true));
        map.put("Receives SNAP", appDao.countByESnap(true));
        map.put("Receives SSDI", appDao.countByESsdi(true));
        map.put("Receives SSH", appDao.countByESsh(true));
        map.put("Receives Unemployment", appDao.countByEUnemp(true));
        map.put("Receives SSI", appDao.countByESsi(true));
        map.put("Receives WIC", appDao.countByEWic(true));

        return gson.toJson(map);
    }

    // used for pie chart,military graphing
    @GetMapping("/graphMilitaryService")
    @ResponseBody
    public String getGraphMilitaryService() {
        Gson gson = new Gson();
        HashMap<String, Long> map = new HashMap<>();
        map.put("Army", appDao.countByEMilitarySrv("Army"));
        map.put("Air Force", appDao.countByEMilitarySrv("Air Force"));
        map.put("Marine Corps", appDao.countByEMilitarySrv("Marine Corps"));
        map.put("Coast Guard", appDao.countByEMilitarySrv("Coast Guard"));
        map.put("Navy", appDao.countByEMilitarySrv("Navy"));
        map.put("National Guard", appDao.countByEMilitarySrv("National Guard"));
        map.put("Other", appDao.countByEMilitarySrv("Other"));

        return gson.toJson(map);
    }

    // used for pie chart,military spouse graphing
    @GetMapping("/graphMilitarySpouse")
    @ResponseBody
    public String getGraphMilitarySpouse() {
        Gson gson = new Gson();
        HashMap<String, Long> map = new HashMap<>();
        map.put("Is a Military Spouse", appDao.countByEMilSpouse(true));
        map.put("Is not a Military Spouse", appDao.countByEMilSpouse(false));

        return gson.toJson(map);
    }

    // used for pie chart, referral graphing
    @GetMapping("/graphReferral")
    @ResponseBody
    public String getGraphReferral() {
        Gson gson = new Gson();
        HashMap<String, Long> map = new HashMap<>();
        map.put("Agency", appDao.countByEReferralSrc("Agency"));
        map.put("Job Fair", appDao.countByEReferralSrc("Job Fair"));
        map.put("Newspaper", appDao.countByEReferralSrc("Newspaper"));
        map.put("Family/Friend", appDao.countByEReferralSrc("Family/Friend"));
        map.put("Radio", appDao.countByEReferralSrc("Radio"));
        map.put("Other", appDao.countByEReferralSrc("Other"));

        return gson.toJson(map);
    }
}

