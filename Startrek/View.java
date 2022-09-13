package Startrek;

import java.util.Scanner;

public class View {
	Scanner sc = new Scanner(System.in);
	//parseint instead of nextline
	public void shields() {
		System.out.println("You currently have " + Galaxy.enterprise.energy + " Energy availiable and "
				+ Galaxy.enterprise.shields
				+ " energy in Shields.\n\nWhat would you like to do with the shield Energy? Raise, Lower or Nothing?");
		String raiseOrLower = sc.nextLine();
		if (raiseOrLower.equalsIgnoreCase("Raise")) {
			System.out.println("You have chosen to raise shields, how much would you like to raise it? You have "
					+ Galaxy.enterprise.energy + " Energy availiable right now.");
			int raiseShields = Integer.parseInt( sc.nextLine() );
			Galaxy.enterprise.decEnergy(raiseShields);
			Galaxy.enterprise.shields = Galaxy.enterprise.shields + raiseShields;
			System.out.println("You now have " + Galaxy.enterprise.energy + " energy available and "
					+ Galaxy.enterprise.shields + " energy in shields.");
		} else if (raiseOrLower.equalsIgnoreCase("Lower")) {
			System.out.println("You have chosen to lower shields, how much would you like to lower it? You have "
					+ Galaxy.enterprise.shields + " Energy in shields right now.");
			int lowerShields = Integer.parseInt( sc.nextLine() );
			Galaxy.enterprise.shields = Galaxy.enterprise.shields - lowerShields;
			Galaxy.enterprise.energy = Galaxy.enterprise.energy + lowerShields;
			System.out.println("You now have " + Galaxy.enterprise.energy + " energy available and "
					+ Galaxy.enterprise.shields + " energy in shields.");
		} else if (raiseOrLower.equalsIgnoreCase("Nothing")) {
			System.out.println("No Energy will be diverted");
		}
		System.out.println("\n");
	}

	public void damage() {
		//System.out.println("Damage report:\n\nWarp Engines: " + Galaxy.enterprise.system[0]
		//		+ "%\n   Max speed 1 quadrant per stardate.\nShort Range Sensors: " + Galaxy.enterprise.system[1]
		//		+ "%\nLong Range Sensors: " + Galaxy.enterprise.system[2] + "%\nPhaser Control: "
		//		+ Galaxy.enterprise.system[3] + "%\n   Accuracy: %\nPhoton Tubes: " + Galaxy.enterprise.system[4]
		//		+ "%\n   Accuracy: %\nShield Control: " + Galaxy.enterprise.system[5] + "%\n   Max shield level: 75");
		System.out.println("Damage Report:\n\nShields: " + Galaxy.enterprise.shields + "\nHull: " + Galaxy.enterprise.hull + "\n");
	}

	public void lrs(Placeable placeable, Placeable placeable2, String string, Quadrant quadrant, Galaxy galaxy) {
		for (int row = 0; row < galaxy.quadrant.length; row++) {
			for (int col = 0; col < galaxy.quadrant[row].length; col++) {
					galaxy.quadrant[row][col].getKBS();
			}
		}
		StringBuilder lrs = new StringBuilder();
		Integer colSubOne = galaxy.quadY - 1;
		Integer colPlusOne = galaxy.quadY + 1;
		Integer rowSubOne = galaxy.quadX - 1;
		Integer rowPlusOne = galaxy.quadX + 1;
		String topLeft;
		String midLeft;
		String bottomLeft;
		String topMid;
		String mid = galaxy.quadrant[galaxy.quadX][galaxy.quadY].getKBS();
		String topRight;
		String midRight;
		String bottomMid;
		String bottomRight;
		if (colSubOne <= 0) {
			colSubOne = 0;
		}
		if (rowSubOne <= 0) {
			rowSubOne = 0;
		}
		if (colPlusOne >= 8) {
			colPlusOne = 0;
		}
		if (rowPlusOne >= 8) {
			rowPlusOne = 0;
		}
				try {
					topLeft = galaxy.quadrant[galaxy.quadX - 1][galaxy.quadY - 1].getKBS();
					galaxy.quadrant[galaxy.quadX - 1][galaxy.quadY - 1].setScan();
				} catch (ArrayIndexOutOfBoundsException exception) {
					topLeft = "N/A";
				}
				try {
					midLeft = galaxy.quadrant[galaxy.quadX][galaxy.quadY - 1].getKBS();
					galaxy.quadrant[galaxy.quadX][galaxy.quadY - 1].setScan();
				} catch (ArrayIndexOutOfBoundsException exception) {
					midLeft = "N/A";
				}
				try {
					bottomLeft = galaxy.quadrant[galaxy.quadX + 1][galaxy.quadY - 1].getKBS();
					galaxy.quadrant[galaxy.quadX + 1][galaxy.quadY - 1].setScan();
				} catch (ArrayIndexOutOfBoundsException exception) {
					bottomLeft = "N/A";
				}
				try {
					topMid = galaxy.quadrant[galaxy.quadX - 1][galaxy.quadY].getKBS();
					galaxy.quadrant[galaxy.quadX - 1][galaxy.quadY].setScan();
				} catch (ArrayIndexOutOfBoundsException exception) {
					topMid = "N/A";
				}
				try {
					topRight = galaxy.quadrant[galaxy.quadX - 1][galaxy.quadY + 1].getKBS();
					galaxy.quadrant[galaxy.quadX - 1][galaxy.quadY + 1].setScan();
				} catch (ArrayIndexOutOfBoundsException exception) {
					topRight = "N/A";
				}
				try {
					midRight = galaxy.quadrant[galaxy.quadX][galaxy.quadY + 1].getKBS();
					galaxy.quadrant[galaxy.quadX][galaxy.quadY + 1].setScan();
				} catch (ArrayIndexOutOfBoundsException exception) {
					midRight = "N/A";
				}
				try {
					bottomMid = galaxy.quadrant[galaxy.quadX + 1][galaxy.quadY].getKBS();
					galaxy.quadrant[galaxy.quadX + 1][galaxy.quadY].setScan();
				} catch (ArrayIndexOutOfBoundsException exception) {
					bottomMid = "N/A";
				}
				try {
					bottomRight = galaxy.quadrant[galaxy.quadX + 1][galaxy.quadY + 1].getKBS();
					galaxy.quadrant[galaxy.quadX + 1][galaxy.quadY + 1].setScan();
				} catch (ArrayIndexOutOfBoundsException exception) {
					bottomRight = "N/A";
				}
				lrs.append("     " + colSubOne + "     " + galaxy.quadY + "     " + colPlusOne
						+ "\n  +-----+-----+-----+\n");
				lrs.append(rowSubOne + " | " + topLeft + " | " + topMid + " | " + topRight + " |\n");
				lrs.append("  +-----+-----+-----+\n");
				lrs.append(galaxy.quadX + " | " + midLeft + " |<" + mid + ">| " + midRight + " |\n");
				lrs.append("  +-----+-----+-----+\n");
				lrs.append(rowPlusOne + " | " + bottomLeft + " | " + bottomMid + " | " + bottomRight + " |\n");
				lrs.append("  +-----+-----+-----+\n");
		System.out.println(lrs);
	}

	public void map(Placeable placeable, Placeable placeable2, String string, Quadrant quadrant, Galaxy galaxy) {
		StringBuilder map = new StringBuilder();
		map.append("     0     1     2     3     4     5     6     7\n");
		map.append("  +-----+-----+-----+-----+-----+-----+-----+-----+\n");
		for (int row = 0; row < galaxy.quadrant.length; row++) {
			map.append(row + " |");
			for (int col = 0; col < galaxy.quadrant[row].length; col++) {
				if (galaxy.quadrant[row][col].hasBeenScanned() == true) {
					if (galaxy.quadrant[row][col].hasEnterprise() == true) {
						map.append("<" + galaxy.quadrant[row][col].getKBS() + ">|");
					} else {
						map.append(" " + galaxy.quadrant[row][col].getKBS() + " |");
					}
				} else {
					map.append("     |");
				}
				if (col == 7) {
					map.append("\n");
					map.append("  +-----+-----+-----+-----+-----+-----+-----+-----+\n");
				}
			}
		}
		System.out.println(map);
	}

	public void ping(Placeable placeable, Placeable placeable2, boolean b, Quadrant quadrant, Galaxy galaxy) {
		StringBuilder sb = new StringBuilder();
		if (b = true) {
			for (int row = 0; row < galaxy.quadrant[galaxy.quadX][galaxy.quadX].sector.length; row++) {
				for (int col = 0; col < galaxy.quadrant[galaxy.quadX][galaxy.quadY].sector.length; col++) {
					if (galaxy.quadrant[galaxy.quadX][galaxy.quadY].sector[row][col] instanceof Klingon) {
						Klingon klingon = (Klingon) galaxy.quadrant[galaxy.quadX][galaxy.quadY].sector[row][col];
						sb.append("Enemy in Sector: (" + row + "," + col + ")\nShield Level: " + klingon.shields
								+ "\nPhaser energy to destroy: " + klingon.health + "\n");
					}
				}
			}
		} else {
			System.out.println("There are no klingons!");
		}
		System.out.println(sb);
	}

	public void impulse(Object object, Placeable placeable, Quadrant quadrant, Galaxy galaxy) {
		galaxy.quadrant[galaxy.quadX][galaxy.quadY].removeEnterprise();
		System.out.println("You have chosen to move enterprise within sector what is desired X coordinate");
		int X = Integer.parseInt( sc.nextLine() );
		System.out.println("what is desired Y coordinate");
		int Y = Integer.parseInt( sc.nextLine() );
		if (X <= 7 || Y <= 7) {
			galaxy.quadrant[galaxy.quadX][galaxy.quadY].moveEnterprise(X, Y);
			System.out.println("you have moved");
			Galaxy.enterprise.decEnergy(1);
		} else {
			System.out.println("Your X and or your Y need to be lower");
		}
	}

	public void srs(Placeable placeable, Placeable placeable2, Galaxy galaxy, int stardate, int endStardate,
			Quadrant quadrant) {
		StringBuilder str = new StringBuilder();
		str.append("   0--1--2--3--4--5--6--7\n");
		int numLock = 0;
		int info = 0;
		for (int row = 0; row < galaxy.quadrant[galaxy.quadX][galaxy.quadY].sector.length; row++) {
			str.append(row + "|");
			for (int col = 0; col < galaxy.quadrant[galaxy.quadX][galaxy.quadY].sector.length; col++) {
				if (galaxy.quadrant[galaxy.quadX][galaxy.quadY].sector[row][col] == null) {
					str.append("   ");
				}
				if (galaxy.quadrant[galaxy.quadX][galaxy.quadY].sector[row][col] instanceof Enterprise) {
					str.append("=E=");
				}
				if (galaxy.quadrant[galaxy.quadX][galaxy.quadY].sector[row][col] instanceof Klingon) {
					str.append("-K-");
				}
				if (galaxy.quadrant[galaxy.quadX][galaxy.quadY].sector[row][col] instanceof Starbase) {
					str.append("<!>");
				}
				if (galaxy.quadrant[galaxy.quadX][galaxy.quadY].sector[row][col] instanceof Star) {
					str.append(" * ");
				}
				if (numLock == 7) {
					str.append(row + "|");
					if (info == 0) {
						str.append("     Stardates Remaining: " + (endStardate - stardate) + "\n");
					}
					if (info == 1) {
						str.append("     Quadrant (X,Y): " + galaxy.quadX + "," + galaxy.quadY + "\n");
					}
					if (info == 2) {
						str.append("     Sector (X,Y): " + galaxy.quadrant[galaxy.quadX][galaxy.quadY].sectorX + ","
								+ galaxy.quadrant[galaxy.quadX][galaxy.quadY].sectorY + "\n");
					}
					if (info == 3) {
						str.append("     Photon Torpedoes: " + Galaxy.enterprise.torpedoes + "\n");
					}
					if (info == 4) {
						str.append("     Shield Energy: " + Galaxy.enterprise.shields + "\n");
					}
					if (info == 5) {
						str.append("     Free Energy: " + Galaxy.enterprise.energy + "\n");
					}
					if (info == 6) {
						str.append("     Klingons remaining: " + galaxy.klingons + "\n");
					}
					if (info == 7) {
						str.append("     Starbases remaining: " + galaxy.starbases + "\n");
					}
					numLock = 0;
					info++;
				} else {
					numLock++;
				}
			}
		}
		str.append("   0--1--2--3--4--5--6--7");
		galaxy.quadrant[galaxy.quadX][galaxy.quadY].setScan();
		System.out.println(str);
	}

	public void phaser(Placeable placeable, boolean b, Quadrant quadrant, Galaxy galaxy) {
		if (b = true) {
			System.out
					.println("how much energy would you like to use, you have " + Galaxy.enterprise.energy + " energy");
			int energyExpenditure = Integer.parseInt( sc.nextLine() );
			while (energyExpenditure > Galaxy.enterprise.energy) {
				System.out.println("You do not have that much energy! Try again!");
				energyExpenditure = Integer.parseInt( sc.nextLine() );
			}
			System.out.println("Which X coordinate would you like to hit?");
			int x = Integer.parseInt( sc.nextLine() );
			System.out.println("Which Y coordinate would you like to hit?");
			int y = Integer.parseInt( sc.nextLine() );
			if (galaxy.quadrant[galaxy.quadX][galaxy.quadY].sector[x][y] instanceof Klingon) {
				System.out.println("You have hit Klingon");
				Klingon klingon = (Klingon) galaxy.quadrant[galaxy.quadX][galaxy.quadY].sector[x][y];
				Galaxy.enterprise.decEnergy(energyExpenditure);
				klingon.takeDamage(energyExpenditure);
				if (klingon.hull <= 0) {
					galaxy.quadrant[galaxy.quadX][galaxy.quadY].removeKlingon(x, y);
					galaxy.klingons--;
					galaxy.quadrant[galaxy.quadX][galaxy.quadY].klingons--;
				}
			} else {
				System.out.println("You have missed!");
				// Decrement Energy Expended
				Galaxy.enterprise.decEnergy(energyExpenditure);
			}
		} else {
			System.out.println("No Klingons in Quadrant");
		}
	}

	public void torpedo(Placeable placeable, boolean b, Galaxy galaxy) {
		if (Galaxy.enterprise.torpedoes > 0) {
			if (b == true) {
				System.out.println("You have " + Galaxy.enterprise.torpedoes + " Torpedoes.\n");
				Galaxy.enterprise.decTorpedoes();
				System.out.println("Which X coordinate would you like to hit?");
				int x = Integer.parseInt( sc.nextLine() );
				System.out.println("Which Y coordinate would you like to hit?");
				int y = Integer.parseInt( sc.nextLine() );
				if (galaxy.quadrant[galaxy.quadX][galaxy.quadY].sector[x][y] instanceof Klingon) {
					System.out.println("You have hit Klingon");
					galaxy.quadrant[galaxy.quadX][galaxy.quadY].removeKlingon(x, y);
					galaxy.klingons--;
				} else {
					System.out.println("You have missed!");
				}
			} else {
				System.out.println("There is no Klingon to shoot at!");
			}
		} else {
			System.out.println("You do not have torpedoes!");
		}
	}

	public void warp(Object object, Placeable placeable, Quadrant quadrant, Galaxy galaxy) {
		galaxy.quadrant[galaxy.quadX][galaxy.quadY].removeEnterprise();
		System.out.println("You have chosen to move the enterprise out of the Quadrant.\n");
		System.out.println("What Quadrant X value do you want to move to!");
		int qx = Integer.parseInt( sc.nextLine() );
		System.out.println("What Quadrant Y value do you want to move to!");
		int qy = Integer.parseInt( sc.nextLine() );
		System.out.println("What Sector X value do you want to move to!");
		int sx = Integer.parseInt( sc.nextLine() );
		System.out.println("What Sector Y value do you want to move to!");
		int sy = Integer.parseInt( sc.nextLine() );
		galaxy.moveEnterprise(qx, qy, sx, sy);

		// get quadrant that enterprise is in
		// remove enterprise
		// get coords from user to where they wanna go
		// place enterprise
		// TODO deduct 10 energy per quadrant moved
		// uses 1 stardate
		System.out.println("You have moved Enterprise.");
	}

	public void destruct() {
		System.out.println("The game is over you have blown the enterprise to bits!");
	}

	public void displayOpening(int stardate, Galaxy galaxy, int endStardate) {
		int amountOfDays = endStardate - stardate;
		System.out.println("The stardate is " + stardate + ".\n");
		System.out.println(
				"You are the captain of the USS Enterprise. You have received word from Starfleet Command of Klingon activity in the region.\nThe Federation is in danger and you are the only ship in range.");
		System.out.println("Your mission is to hunt down and destroy the " + galaxy.klingons
				+ " Klingon warships. You must complete your mission before stardate " + endStardate + ", giving you "
				+ amountOfDays + " stardates to succeed.\n");
		System.out.println("There are " + galaxy.starbases
				+ " Federation Starbases in the region for refueling, restocking torpedoes, and repairs.\n");
		System.out.println("Good luck captain!\n");
	}

	public String[] getCommand() {

		System.out.println("Your Orders Captain: \n");
		String commandString = sc.nextLine();
		return new String[] { commandString };
	}
}
