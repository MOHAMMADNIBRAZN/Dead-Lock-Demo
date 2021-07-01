package PRACTICE;

public class DeadLockDemo {
	public static void main(String[] args) {
		Frog frog=new Frog();
		Crane crane=new Crane();
		new Thread(new Runnable() {
			@Override
			public void run() {
				crane.eat(frog);
			}
		}).start();
				
		new Thread(new Runnable() {
			@Override
			public void run() {
				frog.escape(crane);
			}
		}).start();
	}

}
class Crane{
	synchronized public void eat(Frog frog) {
		System.out.println();
		frog.leaveCalledByCrane();
	}
	synchronized	public void leaceCalledByFrog() {
		
	}
}
class Frog{
	synchronized	public void escape(Crane crane) {
		crane.leaceCalledByFrog();
	}
	synchronized	public void leaveCalledByCrane() {
}
}