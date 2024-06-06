public class StartLabelThread extends Thread{
    private StartLabel startLabel = null;
    public StartLabelThread(StartLabel startLabel){
        this.startLabel = startLabel;
    }

    @Override
    public void run(){
        try {
            startLabel.noticeReady();
            Thread.sleep(1200); // 1.2초 후
            startLabel.noticeGo();
            Thread.sleep(800); // Go 보여주고 0.8초 후 시작
            startLabel.resetIcon();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
