public class Element<E extends Comparable<? super E>> implements ElementInterface<E>{
	
	private E data;
	
	public Element(E initData) {
		data = initData;
	}
	
	public E getData() {
		return data;
	}
	
	@Override
	public String toString() {
		return data.toString();
	}
}
