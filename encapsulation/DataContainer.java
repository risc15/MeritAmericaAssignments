public class DataContainer {
	private String containerName;
	private int containerInt;
	private double containerDouble;

	public DataContainer(String containerName, int containerInt, double containerDouble) {
		this.containerName = containerName;
		this.containerInt = containerInt;
		this.containerDouble = containerDouble;
		System.out.println("Container: " + containerName + " created.");
	}

	// Get methods:

	public String getContainerName() {
		return this.containerName;
	}

	public int getContainerInt() {
		return this.containerInt;
	}

	public double getContainerDouble() {
		return this.containerDouble;
	}

	// Set methods:
	
	public void setContainerName(String newName) {
		String oldName = this.containerName; // Store old name.
		this.containerName = newName;
		System.out.println("Container: " + oldName + ", renamed to: " + newName + ".");
	}

	public void setContainerInt(int newInt) {
		this.containerInt = newInt;
		System.out.println("Container integer now contains: " + newInt + ".");
	}

	public void setContainerDouble(double newDouble) {
		this.containerDouble = newDouble;
		System.out.println("Container double now contains: " + newDouble + ".");
	}

}
