public class Encapsulation {
	public static void main(String[] args) {
		System.out.println("This program demonstrates the idea of encapsulation.");

		// Create a new DataContainer
		DataContainer myPod = new DataContainer("Rod's Container", 255, 3.14);

		myPod.setContainerName("Cool Pod");
		System.out.println(myPod.getContainerName());
		System.out.println(myPod.getContainerInt());

		myPod.setContainerInt(1337);
		myPod.setContainerDouble(0.3333333);

		System.out.println(2 + 3 + "bc");
	}
}
