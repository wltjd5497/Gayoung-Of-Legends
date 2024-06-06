import javax.swing.*;
import java.awt.*;

public class TimerLabel extends JLabel {
    private int barSize = 500;
    private final int MAX_BAR_SIZE = 500;
    private JFrame gameFrame = null;
    // end of Field

    public TimerLabel(JFrame gameFrame){
        this.gameFrame = gameFrame;
        setBackground(Color.YELLOW);
        setOpaque(true); // 배경을 투명하게
    } // end of CTOR

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.green);
        int width = (int)(((double)this.getWidth())/MAX_BAR_SIZE * barSize);
        if (width==0) return; // barSize가 0이어서 0이므로
        g.fillRect(0, 0, width, this.getHeight());
    }

    public boolean isBarOut(){
        if(barSize==0) return true;
        else return false;
    }

    synchronized public void fill(int score){
        if(barSize==MAX_BAR_SIZE) { // 바가 꽉 찼다면
            try {
                wait();
            } catch (InterruptedException e) {
                return;
            }
        }
        barSize += score; // score 만큼 바 증가
        repaint();
        notify();
    } // end of fill()

    synchronized public void consume(int consumeLevel){
        if(barSize==0){
            try {
                wait();
            } catch (InterruptedException e) {
                return;
            }
        }
        barSize -= consumeLevel; // consumeLevel만큼 바 감소
        repaint();
        notify();
    } // end of consume()

    public void gameOver(){

    } // 게임 오버를 담당하는 함수
}
