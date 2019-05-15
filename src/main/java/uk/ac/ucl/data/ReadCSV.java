package uk.ac.ucl.data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class ReadCSV
{
    private ArrayList<Patient> patientList = new ArrayList<>();

    public List<Patient> getPatientList(){
        return patientList;
    }

    public void addToList(Patient patient){ patientList.add(patient);}

    public void readCSV(File file) throws IOException
    {
        var path = Paths.get(file.getAbsolutePath());
        Stream<String> lines = Files.lines(path);
        lines.skip(1).forEach(line -> createPatient(line));
    }

    private void createPatient(String line)
    {
        Patient patient = new Patient(new HashMap<>());
        String[] columns = line.split(",");
        patient.setID(columns[0]);
        patient.setBirthdate(columns[1]);
        patient.setDeathdate(columns[2]);
        patient.setSSN(columns[3]);
        patient.setDrivers(columns[4]);
        patient.setPassport(columns[5]);
        patient.setPrefix(columns[6]);
        patient.setFirst(columns[7]);
        patient.setLast(columns[8]);
        patient.setSuffix(columns[9]);
        patient.setMaiden(columns[10]);
        patient.setMarital(columns[11]);
        patient.setRace(columns[12]);
        patient.setEthnicity(columns[13]);
        patient.setGender(columns[14]);
        patient.setBirthplace(columns[15]);
        patient.setAddress(columns[16]);
        patient.setCity(columns[17]);
        patient.setState(columns[18]);
        if(columns.length == 20) {
            patient.setZip(columns[19]);
        }
        else {
            patient.setZip("");
        }
        patientList.add(patient);
    }
}
