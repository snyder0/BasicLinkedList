import java.util.Scanner;

public class MyList {
    node front;
    public static void main(String[] args) {
        int numOfNodes;
        MyList myList = new MyList();
        System.out.println("List loaded with 0-9...");
        myList.buildList(9);
        myList.showList(myList.front);
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter number of nodes: ");
        numOfNodes = Integer.parseInt(input.next());
        myList.buildList(numOfNodes);
        myList.showList(myList.front);
        myList.textMenu();
    }

    public void textMenu() {
        boolean quit = false;
        while(!quit) {
            int numOfNodes;
            String data;
            Scanner input = new Scanner(System.in);
            System.out.println("\nEnter new number of nodes or q to quit:");
            data = input.next();
            if (data.equals("q")) {
                quit = true;
            } else {
                numOfNodes = Integer.parseInt(data);
                MyList myList = new MyList();
                myList.buildList(numOfNodes);
                myList.showList(myList.front);
            }
        }
    }

    public void buildList(int n) {
        int j;
        node tail;
        MyList myList = new MyList();
        myList.init();
        for (j=0;j<n;j++) {
            if (j==0) {
                front = makeNode(j);
            } else {
                tail = findTail(front);
                tail.next = makeNode(j);
            }
        }
    }

    public void init() {
        front = null;
    }

    public node makeNode(int n) {
        node newNode;
        newNode = new node();
        newNode.num = n;
        newNode.next = null;
        return newNode;
    }

    public node findTail(node front) {
        node current, tail;
        current = front;
        while (current.next != null) {
            current = current.next;
        }
        tail = current;
        return tail;
    }

    public void addNodeAtEndOfList(node spot, int data) {
        node tail;
        if (front==null) {
            front = makeNode(data);
        } else {
            tail = findTail(front);
            tail.next = makeNode(data);
        }
    }

    public void showList(node front) {
        int count = 0;
        node current;
        current = front;
        System.out.println("Linked List:");
        System.out.print("front -->");
        while (current!=null) {
            System.out.print(" [ " + current.num + " ][] -->");
            current = current.next;
            if (count==10)
            {
                System.out.print("\n\n\t\t ");
                count = 0;
            }
            count++;
        }
        System.out.print(" null");
    }
}