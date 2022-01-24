package ques1;

class MyThread implements Runnable{
	Thread thread;
	
	public MyThread(String msg) {
		thread = new Thread(this,msg);
	}
	
	public void run() {
		int i = 0;
		while(i<=100) {
			System.out.println("Thread: "+thread.getName()+" prints: "+i);
			i++;
		}
	}
	
}


public class DemoMultiThread {
	public static void main(String[] args) {
		MyThread mythread = new MyThread("1");
		MyThread mythread2 = new MyThread("2");
		MyThread mythread3 = new MyThread("3");
		mythread.thread.start();
		mythread2.thread.start();
		mythread3.thread.start();
	}
}
