/*==============ATTEMPT 2==============*/
/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as: 
    class Node {
        int data;
        Node next;
    }
*/
/*Idea:
If list is empty, head will be null.
if ever null, hasCycle=false. can always node.next.next...
[1];->[1]; check if node==null
[1]->[2];->[1]->[2]; check if node ==null and node.next == null
[1]->[2]->[3];->[1]->[2]->[3]; which means can see if current and next is null and that I can check next.next aka 3rd; 
an end node can point to any existing node.
	end node is last unique node.
	no mid node can create cycle (due to only having one pointer)
	1st occurrence of a loop is the end node, cannot proceed to the right since can only have one next node.
can use the next.next way to find if a loop occurs between last two nodes, but this does not help if last node points to 1st node in a list of about > 3.
*/
boolean hasCycle(Node head) {
    HashSet <Node> h = new HashSet <Node> ();
	//int count = 0; //&& count < 100
	Node node = head;
	while ( node != null ){
		if ( h.contains(node) ){
			return true;
		}else{
			h.add(node);
			node = node.next;
			//count++;
		}
	}
	return false;
}
/*IMPORTANT SUMMARY NOTES!
for some reason, if I had the below code outside the hasCycle function, would give me slightly different results. 
This is most likely due to the fact that the test script is creating a new call and not directly with the class that creates it or a new class and/or call. (in this case class A).
tried using static, but still had problem. This must mean a it is due to the function. if multiple classes were made, data should be shared among them.
    HashSet <Node> h = new HashSet <Node> ();
*/
/*===============================================================*/
/*===============================================================*/
/*===============================================================*/
/*==============ATTEMPT 1==============*/
/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as: 
    class Node {
        int data;
        Node next;
    }
*///
public class Solution {
    //variables
    //boolean bool = true;
    //ArrayList a = new ArrayList();
    Node node = null;
    HashSet <Integer> h = new HashSet <Integer> ();
    //HashTable <Integer, Integer> h = new HashTable <Integer, Integer>; //data, frequency
    //methods
    boolean hasCycle(Node head) {
        node = head;
        //h.add(node.data);//just add the first one //node = node.next; //get to the next one where we, at 2nd best case, will Find Cycle
        while (node.next != null){
            if ( h.contains(node.data) ){
                return true;
            }else {
                h.add(node.data);
            }
            node = node.next;
        }
        return false;
    }//hasCycle
}//Solution
/*Self Notes:
linked list contains a cycle if a node visited > 1, while traversing.
param: pointer to a node, 'head', that points to head of linked list.
func: returns a Boolean, showing if there is a cycle.
Note: if list = empty, head = null.
input: none.
list size = [0,100]
output: true/false

a linked list will be passed as args to your function.
ex: 
case1 = linked list w/ 1 node(s) pointing to tail null. [1|head]->null
case2 = linked list w/ 3 node(s) pointing in a row, and 3rd points to 2nd. [1|head]->[2]->[3]__->[2]->[3]->[2]->[3]...
out: 
0
1
///
*/