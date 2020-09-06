package com.loatr.learning;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@SpringBootTest
class LearningApplicationTests {

	volatile int key = 0;
	ReentrantLock l = new ReentrantLock();
	Condition c = l.newCondition();

	public static void main(String[] args) throws InterruptedException {
		LearningApplicationTests test = new LearningApplicationTests();
		test.test();
	}

	@Test
	public void test() throws InterruptedException {
		new Thread(()->runA()).start();
		TimeUnit.SECONDS.sleep(1);
		new Thread(()->runB()).start();
	}

	public void runB() {
		int i = 10;
		while(i > 0){
			System.out.println("B try get lock");
			l.lock();
			System.out.println("B got lock");
			try{
				if(key == 0){
					System.out.println("B is Running");
					i--;
					key = 1;
					c.signal();
				}else{
					System.out.println("B is wait");
					c.awaitUninterruptibly();
					System.out.println("B is wait done");
				}
			}
			finally{
				l.unlock();
				System.out.println("B is unlocked");
			}
		}
	}

	public void runA() {
		int i = 10;
		while(i > 0){
			System.out.println("A try get lock");
			l.lock();
			System.out.println("A got lock");
			try{
				if(key == 1){
					System.out.println("A is Running");
					i--;
					key = 0;
					c.signal();
				}else{
					System.out.println("A is wait");
					c.awaitUninterruptibly();
					System.out.println("A is wait done");
				}
			}
			finally{
				l.unlock();
				System.out.println("A is unlocked");
			}
		}
	}

}
