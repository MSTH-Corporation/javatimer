# javatimer
 
# Usage

public class JavaTimerTest {
 public static void main(String args[]) {
  Timer t = new Timer();
  t.setTime(10); //Sets the time (in seconds)
  t.setCallback(() -> {
   System.out.print("Time finished!");
  }); //Sets the function that will run when the time has finished
  t.waitSeconds(); //Starts the timer
 } 
}

If you want to stop the timer write:
t.stop();
