package uk.ac.ucl.data;

import java.sql.SQLException;
import java.util.List;

public class RunSQL  {
    private List<Patient> patientList;

    public RunSQL(List<Patient> patients)
    {
        this.patientList = patients;
    }

    public void run(String url, String username, String password) throws SQLException {
        PatientDbImpl patientDb = new PatientDbImpl(patientList);
        patientDb.setjdbUrl(url);
        patientDb.setUsername(username);
        patientDb.setPassword(password);

        patientDb.connect();
        patientDb.createTable();
        patientDb.setup();
        patientDb.disconnect();
    }
}

