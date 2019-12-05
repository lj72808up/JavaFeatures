```bash
export SBT_OPTS="$SBT_OPTS -DsocksProxyHost=127.0.0.1 -DsocksProxyPort=9100"
export MAVEN_OPTS="-DsocksProxyHost=127.0.0.1 -DsocksProxyPort=9100"
```

[hive常用参数](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/hive%E5%B8%B8%E7%94%A8%E5%8F%82%E6%95%B0%E9%85%8D%E7%BD%AE.ipynb)  
## Distributed system theory
* [1-CAP理论](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Distributed%20System/2-CAP%E7%90%86%E8%AE%BA.ipynb)
* [2-Raft一致性](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Distributed%20System/3-raft%E4%B8%80%E8%87%B4%E6%80%A7.ipynb)
* [3-PaxOS一致性](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Distributed%20System/1-Paxos%E7%AE%97%E6%B3%95.ipynb)
* [4-分布式缓存下的数据分布算法](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Distributed%20System/4-%E5%88%86%E5%B8%83%E5%BC%8F%E7%BC%93%E5%AD%98%E4%B8%8B%E7%9A%84%E6%95%B0%E6%8D%AE%E5%88%86%E5%B8%83%E7%AE%97%E6%B3%95.ipynb)


## Java GC
* [oracle-GC方法论](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/GC/oracle%20-%20Java%20GC%E6%96%B9%E6%B3%95%E8%AE%BA.ipynb)
* [线上问题debug的一般步骤](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/GC/%E7%BA%BF%E4%B8%8A%E9%97%AE%E9%A2%98debug%E7%9A%84%E4%B8%80%E8%88%AC%E6%AD%A5%E9%AA%A4.ipynb)
* jvm诊断工具
    * [1-jcmd工具](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/GC/Java%20Diagnostic%20Tools/1-jcmd.ipynb)
    * [2-使用jmc分析jfr日志](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/GC/Java%20Diagnostic%20Tools/2-%E4%BD%BF%E7%94%A8jmc%E5%88%86%E6%9E%90jfr.ipynb)
    * [nmt本地内存跟踪](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/GC/Java%20Diagnostic%20Tools/3-nmt.ipynb)
* 深入理解Java虚拟机
    * [2-Java内存区域划分](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/GC/%E6%B7%B1%E5%85%A5%E7%90%86%E8%A7%A3Java%E8%99%9A%E6%8B%9F%E6%9C%BA/2-Java%E5%86%85%E5%AD%98%E5%8C%BA%E5%9F%9F%E4%B8%8EOutOfMemory.ipynb)
    * [3-GC收集器与内存分配策略](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/GC/%E6%B7%B1%E5%85%A5%E7%90%86%E8%A7%A3Java%E8%99%9A%E6%8B%9F%E6%9C%BA/3-GC%E6%94%B6%E9%9B%86%E5%99%A8%E4%B8%8E%E5%86%85%E5%AD%98%E5%88%86%E9%85%8D%E7%AD%96%E7%95%A5.ipynb)
    * [4-jvm监控与诊断工具](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/GC/%E6%B7%B1%E5%85%A5%E7%90%86%E8%A7%A3Java%E8%99%9A%E6%8B%9F%E6%9C%BA/4-jvm%E7%9B%91%E6%8E%A7%E4%B8%8E%E8%AF%8A%E6%96%AD%E5%B7%A5%E5%85%B7.ipynb)
    * [7-虚拟机类加载机制](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/GC/%E6%B7%B1%E5%85%A5%E7%90%86%E8%A7%A3Java%E8%99%9A%E6%8B%9F%E6%9C%BA/7-%E8%99%9A%E6%8B%9F%E6%9C%BA%E7%B1%BB%E5%8A%A0%E8%BD%BD%E6%9C%BA%E5%88%B6.ipynb)
    * [12-Java内存模型](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/GC/%E6%B7%B1%E5%85%A5%E7%90%86%E8%A7%A3Java%E8%99%9A%E6%8B%9F%E6%9C%BA/12-Java%E5%86%85%E5%AD%98%E6%A8%A1%E5%9E%8B.ipynb)
    * [13-线程](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/GC/%E6%B7%B1%E5%85%A5%E7%90%86%E8%A7%A3Java%E8%99%9A%E6%8B%9F%E6%9C%BA/13-%E7%BA%BF%E7%A8%8B.ipynb)
    * [13-<附录>JVM的小知识](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/GC/%E6%B7%B1%E5%85%A5%E7%90%86%E8%A7%A3Java%E8%99%9A%E6%8B%9F%E6%9C%BA/13-%5B%E9%99%84%E5%BD%95%5DJVM%E7%9A%84%E5%B0%8F%E7%9F%A5%E8%AF%86.ipynb)

## Java Parallel Program
* **Java并发编程实践**
    * [4-并发基础模块](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Java%20Parallel%20program/Java%E5%B9%B6%E5%8F%91%E7%BC%96%E7%A8%8B%E5%AE%9E%E8%B7%B5/4-%E5%B9%B6%E5%8F%91%E5%9F%BA%E7%A1%80%E6%A8%A1%E5%9D%97.ipynb)
    * [5-并发工具类](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Java%20Parallel%20program/Java%E5%B9%B6%E5%8F%91%E7%BC%96%E7%A8%8B%E5%AE%9E%E8%B7%B5/5-%E5%B9%B6%E5%8F%91%E5%B7%A5%E5%85%B7%E7%B1%BB.ipynb)
    * [7-任务的1取消与关闭](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Java%20Parallel%20program/Java%E5%B9%B6%E5%8F%91%E7%BC%96%E7%A8%8B%E5%AE%9E%E8%B7%B5/7-%E5%8F%96%E6%B6%88%E4%B8%8E%E5%85%B3%E9%97%AD.ipynb)
    * [14-条件队列与AQS](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Java%20Parallel%20program/Java%E5%B9%B6%E5%8F%91%E7%BC%96%E7%A8%8B%E5%AE%9E%E8%B7%B5/14-%E6%9D%A1%E4%BB%B6%E7%AD%89%E5%BE%85-Condition%E5%92%8CAQS.ipynb)
    * [15-原子变量和非阻塞同步机制](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Java%20Parallel%20program/Java%E5%B9%B6%E5%8F%91%E7%BC%96%E7%A8%8B%E5%AE%9E%E8%B7%B5/15-%E5%8E%9F%E5%AD%90%E5%8F%98%E9%87%8F%E5%92%8C%E9%9D%9E%E9%98%BB%E5%A1%9E%E5%90%8C%E6%AD%A5%E6%9C%BA%E5%88%B6.ipynb)

## Java网络编程
* [Linux5种IO模型](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Java%20NetWork/1-Linux5%E7%A7%8DIO%E6%A8%A1%E5%9E%8B.ipynb)
* [JAVA BIO](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Java%20NetWork/1-Java%20Knock%20Knock%20Server%20Socket.ipynb)
* JAVA NIO
    - [1-Channel,Buffer概念与分散读聚合写](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Java%20NetWork/2.2-Channel%E4%B8%8EBuffer.ipynb)
    - [2-Filechannel与高效transfer](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Java%20NetWork/2.3-Channel%20Transfers.ipynb)
    - [3-Selector](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Java%20NetWork/2.4-Selector.ipynb)
    - [4-SocketChannel和ServerSocketChannel](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Java%20NetWork/2.6%20SocketChannel%E5%92%8CServerSocketChannel.ipynb)
    - [5-NIO服务](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Java%20NetWork/2.7%20Non-blocking%20Sever.ipynb)
* Java AIO
    * [1-异步的FileChannel](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Java%20NetWork/3.2-AIO%28AsynchronousFIleChannel%29.ipynb)

## Java Topic
* [1-动态规划](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Java%20Topic/1-%E5%8A%A8%E6%80%81%E4%BB%A3%E7%90%86.ipynb)
* [2-关于常量](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Java%20Topic/2-%E5%85%B3%E4%BA%8E%E5%B8%B8%E9%87%8F%28String%29.ipynb)

## Spark
* [CataLyst与CBO优化)](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Spark/Spark%20Sql%E4%BC%98%E5%8C%96%E5%99%A8%E5%BC%95%E6%93%8E-CataLyst%28CBO%29.ipynb)
* [Spark的三个join](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Spark/Spark%20join%E7%9A%843%E7%A7%8D%E5%AE%9E%E7%8E%B0.ipynb)
* [Spark2.x后的统一内存管理](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Spark/Spark%E7%BB%9F%E4%B8%80%E5%86%85%E5%AD%98%E7%AE%A1%E7%90%86.ipynb)
* [Spark shuffle-read,write,oom](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Spark/spark%20shuffle%E7%90%86%E8%A7%A3.ipynb)
* [Spark-hive 使用ORC文件](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Spark/spark-hive%20orc.ipynb)
* [Spark任务未获得全部资源的快速启动和屏蔽资源抢占](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Spark/spark%E8%B5%84%E6%BA%90%E6%8A%A2%E5%8D%A0.ipynb)
* [Spark面试题](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Spark/spark%E9%9D%A2%E8%AF%95%E9%A2%98.ipynb)
* **Spark组件**
    * [1-RDD](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Spark/spark%E7%BB%84%E4%BB%B6/1-RDD-doc.ipynb)
    * [2-DataFrame与DataSet](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Spark/spark%E7%BB%84%E4%BB%B6/2-DataFrame%2CDataSet%E5%92%8CSql.ipynb)
    * [3-Graphx](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Spark/spark%E7%BB%84%E4%BB%B6/5-graphx.ipynb)

## Hadoop
* HDFS
    * [NameNode HA](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/hadoop/Hdfs/NameNode%20HA.ipynb)
* Yarn
    * [1-yarn基本架构](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/hadoop/Yarn/1-Yarn%E6%9E%B6%E6%9E%84.ipynb)
    * [2-yarn资源调度](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/hadoop/Yarn/2-Yarn%E8%B0%83%E5%BA%A6.ipynb)
    * [3-fair scheduler调度的资源分配](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/hadoop/Yarn/3-FairScheduler%E8%B0%83%E5%BA%A6%E5%99%A8.ipynb)
    * [4-fair scheduler preemption](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/hadoop/Yarn/4-FairScheduler%E7%9A%84%E6%8A%A2%E5%8D%A0%E6%9C%BA%E5%88%B6.ipynb)

## Hbase
- [1-Hbase基本概念](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Hbase/1-Hbase%E5%9F%BA%E6%9C%AC%E6%A6%82%E5%BF%B5.ipynb)
- [2-Hbase系统架构](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Hbase/2-Hbase%E7%B3%BB%E7%BB%9F%E6%9E%B6%E6%9E%84.ipynb)
- [3-rowkey设计](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Hbase/3-rowkey%E8%AE%BE%E8%AE%A1.ipynb)
- [4-Region Splitting and Merging](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Hbase/4-Region%20Splitting%20and%20Merging.ipynb)

## Linux性能优化

## 设计模式
* **创建模式**
    * [1-单例模式](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/%E5%88%9B%E5%BB%BA%E6%A8%A1%E5%BC%8F/1-%E5%8D%95%E4%BE%8B%E6%A8%A1%E5%BC%8F.ipynb)
    * [2-工厂模式](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/%E5%88%9B%E5%BB%BA%E6%A8%A1%E5%BC%8F/2-%E5%B7%A5%E5%8E%82%E6%A8%A1%E5%BC%8F.ipynb)
    * [3-建造者模式](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/%E5%88%9B%E5%BB%BA%E6%A8%A1%E5%BC%8F/3-%E5%BB%BA%E9%80%A0%E8%80%85%E6%A8%A1%E5%BC%8F.ipynb)

## 计算机网络
* 图解TCP/IP
    * [6-TCP协议](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/%E8%AE%A1%E7%AE%97%E6%9C%BA%E7%BD%91%E7%BB%9C/%E5%9B%BE%E8%A7%A3TCP/6.1-TCP.ipynb)

## 计算机软硬件接口
* **5-存储器的层次结构**
    * [5.3-cache的基本原理](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/%E8%AE%A1%E7%AE%97%E6%9C%BA%E8%BD%AF%E7%A1%AC%E4%BB%B6%E6%8E%A5%E5%8F%A3/5-%E5%AD%98%E5%82%A8%E5%99%A8%E7%9A%84%E5%B1%82%E6%AC%A1%E7%BB%93%E6%9E%84/5.3-cache%E7%9A%84%E5%9F%BA%E6%9C%AC%E5%8E%9F%E7%90%86.ipynb)
    * [5.7-虚拟存储器](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/%E8%AE%A1%E7%AE%97%E6%9C%BA%E8%BD%AF%E7%A1%AC%E4%BB%B6%E6%8E%A5%E5%8F%A3/5-%E5%AD%98%E5%82%A8%E5%99%A8%E7%9A%84%E5%B1%82%E6%AC%A1%E7%BB%93%E6%9E%84/5.7-%E8%99%9A%E6%8B%9F%E5%AD%98%E5%82%A8%E5%99%A8.ipynb)

## scala
* [basic operate](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Scala/1-scala%E5%9F%BA%E6%9C%AC%E8%AF%AD%E6%B3%95%E4%B8%8E%E5%9F%BA%E6%9C%AC%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84.ipynb)
* [class,object,trait](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Scala/2-%E7%B1%BB%E4%B8%8E%E5%AF%B9%E8%B1%A1%2C%E7%89%B9%E8%B4%A8.ipynb)
* [higher-order function](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Scala/3-unapply%E4%B8%8E%E9%AB%98%E9%98%B6%E5%87%BD%E6%95%B0.ipynb)
* [scala collection](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Scala/4-%E9%9B%86%E5%90%88.ipynb)
* [pattern match](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Scala/5-%E6%A8%A1%E5%BC%8F%E5%8C%B9%E9%85%8D.ipynb)
* [generic types](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Scala/6-%E6%B3%9B%E5%9E%8B.ipynb)
* [scala types](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Scala/7-scala%E9%AB%98%E7%BA%A7%E7%B1%BB%E5%9E%8B.ipynb)
* [implicit](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Scala/8-%E9%9A%90%E5%BC%8F%E8%BD%AC%E6%8D%A2.ipynb)
