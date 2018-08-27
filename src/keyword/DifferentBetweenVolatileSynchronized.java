package keyword;

/*
* Ref: https://dzone.com/articles/difference-between-volatile-and-synchronized-keywo
*
* Things need to be clear before stepping into any code listed below.
*
* There have fundamentally different between Volatile and Synchronized.
* When any variable marked as Volatile, only one copy of the variable would exist within the whole JVM heap.
* Which is the "main" memory, cuz base of the efficiency consideration, usually when a new thread is created,
* it would also copy of the variable which may be used into its dedicate memory block. In this way, thread can
* have a faster access when some of the varaible is frequently used on Thread rather than fetch it from the
* "main" memory.
*
* But the problem here variable is not in sync between main memory and thread dedicated memory. Thread only
* keep the snapshot of an varaible when in create time and even the variable on "Main" block updated afterward,
* but the thread would never got noticed about the change. In this point of view the variable is not consistence.
*
* The keyword volatile is come to save this situation. When volatile is attached on a variable. the var is itself won't
* split while other thread are making use of it. No matter how many thread referencing it. No copy would be generated and
* all access of the var would point right back to the "main memory" in this way, var would always be latest version.
*
*
* While Synchronized seems to work in similar way and it does. However the internal mechanism is totally different.
* while Thread enter Sync block. It would instruct the thread itself to flush it's memory block and fetch a brand new copy
* from the "main" memory. Noticed that in here the scope is huger than volatile. Cuz in most of the case we just care about
* certainly var which is changed frequently by other. But when Sync is executing, it would just simply flush all instead of
* pinpointed var. And still han't mention  it make use of Lock mechanism which is costly.
*
*
*
* TBC: Example would be added when it's on blog post.
*
* */
public class DifferentBetweenVolatileSynchronized {


    public static void main(String[] args) {

    }
}
