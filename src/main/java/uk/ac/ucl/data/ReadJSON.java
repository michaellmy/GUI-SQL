package uk.ac.ucl.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ReadJSON
{
    private ReadCSV CSVReader;

    public ReadJSON(ReadCSV CSVReader)
    {
        this.CSVReader = CSVReader;
    }

    public void readJSON(File file) throws IOException
    {
        String thisLine ;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(file));
        int lineNumber = 0;
        while ((thisLine = br.readLine()) != null)
        {
            if (++lineNumber < 3)
                continue;
            sb.append(thisLine);
        }
        String patientsJSON = sb.toString();
        patientsJSON = patientsJSON.replaceAll("},[ \t]*\\{", "},{");
        patientsJSON = patientsJSON.replaceAll("[ \t]*\"", "");
        patientsJSON = patientsJSON.replaceAll("}[ \t]*][ \t]*}", "}");
        patientsJSON = patientsJSON.replaceAll("},\\{", "\n").replaceAll("[ \t]*\\{","");
        patientsJSON = patientsJSON.replaceAll("}", "");

        String[] allPatients = patientsJSON.split("\n");
        for(String eachPatient: allPatients)
        {
            createJSONPatient(eachPatient);
        }
    }

    private void createJSONPatient(String eachPatient)
    {
        Patient patient = new Patient(new HashMap<>());
        String[] categories = eachPatient.split(",");
        patient.setZip(categories[0].split(":",-1)[1]);
        patient.setSuffix(categories[1].split(":", -1)[1]);
        patient.setDeathdate(categories[2].split(":", -1)[1]);
        patient.setMaiden(categories[3].split(":", -1)[1]);
        patient.setMarital(categories[4].split(":", -1)[1]);
        patient.setState(categories[5].split(":", -1)[1]);
        patient.setDrivers(categories[6].split(":", -1)[1]);
        patient.setBirthdate(categories[7].split(":", -1)[1]);
        patient.setFirst(categories[8].split(":", -1)[1]);
        patient.setEthnicity(categories[9].split(":", -1)[1]);
        patient.setBirthplace(categories[10].split(":", -1)[1]);
        patient.setSSN(categories[11].split(":", -1)[1]);
        patient.setCity(categories[12].split(":", -1)[1]);
        patient.setPrefix(categories[13].split(":", -1)[1]);
        patient.setLast(categories[14].split(":", -1)[1]);
        patient.setRace(categories[15].split(":", -1)[1]);
        patient.setAddress(categories[16].split(":", -1)[1]);
        patient.setGender(categories[17].split(":", -1)[1]);
        patient.setID(categories[18].split(":", -1)[1]);
        patient.setPassport(categories[19].split(":", -1)[1]);
        CSVReader.addToList(patient);
    }
}
