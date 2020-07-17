class ConsistentHash {
    /** 用ip作为节点 */
    class Node {
        String ip;
        public Node(String ip) {
            this.ip = ip;
        }
    }

    private int slotNum = Integer.MAX_VALUE;  // 65535个环形缓冲区
    private int virtualNum;  //平均虚拟节点数
    private Set<Node> nodeSet;  //节点列表
    private TreeMap<Integer, Node> nodeMap; // key:hashcode,value:Node

    public ConsistentHash(int slotNum, int virtualNum, Set<Node> nodeSet) {
        this.slotNum = slotNum;
        this.virtualNum = virtualNum;
        this.nodeSet = nodeSet;
        nodeMap = new TreeMap<>();
    }

    /**
     * 用虚拟节点构建一致性HASH环, 用Map存储虚拟节点和物理节点之间的映射
     */
    public void buildHashCircle() {
        if (nodeSet == null)
            return;
        for (Node node : nodeSet) {
            for (int i = 0; i < virtualNum; i++) {
                Integer key = hash((node.ip + "-" + i).hashCode());
                nodeMap.put(key, node);
            }
        }
    }

    /**
     * 沿环的顺时针找到虚拟节点
     */
    public Node findNodeByKey(String key) {
        int keySlot = hash(key.hashCode());   // key进行hash求余后的在环中的位置
        Integer integer = nodeMap.ceilingKey(keySlot); // 如果map中存在该key,返回该key, 否则返回大于这个key的最小的key
        // 如果map中不存在待查找比key更大的key, 则返回空, 此时返回map的第一个节点; 以此来表示环形的语义
        Integer targetNodeKey =  (integer==null) ? nodeMap.firstKey():integer;
        return nodeMap.get(targetNodeKey);
    }

    private int hash(int num){
        return num % slotNum;
    }
}