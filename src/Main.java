import java.util.ArrayList;

public class Main{
	public static void main(String[]args){
		MySimpleLinkedList lista1 = new MySimpleLinkedList();
		lista1.insertFront(28);
		lista1.insertFront(14);
		lista1.insertFront(19);
		lista1.insertFront(7);
		lista1.insertFront(2);
		lista1.insertFront(2);
		lista1.insertFront(5);
		lista1.insertFront(3);
		ArrayList<MyDoubleLinkedList> subSecuencias = obtenerSubsecuencias(lista1, 2);
		for(int i = 0; i < subSecuencias.size(); i++){
			MyDoubleLinkedList subSecuencia = subSecuencias.get(i);
			System.out.println("Sub-secuencia " + (i+1) + ":");
			for(int e = 1; e <= subSecuencia.size(); e++){
				System.out.print("| " + subSecuencia.get(e) + " |");
			}
			System.out.println();
		}
	}

	public static ArrayList<MyDoubleLinkedList> obtenerSubsecuencias(MySimpleLinkedList Lista, int tamMinSubSec){
		ArrayList<MyDoubleLinkedList> subSecuencias = new ArrayList<MyDoubleLinkedList>();
		MyDoubleLinkedList subSecuencia = new MyDoubleLinkedList();
		MyIterator itLista = Lista.iterator();
		while(itLista.hasNext()){
			Integer valorAInsertar = itLista.next();
			Integer siguienteValor = itLista.get();
			subSecuencia.insertEnd(valorAInsertar);
			if((siguienteValor == null) || (valorAInsertar >= siguienteValor)){
				if(subSecuencia.size() >= tamMinSubSec){
					subSecuencias.add(subSecuencia);
				}
				subSecuencia = new MyDoubleLinkedList();
			}
		}
		return subSecuencias;
	}

	public static MySimpleLinkedList findCommonItemsInUnorderedLists(MySimpleLinkedList Lista1, MySimpleLinkedList Lista2){
		MySimpleLinkedList elementosEnComun = new MySimpleLinkedList();
		int lista1Tamanio = Lista1.size();
		int pivot = 2147483647;
		for(int i = 1; i <= lista1Tamanio; i++){
			MyIterator itLista1 = Lista1.iterator();
			int maxList1 = -2147483648;
			for(int e = 1; e <= lista1Tamanio; e++){
				if((itLista1.get() > maxList1) && (itLista1.get() < pivot)){
					maxList1 = itLista1.next();
				}
				else{
					itLista1.next();
				}
			}
			pivot = maxList1;
			if(Lista2.indexOf(pivot) != -1){
				elementosEnComun.insertFront(pivot);
			}
		}
		return elementosEnComun;
	}

	public static MySimpleLinkedList findCommonItemsInOrderedLists(MySimpleLinkedList Lista1, MySimpleLinkedList Lista2){
		MySimpleLinkedList elementosEnComun = new MySimpleLinkedList();
		MyIterator itLista1 = Lista1.iterator();
		MyIterator itLista2 = Lista2.iterator();
		while(itLista1.hasNext() && itLista2.hasNext()){
			if(itLista1.get().equals(itLista2.get())){
				elementosEnComun.insertFront(itLista1.next());
				itLista2.next();
			}
			else if(itLista1.get() < itLista2.get()){
				itLista1.next();
			}
			else{
				itLista2.next();
			}
		}
		return elementosEnComun;
	}

	public static MySimpleLinkedList itemsInList1ThatAreNotInList2(MySimpleLinkedList Lista1, MySimpleLinkedList Lista2){
		MySimpleLinkedList elementosEnLista1QueNoEstanEnLista2 = new MySimpleLinkedList();
		MyIterator itLista1 = Lista1.iterator();
		MyIterator itLista2 = Lista2.iterator();
		while(itLista1.hasNext() || itLista2.hasNext()){
			if((itLista2.get() == null) || (itLista1.get() < itLista2.get())){
				elementosEnLista1QueNoEstanEnLista2.insertFront(itLista1.next());
			}
			else if((itLista1.get() == null) || (itLista1.get() > itLista2.get())){
				elementosEnLista1QueNoEstanEnLista2.insertFront(itLista2.next());
			}
			else{
				itLista1.next();
				itLista2.next();
			}
		}
		return elementosEnLista1QueNoEstanEnLista2;
	}
}