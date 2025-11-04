package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * Tests for the {@link Board} class.
 * Verifies board creation, dimensions, and behavior with valid and invalid inputs.
 */
class BoardTest {

    /**
     * Tests creation of a valid board and verifies its dimensions and content.
     */
    @Test
    void testValidBoard() {
        Square[][] grid = new Square[1][1];
        grid[0][0] = new BasicSquare();
        Board board = new Board(grid);
        assertThat(board.getWidth()).isEqualTo(1);
        assertThat(board.getHeight()).isEqualTo(1);
        assertThat(board.squareAt(0, 0)).isNotNull();
        assertThat(board.squareAt(0, 0)).isEqualTo(grid[0][0]);
        assertThat(board.withinBorders(0, 0)).isTrue();
    }

    /**
     * Tests that creating a board with a null square throws an assertion error.
     */
    @Test
    void testInvalidBoardSquareAt() {
        Square[][] grid = new Square[1][1];
        grid[0][0] = null;
        try {
            Board board = new Board(grid);
            board.squareAt(0, 0);
        } catch (AssertionError e) {
            assertThat(e).hasMessageContaining("Initial grid cannot contain null squares");
        }
    }
}
