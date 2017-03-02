public class QuickSortInPlace<E extends Comparable<? super E>> implements QuickSortInPlaceInterface<E> {
	private Object[] toSort;
	
	@SuppressWarnings("unchecked")
	private void order(int start, int end) {
		if (end-start > 1) {
			Element<E> pivot = (Element<E>) toSort[end-1];
			
			//in-place ordering
			for (int j = start; j < end-1; j++) {
				if (((Element<E>)toSort[j]).getData().compareTo(pivot.getData()) < 0) {
					Object temp = toSort[j];
					toSort[j] = toSort[start];
					toSort[start] = temp;
					start++;
				}
			}
			for (int j = end-1; j > start; j--) {
				toSort[j] = toSort[j-1];
				toSort[j-1] = pivot;
			}
			
			//recursive calls on subsequences
			order(0, start);
			order(start+1, end);
		}
	}
	
	public void sort(Object[] initToSort) {
		toSort = initToSort;
		order(0, toSort.length);
	}
}
