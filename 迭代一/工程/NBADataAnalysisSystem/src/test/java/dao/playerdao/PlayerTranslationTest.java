package dao.playerdao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import entity.PlayerInfo;

public class PlayerTranslationTest {

	PlayerTranslation playerTranslation;
	
	@Before
	public void initialize() {
		playerTranslation = new PlayerTranslation();
	}
	
	@Test
	public void testTranslation() {
		assertEquals("age", playerTranslation.translation(PlayerInfo.AGE));
	}
	
	@Test
	public void testReverseTranslation() {
		assertEquals(PlayerInfo.AGE, playerTranslation.reverseTranslation("age"));
	}

}
