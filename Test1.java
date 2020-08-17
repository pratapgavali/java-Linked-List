// Linked list...
import java.util.Scanner;
//start Node class...
class Node{
	private int data;
	private Node next;
	
	//default constructor to initialize data and next...
	public Node(){
		data=0;
		next=null;
	}
	//parameterize constructor for 
	public Node(int d, Node n){
		data=d;
		next=n;
	}
	// to set new data...
	public void setData(int d){
		data=d;
	}
	// to set next...
	public void setNext(Node n){
		next=n;
	}
	//will return data...
	public int getData(){
		return(data);
	}
	// will return next of node...
	public Node getNext(){
		return(next);
	}
	
} // End of Node class...

//start of LinkedList class...

class LinkedList{
	private int size;
	private Node start;
	
	public LinkedList(){
		size=0;
		start=null;
	}
	
	public void insertAtFirst(int val){
		Node n;
		n=new Node();
		n.setData(val);
		n.setNext(start);
		start=n;
		size++;
	}
	
	public void insertAtLast(int val){
		Node n,t;
		n=new Node();
		n.setData(val);
		t=start;
		if(t==null){
			start=n;
		}
		else{
			while(t.getNext() !=null)
				t=t.getNext();
			t.setNext(n);
			
		}
		size++;
		
	}
	
	public void insertAtPos(int val,int pos){
		if(pos==1){
			insertAtFirst(val);
			
		}
		
		else if(pos==size+1){
				insertAtLast(val);
			}
		else if(pos>1 && pos<=size){
			Node n,t;
			n=new Node(val,null);
			t=start;
			for(int i=1;i<pos-1;i++)
				t=t.getNext();
			n.setNext(t.getNext());
			t.setNext(n);
			size++;
			
		}
			
		else{
			System.out.println("Insertion not possible at position");
		}	
	}
	
	
	public void deleteFirst(){
		if(start==null){
			System.out.println("List is already empty!");
		}
		else{
			start=start.getNext();
			size--;
		}
	}
	
	public void deleteLast(){
		if(start==null){
			System.out.println("list is already empty!");
		}
		else if(size==1){
			start=null;
			size--;
		}
		else{
			Node t;
			t=start;
			for(int i=1;i<size-1;i++)
				t=t.getNext();
			t.setNext(null);
			size--;
		}
	}
	
	public void deleteAtPos(int pos){
		if(start==null)
			System.out.println("List is already empty!");
		else if(pos<1||pos>size)
			System.out.println("Invalid position!");
		else if(pos==1)
			deleteFirst();
		else if(pos==size)
			deleteLast();
		
		else{
			Node t,t1;
			t=start;
			for(int i=1;i<pos-1;i++)
				t=t.getNext();
			
			t1=t.getNext();
			t.setNext(t1.getNext());
			size--;
			
			
		}
		
	}
	
	//to check if list empty...
	public boolean isEmpty(){
		if(start==null)
			return(true);
		else
			return(false);
	}
	
	public int getListSize(){
		return(size);
	}
	
	public void viewList(){
		Node t;
		if(isEmpty()){
			System.out.println("List is Empty");
		}
		
		else{
			t=start;
			for(int i=1;i<=size;i++){
				System.out.println(" "+t.getData());
				t=t.getNext();
			}
		}
	}
}

class Test1{
	public static void main(String [] args){
		
		Scanner in = new Scanner(System.in);
		LinkedList list = new LinkedList();
		int choice,position,val;
		boolean flag=true;
		while(flag){
			System.out.println(" \n");
			System.out.println("1.Add item to the list at first");
			System.out.println("2.Add item to the list at last");
			System.out.println("3.Add item to the list at position");
			System.out.println("4.Delete item from list at first position");
			System.out.println("5.Delete item from the list at last position");
			System.out.println("6.Delete item from the list at given position");
			System.out.println("7.View list");
			System.out.println("8.Exite");
			System.out.print("Enter your choice: ");
			choice=in.nextInt();
			
			switch(choice){
				case 1:
					System.out.println("Enter value of list");
					val = in.nextInt();
					list.insertAtFirst(val);
					break;
				case 2:
					System.out.println("Enter value of list");
					val = in.nextInt();
					list.insertAtLast(val);
					break;
					
				case 3:
					System.out.println("Enter position");
					position=in.nextInt();
					System.out.println("Enter value of list");
					val = in.nextInt();
					list.insertAtPos(val,position);
					break;
				case 4:
					list.deleteFirst();
					break;
				case 5:
					list.deleteLast();
					break;
				case 6:
					System.out.println("Enter position");
					position = in.nextInt();
					list.deleteAtPos(position);
					break;
				case 7:
					list.viewList();
					break;
				case 8:
					flag=false;
					break;
				default:
					System.out.println("Invslid choice!");
				
			}
			
			
		}
	}
}