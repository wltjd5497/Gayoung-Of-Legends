public class ConsumerThread extends Thread{
    private int level = 1; // 디폴트 난이도는 레벨 1
    private TimerLabel bar = null;
    public ConsumerThread(TimerLabel bar, int level){
        this.level = level;
        this.bar = bar;
    } // end of CTOR

    @Override
    public void run(){
        try {
            Thread.sleep(2000); // 2초 후 시작 - Ready, Go! 재생될동안
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        while (true) {
            try {
                Thread.sleep(10); // 0.01초마다 감소
                bar.consume(1*level); // 1 * level 씩 감소
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
