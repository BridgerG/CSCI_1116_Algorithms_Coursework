package chapter20_21;


import java.util.Comparator;

public class Exercise20_21 {
  public static void main(String[] args) {
    GeometricObject[] list = {new Circle(5), new Rectangle(4, 5),
        new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5), 
        new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
        new Circle(6.5), new Rectangle(4, 5)};
    
    //selectionSort(list, new GeometricObjectComparator());
    //for (int i = 0; i < list.length; i++)
     // System.out.println(list[i].getArea() + " ");

    Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
      new Circle(5), new Circle(6), new Circle(1), new Circle(2),
      new Circle(3), new Circle(14), new Circle(12)};
    selectionSort(list1, new GeometricObjectComparator());
    for (int i = 0; i < list1.length; i++)
      System.out.println(list1[i].getArea() + " ");
  }
  
  public static <E> void selectionSort(E[] list, Comparator<? super E> comparator) {
	  
	  int num = 0, error = 0;
	  
	  for(int i = 0; i < (list.length - 2) * list.length - 1; i++) {
		  
		  if (comparator.compare(list[num], list[num + 1]) == -1) {
		  
			Object ob = list[num];
		  	list[num] = list[num + 1];
		  	list[num + 1] = (E) ob;
		  	error++;
		  
		  }
		  
		  num++;
		  if (num == list.length - 1) {
			  
			  num = 0;
			  
			  if (error == 0) {
				  
				  break;
			  }
			  
			  error = 0;
		  }
	  }
  }

}