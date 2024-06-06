import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntroPanel extends JPanel {
    private int level = 1; // 디폴트 레벨 1
    private GameFrame gameFrame = null;
    private ImageIcon bgIcon = new ImageIcon("image/intro_image.jpg");
    private Image bgImg = bgIcon.getImage();
    private GamePanel gamePanel = null;
    private StartLabel startLabel = new StartLabel(); // 스타트 레이블
    private StartLabelThread startLabelThread = new StartLabelThread(startLabel); // 스타트 레이블 동작시키는 스레드
    private TimerLabel timerLabel = new TimerLabel(gameFrame); // 타이머 레이블
    private ConsumerThread consumerThread = new ConsumerThread(timerLabel, level); // 타이머 감소시키는 스레드
    // end of Field

    public IntroPanel(GameFrame gameFrame){
        this.gameFrame = gameFrame;
        gamePanel = new GamePanel(gameFrame, startLabel, timerLabel);
        setLayout(null);
        drawLogo(); // 로고를 그린다
        addButton(); // 게임 시작 버튼 삽입
    } // end of CTOR

    private void pressStartButton(){
        gameFrame.setContentPane(gamePanel);
        gameFrame.validate(); // 변경 사항 적용
        startLabelThread.start(); // Ready, Go! 나타내기
        consumerThread.start(); // 타이머 시작
    } // end of startGame()

    private void drawLogo(){
        ImageIcon logoIcon = new ImageIcon("image/Logo2.png");
        JLabel logoLabel = new JLabel(logoIcon);

        logoLabel.setSize(logoIcon.getIconWidth(), logoIcon.getIconHeight());
        logoLabel.setLocation(45, 140);
        add(logoLabel);
    } // end of drawLogo()

    private void addButton(){
        ImageIcon startIcon = new ImageIcon("image/start.png");
        ImageIcon startPressedIcon = new ImageIcon("image/start_pressed.png");
        ImageIcon rankIcon = new ImageIcon("image/rank.png");
        ImageIcon exitIcon = new ImageIcon("image/exit.png");

        JButton start = new JButton(startIcon);
        start.setSize(startIcon.getIconWidth(), startIcon.getIconHeight());
        start.setLocation(340, 450);
        add(start);

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressStartButton();
            }
        });

        start.setPressedIcon(startPressedIcon);
        // end of startBtn

        JButton rank = new JButton(rankIcon);
        rank.setSize(rankIcon.getIconWidth(), rankIcon.getIconHeight());
        rank.setLocation(341, start.getY() + start.getHeight() + 5);
        add(rank);

        rank.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 랭킹 조회를 위한 새 프레임 띄우기
            }
        });
        // end of rankBtn

        JButton exit = new JButton(exitIcon);
        exit.setSize(exitIcon.getIconWidth(), exitIcon.getIconHeight());
        exit.setLocation(340, rank.getY() + rank.getHeight() + 5);
        add(exit);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
        // end of exitBtn

    } // end of addButton()

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(bgImg, 0, 0, getWidth(),getHeight(), null);
    }
}
