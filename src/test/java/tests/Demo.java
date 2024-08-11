package tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class Demo{
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//array1 = [1,2,3,4,5]
		//	output = [14,13,12,11,10]
		int[] array1 = {1,2,3,4,5};
		int [] outputArr = new int[array1.length];
		
		int counter = 0;
		
		for(int i=0; i <array1.length;i++) {
			int sum = 0;
			for(int j=0; j<array1.length; j++) {
				if(i!=j) {
					sum = sum + array1[j];	
					outputArr[i] = sum;
				}
				
				
			}
			
		}
		
		for(int num : outputArr) {
			System.out.print(num + " ");
		}
		

	}



}
