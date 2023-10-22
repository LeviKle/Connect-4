public class Checker {

    public static boolean check(char[][] b) {
        if (checkHorizontal(b) == true) {
            return true;
        }

        if (checkVertical(b) == true) {
            return true;
        }

        if (checkDiagonal(b) == true) {
            return true;
        }

        return false;
    }

    private static boolean checkHorizontal(char[][] b) {
        for (int row = 0; row < 6; row++) {
            int count = 0;
            char token = b[0][row];

            for (int col = 0; col < 7; col++) {
                char current = b[col][row];

                if (current == '\0') {
                    count = 0;
                    continue;
                } else {
                    if (current == token)
                        count++;
                    else {
                        token = current;
                        count = 1;
                        continue;
                    }
                }
                if (count == 4) {
                    return true;
                }
            }

        }
        return false;
    }

    private static boolean checkVertical(char[][] b) {
        for (int col = 0; col < 7; col++) {
            int count = 0;
            char token = b[col][0];

            for (int row = 0; col < 6; col++) {
                char current = b[col][row];

                if (current == '\0') {
                    count = 0;
                    continue;
                } else {
                    if (current == token)
                        count++;
                    else {
                        token = current;
                        count = 1;
                        continue;
                    }
                }
                if (count == 4) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkDiagonal(char[][] b) {
        int count = 0;
        // first checking diagonals to the right until b[0][0] is reached
        for (int col = 3; col < 0; col--) {
            // c allows the checker to move diagonally without changing which column the
            // diagonal starts from
            int c = col;
            char token = b[col][0];

            for (int row = 0; row < 6 && c < 7; row++, c++) {
                if (token == b[c][row] && token != '\0') {
                    count++;
                }
                // if token is not the same as the checked token, the token changes value to the
                // next kind in line and count resets to 0
                else if (token != '\0') {
                    token = b[c][row];
                    c--;
                    row--;
                    count = 0;
                }

                if (count == 4) {
                    return true;
                }
            }
        }

        // checks diagonals from b[0][0] to b[0][2] because that is the last possible
        // diagonal in the right direction
        for (int row = 0; row < 3; row++) {
            // r allows the checker to move diagnonally without affecting the row
            int r = row;
            char token = b[0][row];

            for (int col = 0; col < 7 && r < 6; col++, r++) {
                if (token == b[col][r] && token != '\0') {
                    count++;
                }
                // if token is not the same as the checked token, the token changes value to the
                // next kind in line and count resets to 0
                else if (token != '\0') {
                    token = b[col][r];
                    col--;
                    r--;
                    count = 0;
                }

                if (count == 4) {
                    return true;
                }
            }
        }

        // now checker looks at diagonals going left
        // starts with diagonals from b[3][0] until b[6][0] is reached
        for (int col = 3; col < 7; col++) {
            int c = col;
            char token = b[col][0];

            for (int row = 0; row < 6 && c >= 0; row++, c--) {
                if (token == b[c][row] && token != '\0') {
                    count++;
                }
                // if token is not the same as the checked token, the token changes value to the
                // next kind in line and count resets to 0
                else if (token != '\0') {
                    token = b[c][row];
                    c++;
                    row--;
                    count = 0;
                }

                if (count == 4) {
                    return true;
                }
            }
        }

        // checks diagonals from b[6][1] to the last diagonal to teh left: b[6][2].
        // Starts at row = 1 because we already covered b[6][0] in the last for loop
        for (int row = 1; row < 3; row++) {
            int r = row;
            char token = b[6][row];

            for (int col = 6; col >= 0 && r < 6; col--, r++) {
                if (token == b[col][r] && token != '\0') {
                    count++;
                }
                // if token is not the same as the checked token, the token changes value to the
                // next kind in line and count resets to 0
                else if (token != '\0') {
                    token = b[col][r];
                    col++;
                    r--;
                    count = 0;
                }

                if (count == 4) {
                    return true;
                }
            }
        }
        return false;
    }
}
