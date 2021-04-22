package com.agilysys.Tests;

public class GenericMethods<T> {

	T obj;
	public void setData(T set)
	{
		this.obj=set;
	}
	public T getData()
	{
		return this.obj;
	}
	
	public static void main(String[] args) {
		
		GenericMethods<Integer> obj1=new GenericMethods<Integer>();
		obj1.setData(20);
		System.out.println(obj1.getData());
		
	}

}
