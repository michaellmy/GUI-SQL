package uk.ac.ucl.data;

public class CSVFormatter {
    public StringBuilder writeAllCSV(ReadCSV reader)
    {
        StringBuilder sb = new StringBuilder("ID,BIRTHDATE,DEATHDATE,SSN,DRIVERS,PASSPORT,PREFIX,FIRST,LAST,SUFFIX," +
                "MAIDEN,MARITAL,RACE,ETHNICITY,GENDER,BIRTHPLACE,ADDRESS,CITY,STATE,ZIP\n");
        for(Patient patient : reader.getPatientList())
        {
            sb.append(patient.getID() + ",");
            sb.append(patient.getBirthdate() + ",");
            sb.append(patient.getDeathdate() + ",");
            sb.append(patient.getSSN() + ",");
            sb.append(patient.getDrivers() + ",");
            sb.append(patient.getPassport() + ",");
            sb.append(patient.getPrefix() + ",");
            sb.append(patient.getFirst() + ",");
            sb.append(patient.getLast() + ",");
            sb.append(patient.getSuffix() + ",");
            sb.append(patient.getMaiden() + ",");
            sb.append(patient.getMarital() + ",");
            sb.append(patient.getRace() + ",");
            sb.append(patient.getEthnicity() + ",");
            sb.append(patient.getGender() + ",");
            sb.append(patient.getBirthplace() + ",");
            sb.append(patient.getAddress() + ",");
            sb.append(patient.getCity() + ",");
            sb.append(patient.getState() + ",");
            sb.append(patient.getZip());
            sb.append("\n");
        }
        return sb;
    }
}
