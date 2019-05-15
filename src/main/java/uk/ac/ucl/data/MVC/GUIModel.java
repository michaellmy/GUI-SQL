package uk.ac.ucl.data.MVC;

import uk.ac.ucl.data.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GUIModel
{
    private List<Patient> patientList = new ArrayList<>();
    private ReadCSV CSVReader = new ReadCSV();
    private ReadJSON JSONReader = new ReadJSON(CSVReader);

    public void readFile(File file) throws IOException
    {
        CSVReader.readCSV(file);
        patientList = CSVReader.getPatientList();
    }

    public void readJSON(File file) throws IOException
    {
        JSONReader.readJSON(file);
        patientList = CSVReader.getPatientList();
    }

    public StringBuilder getSingleJSON(String ID)
    {
        JSONFormatter formatter = new JSONFormatter();
        return formatter.writeSingleJSON(ID, CSVReader);
    }

    public StringBuilder getAllJSON()
    {
        JSONFormatter formatter = new JSONFormatter();
        return formatter.writeAllJSON(CSVReader);
    }

    public StringBuilder getAllCSV()
    {
        CSVFormatter formatter = new CSVFormatter();
        return formatter.writeAllCSV(CSVReader);
    }

    public List<Patient> getPatients(){
        return patientList;
    }

    public String getFirst(Patient patient){ return patient.getFirst(); }

    public String getLast(Patient patient){ return patient.getLast();}

    public String getName(Patient patient){ return patient.getName(); }

    public String getID(Patient patient){ return patient.getID(); }

    public String getBirthdate(Patient patient){ return patient.getBirthdate();}

    public String getDeathdate(Patient patient){return patient.getDeathdate();}

    public String getGender(Patient patient){ return patient.getGender();}

    public String getMaiden(Patient patient) { return patient.getMaiden(); }

    public String getMarital(Patient patient) { return patient.getMarital();}

    public String getState(Patient patient ) {return patient.getState();}

    public String getDrivers(Patient patient) { return patient.getDrivers();}

    public String getEthnicity(Patient patient){return patient.getEthnicity();}

    public String getBirthplace(Patient patient){return patient.getBirthplace();}

    public String getSSN(Patient patient) {return patient.getSSN();}

    public String getCity(Patient patient) {return patient.getCity();}

    public String getPrefix(Patient patient) { return patient.getPrefix();}

    public String getRace(Patient patient){return patient.getRace();}

    public String getAddress(Patient patient){return patient.getAddress();}

    public String getPassport(Patient patient){return patient.getPassport();}

    public String getZip(Patient patient){return patient.getZip();}

    public String getSuffix(Patient patient){return patient.getSuffix();}

    private String getIDFromName(String name){
        for(Patient patient: patientList){
            if(name.compareTo(getName(patient)) == 0){
                return patient.getID();
            }
        }
        return "";
    }

    private String getBirthdateFromName(String name){
        for(Patient patient: patientList){
            if(name.compareTo(getName(patient)) == 0){
                return patient.getBirthdate();
            }
        }
        return "";
    }

    private String getDeathdateFromName(String name){
        for(Patient patient : patientList){
            if(name.compareTo(getName(patient)) == 0){
                return patient.getDeathdate();
            }
        }
        return "";
    }

    private String getSSNFromName(String name){
        for(Patient patient : patientList){
            if(name.compareTo(getName(patient)) == 0){
                return patient.getSSN();
            }
        }
        return "";
    }

    private String getDriversFromName(String name){
        for(Patient patient : patientList){
            if(name.compareTo(getName(patient)) == 0){
                return patient.getDrivers();
            }
        }
        return "";
    }

    private String getPassportFromName(String name){
        for(Patient patient : patientList){
            if(name.compareTo(getName(patient)) == 0){
                return patient.getPassport();
            }
        }
        return "";
    }

    private String getPrefixFromName(String name){
        for(Patient patient : patientList){
            if(name.compareTo(getName(patient)) == 0){
                return patient.getPrefix();
            }
        }
        return "";
    }

    private String getSuffixFromName(String name){
        for(Patient patient : patientList){
            if(name.compareTo(getName(patient)) == 0){
                return patient.getSuffix();
            }
        }
        return "";
    }

    private String getMaidenFromName(String name){
        for(Patient patient : patientList){
            if(name.compareTo(getName(patient)) == 0){
                return patient.getMaiden();
            }
        }
        return "";
    }

    private String getMaritalFromName(String name){
        for(Patient patient : patientList){
            if(name.compareTo(getName(patient)) == 0){
                return patient.getMarital();
            }
        }
        return "";
    }

    private String getRaceFromName(String name){
        for(Patient patient : patientList){
            if(name.compareTo(getName(patient)) == 0){
                return patient.getRace();
            }
        }
        return "";
    }

    private String getEthnicityFromName(String name){
        for(Patient patient : patientList){
            if(name.compareTo(getName(patient)) == 0){
                return patient.getEthnicity();
            }
        }
        return "";
    }

    private String getGenderFromName(String name){
        for(Patient patient : patientList){
            if(name.compareTo(getName(patient)) == 0){
                return patient.getGender();
            }
        }
        return "";
    }

    private String getBirthplaceFromName(String name){
        for(Patient patient : patientList){
            if(name.compareTo(getName(patient)) == 0){
                return patient.getBirthplace();
            }
        }
        return "";
    }

    private String getAddressFromName(String name){
        for(Patient patient : patientList){
            if(name.compareTo(getName(patient)) == 0){
                return patient.getAddress();
            }
        }
        return "";
    }

    private String getCityFromName(String name){
        for(Patient patient : patientList){
            if(name.compareTo(getName(patient)) == 0){
                return patient.getCity();
            }
        }
        return "";
    }

    private String getStateFromName(String name){
        for(Patient patient : patientList){
            if(name.compareTo(getName(patient)) == 0){
                return patient.getState();
            }
        }
        return "";
    }

    private String getZipFromName(String name){
        for(Patient patient : patientList){
            if(name.compareTo(getName(patient)) == 0){
                return patient.getZip();
            }
        }
        return "";
    }

    private String getFirstFromName(String name){
        for(Patient patient: patientList){
            if(name.compareTo(getName(patient)) == 0){
                return patient.getFirst();
            }
        }
        return "";
    }

    private String getLastFromName(String name){
        for(Patient patient: patientList){
            if(name.compareTo(getName(patient)) == 0){
                return patient.getLast();
            }
        }
        return "";
    }

    public List<String> getAllInfo(String patientName){
        List<String> infoList = new ArrayList<>();
        infoList.add("ID: " + getIDFromName(patientName));
        infoList.add("First Name: " + getFirstFromName(patientName).replaceAll("\\d",""));
        infoList.add("Last Name: " + getLastFromName(patientName).replaceAll("\\d",""));
        infoList.add("Birthdate: " + getBirthdateFromName(patientName));
        infoList.add("Deathdate: " + getDeathdateFromName(patientName));
        infoList.add("SSN: " + getSSNFromName(patientName));
        infoList.add("Drivers: " + getDriversFromName(patientName));
        infoList.add("Passport: " + getPassportFromName(patientName));
        infoList.add("Prefix: " + getPrefixFromName(patientName));
        infoList.add("Suffix: " + getSuffixFromName(patientName));
        infoList.add("Maiden: " + getMaidenFromName(patientName));
        infoList.add("Marital: " + getMaritalFromName(patientName));
        infoList.add("Race: " + getRaceFromName(patientName));
        infoList.add("Ethnicity: " + getEthnicityFromName(patientName));
        infoList.add("Gender: " + getGenderFromName(patientName));
        infoList.add("Birthplace: " + getBirthplaceFromName(patientName));
        infoList.add("Address: " + getAddressFromName(patientName));
        infoList.add("City :" + getCityFromName(patientName));
        infoList.add("State: " + getStateFromName(patientName));
        infoList.add("Zip: " + getZipFromName(patientName));
        return infoList;
    }

    public void removeAllPatients(){ patientList.clear();}
}
