import java.util.ArrayList;

public class QuickSort<E extends Comparable<? super E>> implements QuickSortInterface<E> {
	
	@SuppressWarnings("unchecked")
	public void sort(Object[] toSort) {
		if (toSort.length <= 20)
			insertionSort(toSort);
		else if (toSort.length >= 2) {
			
			Element<E> pivot = (Element<E>) toSort[toSort.length-1];
			ArrayList<Object> smaller = new ArrayList<Object>();
			ArrayList<Object> bigger = new ArrayList<Object>();
			
			//puts the elements into the correct lists
			for (Object element : toSort) {
				if (((Element<E>)element).getData().compareTo(pivot.getData()) > 0)
					bigger.add(element);
				else if (element != pivot)
					smaller.add(element);
			}
			
			//sorts the list with the bigger elements and transfers them back into the array
			if (!bigger.isEmpty()) {
				Object[] sortedBigger = bigger.toArray();
				sort(sortedBigger);	
				System.arraycopy(sortedBigger, 0, toSort, smaller.size()+1, sortedBigger.length);
				toSort[0] = pivot;
			}
			
			//sorts the list with the smaller elements and transfers them back into the array
			if (!smaller.isEmpty()) {
				Object[] sortedSmaller = smaller.toArray();
				sort(sortedSmaller);
				System.arraycopy(sortedSmaller, 0, toSort, 0, sortedSmaller.length);
		  		toSort[sortedSmaller.length] = pivot;
			} 
		}
	}
	
	@SuppressWarnings("unchecked")
	private void insertionSort(Object[] toSort) {
		int k = 0;
		for (int i = 1; i < toSort.length; i++) {
			Element<E> currentElement = (Element<E>) toSort[i];
			for (k = i; k > 0 && ((Element<E>) toSort[k-1]).getData().compareTo(currentElement.getData()) > 0; k--) 
				toSort[k] = toSort[k-1];
			toSort[k] = currentElement;
		}
	}
}
