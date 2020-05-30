package com.java8;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Demo9_javascriptFromJava {

	/*public static void main(String[] args) throws ScriptException {
		ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
		scriptEngine.eval("print('Hi')");
	}*/
	
	public static void main(String[] args) throws FileNotFoundException, ScriptException, NoSuchMethodException {
		ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
		scriptEngine.eval(new FileReader("src/all/js/myscript.js"));
		
		Invocable invocable =  (Invocable)scriptEngine;
		System.out.println(invocable.invokeFunction("display", "ABCDEF"));
	}
	
	
}
