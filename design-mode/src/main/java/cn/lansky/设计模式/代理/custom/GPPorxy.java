//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cn.lansky.设计模式.代理.custom;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Locale;
import javax.tools.DiagnosticListener;
import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;

public class GPPorxy {
    private static String ln = "\r\n";

    public GPPorxy() {
    }

    public static Object newProxyInstance(GPClassLoader classLoader, Class<?>[] interfaces, GPInvocationHandler h) {
        try {
            String proxySrc = generateSrc(interfaces[0]);
            String filePath = GPPorxy.class.getResource("").getPath();
            File f = new File(filePath + "$Proxy0.java");
            FileWriter fw = new FileWriter(f);
            fw.write(proxySrc);
            fw.flush();
            fw.close();
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager((DiagnosticListener)null, (Locale)null, (Charset)null);
            Iterable iterable = manager.getJavaFileObjects(f);
            CompilationTask task = compiler.getTask((Writer)null, manager, (DiagnosticListener)null, (Iterable)null, (Iterable)null, iterable);
            task.call();
            manager.close();
            Class proxyClass = classLoader.findClass("$Proxy0");
            Constructor c = proxyClass.getConstructor(GPInvocationHandler.class);
            f.delete();
            return c.newInstance(h);
        } catch (Exception var13) {
            var13.printStackTrace();
            return null;
        }
    }

    private static String generateSrc(Class<?> interfaces) {
        StringBuffer src = new StringBuffer();
        src.append("package com.gupaoedu.vip.custom;" + ln);
        src.append("import java.lang.reflect.Method;" + ln);
        src.append("public class $Proxy0 implements " + interfaces.getName() + "{" + ln);
        src.append("GPInvocationHandler h;" + ln);
        src.append("public $Proxy0(GPInvocationHandler h) {" + ln);
        src.append("this.h = h;" + ln);
        src.append("}" + ln);
        Method[] var5;
        int var4 = (var5 = interfaces.getMethods()).length;

        for(int var3 = 0; var3 < var4; ++var3) {
            Method m = var5[var3];
            src.append("public " + m.getReturnType().getName() + " " + m.getName() + "(){" + ln);
            src.append("try{" + ln);
            src.append("Method m = " + interfaces.getName() + ".class.getMethod(\"" + m.getName() + "\",new Class[]{});" + ln);
            src.append("this.h.invoke(this,m,null);" + ln);
            src.append("}catch(Throwable e){e.printStackTrace();}" + ln);
            src.append("}" + ln);
        }

        src.append("}");
        return src.toString();
    }
}
