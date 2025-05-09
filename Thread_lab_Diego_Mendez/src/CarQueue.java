import java.util.*;

public class CarQueue{

	private ArrayList<Integer> directionQ = new ArrayList<>();

	
	public CarQueue() {
		directionQ.add(2);
		directionQ.add(1);
		directionQ.add(2);
		directionQ.add(3);
		directionQ.add(0);	
	}
	
	
	public void addToQueue() {
		class addToQueueRunnable implements Runnable{
			@Override
			public void run() {
			
				try {
					directionQ.add(1);
					directionQ.add(3);
					directionQ.add(1);
					directionQ.add(2);
					directionQ.add(2);

					Thread.sleep(1000);
				} catch (InterruptedException e) {
					return;
				}
			}	
		}
		Runnable queueCar = new addToQueueRunnable();
		Thread t1 = new Thread(queueCar);
		t1.start();
	
	}
	
	public int deleteQueue() {
		return directionQ.remove(0);
	}
	
}
