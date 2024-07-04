package helper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyQuiz extends Frame {

    private final Label questionLabel;
    private final Button[] optButtons;
    private int totalQuestion=0;
    private int score = 0;
    private ResultSet resultSet;
    private int timeLeft = 30;
    private Timer countdownTimer;
    private final Label timerLabel;




    private final DatabaseHandler databaseHandler;
    private QuizTimer quizTimer;


    public MyQuiz(){
        setTitle("Quiz Application with Timer");
        setSize(750,500);
        setLayout(null);

        setLocationRelativeTo(null);
        setResizable(false);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                 dispose();
                 System.exit(0);
            }
        });

        questionLabel = new Label("Hello",Label.CENTER);
        questionLabel.setBounds(75,50,600,50);
        questionLabel.setBackground(Color.CYAN);
        add(questionLabel);

        timerLabel = new Label("Time left: " + timeLeft + " seconds");
        timerLabel.setBounds(300, 120, 150, 20);
        add(timerLabel);

        int width=150;
        int height=200;

        optButtons = new Button[4];
        for (int i = 0; i < 2; i++) {
            optButtons[i] = new Button();
            optButtons[i].setBackground(Color.orange);
            optButtons[i].setBounds(width, height,200,40);
            add(optButtons[i]);
            optButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    checkAnswer(e.getActionCommand());
                }
            });
            width+=250;
        }

        width=150;
        height+=100;

        for (int i = 2; i < 4; i++) {
            optButtons[i] = new Button();
            optButtons[i].setBackground(Color.orange);
            optButtons[i].setLabel(""+i);
            optButtons[i].setBounds(width, height,200, 40);
            add(optButtons[i]);
            optButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    checkAnswer(e.getActionCommand());
                }
            });
            width+=250;
        }
        databaseHandler = new DatabaseHandler();
        try {
            databaseHandler.connect();
            resultSet = databaseHandler.executeQuery();
            quizTimer = new QuizTimer(() -> {
                JOptionPane.showMessageDialog(this, "Time over, moving to next question");
                displayInfoInLayout();
            });
            displayInfoInLayout();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    private void startCountdownTimer() {
        countdownTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeLeft--;
                if (timeLeft >= 0) {
                    timerLabel.setText("Time left: " + timeLeft + " seconds");
                } else {
                    countdownTimer.stop();
                }
            }
        });
        countdownTimer.start();
        timeLeft=30;
    }

    private void displayInfoInLayout() {
        try {
            if (resultSet.next()) {
                totalQuestion++;
                questionLabel.setText(resultSet.getString("question"));
                optButtons[0].setLabel(resultSet.getString("op1"));
                optButtons[1].setLabel(resultSet.getString("op2"));
                optButtons[2].setLabel(resultSet.getString("op3"));
                optButtons[3].setLabel(resultSet.getString("op4"));
                startCountdownTimer();
                quizTimer.restart();
            } else {
                timeLeft=0;
                quizTimer.stop();
                databaseHandler.close();
                JOptionPane.showMessageDialog(this, "Quiz ended. Score: " + score+" / "+totalQuestion);
                System.exit(0);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void checkAnswer(String selectedOption) {
        try {
            if (resultSet.getString("correctAns").equals(selectedOption)) {
                score++;
                displayInfoInLayout();
            } else {
                displayInfoInLayout();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        setVisible(true);
    }

}
