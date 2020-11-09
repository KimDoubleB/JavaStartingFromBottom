import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListPractice {
    /**
     * LinkedList extends list interface
     *  add, remove, addAll, removeAll
     *  get, set
     *  replaceAll, clear, equals
     *  size
     *  isEmpty, iterator, toArray
     *  contains, containsAll
     *  indexOf, lastIndexOf
     *  listIterator, subList
     */
    public LinkedListPractice(){
        testLinkedList();
    }

    private void testLinkedList(){
        LinkedList<String> linkedListData = new LinkedList<>(
                Arrays.asList("Hello", "Java", "this is", "LinkedList")
        );
        System.out.println(linkedListData);

        // 일반적인 list 형태의 메소드

        // linkedlist - 포인터 위치만 변경하면 되기 때문에 처음, 끝 또는 중간에 데이터를 넣는게 쉽다.
        // 하지만 그 특정 위치까지 찾아가는데는 처음 데이터부터 포인터를 통해 접근해야만 한다. O(n)
        linkedListData.add("!");    // 일반적으로 뒤로 데이터가 들어간다.
        linkedListData.addFirst("First data");
        linkedListData.addLast("Last data");
        linkedListData.add(0, "index 0 data add");
        linkedListData.addAll(new LinkedList<String>(
                Arrays.asList("Two List", "Java", "it's fun", "really.", "you know.....")
        ));
        System.out.println(linkedListData);

        linkedListData.remove("!");
        linkedListData.remove(5);
        linkedListData.removeFirst();
        linkedListData.removeLast();

        // 첫 번째부터 검색해서 삭제
        linkedListData.removeFirstOccurrence("Java");
        System.out.println(linkedListData);

        // 마지막부터 검색해서 삭제
        linkedListData.removeLastOccurrence("Java");
        System.out.println(linkedListData);

        // NoSuchElementException -> get...() can't use in length 0 list.
        //        System.out.println(queue.getFirst());
        //        System.out.println(queue.getLast());
        //        System.out.println(queue.get(0));

        /*
        LinkedList 는 Queue, Stack 자료구조를 위한 메소드를 지원하고 있다.

        Queue
        - offer(): 삽입 (뒤에다 삽입)
        - poll(): 제거하며 읽기 (pollFirst, pollLast)
        - peek(): 제거하지 않고 읽기 (peekFirst, peekLast)

        Stack
        - push(): 삽입 (앞에다 삽입)
        - pop(): 제거하며 읽기
        - peek(): 제거하지 않고 읽기 (peekFirst, peekLast)
         */

        queueMethod();
        stackMethod();

    }

    private void queueMethod(){
        // offer, poll, peek
        System.out.println("Queue LinkedList Method");
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(14312421);  // 뒤로 들어감 (Queue) -> 출입구 여러개
        queue.addAll(Arrays.asList(2, 3, 4, 5, 6, 7, 8));
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue.peekFirst());  // same as peek()
        System.out.println(queue.peekLast());

        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue.pollFirst());  // same as poll()
        System.out.println(queue.pollLast());
        System.out.println(queue);

        queue.clear();
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue.peekFirst());  // same as peek()
        System.out.println(queue.peekLast());
    }

    private void stackMethod(){
        // push, pop, peek
        System.out.println("Stack LinkedList Method");
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(1);
        stack.push(1312312312); // 앞으로 들어감 (Stack) -> 출입구 한 개
        stack.addAll(Arrays.asList(2, 3, 4, 5, 6, 7, 8));

        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.peekFirst());  // same as peek()
        System.out.println(stack.peekLast());

        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
