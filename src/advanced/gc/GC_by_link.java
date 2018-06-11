/*
 * Source: http://www.codeceo.com/article/java-gc-part-one.html
 * 
 * Simply example which demonstrate how GC work by checking F-queue
 * and checked by finalize method.
 */


package advanced.gc;

public class GC_by_link {
	
	
    public static GC_by_link object;
    
    public void isAlive() {
        System.out.println("Alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("method finalize is running");
        object = this;
    }

    public static void main(String[] args) throws Exception {
        object = new GC_by_link();

        //Lost reference, as the object dun linked to any object,
        //GC should be smart enough to pick it up.
        object = null;
        
        /* 
         * Cleaning, object got picked up, inserted into F-queue and
         * marked for first time, object only be clean for marked two times.
         * 
         * Then F-queue would run obj,finalize() one by one, cleaned those which 
         * dun linked any other object, move other back to track 
         * (those have interaction with other object in finalize method).
         * 
         */
        System.gc();
        //During the
        

        //Wait for gc done in case it affect experiment result? 
        Thread.sleep(1000);
        
        //As you see "object = this;" call in finalize method, so gc simply put it back on.
        if (object != null) {
            object.isAlive();
        } else {
            System.out.println("Gone");
        }

        /*
         * Unfortunately, finalize method only worked once, 
         * so it dead straight after second time of losing refernce 
         */  
        object = null;
        System.gc();

        Thread.sleep(500);
        if (object != null) {
            object.isAlive();
        } else {
            System.out.println("Gone");
        }
        
    }
    
}