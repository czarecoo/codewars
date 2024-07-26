package org.czareg.codewars.rotten.oranges;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@EqualsAndHashCode
class BoxState {

    private static final int ROTTEN = 2;
    private static final int FRESH = 1;

    private final int[][] grid;

    BoxState passTime() {
        int[][] newGrid = deepCloneGrid();
        modify(newGrid);
        return new BoxState(newGrid);
    }

    private int[][] deepCloneGrid() {
        int[][] newGrid = grid.clone();
        for (int i = 0; i < newGrid.length; i++) {
            newGrid[i] = newGrid[i].clone();
        }
        return newGrid;
    }

    private void modify(int[][] newGrid) {
        int rows = newGrid.length;
        int cols = newGrid[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] != ROTTEN) {
                    continue;
                }
                if (r > 0 && grid[r - 1][c] == FRESH) {
                    newGrid[r - 1][c] = ROTTEN;
                }
                if (r < rows - 1 && grid[r + 1][c] == FRESH) {
                    newGrid[r + 1][c] = ROTTEN;
                }
                if (c > 0 && grid[r][c - 1] == FRESH) {
                    newGrid[r][c - 1] = ROTTEN;
                }
                if (c < cols - 1 && grid[r][c + 1] == FRESH) {
                    newGrid[r][c + 1] = ROTTEN;
                }
            }
        }
    }

    public boolean hasFresh() {
        return Arrays.stream(grid)
                .flatMapToInt(Arrays::stream)
                .anyMatch(i -> i == FRESH);
    }
}
