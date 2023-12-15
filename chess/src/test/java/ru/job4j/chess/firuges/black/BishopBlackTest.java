package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.OccupiedCellException;
import ru.job4j.chess.firuges.Cell;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BishopBlackTest {

    @Test
    void whenPositionTrue() {
        Cell cell = Cell.A7;
        BishopBlack bishopBlack = new BishopBlack(cell);
        assertThat(bishopBlack.position()).isEqualTo(Cell.A7);
    }

    @Test
    void whenCopyTrue() {
        Cell scell = Cell.A7;
        Cell dcell = Cell.C7;
        BishopBlack bishopBlack = new BishopBlack(scell);
        bishopBlack.copy(dcell);
        assertThat(bishopBlack.position()).isEqualTo(Cell.A7);
    }

    @Test
    void whenWayTrue() {
        Cell[] steps = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Cell scell = Cell.C1;
        Cell dcell = Cell.G5;
        BishopBlack bishopBlack = new BishopBlack(scell);
        bishopBlack.copy(dcell);
        Cell[] way = bishopBlack.way(dcell);
        assertThat(way).containsExactly(steps);
    }

    @Test
    void whenWayFalse() {
        Cell scell = Cell.C1;
        Cell dcell = Cell.G4;
        BishopBlack bishopBlack = new BishopBlack(scell);
        bishopBlack.copy(dcell);
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
            bishopBlack.way(dcell);
        });
        assertThat(exception.getMessage()).isEqualTo("Could not way by diagonal from C1 to G4");
    }
}