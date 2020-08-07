package task.task1;

/**
 * @ClassName MyList
 * @Description 单链表
 * @Author 0715-YuHao
 * @Date 2020/7/30 10:06
 */
public class MyList {

    //节点
    private class Node{
        private int data; // 存储数据
        private Node next; // 指向下一个节点

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return this.data;
        }

    }

    // 节点的个数
    private int size = 0;
    //指向第一个节点
    private Node first;
    //指向最后一个节点
    private Node last;

    public MyList() {
        //默认为空链表
        this.first = null;
    }

    /**
     * @Author 0715-YuHao
     * @Description 头插入
     * @Date 2020/7/30 10:08
     * @Param []
     * @return void
     */
    public void addFirst(int data) {
        //如果链表为空，则直接添加至头节点与尾节点
        if (first == null) {
            first = new Node(data);
            last = first;
        }else {
            // 创建新的节点
            Node node = new Node(data);
            // 原头节点指向要插入的节点
            node.next = first;
            first = node;
        }
        size++;
    }

    /**
     * @Author 0715-YuHao
     * @Description 尾插入
     * @Date 2020/7/30 10:27
     * @Param [data]
     * @return void
     */
    public void addLast(int data) {
        //如果链表为空，则直接添加至头节点与尾节点
        if (first == null) {
            first = new Node(data);
            last = first;
        }else {
            //非空链表，将最后一个节点指向新节点
            Node node = new Node(data);
            last.next = node;
            last = node;
        }
        size++;
    }

    /**
     * @Author 0715-YuHao
     * @Description 插入
     * @Date 2020/7/30 12:18
     * @Param [data, index] [数据， 要插入的位置]
     * @return void
     */
    public void insert(int data, int index) {
        // 判断要插入的位置是否超出链表范围，超出则抛出内存溢出异常
        if (index < 0 || index > size - 1) {
            throw new OutOfMemoryError();
        }else {
            //创建temp指针
            Node temp = first;
            //遍历节点到需要插入的位置
            for (int i = 0; i < index; i++) {
                //指向下一Data
                temp = temp.next;
            }
            //创建需要插入的节点
            Node node = new Node(data);
            //指向需要插入位置的下一节点
            node.next = temp.next;
            //把指针的下一节点指向新节点
            temp.next = node;
        }
        size++;
    }

    /**
     * @Author 0715-YuHao
     * @Description 通过Data删除节点
     * @Date 2020/7/30 10:10
     * @Param [list]
     * @return void
     */
    public void deleteData(int data) {
        if (first.getData() == data) {
            first = first.next;
        }else {
            //创建temp指针指向头节点
            Node temp = first;
            //创建beforeTemp指针指向要删除节点的前一节点
            Node beforeTemp = first;
            //创建idelete指针保存需要删除节点之后的数据
            Node idelete;
            for (int i = 0; i < size; i++) {
                //遍历找到需要删除的数据
                if (temp.getData() == data) {
                    //创建idelete指针保存需要删除节点之后的数据
                    idelete = temp.next;
                    for (int j = 0; j < size; j++) {
                        if (beforeTemp.next.equals(temp)) {
                            beforeTemp.next = idelete;
                            break;
                        }
                        beforeTemp = beforeTemp.next;
                    }
                    break;
                }
                temp = temp.next;
            }
        }
        size--;
    }

    /**
     * @Author 0715-YuHao
     * @Description 通过索引删除节点
     * @Date 2020/7/30 14:08
     * @Param [index]
     * @return void
     */
    public void deleteIndex(int index) {
        //创建temp指针指向头节点
        Node temp = first;
        //创建idelete指针保存需要删除节点之后的数据
        Node idelete;
        // 判断要插入的位置是否超出链表范围，超出则抛出内存溢出异常
        if (index < 0 || index > size - 1) {
            throw new OutOfMemoryError();
        }else {
            //减1是为了找到要删除节点的前一节点
            index--;
            switch (index) {
                case -1://删除0位置数据
                    first = temp.next;
                    break;
                case 0://删除1位置数据
                    idelete = temp.next.next;
                    temp.next = idelete;
                    break;
                default:
                    //将temp指针指向要删除节点的前一节点
                    for (int i = 0; i < index; i++) {
                        temp = temp.next;
                    }
                    idelete = temp.next.next;
                    temp.next = idelete;
                    break;
            }
        }
        size--;
    }

    /**
     * @Author 0715-YuHao
     * @Description 遍历
     * @Date 2020/7/30 12:25
     * @Param []
     * @return void
     */
    public void printAll() {
        //创建temp指针
        Node temp = first;
        //循环遍历data
        for (int i = 0; i < size; i++) {
            System.out.print(temp.getData() + " ");
            //指向下一Data
            temp = temp.next;
        }
    }
}
