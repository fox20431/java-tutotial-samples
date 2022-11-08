import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 学习I/O流，需要了解以下内容。
 * 五个类：File、OutputStream、InputStream、Reader、Writer；
 * 一个接口：Serializable。
 * <p>
 * File用于操作文件
 * <p>
 * OutputStream与InputStream作为两个抽象类，其子类完成I/O的字节流操作
 * OutputStream主要的子类：FileOutputStream、BufferedOutputStream
 * InputStream主要的子类：FileOutputStream、BufferedOutputStream
 * <p>
 * Writer与Reader同样是两个抽象类，其子类完成I/O的文本流操作
 * Writer主要的子类：FileWriter、BufferedWriter、InputStreamWriter
 * Reader主要的子类：FileReader、BufferedReader、InputStreamReader
 */
class Demos {
    /**
     * 文件输出流
     */
    @Test
    void fileOutputStreamDemo() {
        // 如果不指定路径，默认maven项目为默认路径（而非maven模块）
        File file = new File("stream-practise.txt");
        // 打印文件绝对路径
        // System.out.println("当前路径为："+file.getAbsolutePath());
        // 如果文件不存在则创建文件
        try {
            boolean b = file.createNewFile();
            if (b) {
                System.out.println(file.getName() + "文件创建成功");
            } else {
                System.out.println(file.getName() + "文件已经存在");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 预先设定被写入的字符串
        String content = "hello, stream :)";
        // 查找文件
        try {
            // 创建由File对象指定的文件输出流用写入到文件中（从内存输出到文件）
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            // 将字符串转换成字节数组作为参数传给write方法进行写入
            fileOutputStream.write(content.getBytes(StandardCharsets.UTF_8));
            // 关闭流防止内存泄漏
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 完成上述操作之后，去指定文件(<root_dir>/stream-practise.txt)中查看输出内容
        // 以Maven运行，文件以项目为根目录创建
        // 以Junit运行，项目以模块为根目录创建
    }

    /**
     * 文件输入流
     */
    @Test
    void fileInputStreamDemo() {
        File file = new File("stream-practise.txt");
        try {
            boolean b = file.createNewFile();
            if (b) {
                System.out.println(file.getName() + "文件创建成功");
            } else {
                System.out.println(file.getName() + "文件已经存在");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            int i = fileInputStream.read();
            while (i != -1) {
                // 将int类型转化成char类型，让后逐个将字符打印到控制台
                System.out.print((char) i);
                // read()方法会自动读取下一个字节
                i = fileInputStream.read();
            }
            // 关闭流防止内存泄漏
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 操作完成后，会在控制台打印指定目录下的字符串（只限ASCII码）
    }

    /**
     * BufferedOutputStreamDemo依托于其他OutputStream
     * 将OutputStream传入BufferedOutputStream用于改善OutputStream性能
     * 暂不清楚具体BufferedInputStream如何提高性能
     * 这个demo只写了BufferedInputStream的使用方法
     */
    @Test
    void bufferedOutputStreamDemo() {
        File file = new File("stream-practise.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String content = "hello, stream :-)";
        // 查找文件
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            bufferedOutputStream.write(content.getBytes(StandardCharsets.UTF_8));
            fileOutputStream.close();
            bufferedOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 作用和BufferedOutputStream相同
     */
    @Test
    void bufferedInputStreamDemo() {
        File file = new File("stream-practise.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            int i = bufferedInputStream.read();
            while (i != -1) {
                // 将int类型转化成char类型，让后逐个将字符打印到控制台
                System.out.print((char) i);
                // read()方法会自动读取下一个字节
                i = bufferedInputStream.read();
            }
            fileInputStream.close();
            bufferedInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * FileWriter
     */
    @Test
    void fileWriterDemo() {
        File file = new File("stream-practise.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String content = "通过FileWriter写入的文本";
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * FileReader
     */
    @Test
    void fileReaderDemo() {
        File file = new File("stream-practise.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileReader fileReader = new FileReader(file);
            int i = fileReader.read();
            while (i != -1) {
                System.out.print((char) i);
                i = fileReader.read();
            }
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * bufferedWriter
     */
    // TODO
    /**
     * bufferedReader
     */
    // TODO

    /**
     * InputStreamWriter
     */
    // TODO
    /**
     * OutputStreamRreader
     */
    // TODO

}
