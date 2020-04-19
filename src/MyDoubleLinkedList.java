public class MyDoubleLinkedList{
	private DoubleLinkedNode first;
	private DoubleLinkedNode last;
	private int size;

	public MyDoubleLinkedList(){
		this.first = null;
		this.last = null;
		size = 0;
	}

	public void insertFront(Integer num){
		DoubleLinkedNode tmp = new DoubleLinkedNode(num, null, this.first);
		if(!this.isEmpty()){
			this.first.setPrevious(tmp);
		}
		else{
			this.last = tmp;
		}
		this.first = tmp;
		this.size++;
	}

	public void insertEnd(Integer num){
		if(!this.isEmpty()){
			DoubleLinkedNode tmp = new DoubleLinkedNode(num, this.last, null);
			this.last.setNext(tmp);
			this.last = tmp;
			this.size++;
		}
		else{
			this.insertFront(num);
		}
	}

	public Integer extractFront(){
		if(!this.isEmpty()){
			Integer info = this.first.getInfo();
			this.first = this.first.getNext();
			if(!this.isEmpty()){
				this.first.setPrevious(null);
			}
			else{
				this.last = null;
			}
			this.size--;
			return info;
		}
		else{
			return null;
		}
	}

	public Integer extractEnd(){
		if(this.last != null){
			Integer info = this.last.getInfo();
			this.last = this.last.getPrevious();
			if(this.last != null){
				this.last.setNext(null);
			}
			else{
				this.first = null;
			}
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
			if(index <= (size/2)){
				DoubleLinkedNode tmp = this.first;
				for(int i = 1; i < index; i++){
					tmp = tmp.getNext();
				}
				Integer info = tmp.getInfo();
				return info;
			}
			else{
				DoubleLinkedNode tmp = this.last;
				for(int i = size; i > index; i--){
					tmp = tmp.getPrevious();
				}
				Integer info = tmp.getInfo();
				return info;
			}
		}
		else{			
			return null;
		}
	}
	
	public int indexOf(Integer num){
		DoubleLinkedNode tmp = this.first;
		int pos = 1;
		while(pos <= this.size){
			if(tmp.getInfo() == num){
				return pos;
			}
			else{
				tmp = tmp.getNext();
				pos++;
			}
		}
		return -1;
	}
}