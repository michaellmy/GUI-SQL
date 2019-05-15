package uk.ac.ucl.data;

import uk.ac.ucl.data.MVC.GUIView;

import javax.swing.*;

/**
 * A simple GUI designed to display patient information.
 *
 * Pressing the 'Enter' key in search bar searches patients by any category.
 *
 * GUIModel - Model class containing all information and getter methods about patients.
 * ModelStatistics - Model class containing additional statistical information about patients.
 * GUIView - View class creating the visible display for the user.
 * GUIController - Controller class interacting with the the Models and GUIView.
 */

public class Main extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUIView::new);
    }
}
