package uk.ac.ucl.data.MVC;

import uk.ac.ucl.data.Patient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModelStatistics
{
    private GUIModel model;

    public ModelStatistics(GUIModel model)
    {
        this.model = model;
    }

    private String countDeath()
    {
        int count = 0;
        for(Patient patient: model.getPatients())
        {
            if(patient.getDeathdate().compareTo("") != 0)
            {
                count++;
            }
        }
        return Integer.toString(count);
    }

    private String countPatients(){ return Integer.toString(model.getPatients().size()); }

    private int getAge(Patient patient)
    {
        String fullDate = patient.getBirthdate();
        String YMD[] = fullDate.split("-");
        String birthYearString = YMD[0];
        int birthYear = Integer.parseInt(birthYearString);
        String deathYearString = patient.getDeathdate();
        if(deathYearString.compareTo("")!=0) {
            int deathYear = Integer.parseInt(deathYearString.split("-")[0]);
            return deathYear - birthYear;
        }
        return 2019 - birthYear;
    }

    private String getAverageAge()
    {
        int count = 0;
        int totalAges = 0;
        for (Patient patient: model.getPatients())
        {
            totalAges += getAge(patient);
            count ++;
        }
        return Integer.toString(totalAges/count);
    }

    private String getYoungest()
    {
        int youngest = getAge(model.getPatients().get(0));
        for(Patient patient: model.getPatients())
        {
            if(getAge(patient)<youngest)
            {
                youngest = getAge(patient);
            }
        }
        return Integer.toString(youngest);
    }

    private String getOldest()
    {
        int oldest = getAge(model.getPatients().get(0));
        for(Patient patient: model.getPatients())
        {
            if(getAge(patient)> oldest)
            {
                oldest = getAge(patient);
            }
        }
        return Integer.toString(oldest);
    }

    private String getChildren()
    {
        int count = 0;
        for(Patient patient : model.getPatients())
        {
            if(getAge(patient) < 21)
            {
                count++;
            }
        }
        return Integer.toString(count);
    }

    private String getMiddleAge()
    {
        int count = 0;
        for(Patient patient : model.getPatients())
        {
            if(getAge(patient) >= 21 && getAge(patient) <= 65)
            {
                count++;
            }
        }
        return Integer.toString(count);
    }

    private String getOldAge()
    {
        int count = 0;
        for(Patient patient : model.getPatients())
        {
            if(getAge(patient) > 65)
            {
                count++;
            }
        }
        return Integer.toString(count);
    }

    private String getMales()
    {
        int count = 0;
        for(Patient patient : model.getPatients())
        {
            if(model.getGender(patient).compareTo("M") == 0){
                count++;
            }
        }
        return Integer.toString(count);
    }

    private String getFemales()
    {
        int count=0;
        for(Patient patient: model.getPatients())
        {
            if(model.getGender(patient).compareTo("F")==0)
            {
                count++;
            }
        }
        return Integer.toString(count);
    }

    private String getNumberOfMaidens()
    {
        int count=0;
        for(Patient patient: model.getPatients())
        {
            if(model.getMaiden(patient).compareTo("")!=0)
            {
                count++;
            }
        }
        return Integer.toString(count);
    }

    private String getNumberOfMarried()
    {
        int count=0;
        for(Patient patient: model.getPatients())
        {
            if(model.getMarital(patient).compareTo("M")==0)
            {
                count++;
            }
        }
        return Integer.toString(count);
    }

    private String getMostCommonCity()
    {
        Map<String, Integer> map = new HashMap<>();

        for (Patient patient : model.getPatients()) {
            String state = patient.getCity();
            Integer value = map.get(state);
            map.put(state, value == null ? 1 : value + 1);
        }

        Map.Entry<String, Integer> commonCity = null;
        for (Map.Entry<String, Integer> city : map.entrySet()) {
            if (commonCity == null || city.getValue() > commonCity.getValue()) {
                commonCity = city;
            }
        }

        return commonCity.getKey();
    }
    
    public List<String> getAllStats()
    {
        List<String> statList = new ArrayList<>();
        statList.add("General Statistics of All Patients: ");
        statList.add("- Total number of patients: " + countPatients());
        statList.add("- Number of male patients " + getMales());
        statList.add("- Number of female patients: " + getFemales());
        statList.add("- Most common city: " + getMostCommonCity());
        statList.add("- Average Age of Patients: " + getAverageAge() + " years");
        statList.add("- Age range: " + getYoungest() + " - " + getOldest() + " Years Old");
        statList.add("- Age distribution:");
        statList.add("    Under 18 years: " + getChildren() + " patients");
        statList.add("    18 to 65 years: " + getMiddleAge() + " patients");
        statList.add("    Over 65 years: " + getOldAge() + " patients");
        statList.add("- Number of deaths recorded: " + countDeath());
        statList.add("- Number of patients with Maidens: " + getNumberOfMaidens());
        statList.add("- Number of married patients: " + getNumberOfMarried());
        return statList;
    }
}
