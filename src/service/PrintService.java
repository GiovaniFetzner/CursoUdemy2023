package service;

import java.util.ArrayList;

public class PrintService<T> {

	private ArrayList<T> array;

	public PrintService() {
		array = new ArrayList();
	}

	public void addValue(T value) {
		array.add(value);
	}
	
	public T first() {
		return array.get(0);
	}
	
	public void print() {
		System.out.println(array.toString());
	}

}