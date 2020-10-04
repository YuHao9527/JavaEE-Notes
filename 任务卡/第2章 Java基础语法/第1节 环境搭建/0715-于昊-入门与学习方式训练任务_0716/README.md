# Java基础语法
## 1. java发展史和其特点特性

Java之父：詹姆斯·高斯林 （James Gosling）

### Java体系与特点

- Java SE: Java Platform, Standard Edition

  标准版：各应用平台的基础，桌面开发和低端商务应用的解决方案。

- Java EE: Java Platform, Enterprise Edition

  企业版：以企业为环境而开发应用程序的解决方案

- Java ME: Java Platform, Micro Edition

  微型版：致力于消费产品 和嵌入式设备的最佳解决方案

#### java的特性

- 一种面向对象的编程语言
- 一种与平台无关(跨平台)的语言。(它提供了在不同平台下运行的解释环境)
- 一种健壮的语言，吸收了C/C++语言的优点。
- 有较高的安全性。(自动回收垃圾，强制类型检查，取消指针)

#### Java 跨平台原理

![Java跨平台原理](https://note.youdao.com/yws/api/personal/file/95C9E1E7E55B474E844E994CFD9E76B3?method=download&shareKey=bae8c9624daac1dc752f03e40210dec3)

Java源代码经过编译器编译成Java字节码文件（class文件），然后运行在JVM（Java虚拟机）中，不同系统有不同的JVM，JVM内部有解释器组件，可以将字节码文件生成对应的计算机系统可以运行的可执行文件。

##### Java 技术两种核心机制

- Java虚拟机(Java virtual Machine) JVM

- 垃圾回收器(Garbage Collection) GC

##### Java 虚拟机(JVM)

![JVM原理](https://note.youdao.com/yws/api/personal/file/5205280E12C44A1FBE44EF89E345BF99?method=download&shareKey=318df0aec02b90370f19a7094430eed7)

JVM是一个可运行Java字节码文件的虚拟计算机系统

- 它有一个解释器组件，可以实现Java字节码和计算机操作系统之间的通信

- 对于不同运行平台，有不同的JVM。

  JVM屏蔽了底层运行平台的差别，实现了“一次编译，随处运行”。

##### 垃圾回收器(GC)

- 不再使用的内存空间应当进行回收-垃圾回收。
- 在 C/C++等语言中，由程序员负责回收无用内存。
- Java 语言消除了程序员回收无用内存空间的责任：
- JVM 提供了一种系统线程跟踪存储空间的分配情况。并在 JVM 的空闲时，检查并释放那些可以被释放的存储空间。
- 垃圾回收器在 Java 程序运行过程中自动启用，程序员无法精确控制和干预。


##### JDK和JRE

###### JDK(Java Development Kits) --> Java开发工具集

- JRE(Java Runtime Environment)Java 运行时环境
  JVM(Java虚拟机)
  Java API (应用程序编程接口)
- Java 编译器(javac.exe)、Java 运行时解释器(java.exe)、Java 文档化化工具(javadoc.exe)及其它工具及资源

###### JRE(Java Runtime Environment)的三项主要功能：

- 加载代码：由类加载器(class loader)完成；
- 校验代码：由字节码校验器(byte code verifier)完成；
- 执行代码：由运行时解释器(runtime interpreter)完成。

## 2.环境搭建(JDK与eclipse 下载安装)

### JDK安装

#### JDK概述

JDK 全称 Java Development ToolKit，是 Java 语言开发工具包。JDK 是整个 JAVA 的核心，包括了 Java 运行环境（Java Runtime Environment），一堆 Java 工具（javac/java/jdb 等）和 Java 基础的类库（即 Java API 包括rt.jar）。
它不提供具体的开发软件，它提供的是无论你用何种开发软件写 Java 程序都必须用到的类库和 Java 语言规范。

#### JDK11下载

目前Java 11 为最新的 LTS（长期支持）版本 ，所以我们的任务编码采用 JDK11。

##### 下载步骤一：

访问官网： [https://www.oracle.com](https://www.oracle.com)

##### 下载步骤二：

注册，并登录。（国内被墙了，无法正常注册，需翻墙）

##### 下载步骤三：

跳转到官网下载页面：

[https://www.oracle.com/java/technologies/javase-jdk11-downloads.html](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)

##### 下载步骤四：

选择对应系统版本的安装包下载

#### JDK11安装

##### 安装步骤一：

双击下载好的安装包

##### 安装步骤二：

按照提示点击下一步完成安装即可

##### 安装步骤三：配置环境变量

我的电脑-->右键属性-->高级系统设置-->环境变量-->系统变量-->新建-->JAVA_HOME-->变量值输入你安装的jdk文件夹例如C:\Program Files\Java\jdk-11.0.6-->确定-->Path-->编辑-->在变量值中添加%JAVA_HOME%\bin-->确定

##### 安装步骤四：

打开运行(start + R)，输入cmd打开命令行程序，输入java -version,若得到

java version "11.0.6" 2020-01-14 LTS
Java(TM) SE Runtime Environment 18.9 (build 11.0.6+8-LTS)
Java HotSpot(TM) 64-Bit Server VM 18.9 (build 11.0.6+8-LTS, mixed mode)

表明安装成功。

![运行](https://note.youdao.com/yws/api/personal/file/7A6623EEF412424095BB7845BEDBAC77?method=download&shareKey=5807b852caf63cf4f5e7d0a0c3cccc3e)

![cmd](https://note.youdao.com/yws/api/personal/file/19E4360240E543CAA941DC35BB746E6C?method=download&shareKey=b1214366e2a61d6aaaeb567cda73d0d6)

### eclipse 安装

#### 简介

Eclipse 是一个开放源代码的、基于 Java 的可扩展开发平台。就其本身而言，它只是一个框架和一组服务，
用于通过插件组件构建开发环境。幸运的是，Eclipse 附带了一个标准的插件集，包括 Java 开发工具（Java
Development Kit，JDK）。

#### 下载步骤

##### 下载步骤一：

打开官网：[https://www.eclipse.org/](https://www.eclipse.org/), 按图标标注位置点击Download

![步骤一](https://note.youdao.com/yws/api/personal/file/2F1E4BECDAB74E0D88EAAAF8E35E5CC1?method=download&shareKey=673650aa84ff533e3f79fcab2950ba7c)

##### 下载步骤二 ：

在新的页面中，点击Download Packages

![步骤二](https://note.youdao.com/yws/api/personal/file/6FB16CCD2AD74727ACA3B6718CDE412A?method=download&shareKey=83b39e4713b266a89cc7e5bfd7fffb9c)

##### 下载步骤三：

如图所示, 根据操作系统不同,选择不同版本进行下载

![步骤三](https://note.youdao.com/yws/api/personal/file/438837DBB05B42879BDEA85223579A60?method=download&shareKey=242ee05938f02ecc4f20af719a92f520)

##### 下载步骤四：

在新的页面中点击 Download 进行下载.

## 3. 编写代码

```java
class Hello{
    /**
    * 这是程序的入口
    */
    public static void main(String[] args) {
        // 单行注释
        /*
         * 多行注释
         */
        system.output.println("Hello, World!")
    }
}
```

### Java代码语句分类

- 结构定义语句；
- 功能定义语句；

