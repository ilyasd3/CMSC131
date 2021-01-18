package poker;

import static org.junit.Assert.*;
import org.junit.Test;

public class StudentTests {

	@Test
	public void testPair() {
		Card a = new Card(7,0);
		Card b = new Card(7,1);
		Card c = new Card(8,3);
		Card d = new Card(2,2);
		Card e = new Card(5,3);
		Card[] pairTest ={a,b,c,d,e};
		
		assertTrue(PokerHandEvaluator.hasPair(pairTest));
		assertFalse(PokerHandEvaluator.hasFlush(pairTest));
		assertEquals(PokerHandEvaluator.hasStraight(pairTest), false);
	}
	
	@Test
	public void testTwoPair() {
		Card a = new Card(7,0);
		Card b = new Card(7,1);
		Card c = new Card(8,3);
		Card d = new Card(8,2);
		Card e = new Card(5,3);
		Card[] twoPairTest ={a,b,c,d,e};
		
		assertEquals(PokerHandEvaluator.hasTwoPair(twoPairTest), true);
	}
	
	@Test
	public void testThreeOfAKind() {
		Card a = new Card(7,0);
		Card b = new Card(7,1);
		Card c = new Card(7,3);
		Card d = new Card(8,2);
		Card e = new Card(5,3);
		Card[] threeOfAKindTest ={a,b,c,d,e};
		
		Card f = new Card(3,0);
		Card g = new Card(4,1);
		Card h = new Card(5,3);
		Card i = new Card(6,2);
		Card j = new Card(7,3);
		Card[] threeOfAKindTestTwo ={f,g,h,i,j};
		
		assertEquals(PokerHandEvaluator.hasThreeOfAKind(threeOfAKindTest), true);
		assertFalse(PokerHandEvaluator.hasThreeOfAKind(threeOfAKindTestTwo));
	}
	
	@Test
	public void testStraight() {
		Card a = new Card(3,0);
		Card b = new Card(4,1);
		Card c = new Card(5,3);
		Card d = new Card(6,2);
		Card e = new Card(7,3);
		Card[] straightTest ={a,b,c,d,e};
		
		Card f = new Card(13,0);
		Card g = new Card(1,1);
		Card h = new Card(2,3);
		Card i = new Card(3,2);
		Card j = new Card(4,3);
		Card[] straightTestTwo ={f,g,h,i,j};
		
		Card k = new Card(1,0);
		Card l = new Card(2,1);
		Card m = new Card(3,3);
		Card n = new Card(4,2);
		Card o = new Card(5,3);
		Card[] straightTestThree ={k,l,m,n,o};
		
		assertEquals(PokerHandEvaluator.hasStraight(straightTest), true);
		assertFalse(PokerHandEvaluator.hasStraight(straightTestTwo));
		assertTrue(PokerHandEvaluator.hasStraight(straightTestThree));
	}
	
	@Test
	public void testStraightTwo() {
		Card a = new Card(10,1);
		Card b = new Card(11,2);
		Card c = new Card(12,0);
		Card d = new Card(13,3);
		Card e = new Card(1,2);
		Card[] straightTestTwo ={a,b,c,d,e};
		
		assertTrue(PokerHandEvaluator.hasStraight(straightTestTwo));
	}
	
	@Test
	public void testFlush() {
		Card a = new Card(3,2);
		Card b = new Card(6,2);
		Card c = new Card(9,2);
		Card d = new Card(11,2);
		Card e = new Card(7,2);
		Card[] flushTest ={a,b,c,d,e};
		
		assertTrue(PokerHandEvaluator.hasFlush(flushTest));
		assertFalse(PokerHandEvaluator.hasPair(flushTest));
	}
	
	@Test
	public void testFullHouse() {
		Card a = new Card(3,1);
		Card b = new Card(3,2);
		Card c = new Card(3,3);
		Card d = new Card(6,2);
		Card e = new Card(6,0);
		Card[] fullHouseTest ={a,b,c,d,e};
		
		assertTrue(PokerHandEvaluator.hasFullHouse(fullHouseTest));
		assertTrue(PokerHandEvaluator.hasPair(fullHouseTest));
		assertEquals(PokerHandEvaluator.hasTwoPair(fullHouseTest), true);
		assertFalse(PokerHandEvaluator.hasFourOfAKind(fullHouseTest));
	}
	
	@Test
	public void testFourOfAKind() {
		Card a = new Card(3,0);
		Card b = new Card(3,1);
		Card c = new Card(3,2);
		Card d = new Card(3,3);
		Card e = new Card(6,0);
		Card[] fourOfAKindTest ={a,b,c,d,e};
		
		assertTrue(PokerHandEvaluator.hasFourOfAKind(fourOfAKindTest));
		assertTrue(PokerHandEvaluator.hasPair(fourOfAKindTest));
		assertEquals(PokerHandEvaluator.hasTwoPair(fourOfAKindTest), false);
		assertFalse(PokerHandEvaluator.hasStraight(fourOfAKindTest));
	}
	
	@Test
	public void testStraightFlush() {
		Card a = new Card(3,0);
		Card b = new Card(4,0);
		Card c = new Card(5,0);
		Card d = new Card(6,0);
		Card e = new Card(7,0);
		Card[] straightFlushTest ={a,b,c,d,e};
		
		assertTrue(PokerHandEvaluator.hasStraightFlush(straightFlushTest));
		assertEquals(PokerHandEvaluator.hasTwoPair(straightFlushTest), false);
	}
	
	@Test
	public void testStraightFlushTwo() {
		Card f = new Card(13,1);
		Card g = new Card(1,1);
		Card h = new Card(2,1);
		Card i = new Card(3,1);
		Card j = new Card(4,1);
		Card[] straightFlushTestTwo ={f,g,h,i,j};
		
		assertFalse(PokerHandEvaluator.hasStraightFlush(straightFlushTestTwo));
	}
	
	@Test
	public void testStraightFlushThree() {
		Card f = new Card(13,1);
		Card g = new Card(1,1);
		Card h = new Card(2,1);
		Card i = new Card(3,1);
		Card j = new Card(4,1);
		Card[] straightFlushTestThree ={f,g,h,i,j};
		
		assertEquals(PokerHandEvaluator.hasPair(straightFlushTestThree), false);
	}
	
	@Test
	public void testStraightFlushFour() {
		Card k = new Card(1,2);
		Card l = new Card(2,2);
		Card m = new Card(3,2);
		Card n = new Card(4,2);
		Card o = new Card(5,2);
		Card[] straightFlushTestFour ={k,l,m,n,o};
		
		assertTrue(PokerHandEvaluator.hasStraightFlush(straightFlushTestFour));
		assertEquals(PokerHandEvaluator.hasFlush(straightFlushTestFour), true);
	}
	
	@Test
	public void testStraightFlushFive() {
		Card k = new Card(1,2);
		Card l = new Card(2,2);
		Card m = new Card(3,2);
		Card n = new Card(4,2);
		Card o = new Card(5,2);
		Card[] straightFlushTestFive ={k,l,m,n,o};
		
		assertTrue(PokerHandEvaluator.hasStraight(straightFlushTestFive));
	}
}