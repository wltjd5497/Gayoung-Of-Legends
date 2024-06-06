import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameFrame extends JFrame {
    private IntroPanel introPanel = new IntroPanel(this);
    public GameFrame(){
        super("Gayoung of Legends");
        setSize(576, 765);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(480, 20);
        setResizable(false);
        setContentPane(introPanel);
        renewCursor();

        setVisible(true);
    } // end of CTOR

    private void renewCursor(){
        Toolkit tk = Toolkit.getDefaultToolkit(); // Toolkit에 대해 알아볼것

        ImageIcon targetIcon = new ImageIcon("image/target.png");
        Image targetImg = targetIcon.getImage();

        ImageIcon targetClickedIcon = new ImageIcon("image/target_clicked.png"); // 클릭 시 이미지
        Image targetClickedImg = targetClickedIcon.getImage();

        Point point = new Point(10, 10);
        Cursor targetCursor = tk.createCustomCursor(targetImg, point, ""); // 기본 마우스 커서
        Cursor targetPressedCursor = tk.createCustomCursor(targetClickedImg, point, "");

        setCursor(targetCursor);

        this.addMouseListener(new MouseAdapter() { // 컨텐트팬 마우스 모양 변경
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                setCursor(targetPressedCursor);
            }

            @Override
            public void mouseReleased(MouseEvent e){
                super.mouseReleased(e);
                setCursor(targetCursor);
            }
        });
    } // end of renewCursor()


    public static void main(String[] args){
        new GameFrame();
    } // end of main()
}
