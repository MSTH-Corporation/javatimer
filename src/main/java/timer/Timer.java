package timer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Timer {
	private static int timeToWait;
	private static int timer;
	private static TimerCallback callback;
	private static ScheduledExecutorService service=null;
	public void setTime(int time) {
		this.timeToWait=time;
		this.timer=this.timeToWait;
		if (service!=null) {
			service.shutdown();
			waitSeconds();
		}
	}
	/*public void addTime(int timeToAdd) {
		this.timeToWait+=timeToAdd;
		this.timer=this.timeToWait;
	}*/
	public void setCallback(TimerCallback callback) {
		this.callback=callback;
	}
	public void start() {
		service=Executors.newSingleThreadScheduledExecutor();
		service.scheduleAtFixedRate(Timer::thread, 0, this.timeToWait, TimeUnit.SECONDS);
	}
	private static void thread() {
		Timer.timer--;
		System.out.println("Timer:"+Timer.timer);
		if (Timer.timer==0) {
			callback.callback();
			service.shutdown();
		}
	}
	public void stop() {
		if (service!=null) {
			service.shutdown();
		} else
			throw new NullPointerException();
	}
}
