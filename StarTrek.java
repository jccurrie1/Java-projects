package startrek;

import java.util.Scanner;

public class StarTrek {
	View view = new View();
	Galaxy galaxy = new Galaxy();
	Scanner sc = new Scanner(System.in);
	int stardate = 2260;
	int endStardate = 2288;
	Quadrant quadrant = new Quadrant();
	Klingon klingon = new Klingon();
	boolean gameOver;

	public void damage() {
		view.damage();
	}

	public void destruct() {
		view.destruct();
	}

	public void impulse() {
		view.impulse(galaxy.currentQuad(), galaxy.quadrant[galaxy.quadX][galaxy.quadY].locateEnterprise(), quadrant,
				galaxy);
		stardate++;
	}

	public void lrs() {
		view.lrs(galaxy.currentQuad(), galaxy.quadrant[galaxy.quadX][galaxy.quadY].locateEnterprise(),
				galaxy.quadrant[galaxy.quadX][galaxy.quadY].getKBS(), quadrant, galaxy);
	}

	public void map() {
		view.map(galaxy.currentQuad(), galaxy.quadrant[galaxy.quadX][galaxy.quadY].locateEnterprise(),
				galaxy.quadrant[galaxy.quadX][galaxy.quadY].getKBS(), quadrant, galaxy);
	}

	public void phaser() {
		view.phaser(galaxy.currentQuad(), galaxy.quadrant[galaxy.quadX][galaxy.quadY].hasKlingon(), quadrant, galaxy);
	}

	public void ping() {
		view.ping(galaxy.currentQuad(), galaxy.quadrant[galaxy.quadX][galaxy.quadY].locateEnterprise(),
				galaxy.quadrant[galaxy.quadX][galaxy.quadY].hasKlingon(), quadrant, galaxy);
	}

	public void shields() {
		view.shields();
	}

	public void srs() {
		view.srs(galaxy.currentQuad(), galaxy.quadrant[galaxy.quadX][galaxy.quadY].locateEnterprise(), galaxy, stardate,
				endStardate, quadrant);
	}

	public void torpedo() {
		view.torpedo(galaxy.currentQuad(), galaxy.quadrant[galaxy.quadX][galaxy.quadY].hasKlingon(), galaxy);
	}

	public void warp() {
		view.warp(galaxy.currentQuad(), galaxy.quadrant[galaxy.quadX][galaxy.quadY].locateEnterprise(), quadrant,
				galaxy);
		stardate++;
	}

	public void enemyTurn() {
		if (galaxy.quadrant[galaxy.quadX][galaxy.quadY].hasKlingon() == true) {
			for (int i = 0; i == quadrant.klingons; i++) {
				Galaxy.enterprise.takeDamage(klingon.fire());
			}
		}
	}

	public void displayOpening() {
		view.displayOpening(stardate, galaxy, endStardate);
	}

	public void executeCommand() {
		String[] words = view.getCommand();
		if (words[0].equalsIgnoreCase("IMPULSE")) {
			impulse();
		}
		if (words[0].equalsIgnoreCase("PHASER")) {
			phaser();
		}
		if (words[0].equalsIgnoreCase("TORPEDO")) {
			torpedo();
		}
		if (words[0].equalsIgnoreCase("WARP")) {
			warp();
		}
		if (words[0].equalsIgnoreCase("PING")) {
			ping();
		}
		if (words[0].equalsIgnoreCase("DAMAGE")) {
			damage();
		}
		if (words[0].equalsIgnoreCase("SHIELDS")) {
			shields();
		}
		if (words[0].equalsIgnoreCase("LRS")) {
			lrs();
		}
		if (words[0].equalsIgnoreCase("MAP")) {
			map();
		}
		if (words[0].equalsIgnoreCase("DESTRUCT")) {
			destruct();
			gameOver = true;
		}
	}

	public boolean isGameOver() {
		if (stardate >= endStardate) {
			return true;
		}
		if (Galaxy.enterprise.isDestroyed() == true) {
			return true;
		}
		return false;
	}

	public void gameLoop() {
		while (isGameOver() == false && gameOver == false) {
			srs();
			executeCommand();
			enemyTurn();
			isGameOver();
			if (galaxy.quadrant[galaxy.quadX][galaxy.quadY].isDocked() == true) {
				Galaxy.enterprise.dock();
			}
			Galaxy.enterprise.repair();
		}
	}

	public static void main(String[] args) {
		StarTrek game = new StarTrek();
		game.displayOpening();
		game.gameLoop();
	}
}
