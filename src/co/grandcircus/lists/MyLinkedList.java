package co.grandcircus.lists;

public class MyLinkedList implements MyList {

	// head is the first node in the list. if null, the list is empty.
	private Node head = null;
	// for convenience, keep track of how many items are in the list
	private int length = 0;
	
	@Override
	public void addAtBeginning(String data) {
		// add a new node and set it as the new head
		Node newNode = new Node(data);
		newNode.setNext(head);
		head = newNode;
		length++;
	}
	
	@Override
	public void removeFromBeginning() {
		// find the second node and set it as the new head
		head = head.getNext();
		length--;
	}
	
	@Override
	public void addAtEnd(String data) {
		// TODO You do this one.
		Node newNode = new Node(data);
		newNode.setNext(null);
		
		if(head == null) {
			head = newNode;
			return;
		}else {
			if(head != null) {
				Node lastNode = getNodeAt(length-1);
				lastNode.setNext(newNode);
				length++;
				
			}
		}
	}
	
	@Override
	public void removeFromEnd() {
		if (length < 2) {
			// The beginning is the end.
			removeFromBeginning();
		} else {
			// find the node right before the end.
			Node beforeTail = getNodeAt(length - 2);
			// set its next to null. This ends the list here.
			beforeTail.setNext(null);
			length--;
		}
	}
	
	@Override
	public String get(int index) {
		return getNodeAt(index).getData();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		// start at the head
		Node node = head;
		// follow the links between nodes until it reaches the end 
		while (node != null) {
			sb.append(node.toString());
			node = node.getNext();
		}
		return sb.toString();
	}
	
	@Override
	public int size() {
		return length;
	}
	
	private Node getNodeAt(int index) {
		// start at the head
		Node node = head;
		// follow the links between nodes until it counts off the right number
		for (int i = 0; i < index; i++) {
			if (node == null) {
				// In case we run out of nodes before we get up to the desired index, return null
				return null;
			}
			node = node.getNext();
		}
		return node;
	}
	
	@Override
	public boolean insertObject(int index, String data) {
		Node firstNode = getNodeAt(index - 1);
		Node newNode = new Node(data);
		Node lastNode = getNodeAt(index);

		if (index == 0) {
			newNode.setNext(head);
			head = newNode;
			length++;
			return true;
		} else {
			for (int i = 0; i < index; i++) {
				if (newNode == null) {
					return false;
				}
				firstNode.setNext(newNode);
				newNode.setNext(lastNode);
			}
			length++;
			return true;
		}
	}
	
	@Override
	public boolean removeObject(int index) {

		Node firstNode = getNodeAt(index - 1);
		Node newNode = new Node();
		Node lastNode = getNodeAt(index +1 );

		if (index < 0 || index >= length) {
			return false;
		}
		if (index == 0) {
			newNode = head;
			head = newNode.getNext();
		} else {
			for (int i = length; i >= index; i--) {
				if (newNode == null) {
					return false;
				}
				firstNode.setNext(lastNode);
			}
		}
		length--;
		return true;
	}


}
