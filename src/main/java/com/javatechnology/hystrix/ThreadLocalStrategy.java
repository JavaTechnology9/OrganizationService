package com.javatechnology.hystrix;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.javatechnology.utils.UserContextHolder;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestVariable;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestVariableLifecycle;
import com.netflix.hystrix.strategy.properties.HystrixProperty;

public class ThreadLocalStrategy extends HystrixConcurrencyStrategy{
	
	private HystrixConcurrencyStrategy existingConcurrencyStrategy;
	
	public ThreadLocalStrategy(HystrixConcurrencyStrategy existingConcurrencyStrategy) {
		this.existingConcurrencyStrategy=existingConcurrencyStrategy;
		// TODO Auto-generated constructor stub
	}
	@Override
	public BlockingQueue<Runnable> getBlockingQueue(int maxQueueSize) {
		// TODO Auto-generated method stub
		return existingConcurrencyStrategy!=null?
				existingConcurrencyStrategy.getBlockingQueue(maxQueueSize):super.getBlockingQueue(maxQueueSize);
	}
	@Override
	public <T> HystrixRequestVariable<T> getRequestVariable(HystrixRequestVariableLifecycle<T> rv) {
		// TODO Auto-generated method stub
		return existingConcurrencyStrategy!=null?
				existingConcurrencyStrategy.getRequestVariable(rv):super.getRequestVariable(rv);
	}
	@Override
	public ThreadPoolExecutor getThreadPool(HystrixThreadPoolKey threadPoolKey, HystrixProperty<Integer> corePoolSize,
			HystrixProperty<Integer> maximumPoolSize, HystrixProperty<Integer> keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		// TODO Auto-generated method stub
		return existingConcurrencyStrategy!=null?
				existingConcurrencyStrategy.getThreadPool(threadPoolKey, corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue):super.getThreadPool(threadPoolKey, corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}
	@Override
	public <T> Callable<T> wrapCallable(Callable<T> callable) {
		// TODO Auto-generated method stub
		return existingConcurrencyStrategy!=null?
				existingConcurrencyStrategy.wrapCallable(new DelegatingUserContextCallable<T>(callable, UserContextHolder.getContext()))
						:super.wrapCallable(new DelegatingUserContextCallable<T>(callable, UserContextHolder.getContext()));
	}

}
