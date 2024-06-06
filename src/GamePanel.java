import javax.swing.*;
import java.awt.*;
public class GamePanel extends JPanel {
    private GameFrame gameFrame = null;
    private ImageIcon bgIcon = new ImageIcon("image/intro_image.jpg");
    private Image bgImg = bgIcon.getImage();
    private StartLabel startLabel = null; // Ready, Go 레이블
    private TimerLabel timerLabel = null; // 타이머 나타내는 레이블
    private ScoreLabel scoreLabel = new ScoreLabel(); // 점수 띄우는 레이블

    // end of Field

    public GamePanel(GameFrame gameFrame, StartLabel startLabel, TimerLabel timerLabel){
        this.startLabel = startLabel;
        this.timerLabel = timerLabel;
        this.gameFrame = gameFrame;
        setLayout(null);
        putStartLabel(); // 스타트 레이블 삽입
        putTimerLabel(); // 타이머 삽입
        putScoreLabel(); // 스코어 삽입

        HunterThread hunterThread = new HunterThread(this, timerLabel);
        hunterThread.start();
    } // end of CTOR

    private void putStartLabel(){
        startLabel.setSize(startLabel.getWidth(), startLabel.getHeight());
        startLabel.setLocation(130, 300);
        add(startLabel);
    } // Ready, Go! 띄우는 함수
    private void putTimerLabel(){
        timerLabel.setSize(576, 40);
        timerLabel.setLocation(0,0);
        add(timerLabel);
    } // 타이머 띄우는 함수
    private void putScoreLabel(){
        scoreLabel.setSize(scoreLabel.getWidth(), 30);
        scoreLabel.setLocation(540, 45);
        scoreLabel.setFont(new Font("Gothic", Font.BOLD, 15));
        add(scoreLabel);
        repaint();
    } // 점수 띄우는 함수
    public void genMob(){
        int x = (int)(Math.random()*561)+10;
        int y = (int)(Math.random()*671)+30;
        MobLabel mobLabel = new MobLabel(timerLabel);
        mobLabel.setSize(mobLabel.getWidth(), mobLabel.getHeight());
        mobLabel.setLocation(x, y);
        add(mobLabel);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bgImg, 0, 0, getWidth(), getHeight(), null);
    } // end of paintComponent()
}
