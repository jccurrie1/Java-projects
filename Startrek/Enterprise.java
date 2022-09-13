
import java.util.concurrent.ThreadLocalRandom;

public class Enterprise extends Ship {
	int energy = 500;
	int torpedoes = 5;
	int hull = 500;
	int[] system = new int[6];
	public static int WARP_ENGINES = 0;
	public static final int SHORT_RANGE_SENSORS = 0;
	public static final int LONG_RANGE_SENSORS = 0;
	public static final int PHASER_CONTROL = 0;
	public static final int PHOTON_TUBES = 0;
	public static final int SHIELD_CONTROL = 0;
	int min = 5;
	int max = 6;

	Enterprise() {
		system[0] = system[WARP_ENGINES] = 100;
		system[1] = system[SHORT_RANGE_SENSORS] = 100;
		system[2] = system[LONG_RANGE_SENSORS] = 100;
		system[3] = system[PHASER_CONTROL] = 100;
		system[4] = system[PHOTON_TUBES] = 100;
		system[5] = system[SHIELD_CONTROL] = 100;
	}

	public void takeDamage(int damage) {
		if (shields >= damage) {
			shields = shields - damage;
		} else {
			hull = (hull + shields) - damage;
			shields = 0;
		}
	}

	public void decEnergy(int energyExpended) {
		energy = energy - energyExpended;
	}

	public void decTorpedoes() {
		torpedoes--;
	}

	public boolean isDestroyed() {
		if (hull <= 0) {
			return true;
		}
		return false;
	}

	public void repair() {
		int heal = ThreadLocalRandom.current().nextInt(min, max + 1);
		if (hull < 500) {
			hull = hull + heal;
			if (hull > 500) {
				hull = 500;
			}
		}
	}

	public void dock() {
		hull = 500;
		torpedoes = 5;
		energy = 500;
	}
}
