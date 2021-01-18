package poker;
public class PokerHandEvaluator {

	public static boolean hasPair(Card[] cards) { //this method returns true if the cards provided contain a pair
		for (int i = 0; i < cards.length; i++) { //this loops through the length of the deck
			for (int j = 0; j < cards.length; j++) { //this also loops through the length of the deck
				if (cards[i].getValue() == cards[j].getValue() && i != j) { //this checks if the values of the two cards are the same and if the index is not the same
					return true; //this returns true if the above condition is met
				}
			}
		}
		return false; //otherwise it returns false
	}

	public static boolean hasTwoPair(Card[] cards) { //this method returns true if the cards provided contain a two pair
		int counter = 0; //this is the counter
		int first = 0; //this is an integer to check
		int second = 0; //this is a second integer to check

		for(int x = 0; x < cards.length-1; x++) { //this loops through the length of the cards provided minus one
			for(int y = x + 1; y < cards.length; y++) { //this loops through the length of the cards provided
				if(cards[x].getValue() == cards[y].getValue() && cards[x].getValue() != first
						&& cards[y].getValue() != second) {
					counter++; //counter is incremented by 1
					if (counter == 1)
						first = cards[x].getValue();
					else if(counter == 2)
						second = cards[x].getValue();
				}
			}
		}
		if (counter == 2) { //if the counter equals 2
			return true; //return true
		} else {
			return false; //otherwise return false
		}
	}

	public static boolean hasThreeOfAKind(Card[] cards) { //this method returns true if the cards provided contain a three of a kind
		int[] numbers = new int[13]; //this is a new integer array of length 13

		for(int i = 0; i < cards.length; i++) { //this loops through the length of the cards provided
			numbers[cards[i].getValue() - 1]++; //the integer array that was created is incremented
		}
		for(int j = 0; j < numbers.length; j++) { //this loops through the length of the numbers array that was created
			if (numbers[j] == 3) { //if the value at j equals 3
				return true; //return true
			}
		}
		System.out.println(" ");
		return false; //otherwise return false
	}

	public static boolean hasStraight(Card [] cards) { //this method returns true if the cards provided contain a straight
		int[] ordered = new int[cards.length]; //a new array is created with the same length as the cards provided
		int index = 0; //the index is initialized at 0

		for (int i = 0; i < cards.length; i++) { //this loops through the length of the cards provided
			int min = 14;
			for (int j = 0; j < cards.length; j++) { //this loops through the length of the cards provided
				if (cards[j].getValue() < min) { //here min is 14 because all values are less than 14
					min = cards[j].getValue();
					ordered[i] = cards[j].getValue(); //the value at i in the ordered array is reassigned
					index = j; //the index is also reassigned to j
				}
			}
			cards[index] = new Card(13, 3);
		}
		if (ordered[0] == 1 && ordered[1] == 10 && ordered[2] == 11 && ordered[3] == 12 && ordered[4] == 13) { //this checks for if ace is at the end of the array
			return true; //it will return true because it is considered a straight
		}
		int value = ordered[0];
		for (int k = 1; k < ordered.length; k++) { //this loops through the length of the new array that was created
			if (ordered[k] != value + 1) {
				return false; //otherwise it returns false
			}
			value = ordered[k];
		}
		return true; //this returns true
	}

	public static boolean hasFlush(Card[] cards) { //this method returns true if the cards provided contain a flush
		if(cards[0].getSuit() == cards[1].getSuit()) {
			if(cards[1].getSuit() == cards[2].getSuit()) {
				if(cards[2].getSuit() == cards[3].getSuit()) {
					if(cards[3].getSuit() == cards[4].getSuit())
						return true; //this returns true
				}
			}
		}
		return false;		
	} 

	public static boolean hasFullHouse(Card[] cards) { //this method returns true if the cards provided contain a full house
		int first = 1; //this is the first integer to check
		int second = 0; //this is the second integer to check
		int firstVal = cards[0].getValue();
		int secondVal = 0;

		for (int i = 1; i < cards.length; i++) { //this loops through the length of the cards
			if (cards[i].getValue() == firstVal) {
				first++; //first is incremented by 1
			} else if (secondVal == 0) {
				secondVal = cards[i].getValue();
				second++; //second is incremented by 1
			} else if (cards[i].getValue() == secondVal) {
				second++; //second is incremented by 1
			}
		}
		if ((first == 2 && second == 3) || (first == 3 && second == 2)) { //check the following conditions to see if the cards provided contain a full house
			return true; //this returns true
		} else {
			return false; //otherwise false is returned
		}
	}

	public static boolean hasFourOfAKind(Card[] cards) { //this method returns true if the cards provided contain a four of a kind
		int counter = 0;

		for (int i = 0; i < cards.length-1; i++) { //this loops through the length of the cards minus 1
			for (int j = (i+1); j < cards.length; j++) //this loops through the length of the cards
				if (cards[i].getValue() == cards[j].getValue()) { //check this condition
					counter = counter + 1; //counter is incremented
				}
		}
		if (counter == 6) { //once the counter = 6
			return true; //return true
		} else {
			return false; //otherwise false is returned
		}
	}

	public static boolean hasStraightFlush(Card[] cards) { //this method returns true if the cards provided contain a straight flush
		if ((hasStraight(cards)) && (hasFlush(cards))) { //this calls the methods above to check for a straight and flush
			return true; //it returns true if a straight and flush are found
		}
		return false; //otherwise it returns false
	}
}