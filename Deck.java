package poker;

public class Deck {

	private Card[] cards;

	public Deck() { //this is a constructor
		cards = new Card[52]; //this initializes the Deck with 52 card objects

		int val = 1; //initialize the value to be 1
		for (int i = 0; i < 13; i++) { //this is for the first 13 cards
			cards[i] = new Card(val, 0); //0 as the suit represents spades
			++val; //value is incremented by 1 each time
		}
		val = 1; //value is reinitialized to 1
		for (int i = 13; i < 26; i++) { //this is for the next 13 cards
			cards[i] = new Card(val, 1); //1 as the suit represents hearts
			++val; //value is incremented by 1 each time
		}
		val = 1; //value is reinitialized to 1
		for (int i = 26; i < 39; i++) { //this is for the next 13 cards
			cards[i] = new Card(val, 2); //2 as the suit represents clubs
			++val; //value is incremented by 1 each time
		}
		val = 1; //value is reinitialized to 1
		for (int i = 39; i < 52; i++) { //this is for the last 13 cards
			cards[i] = new Card(val, 3); //3 as the suit represents diamonds
			++val; //value is incremented by 1 each time
		}
	}

	public Deck(Deck other) { //this is a copy constructor
		this.cards = other.cards;
	}

	public Card getCardAt(int position) {
		return cards[position]; //this returns the card value and suit at the provided position
	}

	public int getNumCards() {
		return cards.length; //this returns the size of the deck (i.e. the number of cards left in the deck)
	}

	public void shuffle() { //this method rearranges the cards in the deck
		Card[] top = new Card[(int) Math.round((double) this.getNumCards()/2.0)]; //this is the top half of the deck
		Card[] bottom = new Card[this.getNumCards()/2]; //this is the bottom half of the deck

		for (int i = 0; i < this.getNumCards()/2; i++) { //this loops through half the deck
			top[i] = cards[i]; //the top half at the index is initialized to the card in the deck at that index
			bottom[i] = cards[i + top.length]; //the bottom half is similar but you add the length of the top half
		}
		if (this.getNumCards() % 2 != 0) top[top.length-1] = cards[top.length-1];
		int j = 0;
		for (int i = 0; i < this.getNumCards(); i++) { //this loops through the whole deck
			if (i % 2 == 0) { //if the index is even
				cards[i] = top[j]; //then the card at that index is initialized to the card in the top half at the index divided by 2
			} else { //if the index is odd
				cards[i] = bottom[j];
				j++;
			}
		}
	}

	public void cut(int position) { //this method cuts the deck at the provided position
		Card[] topCut = new Card[position]; //this is the top cut of the deck
		Card[] bottomCut = new Card[cards.length - position]; //this is the bottom cut of the deck

		for(int i = 0; i < topCut.length; i++){ //this loops through the length of the top cut cards
			topCut[i] = cards[i]; //the top cut at the index is initialized to the card in the deck at that index
		}
		for(int i = 0; i < bottomCut.length; i++){ //this loops through the length of the bottom cut cards
			bottomCut[i] = cards[i + position]; //the card at the position provided is the first card of the bottom cut
		}
		for(int i = 0; i < bottomCut.length; i++){ //this loops through the length of the bottom cut cards
			cards[i] = bottomCut[i]; //this reassigns the card at the index to the card in the bottom cut at that index
		}
		for(int i = 0; i < topCut.length; i++){ //this loops through the length of the top cut cards
			cards[bottomCut.length + i] = topCut[i];
		}
	}

	public Card[] deal(int numCards) { //this removes the number of cards provided in the parameter from the top of the deck
		Card[] smaller = new Card[cards.length - numCards]; //this is the deck remaining after cards are dealt
		Card[] dealtCards = new Card[numCards]; //this is the deck of cards that are dealt

		for(int i = 0; i < smaller.length; i++) { //this loops through the number of cards remaining in the deck 
			smaller[i] = cards[i + numCards]; //this 
		}
		for(int i = 0; i < numCards; i++){ //this loops through the number of cards provided
			dealtCards[i] = cards[i]; //the dealt card at the index is the card in the deck at that index
		}
		cards = smaller; //cards is reassigned to the smaller array
		return dealtCards; //this returns the cards that have been dealt
	}
}