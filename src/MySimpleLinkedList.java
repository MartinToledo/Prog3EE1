//import java.util.Iterator;

public class MySimpleLinkedList implements Iterable<Integer>{
	private Node first;
	private int size;

	public MySimpleLinkedList(){
		this.first = null;
		size = 0;
	}

	public void insertFront(Integer num){
		Node tmp = new Node(num, this.first);
		this.first = tmp;
		this.size++;
	}

	public Integer extractFront(){
		if(!this.isEmpty()){
			Integer info = this.first.getInfo();
			this.first = this.first.getNext();
			this.size--;
			return info;
		}
		else{
			return null;
		}
	}

	public boolean isEmpty(){
		if(this.first != null){
			return false;
		}
		else{			
			return true;
		}
	}

	public int size(){
		return size;
	}

	public Integer get(int index){
		if(size >= index){
			Node tmp = this.first;
			for(int i = 1; i < index; i++){
				tmp = tmp.getNext();
			}
			Integer info = tmp.getInfo();
			return info;
		}
		else{			
			return null;
		}
	}
	
	public int indexOf(Integer num){
		Node tmp = this.first;
		int pos = 1;
		while(pos <= this.size){
			if(tmp.getInfo().equals(num)){
				return pos;
			}
			else{
				tmp = tmp.getNext();
				pos++;
			}
		}
		return -1;
	}
	
	public MyIterator iterator(){
		return new MyIterator(1, this.size, this.first);
	}
}