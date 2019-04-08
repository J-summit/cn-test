//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cn.lansky.设计模式.代理.custom;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class GPClassLoader extends ClassLoader {
    private File baseDir;

    public GPClassLoader() {
        String basePath = GPClassLoader.class.getResource("").getPath();
        this.baseDir = new File(basePath);
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = GPClassLoader.class.getPackage().getName() + "." + name;
        if (this.baseDir != null) {
            File classFile = new File(this.baseDir, name.replaceAll("\\.", "/") + ".class");
            if (classFile.exists()) {
                FileInputStream in = null;
                ByteArrayOutputStream out = null;

                try {
                    in = new FileInputStream(classFile);
                    out = new ByteArrayOutputStream();
                    byte[] buff = new byte[1024];

                    int len;
                    while((len = in.read(buff)) != -1) {
                        out.write(buff, 0, len);
                    }

                    Class var9 = this.defineClass(className, out.toByteArray(), 0, out.size());
                    return var9;
                } catch (Exception var21) {
                    var21.printStackTrace();
                    return null;
                } finally {
                    if (in != null) {
                        try {
                            in.close();
                        } catch (IOException var20) {
                            var20.printStackTrace();
                        }
                    }

                    if (out != null) {
                        try {
                            out.close();
                        } catch (IOException var19) {
                            var19.printStackTrace();
                        }
                    }

                    classFile.delete();
                }
            }
        }

        return null;
    }
}
