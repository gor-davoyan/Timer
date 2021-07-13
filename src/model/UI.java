package model;

import javax.swing.*;
import java.awt.*;

public class UI extends JFrame {
    static JLabel timeLabel;
    static JLabel finishLabel;
    static JButton startButton;

    public UI() {
        super("Timer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        initComponents();

        setLayout(null);
        setVisible(true);
    }

    private void initComponents() {
        JLabel hintLabel = new JLabel("Enter time (minutes,seconds)");
        hintLabel.setBounds(140, 140, 250, 30);
        add(hintLabel);

        JTextField timeTextField = new JTextField();
        timeTextField.setBounds(190, 180, 110, 30);
        add(timeTextField);

        JPanel greenPanel = new JPanel();
        greenPanel.setBounds(140, 310, 220, 70);
        greenPanel.setLayout(new BorderLayout());
        greenPanel.setBackground(Color.GREEN);
        add(greenPanel);

        startButton = new JButton("Start");
        startButton.setBounds(194, 230, 100, 30);
        add(startButton);


        timeLabel = new JLabel("00:00");
        timeLabel.setBounds(195, 310, 100, 30);
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setVerticalAlignment(SwingConstants.CENTER);

        Font font = new Font("Courier", Font.BOLD, 12);
        timeLabel.setFont(font);
        timeLabel.setFont(timeLabel.getFont().deriveFont(16f));

        greenPanel.add(timeLabel);

        finishLabel = new JLabel();
        finishLabel.setBounds(190, 70, 100, 30);
        finishLabel.setHorizontalAlignment(SwingConstants.CENTER);
        finishLabel.setVerticalAlignment(SwingConstants.CENTER);

        finishLabel.setFont(font);
        finishLabel.setFont(finishLabel.getFont().deriveFont(16f));

        add(finishLabel);

        startButton.addActionListener(e -> {
            Thread t = new Thread(new Timer(timeTextField.getText()));
            t.start();
        });
    }
}