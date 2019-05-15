package uk.ac.ucl.data.MVC;

import uk.ac.ucl.data.Patient;
import uk.ac.ucl.data.PatientDbImpl;
import uk.ac.ucl.data.RunSQL;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.sql.SQLException;
import java.util.List;

public class GUIController
{
    private GUIModel model = new GUIModel();
    private ModelStatistics modelStats = new ModelStatistics(model);
    private GUIView view;

    public GUIController(GUIView view)
    {
        this.view = view;
    }

    public void patientClicked(String patientName)
    {
        if(patientName == null){ return;}
        displayPatientInfo(patientName);
    }

    public void enterSearch(String text)
    {
        if (!fileUploaded()){ return; }
        view.removeAllPatientList();
        matchSearch(text, view.getSelectedCategory());
    }

    private void displayAllPatients()
    {
        view.removeAllPatientList();
        for(Patient patient : model.getPatients())
        {
            view.addToPatientList(model.getFirst(patient) + ", " + model.getLast(patient));
        }
    }

    private void displayPatientInfo(String patientName)
    {
        view.removeAllInfoList();
        List<String> infoList = model.getAllInfo(patientName);
        for(String info: infoList)
        {
            view.addToInfoList(info);
        }
    }

    public void displayStatistics()
    {
        if (!fileUploaded()){ return; }
        view.removeAllInfoList();
        for(String stats : modelStats.getAllStats())
        {
            view.addToInfoList(stats);
        }
    }

    private void removeAllPatients()
    {
        model.removeAllPatients();
        view.removeAllPatientList();
        view.removeAllInfoList();
    }

    private Boolean fileUploaded()
    {
        if(model.getPatients().size() == 0)
        {
            view.setPopUp("No Patients Found", "Please load a file first.",
                    JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }

    public void loadSQL(String url, String username, String password){
        if(!fileUploaded()){ return; }
        try {
            RunSQL mysql = new RunSQL(model.getPatients());
            mysql.run(url, username, password);
        }catch (NullPointerException | SQLException e){
            view.setPopUp("Error","Incorrect Information", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void loadCSV()
    {
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter(".csv", "csv"));
        try
        {
            if (fc.showOpenDialog(view) == JFileChooser.APPROVE_OPTION)
            {
                File file = fc.getSelectedFile();
                removeAllPatients();
                model.readFile(file);
                displayAllPatients();
                displayStatistics();
            }
        } catch (IOException | UncheckedIOException | ArrayIndexOutOfBoundsException e)
        {
            view.setPopUp("Read File Error", "Invalid file format.\nPlease reload a .csv File.",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void loadJSON()
    {
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter(".json", "json"));
        try {
            if (fc.showOpenDialog(view) == JFileChooser.APPROVE_OPTION)
            {
                File file = fc.getSelectedFile();
                removeAllPatients();
                model.readJSON(file);
                displayAllPatients();
                displayStatistics();
            }
        } catch (IOException | UncheckedIOException | ArrayIndexOutOfBoundsException e)
        {
            view.setPopUp("File Error","Invalid file format.\nPlease reload a .json File",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void saveToJSON()
    {
        if (!fileUploaded()) { return; }
        try
        {
            StringBuilder patientCSV = model.getAllJSON();
            JFileChooser chooser  = new JFileChooser();
            chooser.setDialogTitle("Select File Destination");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            if (chooser.showOpenDialog(view) == JFileChooser.APPROVE_OPTION)
            {
                OutputStream out = new FileOutputStream(chooser.getSelectedFile() + "\\patients.json");
                out.write(patientCSV.toString().getBytes());
                out.close();
                view.setPopUp("Success","patients.json saved in:\n" + chooser.getSelectedFile(),
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException e)
        {
            view.setPopUp("File Error","Unable to save file.\nDestination Not Found", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void saveToCSV()
    {
        if (!fileUploaded()) { return; }
        try
        {
            StringBuilder patientCSV = model.getAllCSV();
            JFileChooser chooser  = new JFileChooser();
            chooser.setDialogTitle("Select File Destination");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            if (chooser.showOpenDialog(view) == JFileChooser.APPROVE_OPTION)
            {
                OutputStream out = new FileOutputStream(chooser.getSelectedFile() + "\\patients.csv");
                out.write(patientCSV.toString().getBytes());
                out.close();
                view.setPopUp("Success","patients.csv saved in:\n" + chooser.getSelectedFile(),
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException e)
        {
            view.setPopUp("File Error","Unable to save file.\nDestination Not Found", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void matchSearch(String text, String choice)
    {
        for(Patient patient: model.getPatients())
        {
            if(model.getName(patient).toLowerCase().contains(text.toLowerCase())
                    && (choice.compareTo("Name")==0)) {
                view.addToPatientList(model.getName(patient));
            }
            else if(model.getID(patient).toLowerCase().contains(text.toLowerCase())
                    && (choice.compareTo("ID")==0 )) {
                view.addToPatientList(model.getName(patient));
            }
            else if(model.getZip(patient).toLowerCase().contains(text.toLowerCase())
                    && (choice.compareTo("Zip")==0 )) {
                view.addToPatientList(model.getName(patient));
            }
            else if(model.getSuffix(patient).toLowerCase().contains(text.toLowerCase())
                    && (choice.compareTo("Suffix")==0 )) {
                view.addToPatientList(model.getName(patient));
            }
            else if(model.getDeathdate(patient).toLowerCase().contains(text.toLowerCase())
                    && (choice.compareTo("Deathdate")==0 )) {
                view.addToPatientList(model.getName(patient));
            }
            else if(model.getMaiden(patient).toLowerCase().contains(text.toLowerCase())
                    && (choice.compareTo("Maiden")==0 )) {
                view.addToPatientList(model.getName(patient));
            }
            else if(model.getMarital(patient).toLowerCase().contains(text.toLowerCase())
                    && (choice.compareTo("Marital")==0 )) {
                view.addToPatientList(model.getName(patient));
            }
            else if(model.getState(patient).toLowerCase().contains(text.toLowerCase())
                    && (choice.compareTo("State")==0 )) {
                view.addToPatientList(model.getName(patient));
            }
            else if(model.getDrivers(patient).toLowerCase().contains(text.toLowerCase())
                    && (choice.compareTo("Drivers")==0 )) {
                view.addToPatientList(model.getName(patient));
            }
            else if(model.getBirthdate(patient).toLowerCase().contains(text.toLowerCase())
                    && (choice.compareTo("Birthdate")==0 )) {
                view.addToPatientList(model.getName(patient));
            }
            else if(model.getEthnicity(patient).toLowerCase().contains(text.toLowerCase())
                    && (choice.compareTo("Ethnicity")==0 )) {
                view.addToPatientList(model.getName(patient));
            }
            else if(model.getBirthplace(patient).toLowerCase().contains(text.toLowerCase())
                    && (choice.compareTo("Birthplace")==0 )) {
                view.addToPatientList(model.getName(patient));
            }
            else if(model.getSSN(patient).toLowerCase().contains(text.toLowerCase())
                    && (choice.compareTo("SSN")==0 )) {
                view.addToPatientList(model.getName(patient));
            }
            else if(model.getCity(patient).toLowerCase().contains(text.toLowerCase())
                    && (choice.compareTo("City")==0 )) {
                view.addToPatientList(model.getName(patient));
            }
            else if(model.getPrefix(patient).toLowerCase().contains(text.toLowerCase())
                    && (choice.compareTo("Prefix")==0 )) {
                view.addToPatientList(model.getName(patient));
            }
            else if(model.getRace(patient).toLowerCase().contains(text.toLowerCase())
                    && (choice.compareTo("Race")==0 )) {
                view.addToPatientList(model.getName(patient));
            }
            else if(model.getAddress(patient).toLowerCase().contains(text.toLowerCase())
                    && (choice.compareTo("Address")==0 )) {
                view.addToPatientList(model.getName(patient));
            }
            else if(model.getGender(patient).toLowerCase().contains(text.toLowerCase())
                    && (choice.compareTo("Gender")==0 )) {
                view.addToPatientList(model.getName(patient));
            }
            else if(model.getPassport(patient).toLowerCase().contains(text.toLowerCase())
                    && (choice.compareTo("Passport")==0 )) {
                view.addToPatientList(model.getName(patient));
            }
        }
    }
}
