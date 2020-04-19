public class Node{
	private Integer info;
	private Node next;

	public Node(){
		this.info = null;
		this.next = null;
	}

	public Node(Integer num, Node N){
		this.setInfo(num);
		this.setNext(N);
	}

	public Node getNext(){
		return next;
	}

	public void setNext(Node N){
		this.next = N;
	}

	public Integer getInfo(){
		return info;
	}

	public void setInfo(Integer info){
		this.info = info;
	}
}