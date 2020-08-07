## 多线程

### 线程与进程概述

#### 线程与进程

**进程**

- 是指一个内存中运行的应用程序，每个进程都有一个独立的内存空间线程
- 是进程中的一个执行路径，共享一个内存空间，线程之间可以自由切换，并发执行。一个进程最少有一个线程
- 线程实际上是在进程基础之上的进一步划分，一个进程启动之后，里面的若干执行路径又可划分成若干个线程

#### 线程调度

**分时调度**

- 所有线程轮流使用CPU的使用权，平均分配每个线程暂用CPU的时间。

**抢占式调度**

- 优先让优先级高的线程使用CPU，如果线程的优先级相同，那么会随机选择一个（线程随机性），Java使用的为抢占式调度
- CPU使用抢占式调度模式在多个线程间进行着高速的切换。对于CPU的一个核新而言，某个时刻，只能执行一个线程，而 CPU的在多个线程间切换速度相对我们的感觉要快，看上去就是 在同一时刻运行。 其实，多线程程序并不能提高程序的运行速度，但能够提高程序运行效率，让CPU的使用率更高。

#### 同步与异步

- 同步：排队执行，效率低但安全。
- 异步：同时执行，效率高但是数据不安全。

#### 并发与并行

- 并发：指两个或多个事件在**同一个时间段内**发生。
- 并行：指两个或多个事件在**同一时刻**发生（同时发生）。

### 多线程实现

#### 继承Thread

```java
每个线程都拥有自己的栈空间，共用一份堆内存
public class MyThread extends Thread {
	@Override
    public void run() {
    	//这里的代码就是一条新的执行路径
    	//这个执行路径的触发方式，不是调用run方法，而是通过Thread对象的start()方法来启动任务
    	//执行任务代码块
    }
}

public class Demo {
	public static void main(String[] args) {
		Thread thread = new Thread();
		thread.start();
		
		/*
		//匿名内部类方式
        new Thread() {
        	@Override
            public void run() {
            	//执行任务代码块
            }
        }.start();
		*/
	}
}
```

#### Thread类

```
线程是程序中执行的线程。 Java虚拟机允许应用程序同时运行多个执行线程。 
每个线程都有优先权。具有较高优先级的线程优先于具有较低优先级的线程执行。每个线程可能也可能不会被标记为守护进程。 当在某个线程中运行的代码创建一个新的Thread对象时，新线程的优先级最初设置为等于创建线程的优先级，并且当且仅当创建线程是守护进程时才是守护进程线程。 
```

##### 构造方法

| 构造器                                 | 描述                               |
| -------------------------------------- | ---------------------------------- |
| `Thread()`                             | 分配新的Thread对象                 |
| `Thread(String name)`                  | 分配新的Thread对象，name为线程名称 |
| `Thread(Runnable target)`              | 分配新的Thread对象                 |
| `Thread(Runnable target, String name)` | 分配新的Thread对象, name为线程名称 |

##### 方法

| 变量和类型    | 方法                                  | 描述                                                         |
| ------------- | ------------------------------------- | ------------------------------------------------------------ |
| static Thread | `currentThread()`                     | 返回对当前正在执行的线程对象的引用。                         |
| String        | `getName()`                           | 返回此线程的名称。                                           |
| void          | `interrupt()`                         | 中断此线程                                                   |
| boolean       | `isAlive()`                           | 测试此线程是否存活                                           |
| boolean       | `isDaemon()`                          | 测试此线程是否为守护线程                                     |
| void          | `run()`                               | 如果此线程是使用单独的`Runnable`运行对象构造的，则调用该`Runnable`对象的`run`方法; 否则，此方法不执行任何操作并返回。 |
| static void   | `sleep(long millis)`                  | 导致当前正在执行的线程休眠（暂时停止执行）指定的毫秒数，具体取决于系统计时器和调度程序的精度和准确性。 |
| static void   | `sleep(long millis, int namos)`       | 导致当前正在执行的线程休眠（暂时停止执行）指定的毫秒数加上指定的纳秒数，具体取决于系统计时器和调度程序的精度和准确性。 |
| void          | `start()`                             | 导致此线程开始执行; Java虚拟机调用此线程的`run`方法。        |
| void          | `notify()`                            | 随机唤醒正在此对象监视器上等待的单个线程。                   |
| void          | `notifyAll()`                         | 唤醒等待此对象监视器的所有线程。                             |
| void          | `wait()`                              | 导致当前线程等待它被唤醒，通常是 *通知* 或 *中断* 。         |
| void          | `wait(long timeoutMillis)`            | 导致当前线程等待它被唤醒，通常是 *通知* 或 *中断* ,      或者直到经过一定量的实时。 |
| void          | `wait(long timeoutMillis, int nanos)` | 导致当前线程等待它被唤醒，通常是 *通知* 或 *中断* ,      或者直到经过一定量的实时。 |

#### 实现Runnable

```java
public class MyRunnable implements Runnnable {
	@Override
    public void run() {
    	//线程的任务
    }
}

public class Demo {
	public static void main(String[] args) {
        //实现Runnable
        //1. 创建一个任务对象
		MyRunnable r = new MyRunnable();
        //2. 创建一个线程，并为其分配一个任务
		Thread thread = new Thread(r);
        //3. 执行这个线程
        thread.start();
	}
}

实现Runnable与继承Thread相比有如下优势：
1. 通过创建任务，然后给线程分配的方式来实现的多线程，更适合多个线程同时执行相同任务的情况。
2. 可以避免单继承所带来的局限性
3. 任务与线程本身是分离的，提高了程序的健壮性
4. 后续学习的线程池技术，接受Runnable类型的任务，不接兽Thread类型的线程
```

#### 线程休眠sleep

```java
//线程休眠（暂停执行）1秒
Thread.sleep(1000);
```

#### 线程阻塞

```
所有耗时较长的操作称为线程阻塞，比如说读取文件、获取用户键盘输入等等
```

#### 线程的中断

```java
一个线程是一个独立的执行路径，它是否应该结束，应该由其自身决定。
通过打标记的方式进行线程中断

public class Demo {
	public static void main(String[] args) {
		MyRunnable r = new MyRunnable();
		Thread t = new Thread(r);
		//给线程打上中断标记，在线程(wait()、sleep()、interrupt()）的时候判断
		t.interrupt;
	}
	
    static class MyRunnable implements Runnable {
    	@Override
    	public void run() {
			//执行任务代码块
			//休眠
            try {
            	Thread.sleep();
            }catch （InterruptedEXception e) {
            	//决定是否杀死线程
            	//e.printStackTrace(); 
                //释放所有内存后杀死线程
                return;
            }
		}
    }
}
```

#### 守护线程

```
线程分为：守护线程和用户线程
用户线程：当一个进程不包含任何的存活用户线程时，进行结束
守护线程：守护用户线程，当最后一个用户线程结束时，所有守护线程自动死亡。
```

#### 线程不安全问题

```
线程不安全：两个或以上的线程同时执行同一个任务，去争抢操作一个数据，导致数据异常
```

##### 线程不安全解决方法

1. **同步代码块**

```java
//线程同步：关键字synchronized
//同步代码块
//任何对象都可以作为锁对象(打上锁标记)，注意：必须是同一把锁
//格式:
synchronized(锁对象) {
}

static class MyRunnable implements Runnable {
	private Object o = new Object();//任何对象都可以作为锁对象
    @Override
    public void run() {
        synchronized(o) {
            //执行任务代发块
            //当一个线程使用o对象时，其它线程必须排队等待o			  解锁才可以进入
        }
    }
}
```

2. **同步方法**

```java
用synchronized修饰方法，则各线程在调用这个方法时会排队调用
注意：调用该方法的线程必须是同一对象，这样才能保正是同一把锁
```

3. 显示锁

```java
同步代码块和同步方法是 隐式锁；
显式锁 Lock 子类 ReentrantLock()
    class MyRunnable implements Runnable {
        //显式锁 l
        private Lock l = new ReentrantLock();
        @Override
        public void run() {
            //上锁
            l.lock();
            //执行任务代码块
            //开锁
            l.unlock();
        }
    }
```

##### 公平锁和非公平锁

```java
公平锁：先到先得,排队获取
非公平锁：所有线程都可以去争抢，前面3种都是非公平锁
实现公平锁：
显示锁 ReentrantLock ：fair参数为true，就表示公平锁
Lock l = new ReentrantLock(true);
```

##### 线程死锁

```
多个线程同时被阻塞，它们中的一个或者全部都在等待某个资源被释放。由于线程被无限期地阻塞，因此程序不可能正常终止。

例如，线程 A 持有资源 2，线程 B 持有资源 1，他们同时都想申请对方的资源，所以这两个线程就会互相等待而进入死锁状态。
如何避免线程死锁？
1. 破坏互斥条件
这个条件我们没有办法破坏，因为我们用锁本来就是想让他们互斥的（临界资源需要互斥访问）。
2. 破坏请求与保持条件
一次性申请所有的资源。
3. 破坏不剥夺条件
占用部分资源的线程进一步申请其他资源时，如果申请不到，可以主动释放它占有的资源。
4. 破坏循环等待条件
靠按序申请资源来预防。按某一顺序申请资源，释放资源则反序释放。破坏循环等待条件。
```

#### 线程的六种状态

```
线程状态。 线程可以处于以下状态之一： 
	NEW 
		尚未启动的线程处于此状态。 
	RUNNABLE 
		在Java虚拟机中执行的线程处于此状态。 
	BLOCKED 
		被阻塞等待监视器锁定的线程处于此状态。 
	WAITING 
		无限期等待另一个线程执行特定操作的线程处于此状态。 
	TIMED_WAITING 
		正在等待另一个线程执行最多指定等待时间的操作的线程处于此状态。 
	TERMINATED 
		已退出的线程处于此状态。 

线程在给定时间点只能处于一种状态。 这些状态是虚拟机状态，不反映任何操作系统线程状态。
```

#### Callable(带返回值的线程)

##### Runnable与Callable

```java
接口定义
//Callable接口

public interface Callable<V> {
	V call() throws Exception;
}

//Runnable接口
public interface Runnable {
	public abstract void run();
}
```

##### Callable使用步骤

```java
1. 编写类实现Callable接口，实现call方法
	class MyCallable implements Callable<T> {
		@Override
        public <T> call() throws Exception {
        	return T;
        }
	}
2. 创建FutureTask对象，并传入第一步编写的Callable类对象
	FutureTask<Integer> future = new FutureTask<>(callable);
3. 通过Thread,启动线程
	new Thread(future).start();
```

##### Runnable 与 Callable的相同点

- 都是接口
- 都可以编写多线程程序
- 都采用Thread.start()启动线程

##### Runnable 与 Callable的不同点

- Runnable没有返回值；Callable可以返回执行结果
- Callable接口的call()允许抛出异常；Runnable的run()不能抛出

##### Callable获取返回值

Callalble接口支持返回执行结果，需要调用FutureTask.get()得到，此方法会阻塞主进程的继续往下执行，如果不调用不会阻塞。

#### 线程池

##### 线程池 Executors

```
如果并发的线程数量很多，并且每个线程都是执行一个时间很短的任务就结束了，这样频繁创建线程
就会大大降低 系统的效率，因为频繁创建线程和销毁线程需要时间. 线程池就是一个容纳多个线程的容器，池中的线程可以反复使用，省去了频繁创建线程对象的操作，节省了大量的时间和资源。
```

###### 线程池的好处

- 降低资源消耗
- 提高响应速度
- 提高线程的可管理性

##### Java种的四种线程池 ExecutorService

###### 1. 缓存线程池

```java
/**
* 缓存线程池.
* (长度无限制)
* 执行流程:
* 1. 判断线程池是否存在空闲线程
* 2. 存在则使用
* 3. 不存在,则创建线程 并放入线程池, 然后使用
*/
ExecutorService service = Executors.newCachedThreadPool();
//向线程池中 加入 新的任务
service.execute(new Runnable() {
	@Override
	public void run() {
		System.out.println("线程的名称:"+Thread.currentThread().getName());
	}
});
service.execute(new Runnable() {
	@Override
	public void run() {
		System.out.println("线程的名称:"+Thread.currentThread().getName());
	}
});
service.execute(new Runnable() {
	@Override
	public void run() {
		System.out.println("线程的名称:"+Thread.currentThread().getName());
	}
});
```

###### 2. 定长线程池

```java
/**
* 定长线程池.
* (长度是指定的数值)
* 执行流程:
* 1. 判断线程池是否存在空闲线程
* 2. 存在则使用
* 3. 不存在空闲线程,且线程池未满的情况下,则创建线程 并放入线程池, 然后使用
* 4. 不存在空闲线程,且线程池已满的情况下,则等待线程池存在空闲线程
*/
ExecutorService service = Executors.newFixedThreadPool(2);
service.execute(new Runnable() {
	@Override
	public void run() {
		System.out.println("线程的名称:"+Thread.currentThread().getName());
	}
});
service.execute(new Runnable() {
	@Override
	public void run() {
		System.out.println("线程的名称:"+Thread.currentThread().getName());
	}
});
```

###### 3. 单线程线程池

```java
效果与定长线程池 创建时传入数值1 效果一致.
    /**
    * 单线程线程池.
    * 执行流程:
    * 1. 判断线程池 的那个线程 是否空闲
    * 2. 空闲则使用
    * 4. 不空闲,则等待 池中的单个线程空闲后 使用
    */
	ExecutorService service = Executors.newSingleThreadExecutor();
	service.execute(new Runnable() {
		@Override
		public void run() {
			System.out.println("线程的名称:"+Thread.currentThread().getName());
		}
	});
	service.execute(new Runnable() {
		@Override
		public void run() {
			System.out.println("线程的名称:"+Thread.currentThread().getName());
		}
	});
```

###### 4. 周期性任务定长线程池

```java
public static void main(String[] args) {
    /**
    * 周期任务 定长线程池.
    * 执行流程:
    * 1. 判断线程池是否存在空闲线程
    * 2. 存在则使用
    * 3. 不存在空闲线程,且线程池未满的情况下,则创建线程 并放入线程池, 然后使用
    * 4. 不存在空闲线程,且线程池已满的情况下,则等待线程池存在空闲线程
    *
    * 周期性任务执行时:
    * 定时执行, 当某个时机触发时, 自动执行某任务 .
    */
    ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
    /**
    * 定时执行
    * 参数1. runnable类型的任务
    * 参数2. 时长数字
    * 参数3. 时长数字的单位
    */
    /*service.schedule(new Runnable() {
    	@Override
    	public void run() {
    		System.out.println("定时执行");
    	}
    },5,TimeUnit.SECONDS);
    */
    /**
    * 周期执行
    * 参数1. runnable类型的任务
    * 参数2. 时长数字(延迟执行的时长)
    * 参数3. 周期时长(每次执行的间隔时间)
    * 参数4. 时长数字的单位
    */
    service.scheduleAtFixedRate(new Runnable() {
    	@Override
    	public void run() {
   			System.out.println("周期执行");
    	}
    },5,2,TimeUnit.SECONDS);
}
```

#### Lambda表达式

```
Lambda表达式: 函数式编程思想
//格式
Thread t = new Thread((参数) -> {
    //执行任务代码块
});
注意使用Lambda表达式的接口必须只有一个方法
```