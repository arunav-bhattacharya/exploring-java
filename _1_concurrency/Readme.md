# Concurrency on JVM

## Some core concepts

### Program
A Program is a set of instructions, most likely written in a programming language that tells the Computer how to perform a specific task.

### Process
A Process is a single executing instance of a program. When a program runs, the Operating System creates a *process* to manage its execution.

### Thread
A Thread is the smallest unit of execution within a process. A process can have multiple threads, which share the same resources but can run independently.

### Multitasking
Multitasking allows an Operating System to run multiple processes simultaneously.

### Multithreading
Multithreading refers to the ability to execute multiple threads within a single process concurrently. Multithreading enhances the efficiency of multitasking by breaking down individual tasks into smaller sub-tasks or threads and these threads can be processed simultaneously thereby making better use of CPU.

### Multitasking vs Multithreading

| Multitasking                                                                                                                     | Multithreading                                                                                              |
|----------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------|
| Multitasking can be achieved through multithreading where each task is divided into threads that are managed concurrently.       | Multithreading is more granular dealing with multiple threads within the same application or process.       |
| Multitasking operates at processes, which are OS's primary units of execution.                                                   | Multithreading operates at the level of threads, which are smaller units within a process.                  |
| Involves managing resources between completely separate programs, which may have independent memory spaces and system resources. | Involves managing resources within a single program, where threads share the same memory and resources.     |
| Allows to run multiple applications simultaneously, improving productivity and system utilization.                               | Allows single app to perform multiple tasks at the same time, improving app performance and responsiveness. |


<br>

## Multithreading in Java

Java's multithreading is managed by the JVM and the OS, using time-slicing thread execution is managed thus giving an illusion of concurrency. Irrespective of single or multi-core CPUs, Java's multithreading can take full advantage of the available cores.

### Constructing Thread

A `Thread` is a lightweight process, the smallest unit of processing. To create a new thread in Java, we can do either of the two - 
1. Extend the `java.lang.Thread` class
2. Implement the `java.lang.Runnable` interface

In both the cases, the overridden `run()` method contains the code that will be executed in a separate `Thread`.

### Thread Lifecycle

A thread can move through a number of states in the JVM in its lifecycle -
```
NEW: 
- Thread created but not started

RUNNABLE: 
- After start() is called, it is in RUNNABLE state, but waiting for CPU time. 
- When it is executing. But Java doesn't have a separate ENUM value for RUNNING. It is maintained under RUNNABLE.
- OS actually schedules execution of thread, and that is abstracted of JVM. Hence JVM doesn't know when a thread is RUNNING, as that's why there is no RUNNING state.  

BLOCKED 
- Blocked while waiting for a lock. 

WAITING:
- Waiting indefinitely on another thread to do an action.
 
TIMED_WAITING: 
- Waiting on another thread for a specified Waiting time

TERMINATED: 
- When thread finished executing
```

### Daemon Thread

- Daemon Threads are background threads that stop execution when the main thread completes or all user threads execution completes.
- We can make a thread as deamon thread by setting the daemon flag to `true`.

```java
    Thread t1 = new Thread();
    t1.setDaemon(true);
```

### `sleep()` and `join()`

<br/>

## References

- [1-Introduction to Java Threads](https://www.infoworld.com/article/2163579/java-101-understanding-java-threads-part-1-introducing-threads-and-runnables.html)
- [2-Thread Synchronization](https://www.infoworld.com/article/2163830/java-101-understanding-java-threads-part-2-thread-synchronization.html)
- [3-Thread scheduling](https://www.infoworld.com/article/2157214/java-101-understanding-java-threads-part-3-thread-scheduling-and-wait-notify.html)
- [4-Thread groups, volatile and thread local](https://www.infoworld.com/article/2164617/java-101-understanding-java-threads-part-4-thread-groups-volatility-and-threa.html)
- [5-Concurreny Utilities](https://www.infoworld.com/article/2171320/java-concurrency-java-101-the-next-generation-java-concurrency-without-the-pain-part-1.html)
- [6-Locking Framework, Fork/Join Framework](https://www.infoworld.com/article/2171493/java-concurrency-java-101-the-next-generation-java-concurrency-without-the-pain-part-2.html)
