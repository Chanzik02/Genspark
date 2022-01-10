import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DriverGUI {
    int humanStartPos = (int)(Math.random() * 19);
    Human human = new Human(humanStartPos,100,100);
    JFrame frame;
    Container container;
    JPanel headerPanel, mainTextPanel, directionPanel;
    JPanel startButtonPanel, playerStatsPanel;
    JButton startButton, northButton, southButton, eastButton, westButton;
    JLabel titleLabel, healthLabel, healthNumberLabel;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 20);
    Font startButtonFont = new Font("Times New Roman", Font.PLAIN, 30);
    JTextArea textArea1, textArea2, textArea3, textArea4;
    MainScreenHandler mainScreenHandler = new MainScreenHandler();

    public DriverGUI() {
        frame = new JFrame();
        frame.setSize(1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(null);
        frame.setVisible(true);

        container = frame.getContentPane();

        headerPanel = new JPanel();
        headerPanel.setBounds(200, 100, 600, 150);
        headerPanel.setBackground(Color.ORANGE);

        titleLabel = new JLabel("Hello");
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setFont(titleFont);

        headerPanel.add(titleLabel);
        container.add(headerPanel);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(400,400,200,50);
        startButtonPanel.setBackground(Color.BLUE);
        container.add(startButtonPanel);


        startButton = new JButton("Start");
        startButton.setBackground(Color.RED);
        startButton.setForeground(Color.WHITE);
        startButton.setBounds(450, 400, 100,50);
        startButton.setFont(startButtonFont);
        startButton.addActionListener(mainScreenHandler);

        startButtonPanel.add(startButton);
        container.add(startButtonPanel);

        container.add(startButton);

    }

    public void inGameScreen() {
        headerPanel.setVisible(false);
        startButtonPanel.setVisible(false);
        startButton.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(200,100,600, 250);
        mainTextPanel.setBackground(Color.BLUE);
        mainTextPanel.setLayout(new GridLayout(2, 3));
        container.add(mainTextPanel);

        textArea1 = new JTextArea("Open");
        textArea1.setBounds(100, 100, 600, 250);
        textArea1.setBackground(Color.GREEN);
        textArea1.setForeground(Color.WHITE);
        textArea1.setFont(startButtonFont);
        textArea1.setLineWrap(true);
        mainTextPanel.add(textArea1);

        textArea2 = new JTextArea("Human");
        textArea2.setBounds(100, 100, 600, 250);
        textArea2.setBackground(Color.GREEN);
        textArea2.setForeground(Color.WHITE);
        textArea2.setFont(startButtonFont);
        textArea2.setLineWrap(true);
        mainTextPanel.add(textArea2);

        textArea3 = new JTextArea("Goblin");
        textArea3.setBounds(100, 100, 600, 250);
        textArea3.setBackground(Color.GREEN);
        textArea3.setForeground(Color.WHITE);
        textArea3.setFont(startButtonFont);
        textArea3.setLineWrap(true);
        mainTextPanel.add(textArea3);

        textArea4 = new JTextArea("Open");
        textArea4.setBounds(100, 100, 600, 250);
        textArea4.setBackground(Color.GREEN);
        textArea4.setForeground(Color.WHITE);
        textArea4.setFont(startButtonFont);
        textArea4.setLineWrap(true);
        mainTextPanel.add(textArea4);

        directionPanel = new JPanel();
        directionPanel.setBounds(400, 350, 300, 150);
        directionPanel.setBackground(Color.WHITE);
        directionPanel.setLayout(new GridLayout(4, 1));
        container.add(directionPanel);

        northButton = new JButton("North");
        northButton.setBackground(Color.BLACK);
        northButton.setForeground(Color.WHITE);
        northButton.setFont(startButtonFont);
        northButton.setBounds(300, 300, 200, 200);
        directionPanel.add(northButton);
        southButton = new JButton("South");
        southButton.setBackground(Color.BLACK);
        southButton.setForeground(Color.WHITE);
        southButton.setFont(startButtonFont);
        directionPanel.add(southButton);
        eastButton = new JButton("East");
        eastButton.setBackground(Color.BLACK);
        eastButton.setForeground(Color.WHITE);
        eastButton.setFont(startButtonFont);
        directionPanel.add(eastButton);
        westButton = new JButton("West");
        westButton.setBackground(Color.BLACK);
        westButton.setForeground(Color.WHITE);
        westButton.setFont(startButtonFont);
        directionPanel.add(westButton);

        playerStatsPanel = new JPanel();
        playerStatsPanel.setBounds(100, 15, 600, 50);
        playerStatsPanel.setBackground(Color.blue);
        playerStatsPanel.setLayout(new GridLayout(1, 4));
        container.add(playerStatsPanel);

        healthLabel = new JLabel("Health: ");
        healthLabel.setFont(titleFont);
        healthLabel.setForeground(Color.WHITE);
        playerStatsPanel.add(healthLabel);
        healthNumberLabel = new JLabel(Integer.toString(this.human.getHealth()));
        healthNumberLabel.setFont(titleFont);
        healthNumberLabel.setForeground(Color.WHITE);
        playerStatsPanel.add(healthNumberLabel);

    }

    public class MainScreenHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            inGameScreen();
        }
    }

    public static void main(String[] args) {
        DriverGUI gui = new DriverGUI();
    }
}
