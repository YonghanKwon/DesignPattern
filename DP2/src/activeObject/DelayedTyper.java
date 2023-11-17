package activeObject;

public class DelayedTyper implements Command {
    private long mDelay = 0;
    private char mChar;
    private static boolean stop = false;
    private static ActiveObjectEngine engine = new ActiveObjectEngine();    
    public DelayedTyper(long delay, char c) {
        mDelay = delay;
        mChar = c;
    }
    @Override
    public void execute() {
        System.out.print(mChar);
        if (!stop) {
            delayAndRepeat();
        }
    }
    
    private void delayAndRepeat() {
        engine.addCommand(new SleepCommand(mDelay, engine, this));
    } 
    
    public static void main(String args[]) throws Exception {
        engine.addCommand(new DelayedTyper(100, '1'));
        engine.addCommand(new DelayedTyper(300, '3'));
        engine.addCommand(new DelayedTyper(500, '5'));
        engine.addCommand(new DelayedTyper(700, '7'));        

        Command stopCommand = new Command() {            
            @Override public void execute() {
                stop = true;                
            }
        };        
        engine.addCommand(new SleepCommand(10000, engine, stopCommand));      
        engine.run();
    }
} // end of class
