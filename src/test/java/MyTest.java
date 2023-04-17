import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MyTest {

	@Test
	void testingrank(){
		int[][] playersHand = new int[2][3];
		assertEquals(2,PokerInfo.calculateHighestRank(playersHand,2));
	}
	@Test
	void testingissamecard(){
		int[][] playersHand10 = new int[2][3];
		assertEquals(true,PokerInfo.isSameCard(playersHand10));
	}
	@Test
	void testisinorder(){
		int[][] usercard = new int[2][3];
		assertEquals(false,PokerInfo.isInOrder(usercard));
	}
	@Test
	void testhaspair(){
		int[][] usercard = new int[2][3];
		assertEquals(false,PokerInfo.hasPair(usercard));
	}
	@Test
	void testingissamecardpt2(){
		int[][] playersHand12 = new int[2][3];
		PokerInfo.isSameCard(playersHand12);
		assertEquals(true,PokerInfo.isSameCard(playersHand12));
	}
	@Test
	void testingvaluecard(){
		int[][] playersHand12 = new int[2][3];
		assertEquals(0,PokerInfo.highestValueCard(playersHand12));
	}
	@Test
	void testingisinorder(){
		int[][] playersHand11 = new int[2][3];
		PokerInfo.hasPair(playersHand11);
		assertEquals(false,PokerInfo.hasPair(playersHand11));
	}
	@Test
	void testingisinorderpt2(){
		int[][] playersHand20 = new int[3][3];
		assertEquals(false,PokerInfo.hasPair(playersHand20));
	}
	@Test
	void testcomparehands(){
		int[][] playersHand1 = new int[3][3];
		int[][] dealershand = new int[3][3];
		int playershighcard = 5;
		int dealershighestcard = 5;

		assertEquals("Sorry, you tied. No money lost tho!",PokerInfo.compareHands(playersHand1,dealershand,playershighcard,dealershighestcard));
	}
	@Test
	void testcomparehandspt2(){
		int[][] playersHand = new int[2][3];
		int[][] dealershand = new int[2][3];
		int playershighcard = 10;
		int dealershighestcard = 1;

		assertEquals("Sorry, you tied. No money lost tho!",PokerInfo.compareHands(playersHand,dealershand,playershighcard,dealershighestcard));
	}

}
