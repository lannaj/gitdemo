/**
 * Defines a class for cards that store the card's rank (2-10, J, Q, K, A),
 * suit (H - Hearts, D - Diamonds, S - Spades, C - Clubs),
 * and scoring value (2-10 - face value, J-K - 10, A - 1 or 11).
 * Defines methods that formats cards for display on a game board.
 * @author LMack
 */

public class Card {
	String rank;
	String suit;
	int value;	
	
	Card(String rank, String suit) {
		setRank(rank);
		setSuit(suit);
		
		//Cards with a rank of "none" are either "empty" or "none" non-playable Cards and have no scoring value
		if (getRank().equals("none")) {
			setValue(0);
		}
		else if (getRank().equals("J") || getRank().equals("Q") || getRank().equals("K")) {
			setValue(10);
		}
		else if (getRank().equals("A")) {
			setValue(1);  //the base value of Ace; the extra 10 points added if needed during scoring
		}
		else {
			setValue(Integer.parseInt(getRank()));
		}
	}
	
	//returns a string of the first characters of rank and suit for printing Card on-screen
	public String displayCard() {
		String displayText = "";
		
		//Cards with a rank of "none" are either "empty" Cards or "none" non-playable Cards.
		if (this.getRank().equals("none")) {
			//rank displays with two characters
			if (this.getSuit().equals("none")) {
				displayText = "  ";
			}
			else {
				if (Integer.parseInt(this.getSuit()) < 10) {
					displayText = "  ";
				}
				else {
					displayText = " ";
				}
			}
			
		}
		else {
			if (this.getRank().contentEquals("10")) {
				displayText = this.getRank();
			}
			else {
				displayText = " " + this.getRank();
			}
		}
		
		//Cards with a suit of "none" are non-playable Cards that display as blank spaces
		if (this.getSuit().equals("none")) {
			//suit displays with one character
			displayText += " ";
		}
		else {
			displayText += this.getSuit();
		}
		
		return displayText;
	}
	
	
	//Card's Instance Variable Getters and Setters
	
	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	
}
