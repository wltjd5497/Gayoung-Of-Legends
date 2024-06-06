public class HunterThread extends Thread{ // 몹을 생성하는 역할
    private GamePanel gamePanel = null;
    private TimerLabel timerLabel = null;
    public HunterThread(GamePanel gamePanel, TimerLabel timerLabel){
        this.gamePanel = gamePanel;
        this.timerLabel = timerLabel;
    }

    @Override
    public void run(){
        while(!timerLabel.isBarOut()){ // 바가 존재하는 동안
            try {
                gamePanel.genMob();
                gamePanel.repaint();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }

}
