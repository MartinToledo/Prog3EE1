public class DoubleLinkedNode{
	private Integer info;
	private DoubleLinkedNode previous;
	private DoubleLinkedNode next;

	public DoubleLinkedNode(){
		this.info = null;
		this.next = null;
		this.previous = null;
	}

	public DoubleLinkedNode(Integer num, DoubleLinkedNode DNP, DoubleLinkedNode DNN){
		this.setInfo(num);
		this.setPrevious(DNP);
		this.setNext(DNN);
	}

	public DoubleLinkedNode getPrevious(){
		return previous;
	}

	public void setPrevious(DoubleLinkedNode DNP){
		this.previous = DNP;
	}

	public DoubleLinkedNode getNext(){
		return next;
	}

	public void setNext(DoubleLinkedNode DNN){
		this.next = DNN;
	}

	public Integer getInfo(){
		return info;
	}

	public void setInfo(Integer info){
		this.info = info;
	}
}