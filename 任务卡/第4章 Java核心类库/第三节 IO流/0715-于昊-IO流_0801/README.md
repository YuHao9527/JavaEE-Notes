### IO流

#### java.io.File

```java
文件和目录路径名的抽象表示。 
1. 常用字段
	pathSeparator ： 文件和目录路径名的抽象表示。 windows(\)
	separator: 文件和目录路径名的抽象表示。 windows(;)
2. 构造方法
	File(File parent, String child) 从父抽象路径和子路径名字符串创建新的File实例
	File(String pathname) 通过给定的路径名字符串转换为抽象路径名来创建新的File实例
	File(String parent, String child) 文件和目录路径名的抽象表示。
		File() file = new File("C:\\a.txt");
		File() file = new File("C:\\", "a.txt");
3. 常用方法
boolean	createNewFile() 文件和目录路径名的抽象表示。
boolean	delete() 文件和目录路径名的抽象表示。
boolean	exists() 测试此抽象路径名表示的文件或目录是否存在。
String	getAbsolutePath() 测试此抽象路径名表示的文件或目录是否存在。
String	getCanonicalPath() 测试此抽象路径名表示的文件或目录是否存在。
String getName() 返回此抽象路径名表示的文件或目录的名称。
String getParent() 返回此抽象路径名父项的路径名字符串，如果此路径名未指定父目录，则返回 null 。
long length() 返回此抽象路径名表示的文件的长度。(字节数)
String[] list() 返回一个字符串数组，用于命名此抽象路径名表示的目录中的文件和目录。
String[] list(FilenameFilter filter) 返回一个字符串数组，用于命名由此抽象路径名表示的目录中的文件和目录，以满足指定的过滤器。
String[] listFiles() 返回一个抽象路径名数组，表示此抽象路径名表示的目录中的文件。
String[] listFiles(FileFileter filter) 返回一个抽象路径名数组，表示此抽象路径名表示的目录中满足指定过滤器的文件和目录。
String mkdir() 创建此抽象路径名指定的目录。
String mkdirs() 创建此抽象路径名指定的目录，包括任何必需但不存在的父目录。
```

```java
//文件遍历案例
package Demo;

import java.io.File;

/**
 * @ClassName Demo2
 * @Description 文件遍历
 * @Author 0715-YuHao
 * @Date 2020/8/1 13:43
 */
public class Demo1 {

    public static void main(String[] args) {
        File e = new File("D:\\");
        File[] files = e.listFiles();
        listFiles(files);
    }

    public static void listFiles(File[] files) {
        if (files != null && files.length > 0) {
            for (File file : files) {
                if (file.isFile()) {
                    //文件
                    if (file.getName().endsWith(".txt")) {
                        //找到一个txt文件
                        System.out.println("找到一个txt文件：" + file.getAbsolutePath());
                    }
                }else {
                    //文件夹
                    File[] file2 = file.listFiles();
                    listFiles(file2);
                }
            }
        }
    }
}
```

```java
package Demo;

import java.io.File;
import java.io.FileFilter;

/**
 * @ClassName Demo2
 * @Description 文件过滤器
 * @Author 0715-YuHao
 * @Date 2020/8/1 13:53
 */
public class Demo2 {

    public static void main(String[] args) {
        File file = new File("D:\\");
        listFiles(file);
    }

    public static void listFiles(File file) {
        //创建一个过滤器，并描述规则
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.getName().endsWith(".txt") || pathname.isDirectory()){
                    return true;
                }
                return false;
            }
        });
        //通过文件获取子文件夹
        if (files!=null && files.length>0) {
            for (File f: files) {
                if (f.isDirectory()) {
                    listFiles(f);
                }else {
                    System.out.println("发现一个txt文件：" + f.getAbsolutePath());
                }
            }
        }
    }
}
```

#### 相对与绝对路径

```
绝对路径：从盘符开始，是一个完整的路径。例如：C://a.txt
相对路径：在Java代码中是相对于项目目录路径，这是一个不完整的便捷路径。在Java开发中很常用。例如：a.txt
```

#### 流概述

```
IO流概述：
	可以将这种数据传输操作，看作是一种数据的流动，按照流动的方向分为输入Input和输出Output
	Java中的IO操作主要指的是 java.io 包下的一些常用类的使用，通过这些常用对数据进行读取(输入Input) 和 写出 (输出Output)

IO流的分类：
	按照流的方向来分，可以分为：输入流和输出流
	按照流动的数据类型来访，可以分为：字节流和字符流
	
	字节流：
		- 输入流: InputStream
		- 输出流：OutputStream
	字符流：
		- 输入流：Reader
		- 输出流：Writer
一切皆字节：
	计算机中的任何数据（文本、图片、视频、音乐等等）都是以二进制的形式存储的。
	在数据传输时，也都是以二进制的形式存储的。
```

#### java.io.OutputStream

```java
此抽象类是表示输出字节流的所有类的超类。 输出流接受输出字节并将它们发送到某个接收器。 
需要定义OutputStream的子类的应用程序必须始终至少提供一个写入一个输出字节的方法。
```

##### java.io.FileOutputStrem

```
文件输出流是用于将数据写入File或FileDescriptor的输出流。 文件是否可用或是否可以创建取决于底层平台。 特别是某些平台允许一次仅打开一个文件以供写入FileOutputStream （或其他文件写入对象）。 在这种情况下，如果涉及的文件已经打开，则此类中的构造函数将失败。 
FileOutputStream用于写入诸如图像数据的原始字节流。
```

###### 构造方法

| 构造器                                        | 描述                                                         |
| --------------------------------------------- | ------------------------------------------------------------ |
| `FileOutputStream(File file)`                 | 创建文件输出流以写入由指定的 `File`对象表示的文件。          |
| `FileOutputStream(File file, boolean append)` | 创建文件输出流以写入由指定的 `File`对象表示的文件。append为true表明追加不覆盖。 |
| `File(String name)`                           | 创建文件输出流以写入由指定的 `File`对象表示的文件。          |
| `File(String name, boolean append)`           | 创建文件输出流以写入由指定的 `File`对象表示的文件。append为true表明追加不覆盖。 |

###### 方法

| 变量和类型 | 方法                                | 描述                                                         |
| ---------- | ----------------------------------- | :----------------------------------------------------------- |
| void       | `close()`                           | append为true表明追加不覆盖。                                 |
| void       | `flush()`                           | 刷新此输出流并强制写出任何缓冲的输出字节。                   |
| void       | `write(byte[] b)`                   | 将指定字节数组中的 `b.length`字节写入此文件输出流。          |
| void       | `write(byte[] b, int off, int len)` | 将从偏移量 `off`开始的指定字节数组中的 `len`字节写入此文件输出流。 |
| void       | `write(int b)`                      | 将指定的字节写入此文件输出流。                               |

#### java.io.InputStream

```
此抽象类是表示输入字节流的所有类的超类。 
需要定义子类InputStream应用程序必须始终提供返回输入的下一个字节的方法。
```

##### java.io.FileInputStream

```
A FileInputStream从文件系统中的文件获取输入字节。 可用的文件取决于主机环境。 
FileInputStream用于读取诸如图像数据的原始字节流。
```

###### 构造方法

| 构造器                         | 描述                                                         |
| ------------------------------ | ------------------------------------------------------------ |
| `FileInputStream(File file)`   | 通过打开与实际文件的连接来创建 `FileInputStream` ，该文件由文件系统中的 `File`对象 `file`命名。 |
| `FileInputStream(String name)` | 通过打开与实际文件的连接来创建 `FileInputStream` ，该文件由文件系统中的路径名 `name`命名。 |

###### 方法

| 变量和类型 | 方法                               | 描述                                                         |
| ---------- | ---------------------------------- | ------------------------------------------------------------ |
| void       | `close()`                          | 关闭此文件输入流并释放与该流关联的所有系统资源。             |
| int        | `read()`                           | 从此输入流中读取一个字节的数据。                             |
| int        | `read(byte[] b)`                   | 从此输入流 `b.length`最多 `b.length`字节的数据读 `b.length`字节数组。 |
| int        | `read(byte[] b, int off, int len)` | 从此输入流 `len`最多 `len`字节的数据读入一个字节数组。       |

#### 字符流

##### java.io.Writer

```
用于写入字符流的抽象类。 子类必须实现的唯一方法是write(char []，int，int),flush() 和close() 。
```

###### 构造方法

| 构造器                | 描述                                                       |
| --------------------- | ---------------------------------------------------------- |
| `Writer()`            | 创建一个新的字符流编写器，其关键部分将在编写器本身上同步。 |
| `Writer(Object lock)` | 创建一个新的字符流编写器，其关键部分将在给定对象上同步。   |

| 变量和类型 | 方法                                           | 描述                                   |
| ---------- | ---------------------------------------------- | -------------------------------------- |
| Writer     | `append(char c)`                               | 将指定的字符追加到此writer。           |
| Writer     | `append(CharSequence csq)`                     | 将指定的字符序列追加到此writer。       |
| Writer     | `append(CharSequence csq, int start, int end)` | 将指定字符序列的子序列追加到此writer。 |
| void       | `close()`                                      | 关闭流，先刷新它。                     |
| void       | `flush()`                                      | 刷新流                                 |
| void       | `write(char[] cbuf)`                           | 写一个字符数组。                       |
| void       | `write(char[] cbuf,int off, int len)`          | 写一个字符数组的一部分。               |
| void       | `write(int c)`                                 | 写一个字符。                           |
| void       | `write(String str)`                            | 写一个字符串。                         |
| void       | `write(String str,int off, int len)`           | 写一个字符串的一部分。                 |

##### java.io.Reader

```
用于读取字符流的抽象类。 子类必须实现的唯一方法是read（char []，int，int）和close（）。
```

###### 构造方法

| 构造器                | 描述                                                       |
| --------------------- | ---------------------------------------------------------- |
| `Reader()`            | 创建一个新的字符流阅读器，其关键部分将在编写器本身上同步。 |
| `Reader(Object lock)` | 创建一个新的字符流阅读器，其关键部分将在给定对象上同步。   |

###### 方法

| 变量和类型 | 方法                                  | 描述                                 |
| ---------- | ------------------------------------- | ------------------------------------ |
| void       | `close()`                             | 关闭流并释放与其关联的所有系统资源。 |
| void       | `read()`                              | 读一个字符。                         |
| void       | `read(char[] cbuf)`                   | 将字符读入数组。                     |
| void       | `read(char[] cbuf, int off, int len)` | 将字符读入数组的一部分。             |
| void       | `read(charBuffer target)`             | 尝试将字符读入指定的字符缓冲区。     |

#### Print和BufferReader

```java
//字符输出(打印流)
PrintStream ps = new PrintStream("D:\\a.txt");
ps.println("锄禾日当午1");
ps.println("锄禾日当午2");
ps.println("锄禾日当午3");
ps.println("锄禾日当午4");
ps.close();
PrintWriter pw = new PrintWriter("D:\\b.txt");
pw.println("汗滴禾下土1");
pw.println("汗滴禾下土2");
pw.println("汗滴禾下土3");
pw.println("汗滴禾下土4");
pw.close();
FileOutputStream fos = new FileOutputStream("D:\\c.txt");
PrintWriter pw2 = new PrintWriter(fos);
pw2.println("你好1");
pw2.println("你好2");
pw2.println("你好3");
pw2.println("你好4");
pw2.close()
```

```java
//缓存读取流，将字符输入流转换为带有缓存 可以一次读取一行的缓存字符读取流
FileReader fw = new FileReader("D:\\a.txt");
BufferedReader br = new BufferedReader(fw);
String text = br.readLine();
System.out.println(text);
```

#### Properties

```java
Properties类表示一组持久的属性。Properties可以保存到流中或从流中加载。属性列表中的每个键及其对应的值都是一个字符串。 
属性列表可以包含另一个属性列表作为其“默认值”; 如果在原始属性列表中找不到属性键，则搜索第二个属性列表。 
```

###### 构造方法

| 构造器         | 描述                             |
| -------------- | -------------------------------- |
| `Properties()` | 创建一个没有默认值的空属性列表。 |

###### 方法

| 变量和类型 | 方法                                           | 描述                                                         |
| ---------- | ---------------------------------------------- | ------------------------------------------------------------ |
| void       | `store(OutputStream out, String comments)`     | 将此 `Properties`表中的此属性列表（键和元素对）以适合使用 `load(InputStream)`方法加载到 `Properties`表的格式写入输出流。 |
| void       | `store(Writer writer, String comments)`        | 将此 `Properties`表中的此属性列表（键和元素对）以适合使用 [`load(Reader)`](#load(java.io.Reader))方法的格式写入输出字符流。 |
| void       | `load(InputStream inStream)`                   | 从输入字节流中读取属性列表（键和元素对）。                   |
| void       | `load(Reader reader)`                          | 以简单的面向行的格式从输入字符流中读取属性列表（键和元素对）。 |
| void       | `list(PrintStream out)`                        | 将此属性列表打印到指定的输出流。                             |
| void       | `list(PrintWriter out)`                        | 从输入字节流中读取属性列表（键和元素对）。                   |
| String     | `getProperty(String key)`                      | 在此属性列表中搜索具有指定键的属性。                         |
| String     | `getProperty(String key, String defaultValue)` | 在此属性列表中搜索具有指定键的属性。                         |

#### try-with-resources

```java
//1.7
try {
     FileReader fr = new FileReader("c：//book.txt");
     int c = fr.read();
     System.out.println((char)c);
     fr.close();
} catch (IOException e) {
     e.printStackTrace();
}
//jdk9 必须有实现接口Closeable
FileReader fr = new FileReader("c：//book.txt");
PrintWriter pw = new PrintWriter("c：//book.txt");
try(fr;pw){
    int c = fr.read();
    System.out.println((char)c);
}catch (IOException e) {
    e.printStackTrace();
}
```
