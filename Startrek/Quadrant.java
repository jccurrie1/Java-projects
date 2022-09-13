package startrek;

public class Quadrant {
	Placeable[][] sector = new Placeable[8][8];
	int sectorX;
	int sectorY;
	int starbases = 0;
	int klingons = 0;
	int stars = 0;
	boolean hasBeenScanned = false;

	Quadrant() {
		for (int row = 0; row < sector.length; row++) {
			for (int col = 0; col < sector.length; col++) {
				sector[row][col] = null;
			}
		}
	}

	public boolean hasEnterprise() {
		for (int row = 0; row < sector.length; row++)
			for (int col = 0; col < sector[row].length; col++)
				if (sector[row][col] instanceof Enterprise) {
					return true;
				}
		return false;
	}
	
	public Placeable locateEnterprise() {
		for (int row = 0; row < sector.length; row++)
			for (int col = 0; col < sector.length; col++)
				if (sector[row][col] instanceof Enterprise) {
					sectorX = row;
					sectorY = col;
					return sector[sectorX][sectorY];
				}
		sectorX = -1;
		sectorY = -1;
		return null;
	}

	public String getKBS() {
		String kbs = klingons + "" + starbases + "" + stars + "";
		for (int row = 0; row < sector.length; row++) {
			for (int col = 0; col < sector[row].length; col++) {
				if (sector[row][col] instanceof Klingon) {
					klingons = + 1;
				} 
				if (sector[row][col] instanceof Starbase) {
					starbases = + 1;
				}
				if (sector[row][col] instanceof Star) {
					stars = + 1;
				}
			}
		}
		return kbs;
	}

	public boolean isDocked() {
		for (int row = 0; row < sector.length; row++) {
			for (int col = 0; col < sector[row].length; col++) {
				if (sector[row][col] instanceof Starbase) {
					try {
						if (sector[row - 1][col - 1] instanceof Enterprise) {
							return true;
						}
					} catch (ArrayIndexOutOfBoundsException exception) {

					}
					try {
						if (sector[row - 1][col] instanceof Enterprise) {
							return true;
						}
					} catch (ArrayIndexOutOfBoundsException exception) {

					}
					try {
						if (sector[row - 1][col + 1] instanceof Enterprise) {
							return true;
						}
					} catch (ArrayIndexOutOfBoundsException exception) {

					}
					try {
						if (sector[row][col - 1] instanceof Enterprise) {
							return true;
						}
					} catch (ArrayIndexOutOfBoundsException exception) {

					}
					try {
						if (sector[row][col + 1] instanceof Enterprise) {
							return true;
						}
					} catch (ArrayIndexOutOfBoundsException exception) {

					}
					try {
						if (sector[row][col + 1] instanceof Enterprise) {
							return true;
						}
					} catch (ArrayIndexOutOfBoundsException exception) {

					}
					try {
						if (sector[row][col + 1] instanceof Enterprise) {
							return true;
						}
					} catch (ArrayIndexOutOfBoundsException exception) {

					}
					try {
						if (sector[row + 1][col - 1] instanceof Enterprise) {
							return true;
						}
					} catch (ArrayIndexOutOfBoundsException exception) {

					}
					try {
						if (sector[row + 1][col] instanceof Enterprise) {
							return true;
						}
					} catch (ArrayIndexOutOfBoundsException exception) {

					}
					try {
						if (sector[row + 1][col + 1] instanceof Enterprise) {
							return true;
						}
					} catch (ArrayIndexOutOfBoundsException exception) {

					}
				} 
			}
		}
		return false;
	}

	public boolean hasKlingon() {
		for (int row = 0; row < sector.length; row++)
			for (int col = 0; col < sector[row].length; col++)
				if (sector[row][col] instanceof Klingon) {
					return true;
				}
		return false;
	}

	/*
	 * public Placeable[][] putStar(int sx, int sy) { sector[sx][sy] = new Star();
	 * return sector; }
	 * 
	 * public Placeable[][] putStarbase(int sx, int sy) { sector[sx][sy] = new
	 * Starbase(); return sector; }
	 */

	public void moveEnterprise(int x, int y) {
		// move enterprise here
		sector[x][y] = Galaxy.enterprise;
		hasBeenScanned = true;
	}

	public void removeEnterprise() {
		sector[sectorX][sectorY] = null;
	}

	public void removeKlingon(int x, int y) {
		sector[x][y] = null;
	}

	public boolean hasBeenScanned() {
		return hasBeenScanned;
	}

	public void setScan() {
		hasBeenScanned = true;
	}
}
