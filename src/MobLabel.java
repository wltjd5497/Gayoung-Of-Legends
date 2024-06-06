import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MobLabel extends JLabel {
    private ImageIcon[] mobIcon = new ImageIcon[8];
    private int randomNum = (int)(Math.random()*7);
    private TimerLabel timerLabel = null;

    @Override
    public int getWidth(){
        return mobIcon[randomNum].getIconWidth();
    }

    @Override
    public int getHeight(){
        return mobIcon[randomNum].getIconHeight();
    }
    private void generateMobLabelArray(){
        mobIcon[0] = new ImageIcon("image/mob1.png");
        mobIcon[1] = new ImageIcon("image/mob2.png");
        mobIcon[2] = new ImageIcon("image/mob3.png");
        mobIcon[3] = new ImageIcon("image/mob4.png");
        mobIcon[4] = new ImageIcon("image/mob5.png");
        mobIcon[5] = new ImageIcon("image/mob6.png");
        mobIcon[6] = new ImageIcon("image/mob7.png");
        mobIcon[7] = new ImageIcon("image/mob8.png");
    }
    public MobLabel(TimerLabel timerLabel){
        this.timerLabel = timerLabel;
        generateMobLabelArray();
        setIcon(mobIcon[randomNum]);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                timerLabel.fill(50); // 타이머를 50만큼 채우고
                Container parent = timerLabel.getParent(); // 부모 컴포넌트를 참조합니다
                parent.remove(MobLabel.this); // MobLabel 인스턴스 제거

                SwingUtilities.invokeLater(() -> {
                    parent.repaint(); // 부모 컴포넌트를 다시 그립니다
                    parent.revalidate(); // 레이아웃을 새로 계산하고 GUI를 새로 고침
                });
            }
        });
    } // end of CTOR

}
