package nio.datastruct;

/**
 * 一种ringbuffer, 当writePos越界时会指向0
 */
public class QueueFlipInt {
    private int capacity;
    private int[] elems;

    private int writePos = 0;
    private int readPos = 0;

    private boolean flipped = false;

    public QueueFlipInt(int capacity) {
        /** 初始化指定大小的ringbuffer */
        this.capacity = capacity;
        this.elems = new int[capacity];
    }

    public int avaliable(){
        /** 当前存储的数据量 */
        if(!flipped)  // 未发生overflowed
            return writePos - readPos;  // writePos是下一个可写入的位置
        else  // 发生overflowed. writePos在readPos之前
            return capacity - readPos + writePos;
    }

    public boolean put(int elem){
        /** 插入数据 */
        if(!flipped){ // 未发生过overflowed
            if(writePos == capacity){  // 再写就overflowed了
                writePos = 0;
                flipped = true;

                if(readPos>writePos){ // 可写
                    elems[writePos] = elem;
                    writePos ++;
                    return true;
                }else  // 已满
                    return false;
            }else{
                elems[writePos] = elem;
                writePos ++;
                return true;
            }
        }else{
            if(readPos>writePos) {
                elems[writePos] = elem;
                writePos++;
                return true;
            }else
                return false;
        }
    }

    public int put(int[] datas,int length){
        /** 插入datas中的数据, 返回成功插入的int值个数 */
        int count = 0;
        if(!flipped){
            if(length <= capacity-writePos){
                for (;count<length;count++)
                    this.elems[writePos++] = datas[count];
                return count;
            }else{
                // writing to top
                for(;writePos<capacity;writePos++)
                    this.elems[writePos] = datas[count++];
                // writing to bottom
                writePos = 0;
                flipped = true;
                int endPos = Math.min(readPos,length-count);
                for (;writePos<endPos;writePos++)
                    this.elems[writePos] = datas[count++];
                return count;
            }
        }else{
            int endPos = Math.min(readPos,writePos+length);
            for (;writePos<endPos;writePos++)
                this.elems[writePos] = datas[count++];
            return count;
        }
    }

    public int take(){
        /** 获取一个int值 */
        if(!flipped){
            if(readPos<writePos)
                return this.elems[readPos++];
            else
                return -1;
        }else{
            if(readPos == capacity){
                readPos = 0;
                flipped = false;

                if(readPos<writePos)
                    return this.elems[readPos++];
                else
                    return -1;
            }else
                return this.elems[readPos++];
        }
    }

    public int take(int[] into, int length){
        /** 获取length个int值 */
        int count = 0;
        if(!flipped){
            int endPos = Math.min(writePos, readPos+length);
            for (;readPos<endPos;readPos++)
                into[count++] = this.elems[readPos];
            return count;
        }else{
            if(length <= capacity-readPos){
                for (;count<length;count++)
                    into[count] = this.elems[readPos++];
                return count;
            }else{
                //copy from top
                for (;readPos<capacity;readPos++)
                    into[count++] = this.elems[readPos];

                //copy from bottom
                readPos = 0;
                flipped = false;
                int endPos = Math.min(writePos, length-count);
                for (;readPos<endPos;readPos++)
                    into[count++] = this.elems[readPos];
                return count;
            }
        }
    }

}
