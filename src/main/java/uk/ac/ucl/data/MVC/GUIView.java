package uk.ac.ucl.data.MVC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUIView extends JFrame
{
    private JPanel backPanel;
    private JPanel inputPanel;
    private JPanel searchPanel;
    private JPanel buttonPanel;
    private JPanel patientPanel;
    private JPanel infoPanel;

    private JButton loadCSVButton;
    private JButton loadJSONButton;
    private JButton saveJSONButton;
    private JButton saveCSVButton;
    private JButton statsButton;
    private JButton sqlButton;
    private JComboBox<String> selectionList;
    private JTextField searchField;

    private JScrollPane scroller;
    private JScrollPane infoScroller;
    private DefaultListModel<String> listModel;
    private DefaultListModel<String> infoListModel;
    private JList<String> patientList;
    private JList<String> infoList;

    private static final int LIST_ROWS = 25;
    private static final int TEXT_FIELD_COLUMNS = 20;

    private GUIController controller = new GUIController(this);

    public GUIView()
    {
        super("Patient Data");
        createGUI();
        setModel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createGUI()
    {
        createButtonPanel();
        createSearchPanel();
        createPatientListPanel();
        createInfoListPanel();
        createInputPanel();
        createBackPanel();
        add(backPanel, BorderLayout.CENTER);
    }

    private void setModel()
    {
        listModel = new DefaultListModel<>();
        patientList.setModel(listModel);
        infoListModel = new DefaultListModel<>();
        infoList.setModel(infoListModel);
    }

    private void createBackPanel()
    {
        backPanel = new JPanel(new BorderLayout());
        backPanel.add(inputPanel,BorderLayout.NORTH);
        backPanel.add(patientPanel,BorderLayout.WEST);
        backPanel.add(infoPanel,BorderLayout.CENTER);
    }

    private void createInputPanel(){
        inputPanel = new JPanel();
        inputPanel.add(buttonPanel);
        inputPanel.add(searchPanel);
    }

    private void createButtons()
    {
        loadCSVButton = new JButton("Load .CSV");
        loadCSVButton.addActionListener(loadCSVEvent -> controller.loadCSV());
        loadJSONButton = new JButton("Load .JSON");
        loadJSONButton.addActionListener(loadJSONEvent -> controller.loadJSON());

        saveCSVButton = new JButton("Save as .CSV");
        saveCSVButton.addActionListener(saveCSVEvent -> controller.saveToCSV());
        saveJSONButton = new JButton("Save as .JSON");
        saveJSONButton.addActionListener(saveJSONEvent -> controller.saveToJSON());

        statsButton = new JButton("Show Stats");
        statsButton.addActionListener(statsEvent -> controller.displayStatistics());

        sqlButton = new JButton("Load SQL Database");
        sqlButton.addActionListener(sqlEvent -> displaySQL());
    }

    private void createButtonPanel()
    {
        createButtons();
        buttonPanel = new JPanel();
        buttonPanel.add(loadCSVButton);
        buttonPanel.add(loadJSONButton);
        buttonPanel.add(saveCSVButton);
        buttonPanel.add(saveJSONButton);
        buttonPanel.add(statsButton);
        buttonPanel.add(sqlButton);
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Load / Save File"));
    }

    private void displaySQL() {
        JTextField url = new JTextField();
        JTextField username = new JTextField();
        JPasswordField password = new JPasswordField();

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("URL: "));
        panel.add(url);
        panel.add(new JLabel("Username:"));
        panel.add(username);
        panel.add(new JLabel("Password:"));
        panel.add(password);

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Information and Credentials",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            controller.loadSQL(url.getText(), username.getText(), password.getText());
        }
    }

    private void createSearchPanel()
    {
        createSearchField();
        searchPanel = new JPanel();
        searchPanel.add(searchField);
        searchPanel.add(selectionList);
        searchPanel.setBorder(BorderFactory.createTitledBorder("'Enter' to search"));
    }

    private void createSearchField()
    {
        searchField = new JTextField(TEXT_FIELD_COLUMNS);
        Action action = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String text = searchField.getText();
                controller.enterSearch(text);
            }
        };
        searchField.addActionListener(action);
        String searchCategories[] = {"Name", "ID", "Zip", "Suffix", "Deathdate", "Maiden", "Marital", "State", "Drivers",
        "Birthdate", "Ethnicity", "Birthplace", "SSN", "City", "Prefix", "Race", "Address", "Gender", "Passport"};
        selectionList = new JComboBox<>(searchCategories);
    }

    private void createPatientListPanel()
    {
        patientPanel = new JPanel(new BorderLayout());
        patientPanel.setBorder(BorderFactory.createTitledBorder("Patient List"));
        patientList = new JList<>();
        patientList.setVisibleRowCount(LIST_ROWS);
        patientList.addMouseListener(
                new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        String patientName = patientList.getSelectedValue();
                        controller.patientClicked(patientName);
                    }
                });
        scroller = new JScrollPane(patientList);
        patientPanel.add(scroller);
    }

    private void createInfoListPanel()
    {
        infoPanel = new JPanel(new BorderLayout());
        infoPanel.setBorder(BorderFactory.createTitledBorder("Patient Information"));
        infoList = new JList<>();
        infoList.setVisibleRowCount(LIST_ROWS);
        infoScroller = new JScrollPane(infoList);
        infoPanel.add(infoScroller);
    }

    String getSelectedCategory() {
        return (String) selectionList.getSelectedItem();
    }

    void removeAllPatientList(){
        listModel.removeAllElements();
    }

    void removeAllInfoList(){
        infoListModel.removeAllElements();
    }

    void addToPatientList(String info){
        listModel.addElement(info);
    }

    void addToInfoList(String info) {
        infoListModel.addElement(info);
    }

    void setPopUp(String title, String message, int type) {
        JOptionPane.showMessageDialog(this, message, title, type);
    }
}
