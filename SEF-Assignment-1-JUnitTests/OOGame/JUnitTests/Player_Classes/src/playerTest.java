
public class playerTest {

	@before
	Player player1 = new Player();
	
	@test
	public void testTeleport() {
	player1.playerTeleport(KeyEvent.VK_SPACE);	
	}
}
