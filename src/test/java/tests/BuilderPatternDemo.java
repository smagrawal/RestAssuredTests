package tests;

public class BuilderPatternDemo {

	public BuilderPatternDemo fetchName() {
		System.out.println("Method fetchName");
		return this;
	}

	public BuilderPatternDemo fetchCity() {
		System.out.println("Method fetchCity");
		return this;
	}

	public BuilderPatternDemo fetchNumber() {
		System.out.println("Method fetchNumber");
		return this;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BuilderPatternDemo obj = new BuilderPatternDemo();
		obj.fetchName().fetchCity().fetchNumber();

	}

}
