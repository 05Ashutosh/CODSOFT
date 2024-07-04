package helper;

import javax.swing.*;

public class QuizTimer {
    private Timer timer;
    private static final int QUESTION_TIME = 30000; 
    public QuizTimer(Runnable timeoutAction) {
        timer = new Timer(QUESTION_TIME, e -> timeoutAction.run());
        timer.setRepeats(false);
    }

    public void start() {
        timer.start();
    }

    public void restart() {
        timer.restart();
    }

    public void stop() {
        timer.stop();
    }
}
