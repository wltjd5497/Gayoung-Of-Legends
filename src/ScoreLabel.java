import javax.swing.*;
import java.awt.*;

public class ScoreLabel extends JLabel {
    private int score = 0; // 처음 점수 0부터 시작
    public int getScore(){
        return score;
    }

    public ScoreLabel(){
        setText(Integer.toString(score));
        setForeground(Color.YELLOW);
    } // end of CTOR

    @Override
    public int getWidth(){
        return (score/10 + 1)*10;
    } // end of getWidth()

    synchronized public void increase(int s){
        score += s; // 스코어 업
        setText(Integer.toString(score));
        notify(); // score가 0보다 작아 wait된 스레드를 깨우기
    } // 점수를 s만큼 올리는 함수

    synchronized public void decrease(int s){
        if(score <= 0){
            try {
                wait();
            } catch (InterruptedException e) {
                return;
            }
        }
        score -= s;
        setText(Integer.toString(score));
    } // 점수를 s만큼 줄이는 함수
}
