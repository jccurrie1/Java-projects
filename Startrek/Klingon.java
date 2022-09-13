package startrek;

import java.util.concurrent.ThreadLocalRandom;

public class Klingon extends Ship {
	int hull = 10;
	int energy = 20;
	final int max = energy;
	final int min = 1;
	int health = hull +  shields;

	@Override
	public void takeDamage(int damage) {
		if (damage >= shields) {
			int hullDamage = damage - shields;
			hull = hull - hullDamage;
			health = (shields + hull) - damage;
			shields = 0;
		} else {
			shields = shields - damage;
			health = shields + hull;
		}
	}

	public int fire() {
		if (energy <= 0) {
			return 0;
		} else {
			int damage = ThreadLocalRandom.current().nextInt(min, max + 1);
			return damage;
		}
	}

}
