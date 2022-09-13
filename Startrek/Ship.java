package startrek;

public abstract class Ship extends Placeable {
	int shields = 50;

	public void decShields(int  damage) {
		
	}

	public void increaseShields() {
	}

	public abstract void takeDamage(int damage);
		
}
