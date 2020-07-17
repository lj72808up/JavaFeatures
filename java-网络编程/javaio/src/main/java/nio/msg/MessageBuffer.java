package nio.msg;

/**
 * MessageBuffer是一个共享的buffer, 里面会存储多条message.
 * 如果MessageBuffer太小了, 则会产生一个更大的buffer, 将小buffer中的数据复制到大buffer中, 然后释放小buffer
 * 提供3种buffer size共扩展, 初始化时使用小的size(4kb), 扩展成中型size(128kb), 最终可以扩展成大型size(1mb)
 */
public class MessageBuffer {

    private static final int KB = 1024;
    private static final int MB = 1024 * 1024;

    // 扩展的3种size
    private static final int SMALL_CAPACITY = 4 * KB;
    private static final int MEDIUM_CAPACITY = 128 * KB;
    private static final int LARGE_CAPACITY = 1 * MB;

    byte[] smallMessageBuffer = new byte[1024 * SMALL_CAPACITY]; // 可存储1024个小message
    byte[] mediumMessageBuffer = new byte[128 * MEDIUM_CAPACITY]; // 128个中型message
    byte[] largeMessageBuffer = new byte[16 * LARGE_CAPACITY];   // 16个大型message
}
