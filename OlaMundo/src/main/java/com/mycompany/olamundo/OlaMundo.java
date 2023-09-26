package com.mycompany.olamundo;

/**
 *
 * @author a21pablorf
 */
public class OlaMundo {

    public static void main(String[] args) {
        // Schedule a job for the event-dispatch thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
        });
    }
}
