package com.hand.exam;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Hello world!
 *
 */
public class App {

	int squares = 81;

	static int[] a;

	static {
		// Exception in thread "main" java.lang.ExceptionInInitializerError
		// a[0] = 1;
	}

	public static void main(String[] args) {
		System.out.println("Hello World!");

		System.out.println("第二題：D");
		String str2 = "420";
		str2 += 42;
		System.out.println(str2);

		System.out.println("第三題：F");

		System.out.println("第四題：D");
		int x = 5;
		boolean b1 = true;
		boolean b2 = false;
		if ((x == 4) && !b2)
			System.out.println("1");
		System.out.println("2");
		if ((b2 = true) && b1) {
			System.out.println("3" + (b2 = true));
		}

		System.out.println("第五題：C");
		String o = "";
		z: for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				if (i == 1) {
					break;
				}
				if (i == 2 && j == 1) {
					break z;
				}
				o = o + i + j;
			}
		}
		System.out.println(o);

		System.out.println("第六題：B");
		x = 0;
		int y = 10;
		do {
			y--;// 用完再减
			++x;// 加完再用
		} while (x < 5);
		System.out.println(x + " " + y);

		System.out.println("第七题：");
		int i = 0, j = 10;
		do {
			if (i++ > --j) {
				continue;
			}
		} while (i < 5);
		System.out.println(i + " " + j);

		System.out.println("第八题：E");
		long tail = 2000l;
		long distance = 1999l;
		long story = 1000l;
		if ((tail > distance) ^ (story * 2 == tail)) {// 逻辑与
			System.out.println("1");
		}
		if ((distance + 1 != tail) ^ (story * 2 == distance)) {
			System.out.println("2");
		}
		System.out.println((tail > distance) ^ (story * 2 == tail));
		System.out.println((distance + 1 != tail) ^ (story * 2 == distance));

		System.out.println("第十一题：B");
		try {
			// return;
		} finally {
			System.out.println("finally");
		}

		System.out.println("第十二题：E");
		EnclosingOne eo = new EnclosingOne();
		EnclosingOne.InsideOne insideOne = eo.new InsideOne();

		// 重写override:要求方法名，参数，返回值一致

		System.out.println("第十六题：D");
		// 子类继承父类，若父类构造函数有参数，
		// 则子类构造函数必须引用super(参数)，即先调用父类的构造方法

		System.out.println("第十七题：D");
		// 在创建子类的对象时，jvm会首先执行搜索父类的构造方法，
		// 然后再执行子类的构造方法，如果是多级继承，会先执行最顶级父类的构造方法，
		// 然后依次执行各级个子类的构造方法。

		System.out.println("第十八题：B");
		new App().go();

		System.out.println("第二十四题：B");
		// 向上转型，程序会自动完成
		// 父类 父类对象 = 子类实例
		// 向下转型，即强制类型转换
		// 子类 子类对象 = (子类)父类实例

		System.out.println("第二十五题：ABD");
		// 接口中 的变量需要为 static final类型的，
		// 平时你可以不写修饰符但是默认的就是static final
		// 这样的话想一下就可以知道了不可以声明为私有private的了
		// 另外，方法是public abstract来修饰的，即使你不加
		// 其实动手写一些代码就就知道，也会牢牢记住了。

		System.out.println("第二十八题：D");
		Dogs myDog = Dogs.collie;
		switch (myDog) {
		case collie:
			System.out.println("collie");
		case harrier:
			System.out.println("harrier");
		}

		System.out.println("第三十一题：");
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(8);
		list.add(5);
		list.add(2);
		System.out.println(list);
		Collections.sort(list);//排序
		System.out.println(list);
		list.add(0);
		Collections.reverse(list);//反序
		System.out.println(list);
	}

	double method(byte x, double y) {// 本题double精度最高
		return (short) x / y;
	}

	void go() {// 本题考查赋值传递以及引用传递
		incr(++squares);// 这里用到的是赋值传递
		System.out.println(squares);// squares = squares + 1;
	}

	void incr(int num) {
		num += 10;
	}

	public enum Dogs {
		collie, harrier
	};

}

class EnclosingOne {
	public EnclosingOne() {
	}

	public class InsideOne {
	}
}

class Person {
	String name = "no name";

	public Person(String name) {
		// this.name = name;
	}
}

class Employee extends Person {

	public Employee(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	String id = "0000";

	// error
	// public Employee(String id) {
	// super(name);
	// // TODO Auto-generated constructor stub
	// this.id = id;
	// }
}

class Atom {
	public Atom() {
		// TODO Auto-generated constructor stub
		System.out.println("atom");
	}
}

class Rock extends Atom {
	public Rock() {
		System.out.println("rock");
	}
}

interface test {
	final static public int test = 0;// private
}