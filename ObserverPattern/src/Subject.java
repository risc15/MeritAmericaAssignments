public interface Subject {
	public void notifyObservers();
	void registerObserver(Observer observer);
	void removeObserver(Observer observer);
}