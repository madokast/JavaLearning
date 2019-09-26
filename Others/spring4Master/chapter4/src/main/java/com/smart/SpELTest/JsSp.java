package com.smart.SpELTest;

import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.springframework.stereotype.Component;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.*;
import java.awt.*;

@Component
public class JsSp {
    public void test()throws Exception{

        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("JavaScript");
        String jsScript = "function sum(a,b){return a+b;}";

        scriptEngine.eval(jsScript);
        Invocable invocable = (Invocable)scriptEngine;

        Object result = invocable.invokeFunction("sum",10,20);

        System.out.println("result = " + result);

    }

    public static void main(String[] args) {
        try {
            final JsSp jsSp = new JsSp();
            jsSp.test();
        } catch (Exception e){e.printStackTrace();}
    }
}
