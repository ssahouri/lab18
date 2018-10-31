package co.grandcircus.lists;


public class ListApp {

	public static void main(String[] args) {
		testArrayList();
		testLinkedList();
	}
	
	private static void testArrayList() {
		MyList list = new MyArrayList();
		
		list.addAtBeginning("B");
		list.addAtBeginning("A");
		list.addAtEnd("C");
		list.addAtEnd("D");
		list.removeFromBeginning();
		list.removeObject(2);
		list.insertObject(1, "A");
		
		System.out.println(list);
		System.out.println(list.size());
		System.out.println(list.get(0));
		System.out.println(list.get(1));
	}
	
	private static void testLinkedList() {
		MyList list = new MyLinkedList();
		
		list.addAtBeginning("B");
		list.addAtBeginning("A");
		list.addAtEnd("C");
		list.addAtEnd("D");
		list.removeFromBeginning();
		list.removeFromEnd();
		list.addAtEnd("Z");
		list.removeObject(2);
		list.insertObject(1, "A");
		
		
		System.out.println(list);
		System.out.println(list.size());
		System.out.println(list.get(0));
		System.out.println(list.get(1));
	}

}
