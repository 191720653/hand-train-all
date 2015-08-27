package com.hand.Exam1;

import java.awt.List;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=101;i<=200;i++){
        	boolean sign = false;
        	for(int j=2;j<i;j++){
        		if(i%j==0){
        			sign=true;
        			break;
        		}
        	}
        	if(!sign){
        		list.add(i);
        	}
        }
        System.out.println("101-200间总共有"+list.size()+"素数，分别是：");
        for(int i=0;i<list.size();i++){
        	System.out.print(list.get(i)+",");
        }
    }
}
