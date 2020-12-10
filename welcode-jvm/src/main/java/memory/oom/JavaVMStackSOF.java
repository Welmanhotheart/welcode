package memory.oom;

public class JavaVMStackSOF {
	private int stackLength = 1;
	
	public void stackLeak() {
		stackLength ++;
		stackLeak();
	}

	public static void main(String[] args) throws Throwable {
		JavaVMStackSOF vmStackSOF = new JavaVMStackSOF();
		try {
			vmStackSOF.stackLeak();
		} catch(Throwable e) {
			System.out.println("stack lenght:" + vmStackSOF.stackLength);
			throw e;
		}
	}
}

// -Xss128k