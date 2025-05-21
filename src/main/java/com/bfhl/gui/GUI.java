package com.bfhl.gui;
import javax.swing.*;
public class GUI {
    public static void showMessage(String title, String message) {
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
