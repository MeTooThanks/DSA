import java.util.ArrayList;

public class TestMerge {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		/*
		Element<Integer> elem1 = new Element<Integer>(1);
		Element<Integer> elem2 = new Element<Integer>(2);
		Element<Integer> elem3 = new Element<Integer>(3);
		Element<Integer> elem4 = new Element<Integer>(4);
		Element<Integer> elem5 = new Element<Integer>(5);
		Element<Integer> elem6 = new Element<Integer>(6);
		Element<Integer> elem7 = new Element<Integer>(7);
		Element<Integer> elem8 = new Element<Integer>(8);
		Element<Integer> elem9 = new Element<Integer>(9);
		
		//MergeSort
		Object[] elements = {elem3, elem2, elem5, elem1, elem6, elem7, elem4};
		
		System.out.println("MergeSort:");
		
		for (int i = 0; i < elements.length; i++) {
			System.out.print(((Element<Integer>)elements[i]).toString());
		}
		System.out.println("\n");
		
		MergeSortInterface<Integer> sorter = new MergeSort<Integer>();
		
		sorter.sort(elements);
		
		for (int i = 0; i < elements.length; i++) {
			System.out.print(((Element<Integer>)elements[i]).toString());
		}
				
		//QuickSort
		Object[] elementsSec = {elem3, elem5, elem1, elem6,elem7, elem4, elem8, elem9, elem2};
		*/

		System.out.println("\n\nQuickSort:");
		
		/*for (int i = 0; i < elementsSec.length; i++) {
			System.out.print(((Element<Integer>)elementsSec[i]).toString());
		}
		System.out.println("\n");
		*/
		
		QuickSortInPlace<Integer> quicksorter = new QuickSortInPlace<Integer>();
		
		Object[] toSort = new Object[250000];
		
		for (int i = 0; i < toSort.length; i++) {
			toSort[i] = new Element<Integer>((int)(Math.random()*10000));
		}
		
		quicksorter.sort(toSort);
		
		for (int i = 0; i < toSort.length; i++) {
			System.out.print(((Element<Integer>)toSort[i]).toString() +" ");
			if (i % 15 == 0)
				System.out.print("\n");
		}
		
		
	}
}
