# KotlinCorountines

Coroutines are not a thread but they are like as thread. 
Coroutines are jobs it has to be done and the thread is to get the job done.
Many coroutines can performs in single Thread.
We should not call Thread.sleep() inside the corountines.

# Coroutine Scopes:
It it the way to organize coroutines into the group. There are 3 types of scopes i)IO ii) Main iii) Default

The WithContext is will switch the context of corountine whatever we mention in the builder.
launch is the new coroutine launch withcontext is switch the context.

If we make function as suspend then it has to be wait until all the progress has to complete.
Coroutines are light-weight efficient Thread.
Suspend functions are not blocking thread its making some delay progress.
RunBlocking functions is really blocking the thread.

You can only call suspend functions from other suspend functions or by using a coroutine builder like launch to start a new coroutine.

In kotlin all the Coroutines must run in a dispatcher even they are running on the main Thread.

You can execute a coroutine using different CoroutineDispatchers. These Dispatchers are
i) Dispatchers.Main :
   Main Thread on Android, interact with UI and perform lightweight work
   Ex: Calling suspend functions , Call UI functions and Updating LiveData.
   
ii) Dispatchers.IO :
     It is optimized for disk and network IO off the main Thread
     Ex: Database, Reading/Writing Files and Network
     
iii) Dispatchers.Default:
     It is optimized for CPU intensive work off Main Thread.
     Ex: Sorting a list, Parsing JSON and DiffUtils
     
What is the difference between launch and Async in CoroutineBuilder?
Launch returns a job and does not carry any resulting value but async returns deferred

# Coroutine Dispatcher:
i) UIDispatcher: To dispatch execution onto the main UIThread.
ii) BgDispatcher: To dispatch execution in the background thread.
      

![Screenshot_20191008-184914](https://user-images.githubusercontent.com/39657409/66402686-e2f43480-ea02-11e9-8689-1ab087deb7d7.png)

![Screenshot_20191008-184926](https://user-images.githubusercontent.com/39657409/66402703-e8517f00-ea02-11e9-8f8e-5804a6946bc6.png)
![Screenshot_20191008-184934](https://user-images.githubusercontent.com/39657409/66402722-ee476000-ea02-11e9-86a8-db2549957940.png)
![Screenshot_20191008-184942](https://user-images.githubusercontent.com/39657409/66402737-f99a8b80-ea02-11e9-8c0e-70d0a18b2382.png)


