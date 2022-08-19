import cs5004.marblesolitaire.model.MarbleSolitaireModel;
import cs5004.marblesolitaire.model.MarbleSolitaireModelImpl;
import cs5004.marblesolitaire.model.Piece;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * A JUnit test class for MarbleSolitaireModelImpl class
 */
public class MarbleSolitaireModelImplTest {

    MarbleSolitaireModel marble1;
    MarbleSolitaireModel marble2;
    MarbleSolitaireModel marble3;
    MarbleSolitaireModel marble4;
    MarbleSolitaireModel marble5;

    /**
     * Create and Initialize the four constructor
     */
    @org.junit.Before
    public void setUp() throws Exception {
        marble1 = new MarbleSolitaireModelImpl();
        marble2 = new MarbleSolitaireModelImpl(3,3);
        marble3 = new MarbleSolitaireModelImpl(5);
        marble4 = new MarbleSolitaireModelImpl(3,4,3);
        marble5 = new MarbleSolitaireModelImpl(5,4,4);
    }

    /**
     * Test the invalid second constructor
     * the sRow is out of board
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalBoard1(){
        MarbleSolitaireModel invalidBoard1 = new MarbleSolitaireModelImpl(8,4);
    }
    /**
     * Test the invalid second constructor
     * the sCol is out of board
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalBoard2(){
        MarbleSolitaireModel invalidBoard3 = new MarbleSolitaireModelImpl(4,10);
    }
    /**
     * Test the invalid second constructor
     * the sRow is a negative number
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalBoard3(){
        MarbleSolitaireModel invalidBoard4 = new MarbleSolitaireModelImpl(-3,10);
    }
    /**
     * Test the invalid third constructor
     * Test even arm thickness of the third constructor
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalBoard4(){
        MarbleSolitaireModel invalidBoard4 = new MarbleSolitaireModelImpl(6);
    }
    /**
     * Test the invalid third constructor
     * Test non-positive arm thickness of the third constructor
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalBoard5(){
        MarbleSolitaireModel invalidBoard5 = new MarbleSolitaireModelImpl(-1);
    }
    /**
     * Test the invalid third constructor
     * Test arm thickness is smaller than 3
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalBoard6(){
        MarbleSolitaireModel invalidBoard6 = new MarbleSolitaireModelImpl(1);
    }
    /**
     * Test the invalid fourth constructor
     * Test arm thickness invalid
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalBoard7(){
        MarbleSolitaireModel invalidBoard7 = new MarbleSolitaireModelImpl(8, 4, 7);
    }
    /**
     * Test the invalid fourth constructor
     * Test sRow is invalid
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalBoard8(){
        MarbleSolitaireModel invalidBoard8 = new MarbleSolitaireModelImpl(5, 13, 7);
    }
    /**
     * Test the invalid fourth constructor
     * Test sCol is invalid
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalBoard9(){
        MarbleSolitaireModel invalidBoard9 = new MarbleSolitaireModelImpl(7, 0, -2);
    }


    /**
     * Test the invalid slot for constructor2-->the slot is in the board but in INVALID position
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidSlot(){
        MarbleSolitaireModel marble = new MarbleSolitaireModelImpl(1, 1);
    }

    /**
     * Test the invalid slot for constructor4-->the slot is in the board but in INVALID position
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidSlot1(){
        MarbleSolitaireModel marble = new MarbleSolitaireModelImpl(5, 2, 2);
    }
    /**
     * Test the game state of constructor 1
     */
    @org.junit.Test
    public void testGetGameState1() {
        assertEquals("" +
                "    O O O    \n" +
                "    O O O    \n" +
                "O O O O O O O\n" +
                "O O O _ O O O\n" +
                "O O O O O O O\n" +
                "    O O O    \n" +
                "    O O O    ",marble1.getGameState());
    }

    /**
     * Test the game state of constructor 2
     */
    @Test
    public void testGetGameState2() {
        assertEquals("" +
                "    O O O    \n" +
                "    O O O    \n" +
                "O O O O O O O\n" +
                "O O O _ O O O\n" +
                "O O O O O O O\n" +
                "    O O O    \n" +
                "    O O O    ",marble2.getGameState());
    }

    /**
     * Test the game state of constructor 3
     */
    @Test
    public void testGetGameState3(){
        assertEquals("" +
                "      O O O O O      \n" +
                "      O O O O O      \n" +
                "      O O O O O      \n" +
                "O O O O O O O O O O O\n" +
                "O O O O O O O O O O O\n" +
                "O O O O O _ O O O O O\n" +
                "O O O O O O O O O O O\n" +
                "O O O O O O O O O O O\n" +
                "      O O O O O      \n" +
                "      O O O O O      \n" +
                "      O O O O O      ", marble3.getGameState());
    }
    /**
     * Test the game state of constructor 4
     */
    @Test
    public void testGetGameState4(){
        assertEquals("" +
                "    O O O    \n" +
                "    O O O    \n" +
                "O O O O O O O\n" +
                "O O O O O O O\n" +
                "O O O _ O O O\n" +
                "    O O O    \n" +
                "    O O O    ",marble4.getGameState());
    }

    /**
     * Test the game state of constructor4
     */
    @Test
    public void testGetGameState5(){
        MarbleSolitaireModel m1 = new MarbleSolitaireModelImpl(5,7,8);
        assertEquals("" +
                "      O O O O O      \n" +
                "      O O O O O      \n" +
                "      O O O O O      \n" +
                "O O O O O O O O O O O\n" +
                "O O O O O O O O O O O\n" +
                "O O O O O O O O O O O\n" +
                "O O O O O O O O O O O\n" +
                "O O O O O O O O _ O O\n" +
                "      O O O O O      \n" +
                "      O O O O O      \n" +
                "      O O O O O      ", m1.getGameState());
    }

    /**
     * Test the game state of constructor4
     */
    @Test
    public void testGetGameState6(){
        assertEquals("" +
                "      O O O O O      \n" +
                "      O O O O O      \n" +
                "      O O O O O      \n" +
                "O O O O O O O O O O O\n" +
                "O O O O _ O O O O O O\n" +
                "O O O O O O O O O O O\n" +
                "O O O O O O O O O O O\n" +
                "O O O O O O O O O O O\n" +
                "      O O O O O      \n" +
                "      O O O O O      \n" +
                "      O O O O O      ", marble5.getGameState());
    }

    @org.junit.Test
    public void getScoreInitialBoard() {
        assertEquals(32,marble1.getScore());
        assertEquals(32,marble2.getScore());
        assertEquals(84,marble3.getScore());
        assertEquals(32,marble4.getScore());
        assertEquals(84,marble5.getScore());
    }


    /**
     * Test move of marble1
     */
    @Test
    public void testMove1(){
        assertEquals("" +
                "    O O O    \n" +
                "    O O O    \n" +
                "O O O O O O O\n" +
                "O O O _ O O O\n" +
                "O O O O O O O\n" +
                "    O O O    \n" +
                "    O O O    ",marble1.getGameState());
        marble1.move(5, 3, 3, 3);
        assertEquals("" +
                "    O O O    \n" +
                "    O O O    \n" +
                "O O O O O O O\n" +
                "O O O O O O O\n" +
                "O O O _ O O O\n" +
                "    O _ O    \n" +
                "    O O O    ",marble1.getGameState());
    }

    /**
     * Test the in    O O O
     *     O _ O
     * O O O O _ _ O
     * O O O _ _ _ O
     * O O O O O _ O
     *     O _ _
     *     O _ _ valid move-->move from a slot that is invalid
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidMove1(){
        marble1.move(1,1,1,3);
    }

    /**
     * Test the invalid move-->move three steps instead two steps
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidMove2(){
        marble1.move(5,4,2,4);
    }

    /**
     * Test the invalid move-->the "from" cell is invalid
     * move is not allowed when distance is 1
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidMove3(){
        marble2.move(3,4,3,3);
    }

    //move is not allowed when distance is longer than 2 (2.0/2.0)
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidMove4(){
        marble3.move(6,4,6,1);
    }
    /**
     * A test to check that the game is not over
     */
    @org.junit.Test
    public void testisGameNotOver1() {
        marble2.move(5, 3, 3, 3);
        marble2.move(4, 5, 4, 3);
        marble2.move(6, 4, 4, 4);
        assertFalse(marble2.isGameOver());
    }

    /**
     * A test to check that the game is not over
     */
    @Test
    public void testisGameNotOver2(){
        marble3.move(7, 5, 5, 5);
        assertFalse(marble3.isGameOver());

    }

    /**
     * A test to check that the isGameOver method works as expected
     */
    @Test
    public void testGameOver(){
        marble1.move(5,3,3,3);
        marble1.move(4,5,4,3);
        marble1.move(6,4,4,4);
        marble1.move(2,5,4,5);
        marble1.move(3,3,5,3);
        marble1.move(6,3,4,3);
        marble1.move(1,3,3,3);
        marble1.move(4,3,2,3);
        marble1.move(4,5,4,3);
        marble1.move(2,4,4,4);
        assertEquals("" +
                "    O O O    \n" +
                "    O _ O    \n" +
                "O O O O _ _ O\n" +
                "O O O _ _ _ O\n" +
                "O O O O O _ O\n" +
                "    O _ _    \n" +
                "    O _ _    ",marble1.getGameState());
        marble1.move(0,4,2,4);
        marble1.move(2,3,2,5);
        marble1.move(2,6,2,4);
        marble1.move(4,3,4,5);
        marble1.move(4,6,4,4);
        marble1.move(0,2,0,4);
        marble1.move(2,2,0,2);
        marble1.move(2,0,2,2);
        marble1.move(4,0,2,0);
        marble1.move(3,1,3,3);
        marble1.move(4,1,4,3);
        marble1.move(4,3,2,3);
        assertFalse(marble1.isGameOver());
        marble1.move(2,3,2,5);
        //assertTrue(marble1.isGameOver());
        marble1.move(6,2,4,2);
        assertTrue(marble1.isGameOver());
        assertEquals(8,marble1.getScore());
        assertEquals("" +
                "    O _ O    \n" +
                "    _ _ _    \n" +
                "O _ O _ _ O _\n" +
                "_ _ _ _ _ _ O\n" +
                "_ _ O _ O _ _\n" +
                "    _ _ _    \n" +
                "    _ _ _    ",marble1.getGameState());
    }


}