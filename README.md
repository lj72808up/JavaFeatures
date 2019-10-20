```bash
export MAVEN_OPTS="-DsocksProxyHost=127.0.0.1 -DsocksProxyPort=8085"
```
[hive常用参数](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/hive%E5%B8%B8%E7%94%A8%E5%8F%82%E6%95%B0%E9%85%8D%E7%BD%AE.ipynb)
## Distributed system theory
* [CAP理论](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Distributed%20System/2-CAP%E7%90%86%E8%AE%BA.ipynb)
* [Raft一致性](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Distributed%20System/3-raft%E4%B8%80%E8%87%B4%E6%80%A7.ipynb)
* [PaxOS一致性](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Distributed%20System/1-Paxos%E7%AE%97%E6%B3%95.ipynb)

## Flink
* [1-notation](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Flink/1-notion.ipynb)
* [2-Dataset api](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Flink/2-Dataset%20api.ipynb)

## Leetcode
* 动态规划
    * [6种动态规划编程模板](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Leetcode/DP/1-%E5%85%AD%E7%A7%8DDP.ipynb)
    * [背包问题](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Leetcode/DP/2-%E8%83%8C%E5%8C%85%E9%97%AE%E9%A2%98.ipynb)
* String
    * [DFA自动机](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Leetcode/Strings/DFA.ipynb)

## Java GC
* [oracle - Java Garbage Collection](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/GC/oracle%20-%20Java%20Garbage%20Collection2.ipynb)
* jvm诊断工具
    * [jmc分析jfr](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/GC/Java%20Diagnostic%20Tools/1-jfr.ipynb)
    * [jcmd](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/GC/Java%20Diagnostic%20Tools/2-jcmd.ipynb)
    * [nmt本地内存跟踪](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/GC/Java%20Diagnostic%20Tools/3-nmt.ipynb)

## Spark
* spark组件
    * [RDD](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Spark/spark%E7%BB%84%E4%BB%B6/1-RDD-doc.ipynb)
    * [DataFrame](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Spark/spark%E7%BB%84%E4%BB%B6/2-DataFrame%2CDataSet%E5%92%8CSql.ipynb)
    * [Graphx](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Spark/spark%E7%BB%84%E4%BB%B6/5-graphx.ipynb)
    * [mlib](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Spark/spark%E7%BB%84%E4%BB%B6/4-Spark%20MLib.ipynb)
    * [GraphFrame](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Spark/spark%E7%BB%84%E4%BB%B6/3-GraphFrame.ipynb)
* spark sql
    * [Spark sql优化器-CataLyst(CBO)](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Spark/Spark%20Sql%E4%BC%98%E5%8C%96%E5%99%A8%E5%BC%95%E6%93%8E-CataLyst%28CBO%29.ipynb)
    * [Spark Sql三种join](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Spark/Spark%20join%E7%9A%843%E7%A7%8D%E5%AE%9E%E7%8E%B0.ipynb)
    * [数据倾斜的处理方式](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Spark/Spark%E6%95%B0%E6%8D%AE%E5%80%BE%E6%96%9C.ipynb)
* [spark统一内存管理](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Spark/Spark%E7%BB%9F%E4%B8%80%E5%86%85%E5%AD%98%E7%AE%A1%E7%90%86.ipynb)
* [Cluster Mode and Job Scheduling](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Spark/Cluster%20Mode%20and%20Job%20Scheduling.ipynb)
* [spark-hive ORC](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Spark/spark-hive%20orc.ipynb)
* [spark shuffle](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Spark/spark%20shuffle%E7%90%86%E8%A7%A3.ipynb)

## Hadoop
* HDFS
    * [NameNode HA](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/hadoop/Hdfs/NameNode%20HA.ipynb)
* Yarn
    * [yarn基本架构](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/hadoop/Yarn/1-Yarn%E6%9E%B6%E6%9E%84.ipynb)
    * [yarn资源调度](https://github.com/lj72808up/JavaFeatures/blob/master/hadoop/Yarn/2-Yarn%E8%B0%83%E5%BA%A6.ipynb)
    * [fair scheduler调度策略](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/hadoop/Yarn/3-FairScheduler%E8%B0%83%E5%BA%A6%E5%99%A8.ipynb)
    * [fair scheduler preemption](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/hadoop/Yarn/4-FairScheduler%E7%9A%84%E6%8A%A2%E5%8D%A0%E6%9C%BA%E5%88%B6.ipynb)

## Hbase
- [why hbase?](http://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/5beee9f776165a711d863e26334c9461772a8fc5/Hbase/1-Hbase%E5%9F%BA%E6%9C%AC%E6%A6%82%E5%BF%B5.ipynb)
- [hbase's dietributed infrastructure](http://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/5beee9f776165a711d863e26334c9461772a8fc5/Hbase/2-Hbase%E7%B3%BB%E7%BB%9F%E6%9E%B6%E6%9E%84.ipynb)
- [Rowkey design](http://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/5beee9f776165a711d863e26334c9461772a8fc5/Hbase/3-rowkey%E8%AE%BE%E8%AE%A1.ipynb)
- [Region Splitting and Merging](http://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/5beee9f776165a711d863e26334c9461772a8fc5/Hbase/4-Region%20Splitting%20and%20Merging.ipynb)

## Linux性能优化

## Java Parallel Program
* [parallel model](http://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/6a4009c8ea14bcbfc12995edf5450b1e01e86b74/Java%20Parallel%20program/1-parallel%20programming%20Model.ipynb)
* [parallel control and parallel data Structure](http://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/6a4009c8ea14bcbfc12995edf5450b1e01e86b74/Java%20Parallel%20program/2-parallel%20control%20method.ipynb)

## Java NetWork
* JAVA BIO
	- [Java Knock Knock Server Socket](http://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/5beee9f776165a711d863e26334c9461772a8fc5/Java%20NetWork/1-Java%20Knock%20Knock%20Server%20Socket.ipynb)
* JAVA NIO
    - [Channel,Buffer,Scatter Read & Gather write](http://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/5beee9f776165a711d863e26334c9461772a8fc5/Java%20NetWork/2.2-Channel%E4%B8%8EBuffer.ipynb)
    - [Filechannel之间的transfer](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Java%20NetWork/2.3-Channel%20Transfers.ipynb)
    - [Selector & SelectionKey](http://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/5beee9f776165a711d863e26334c9461772a8fc5/Java%20NetWork/2.4-Selector.ipynb)
    - [使用Filechannel拷贝文件](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Java%20NetWork/2.5%20FileChannel.ipynb)
    - [SocketChannel和ServerSocketChannel](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Java%20NetWork/2.6%20SocketChannel%E5%92%8CServerSocketChannel.ipynb)
    - [完整的NIO服务](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/Java%20NetWork/2.7%20Non-blocking%20Sever.ipynb)


## 计算机网络
* 图解TCP/IP
    * [TCP协议](https://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/master/%E8%AE%A1%E7%AE%97%E6%9C%BA%E7%BD%91%E7%BB%9C/%E5%9B%BE%E8%A7%A3TCP/6.1-TCP.ipynb)

## scala
* [basic operate](http://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/6a4009c8ea14bcbfc12995edf5450b1e01e86b74/Scala/1-scala%E5%9F%BA%E6%9C%AC%E8%AF%AD%E6%B3%95%E4%B8%8E%E5%9F%BA%E6%9C%AC%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84.ipynb)
* [class,object,trait](http://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/6a4009c8ea14bcbfc12995edf5450b1e01e86b74/Scala/2-%E7%B1%BB%E4%B8%8E%E5%AF%B9%E8%B1%A1%2C%E7%89%B9%E8%B4%A8.ipynb)
* [higher-order function](http://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/6a4009c8ea14bcbfc12995edf5450b1e01e86b74/Scala/3-unapply%E4%B8%8E%E9%AB%98%E9%98%B6%E5%87%BD%E6%95%B0.ipynb)
* [scala collection](http://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/6a4009c8ea14bcbfc12995edf5450b1e01e86b74/Scala/4-%E9%9B%86%E5%90%88.ipynb)
* [pattern match](http://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/6a4009c8ea14bcbfc12995edf5450b1e01e86b74/Scala/5-%E6%A8%A1%E5%BC%8F%E5%8C%B9%E9%85%8D.ipynb)
* [generic types](http://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/6a4009c8ea14bcbfc12995edf5450b1e01e86b74/Scala/6-%E6%B3%9B%E5%9E%8B.ipynb)
* [scala types](http://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/6a4009c8ea14bcbfc12995edf5450b1e01e86b74/Scala/7-scala%E9%AB%98%E7%BA%A7%E7%B1%BB%E5%9E%8B.ipynb)
* [implicit](http://nbviewer.jupyter.org/github/lj72808up/JavaFeatures/blob/6a4009c8ea14bcbfc12995edf5450b1e01e86b74/Scala/8-%E9%9A%90%E5%BC%8F%E8%BD%AC%E6%8D%A2.ipynb)
