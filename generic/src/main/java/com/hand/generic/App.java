package com.hand.generic;

import java.awt.List;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		MyGeneric<Integer, String> myGeneric = new MyGeneric<Integer, String>(1, "first");

		System.out.println("the k is " + myGeneric.getK("first"));

		System.out.println("the t is " + myGeneric.getT(1));

	}
}

class MyGeneric<K, T> {
	K k = null;
	T t = null;

	public MyGeneric(K k, T t) {
		this.k = k;
		this.t = t;
	}

	public T getT(K k) {
		if (k == this.k) {
			return t;
		} else
			return null;
	}

	public K getK(T t) {
		if (this.t == t) {
			return k;
		} else {
			return null;
		}
	}
}
