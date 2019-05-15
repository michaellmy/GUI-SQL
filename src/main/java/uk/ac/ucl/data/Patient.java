package uk.ac.ucl.data;

import java.util.HashMap;

public class Patient {
    private HashMap<String, String> patientMap;

    public Patient(HashMap<String, String> patientMap){
        this.patientMap = patientMap;
    }

    public HashMap<String, String> getPatientMap() {
        return patientMap;
    }

    public String getID(){
        return patientMap.get("ID");
    }

    public String getFirst() { return patientMap.get("FIRST");}

    public String getBirthdate(){ return patientMap.get("BIRTHDATE");}

    public String getDeathdate(){ return patientMap.get("DEATHDATE");}

    public String getSSN(){return patientMap.get("SSN");}

    public String getDrivers(){ return  patientMap.get("DRIVERS");}

    public String getPassport(){ return  patientMap.get("PASSPORT");}

    public String getPrefix(){ return patientMap.get("PREFIX");}

    public String getLast(){ return patientMap.get("LAST");}

    public String getSuffix(){ return patientMap.get("SUFFIX");}

    public String getMaiden(){ return patientMap.get("MAIDEN");}

    public String getMarital(){ return patientMap.get("MARITAL");}

    public String getRace(){ return patientMap.get("RACE");}

    public String getEthnicity(){ return patientMap.get("ETHNICITY");}

    public String getGender(){ return patientMap.get("GENDER");}

    public String getBirthplace(){ return patientMap.get("BIRTHPLACE");}

    public String getAddress(){ return patientMap.get("ADDRESS");}

    public String getCity(){ return patientMap.get("CITY");}

    public String getState(){ return patientMap.get("STATE");}

    public String getName(){ return patientMap.get("FIRST") + ", " + patientMap.get("LAST");}

    public String getZip(){return patientMap.get("ZIP");}

    public void setID(String ID){
        patientMap.put("ID", ID);
    }

    public void setBirthdate(String birthdate){patientMap.put("BIRTHDATE", birthdate);}

    public void setDeathdate(String deathdate){patientMap.put("DEATHDATE", deathdate);}

    public void setSSN(String ssn){patientMap.put("SSN", ssn);}

    public void setDrivers(String drivers){patientMap.put("DRIVERS", drivers);}

    public void setPassport(String passport){patientMap.put("PASSPORT", passport);}

    public void setFirst(String FIRST) {patientMap.put("FIRST", FIRST); }

    public void setLast(String LAST) {patientMap.put("LAST", LAST);}

    public void setPrefix(String prefix){patientMap.put("PREFIX", prefix);}

    public void setSuffix(String suffix){patientMap.put("SUFFIX", suffix);}

    public void setMaiden(String maiden){patientMap.put("MAIDEN", maiden);}

    public void setMarital(String marital){patientMap.put("MARITAL", marital);}

    public void setRace(String race){patientMap.put("RACE", race);}

    public void setEthnicity(String ethnicity){patientMap.put("ETHNICITY", ethnicity);}

    public void setGender(String gender){patientMap.put("GENDER", gender);}

    public void setBirthplace(String birthplace){patientMap.put("BIRTHPLACE", birthplace);}

    public void setAddress(String address){patientMap.put("ADDRESS", address);}

    public void setCity(String city){patientMap.put("CITY",city);}

    public void setState(String State) {patientMap.put("STATE", State);}

    public void setZip(String Zip) { patientMap.put("ZIP", Zip);}
}
