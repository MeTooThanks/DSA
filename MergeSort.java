public class MergeSort<E extends Comparable<? super E>> implements MergeSortInterface<E> {
	@SuppressWarnings("unchecked")
	public void sort(Object[] toSort) {
		if (toSort.length >= 2) {
			//splits the array
			ElementInterface<E>[] left = new Element[(int)Math.ceil(toSort.length/2d)];		
			ElementInterface<E>[] right = new Element[toSort.length/2];
			System.arraycopy(toSort, 0, left, 0, left.length);
			System.arraycopy(toSort, left.length, right, 0, right.length);
			
			//recursive call on subarrays
			sort(left);
			sort(right);
			
			//bubble(toSort);
			
			//merges
			int leftPointer = 0, rightPointer = 0;
			while (true) {
				if ((leftPointer+rightPointer) == toSort.length)
					break;
				
				if (leftPointer == left.length) {
					toSort[leftPointer+rightPointer] = right[rightPointer];
					rightPointer++;
				}
				else if (rightPointer == right.length) {
					toSort[leftPointer+rightPointer] = left[leftPointer];
					leftPointer++;
				}
				else if (((ElementInterface<E>) left[leftPointer]).getData().compareTo
						(((ElementInterface<E>) right[rightPointer]).getData()) < 0)
				{
					toSort[leftPointer+rightPointer] = left[leftPointer];
					leftPointer++;
				} else {
					toSort[leftPointer+rightPointer] = right[rightPointer];
					rightPointer++;
				}
			}
		}
	}
	
	@SuppressWarnings({ "unchecked", "unused" })
	private void bubble(Object[] toSort) {
		for (int i = 0; i < toSort.length-1; i++) {
			if (((ElementInterface<E>) toSort[i]).getData().compareTo
			   (((ElementInterface<E>) toSort[i+1]).getData()) > 0) 
			{
				ElementInterface<E> tempElem = (ElementInterface<E>) toSort[i];
				toSort[i] = toSort[i+1];
				toSort[i+1] = tempElem;
				i = 0;
			}
		}
	}
}
