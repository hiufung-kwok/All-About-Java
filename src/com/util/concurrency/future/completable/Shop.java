package com.util.concurrency.future.completable;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {

	
	String name;
	
	
	//------------------------Get && Set -------------------------
	
	public Shop(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice (String product) {
		System.out.println("Check price start");
		double price = calculatePrice(product);
		System.out.println("Check price done");
		return price;
	}
	
	//------------ Future<Double> version of getPrice--------------
	
	//Old way
	public Future<Double> getPriceAsync (String product) {
		System.out.println("Check price start");
		CompletableFuture<Double> futurePrice = new CompletableFuture<> ();
		new Thread (	() -> {
				try {
						double price = calculatePrice(product);
						futurePrice.complete(price);
				}catch (Exception ex) {
					futurePrice.completeExceptionally(ex);
				}
		}).start();
		System.out.println("Check price done");
		return futurePrice;
	}
	
	//LambdaWay
	public Future<Double> getPriceAsyncLambda (String product) {
		return CompletableFuture.supplyAsync(() -> calculatePrice(product));
	}
	
	//-------------------------Private method------------------------
	private double calculatePrice (String product) {
		
		delay();
		return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
		
	}
	
	private static void delay () {

			try {
				Thread.sleep(5000L);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}

	}
	
}
