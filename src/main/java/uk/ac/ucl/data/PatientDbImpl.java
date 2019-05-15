package uk.ac.ucl.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PatientDbImpl extends DbAdapter {
    List<Patient> patientList ;

    public PatientDbImpl(List<Patient> patients)
    {
        this.patientList = patients;
    }

    public void createTable(){
        try {
            stmt = conn.createStatement();
            String sql = "DROP TABLE IF EXISTS patients;" +
                    "CREATE TABLE IF NOT EXISTS patients ("+
                    "patient_id VARCHAR(100), " +
                    "patient_birthdate VARCHAR(100), " +
                    "patient_deathdate VARCHAR(100), " +
                    "patient_ssn VARCHAR(100), " +
                    "patient_drivers VARCHAR(100), " +
                    "patient_passport VARCHAR(100), " +
                    "patient_prefix VARCHAR(100), " +
                    "patient_first VARCHAR(100), " +
                    "patient_last VARCHAR(100), " +
                    "patient_suffix VARCHAR(100), " +
                    "patient_maiden VARCHAR(100), " +
                    "patient_marital VARCHAR(100), " +
                    "patient_race VARCHAR(100), " +
                    "patient_ethnicity VARCHAR(100), " +
                    "patient_gender VARCHAR(100), " +
                    "patient_birthplace VARCHAR(100), " +
                    "patient_address VARCHAR(100), " +
                    "patient_city VARCHAR(100), " +
                    "patient_state VARCHAR(100) , " +
                    "patient_zip VARCHAR(100)) ";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setup(){
        try {
            PreparedStatement st = conn.prepareStatement(
                    "SELECT count(*) FROM patients");
            ResultSet rs = st.executeQuery();
        } catch (SQLException e){
            System.out.println("Unable to set up.");
        }

        for(Patient patient : patientList){
            insertPatient(patient.getID(), patient.getBirthdate(),patient.getDeathdate(),patient.getSSN(),
                    patient.getDrivers(),patient.getPassport(),patient.getPrefix(),patient.getFirst(),patient.getLast()
                    ,patient.getSuffix(),patient.getMaiden(),patient.getMarital(),patient.getRace(),patient.getEthnicity()
                    ,patient.getGender(),patient.getBirthplace(),patient.getAddress(),patient.getCity(),patient.getState()
                    ,patient.getZip());
        }
    }

    public void insertPatient(String id, String birthdate, String deathdate, String ssn, String drivers, String passport,
                              String prefix, String first, String last, String suffix, String maiden, String marital,
                              String race, String ethn, String gender, String birthplace, String address, String city,
                              String state, String zip){
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO PATIENTS " +
                    "(patient_id, patient_birthdate, patient_deathdate, patient_ssn, patient_drivers, patient_passport," +
                    "patient_prefix, patient_first, patient_last, patient_suffix, patient_maiden, patient_marital," +
                    "patient_race, patient_ethnicity, patient_gender, patient_birthplace, patient_address, patient_city," +
                    "patient_state, patient_zip) " +
                    "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            st.setString(1, id);
            st.setString(2, birthdate);
            st.setString(3, deathdate);
            st.setString(4, ssn);
            st.setString(5, drivers);
            st.setString(6, passport);
            st.setString(7, prefix);
            st.setString(8, first);
            st.setString(9, last);
            st.setString(10, suffix);
            st.setString(11, maiden);
            st.setString(12, marital);
            st.setString(13, race);
            st.setString(14, ethn);
            st.setString(15, gender);
            st.setString(16, birthplace);
            st.setString(17, address);
            st.setString(18, city);
            st.setString(19, state);
            st.setString(20, zip);
            st.execute();
            st.close();
        } catch (SQLException e) {
            System.out.println("Unable to insert patients into table.");
        }
    }
}
