import javax.swing.*;

public class StartLabel extends JLabel {
    private ImageIcon readyIcon = new ImageIcon("image/ready.png");
    private ImageIcon goIcon = new ImageIcon("image/go.png");

    @Override
    public int getWidth(){
        return readyIcon.getIconWidth();
    }

    @Override
    public int getHeight(){
        return readyIcon.getIconHeight();
    }

    public StartLabel(){
    } // end of CTOR

    public void noticeReady(){
        setIcon(readyIcon);
        repaint();
    } // end of noticeReady()

    public void noticeGo(){
        setIcon(goIcon);
        repaint();
    } // end of noticeGo()

    public void resetIcon(){
        setIcon(null);
        repaint();
    }
}
