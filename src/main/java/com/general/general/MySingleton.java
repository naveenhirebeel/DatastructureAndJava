package com.general.general;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

public class MySingleton implements Serializable{

	private MySingleton() {
		if (SingletonHelper.INSTANCE != null) {
			throw new RuntimeException("Already Created! LOL");
		}
	}

	private static class SingletonHelper {
		private static final MySingleton INSTANCE = new MySingleton();
	}

	public static MySingleton getInstance() {
		return SingletonHelper.INSTANCE;
	}
	
	protected Object readResolve() {
		System.out.println("readResolve Called!");
		return getInstance();
	}

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException, ClassNotFoundException {
		
		//Case 1
		MySingleton one = MySingleton.getInstance();
		System.out.println(MySingleton.getInstance() == MySingleton.getInstance());
		
		//Case 2
//		MySingleton two = null;
//		Constructor[] cs = MySingleton.class.getDeclaredConstructors();
//		cs[1].setAccessible(true);
//		two = (MySingleton) cs[1].newInstance();
		
		//Case 3 - Serialization & Deserialization
		MySingleton instanceOne = MySingleton.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
                "filename.ser"));
        out.writeObject(instanceOne);
        out.close();
        
        //deserailize from file to object
        ObjectInput in = new ObjectInputStream(new FileInputStream(
                "filename.ser"));
        MySingleton instanceTwo = (MySingleton) in.readObject();
        in.close();
        
        System.out.println("instanceOne hashCode="+instanceOne.hashCode());
        System.out.println("instanceTwo hashCode="+instanceTwo.hashCode());
	}

}
