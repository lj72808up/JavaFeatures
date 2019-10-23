```bash
export MAVEN_OPTS="-DsocksProxyHost=127.0.0.1 -DsocksProxyPort=8085"
```
[hive常用参数](http://149.129.33.202:5000/github/lj72808up/JavaFeatures/blob/master/hive%E5%B8%B8%E7%94%A8%E5%8F%82%E6%95%B0%E9%85%8D%E7%BD%AE.ipynb)  
## Distributed system theory
* [1-CAP理论](http://149.129.33.202:5000/github/lj72808up/JavaFeatures/blob/master/Distributed%20System/2-CAP%E7%90%86%E8%AE%BA.ipynb)
* [2-Raft一致性](http://149.129.33.202:5000/github/lj72808up/JavaFeatures/blob/master/Distributed%20System/3-raft%E4%B8%80%E8%87%B4%E6%80%A7.ipynb)
* [3-PaxOS一致性](http://149.129.33.202:5000/github/lj72808up/JavaFeatures/blob/master/Distributed%20System/1-Paxos%E7%AE%97%E6%B3%95.ipynb)
* [4-分布式缓存下的数据分布算法](http://149.129.33.202:5000/github/lj72808up/JavaFeatures/blob/master/Distributed%20System/4-%E5%88%86%E5%B8%83%E5%BC%8F%E7%BC%93%E5%AD%98%E4%B8%8B%E7%9A%84%E6%95%B0%E6%8D%AE%E5%88%86%E5%B8%83%E7%AE%97%E6%B3%95.ipynb)


## Java GC
* [oracle-GC方法论](http://149.129.33.202:5000/github/lj72808up/JavaFeatures/blob/master/GC/oracle%20-%20Java%20GC%E6%96%B9%E6%B3%95%E8%AE%BA.ipynb)
* [线上问题debug的一般步骤](http://149.129.33.202:5000/github/lj72808up/JavaFeatures/blob/master/GC/%E7%BA%BF%E4%B8%8A%E9%97%AE%E9%A2%98debug%E7%9A%84%E4%B8%80%E8%88%AC%E6%AD%A5%E9%AA%A4.ipynb)
* jvm诊断工具
    * [1-jcmd工具](http://149.129.33.202:5000/github/lj72808up/JavaFeatures/blob/master/GC/Java%20Diagnostic%20Tools/1-jcmd.ipynb)
    * [2-使用jmc分析jfr日志](http://149.129.33.202:5000/github/lj72808up/JavaFeatures/blob/master/GC/Java%20Diagnostic%20Tools/2-%E4%BD%BF%E7%94%A8jmc%E5%88%86%E6%9E%90jfr.ipynb)
    * [nmt本地内存跟踪](http://149.129.33.202:5000/github/lj72808up/JavaFeatures/blob/master/GC/Java%20Diagnostic%20Tools/3-nmt.ipynb)
* 深入理解Java虚拟机
    * [2-Java内存区域划分](http://149.129.33.202:5000/github/lj72808up/JavaFeatures/blob/master/GC/%E6%B7%B1%E5%85%A5%E7%90%86%E8%A7%A3Java%E8%99%9A%E6%8B%9F%E6%9C%BA/2-Java%E5%86%85%E5%AD%98%E5%8C%BA%E5%9F%9F%E4%B8%8EOutOfMemory.ipynb)
    * [3-GC收集器与内存分配策略](http://149.129.33.202:5000/github/lj72808up/JavaFeatures/blob/master/GC/%E6%B7%B1%E5%85%A5%E7%90%86%E8%A7%A3Java%E8%99%9A%E6%8B%9F%E6%9C%BA/3-GC%E6%94%B6%E9%9B%86%E5%99%A8%E4%B8%8E%E5%86%85%E5%AD%98%E5%88%86%E9%85%8D%E7%AD%96%E7%95%A5.ipynb)
    * [4-jvm监控与诊断工具](http://149.129.33.202:5000/github/lj72808up/JavaFeatures/blob/master/GC/%E6%B7%B1%E5%85%A5%E7%90%86%E8%A7%A3Java%E8%99%9A%E6%8B%9F%E6%9C%BA/4-jvm%E7%9B%91%E6%8E%A7%E4%B8%8E%E8%AF%8A%E6%96%AD%E5%B7%A5%E5%85%B7.ipynb)
    * [7-虚拟机类加载机制](http://149.129.33.202:5000/github/lj72808up/JavaFeatures/blob/master/GC/%E6%B7%B1%E5%85%A5%E7%90%86%E8%A7%A3Java%E8%99%9A%E6%8B%9F%E6%9C%BA/7-%E8%99%9A%E6%8B%9F%E6%9C%BA%E7%B1%BB%E5%8A%A0%E8%BD%BD%E6%9C%BA%E5%88%B6.ipynb)
    * [12-Java内存模型](http://149.129.33.202:5000/github/lj72808up/JavaFeatures/blob/master/GC/%E6%B7%B1%E5%85%A5%E7%90%86%E8%A7%A3Java%E8%99%9A%E6%8B%9F%E6%9C%BA/12-Java%E5%86%85%E5%AD%98%E6%A8%A1%E5%9E%8B.ipynb)
    * [13-线程](http://149.129.33.202:5000/github/lj72808up/JavaFeatures/blob/master/GC/%E6%B7%B1%E5%85%A5%E7%90%86%E8%A7%A3Java%E8%99%9A%E6%8B%9F%E6%9C%BA/13-%E7%BA%BF%E7%A8%8B.ipynb)
    * [13-[附录]JVM的小知识](http://149.129.33.202:5000/github/lj72808up/JavaFeatures/blob/master/GC/%E6%B7%B1%E5%85%A5%E7%90%86%E8%A7%A3Java%E8%99%9A%E6%8B%9F%E6%9C%BA/13-%5B%E9%99%84%E5%BD%95%5DJVM%E7%9A%84%E5%B0%8F%E7%9F%A5%E8%AF%86.ipynb)


## Spark
* spark组件
    * [RDD](https://github/lj72808up/JavaFeatures/blob/master/Spark/spark%E7%BB%84%E4%BB%B6/1-RDD-doc.ipynb)
    * [DataFrame](https://github/lj72808up/JavaFeatures/blob/master/Spark/spark%E7%BB%84%E4%BB%B6/2-DataFrame%2CDataSet%E5%92%8CSql.ipynb)
    * [Graphx](https://github/lj72808up/JavaFeatures/blob/master/Spark/spark%E7%BB%84%E4%BB%B6/5-graphx.ipynb)
    * [mlib](https://github/lj72808up/JavaFeatures/blob/master/Spark/spark%E7%BB%84%E4%BB%B6/4-Spark%20MLib.ipynb)
    * [GraphFrame](https://github/lj72808up/JavaFeatures/blob/master/Spark/spark%E7%BB%84%E4%BB%B6/3-GraphFrame.ipynb)
* spark sql
    * [Spark sql优化器-CataLyst(CBO)](https://github/lj72808up/JavaFeatures/blob/master/Spark/Spark%20Sql%E4%BC%98%E5%8C%96%E5%99%A8%E5%BC%95%E6%93%8E-CataLyst%28CBO%29.ipynb)
    * [Spark Sql三种join](https://github/lj72808up/JavaFeatures/blob/master/Spark/Spark%20join%E7%9A%843%E7%A7%8D%E5%AE%9E%E7%8E%B0.ipynb)
    * [数据倾斜的处理方式](https://github/lj72808up/JavaFeatures/blob/master/Spark/Spark%E6%95%B0%E6%8D%AE%E5%80%BE%E6%96%9C.ipynb)
* [spark统一内存管理](https://github/lj72808up/JavaFeatures/blob/master/Spark/Spark%E7%BB%9F%E4%B8%80%E5%86%85%E5%AD%98%E7%AE%A1%E7%90%86.ipynb)
* [Cluster Mode and Job Scheduling](https://github/lj72808up/JavaFeatures/blob/master/Spark/Cluster%20Mode%20and%20Job%20Scheduling.ipynb)
* [spark-hive ORC](https://github/lj72808up/JavaFeatures/blob/master/Spark/spark-hive%20orc.ipynb)
* [spark shuffle](https://github/lj72808up/JavaFeatures/blob/master/Spark/spark%20shuffle%E7%90%86%E8%A7%A3.ipynb)

## Hadoop
* HDFS
    * [NameNode HA](https://github/lj72808up/JavaFeatures/blob/master/hadoop/Hdfs/NameNode%20HA.ipynb)
* Yarn
    * [yarn基本架构](https://github/lj72808up/JavaFeatures/blob/master/hadoop/Yarn/1-Yarn%E6%9E%B6%E6%9E%84.ipynb)
    * [yarn资源调度](https://github.com/lj72808up/JavaFeatures/blob/master/hadoop/Yarn/2-Yarn%E8%B0%83%E5%BA%A6.ipynb)
    * [fair scheduler调度策略](https://github/lj72808up/JavaFeatures/blob/master/hadoop/Yarn/3-FairScheduler%E8%B0%83%E5%BA%A6%E5%99%A8.ipynb)
    * [fair scheduler preemption](https://github/lj72808up/JavaFeatures/blob/master/hadoop/Yarn/4-FairScheduler%E7%9A%84%E6%8A%A2%E5%8D%A0%E6%9C%BA%E5%88%B6.ipynb)

## Hbase
- [1-Hbase基本概念](http://149.129.33.202:5000/github/lj72808up/JavaFeatures/blob/master/Hbase/1-Hbase%E5%9F%BA%E6%9C%AC%E6%A6%82%E5%BF%B5.ipynb)
- [2-Hbase系统架构](http://149.129.33.202:5000/github/lj72808up/JavaFeatures/blob/master/Hbase/2-Hbase%E7%B3%BB%E7%BB%9F%E6%9E%B6%E6%9E%84.ipynb)
- [3-rowkey设计](http://149.129.33.202:5000/github/lj72808up/JavaFeatures/blob/master/Hbase/3-rowkey%E8%AE%BE%E8%AE%A1.ipynb)
- [4-Region Splitting and Merging](http://149.129.33.202:5000/github/lj72808up/JavaFeatures/blob/master/Hbase/4-Region%20Splitting%20and%20Merging.ipynb)

## Linux性能优化

## Java Parallel Program
* [parallel model](http://github/lj72808up/JavaFeatures/blob/master/6a4009c8ea14bcbfc12995edf5450b1e01e86b74/Java%20Parallel%20program/1-parallel%20programming%20Model.ipynb)
* [parallel control and parallel data Structure](http://github/lj72808up/JavaFeatures/blob/master/6a4009c8ea14bcbfc12995edf5450b1e01e86b74/Java%20Parallel%20program/2-parallel%20control%20method.ipynb)

## Java NetWork
* JAVA BIO
	- [Java Knock Knock Server Socket](http://github/lj72808up/JavaFeatures/blob/master/5beee9f776165a711d863e26334c9461772a8fc5/Java%20NetWork/1-Java%20Knock%20Knock%20Server%20Socket.ipynb)
* JAVA NIO
    - [Channel,Buffer,Scatter Read & Gather write](http://github/lj72808up/JavaFeatures/blob/master/5beee9f776165a711d863e26334c9461772a8fc5/Java%20NetWork/2.2-Channel%E4%B8%8EBuffer.ipynb)
    - [Filechannel之间的transfer](https://github/lj72808up/JavaFeatures/blob/master/Java%20NetWork/2.3-Channel%20Transfers.ipynb)
    - [Selector & SelectionKey](http://github/lj72808up/JavaFeatures/blob/master/5beee9f776165a711d863e26334c9461772a8fc5/Java%20NetWork/2.4-Selector.ipynb)
    - [使用Filechannel拷贝文件](https://github/lj72808up/JavaFeatures/blob/master/Java%20NetWork/2.5%20FileChannel.ipynb)
    - [SocketChannel和ServerSocketChannel](https://github/lj72808up/JavaFeatures/blob/master/Java%20NetWork/2.6%20SocketChannel%E5%92%8CServerSocketChannel.ipynb)
    - [完整的NIO服务](https://github/lj72808up/JavaFeatures/blob/master/Java%20NetWork/2.7%20Non-blocking%20Sever.ipynb)

## Java Topic
* [1-动态规划](http://149.129.33.202:5000/github/lj72808up/JavaFeatures/blob/master/Java%20Topic/1-%E5%8A%A8%E6%80%81%E4%BB%A3%E7%90%86.ipynb)
* [2-关于常量](http://149.129.33.202:5000/github/lj72808up/JavaFeatures/blob/master/Java%20Topic/2-%E5%85%B3%E4%BA%8E%E5%B8%B8%E9%87%8F%28String%29.ipynb)


## 计算机网络
* 图解TCP/IP
    * [6-TCP协议](https://github.com/lj72808up/JavaFeatures/blob/master/%E8%AE%A1%E7%AE%97%E6%9C%BA%E7%BD%91%E7%BB%9C/%E5%9B%BE%E8%A7%A3TCP/6.1-TCP.ipynb)

## scala
* [basic operate](http://149.129.33.202:5000/github/lj72808up/JavaFeatures/blob/master/Scala/1-scala%E5%9F%BA%E6%9C%AC%E8%AF%AD%E6%B3%95%E4%B8%8E%E5%9F%BA%E6%9C%AC%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84.ipynb)
* [class,object,trait](http://149.129.33.202:5000/github/lj72808up/JavaFeatures/blob/master/Scala/2-%E7%B1%BB%E4%B8%8E%E5%AF%B9%E8%B1%A1%2C%E7%89%B9%E8%B4%A8.ipynb)
* [higher-order function](http://149.129.33.202:5000/github/lj72808up/JavaFeatures/blob/master/Scala/3-unapply%E4%B8%8E%E9%AB%98%E9%98%B6%E5%87%BD%E6%95%B0.ipynb)
* [scala collection](http://149.129.33.202:5000/github/lj72808up/JavaFeatures/blob/master/Scala/4-%E9%9B%86%E5%90%88.ipynb)
* [pattern match](http://149.129.33.202:5000/github/lj72808up/JavaFeatures/blob/master/Scala/5-%E6%A8%A1%E5%BC%8F%E5%8C%B9%E9%85%8D.ipynb)
* [generic types](http://149.129.33.202:5000/github/lj72808up/JavaFeatures/blob/master/Scala/6-%E6%B3%9B%E5%9E%8B.ipynb)
* [scala types](http://149.129.33.202:5000/github/lj72808up/JavaFeatures/blob/master/Scala/7-scala%E9%AB%98%E7%BA%A7%E7%B1%BB%E5%9E%8B.ipynb)
* [implicit](http://149.129.33.202:5000/github/lj72808up/JavaFeatures/blob/master/Scala/8-%E9%9A%90%E5%BC%8F%E8%BD%AC%E6%8D%A2.ipynb)
