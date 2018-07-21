package exercise.object;
//exercise4
public class DataOnly {
  int i;  
  double d;  
  boolean b; 
  public DataOnly(int i, double d, boolean b) {
	// TODO Auto-generated constructor stub
	  this.i= i;
	  this.d = d;
	  this.b = b;
  }
  
  @Override
public String toString() {
	return "DataOnly [i=" + i + ", d=" + d + ", b=" + b + "]";
}

public static void main(String[] args) {
	System.out.println(new DataOnly(4,5,false));
  }
}
