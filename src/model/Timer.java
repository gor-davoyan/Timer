package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Timer implements Runnable {
    private int minutes;
    private int seconds;
    static SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");

    public Timer(int minutes, int seconds) {
        setMinutes(minutes);
        setSeconds(seconds);
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        if (minutes > 0)
            this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        if (seconds > 0)
            this.seconds = seconds;
    }

    @Override
    public void run() {
        UI.finishLabel.setText("");
        int time = 60 * minutes + seconds;
        for (int i = 0; i <= time; i++) {
            UI.timeLabel.setText(sdf.format(new Date((60L * minutes + seconds) * 1000)));
            if (seconds == 0) {
                seconds = 60;
                minutes--;
            }
            seconds--;
            if (i != time)
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        UI.finishLabel.setText("Finished!");
    }
}