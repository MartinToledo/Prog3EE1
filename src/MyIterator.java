import java.util.Iterator;

public class MyIterator implements Iterator<Integer>{
	private int pos;
	private int listSize;
	private Node nodoTmp;

	public MyIterator(int posInicio, int size, Node NodoInicio){
		pos = posInicio;
		listSize = size;
		nodoTmp = NodoInicio;
	}

	public boolean hasNext(){
		return pos <= listSize;
	}

	public Integer next(){
		if(this.hasNext()){
			Integer info = nodoTmp.getInfo();
			nodoTmp = nodoTmp.getNext();
			pos++;
			return info;
		}
		else{
			return null;
		}
	}
	
	public Integer get(){
		if(nodoTmp != null){				
			return nodoTmp.getInfo();
		}
		else{
			return null;
		}
	}
}