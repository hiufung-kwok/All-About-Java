package concurrent.keyword.low_lv_sync;


public class Main {

	public static void main(String[] args) throws InterruptedException {
		final Low_Lv_Sync low_lv_sync = new Low_Lv_Sync();
		
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					low_lv_sync.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}		
		});
		
		
		Thread t2 = new Thread(new Runnable () {

			@Override
			public void run() {
				try {
					low_lv_sync.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();

	}

}
