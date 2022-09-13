package startrek;

import java.util.Random;

public class Galaxy {
	Quadrant[][] quadrant = new Quadrant[8][8];
	static Enterprise enterprise = new Enterprise();
	Random rand = new Random();
	// which quad has enterprise
	// in quadrant sectorx and sectorY
	int quadX;
	int quadY;
	int klingons;
	int stars;
	int starbases;

	Galaxy() {
		for (int row = 0; row < quadrant.length; row++) {
			for (int col = 0; col < quadrant.length; col++) {
				quadrant[row][col] = new Quadrant();
			}
		}
		klingons = rand.nextInt(25);
		// number of klingons in galaxy
		starbases = rand.nextInt(25);
		stars = rand.nextInt(25);
		placeItem(Placeable.KLINGON, klingons);
		// passing in type and number of type
		placeItem(Placeable.STARBASE, starbases);
		placeItem(Placeable.STAR, stars);
		placeItem(Placeable.ENTERPRISE, 1);
	}

	public Placeable currentQuad() {
		for (int qx = 0; qx < quadrant.length; qx++)
			for (int qy = 0; qy < quadrant.length; qy++)
				for (int row = 0; row < quadrant.length; row++) {
					for (int col = 0; col < quadrant.length; col++) {
						if (quadrant[qx][qy].sector[row][col] instanceof Enterprise) {
							quadX = qx;
							quadY = qy;
							return quadrant[quadX][quadY].sector[row][col];
						}
					}
				}
		return null;
	}

	public void moveEnterprise(int qX, int qY, int x, int y) {
		quadrant[qX][qY].sector[x][y] = Galaxy.enterprise;
		qX = quadX;
		qY = quadX;
	}

	public void placeItem(int type, int n) {
		int qx;
		int qy;
		int sx;
		int sy;
		for (int i = 0; i < n; i++) {
			boolean placed = false;
			while (placed != true) {
				qx = rand.nextInt(8);
				qy = rand.nextInt(8);
				sx = rand.nextInt(8);
				sy = rand.nextInt(8);
				if (quadrant[qx][qy].sector[sx][sy] == null) {
					placed = true;
					if (type == Placeable.KLINGON) {
						Klingon klingon = new Klingon();
						quadrant[qx][qy].sector[sx][sy] = klingon;
					} else if (type == Placeable.ENTERPRISE) {
						quadrant[qx][qy].sector[sx][sy] = Galaxy.enterprise;
					} else if (type == Placeable.STAR) {
						Star star = new Star();
						quadrant[qx][qy].sector[sx][sy] = star;
					} else if (type == Placeable.STARBASE) {
						Starbase starbase = new Starbase();
						quadrant[qx][qy].sector[sx][sy] = starbase;
					}
				}
			}
		}
	}
}
