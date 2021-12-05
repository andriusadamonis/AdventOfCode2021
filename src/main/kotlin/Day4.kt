class Day4 {

    data class Board(val board: MutableMap<Int, Cell>, var marked: Boolean)
    data class Cell(val col: Int, val row: Int, val number: Int, var marked: Boolean)

    fun bingo(data: List<String>): Int {
        return play(data, { current, boards ->
            if (current.marked)
                current
            else
                null
        })
    }

    fun play(data: List<String>, stopRule: (current: Board, boards: List<Board>) -> Board?): Int {

        // load

        val moves = data.get(0).split(",").map { it.toInt() }

        var boards = mutableListOf<Board>()

        var p = 0 // start from 1
        var row = 0
        while (++p < data.size) {
            val str = data[p].trim()
            if (str.isBlank()) {
                boards += Board(mutableMapOf<Int, Cell>(), false)
                row = 0
            }
            else {
                str.split(Regex("\\s+")).withIndex().forEach {
                    val col = it.index
                    boards[boards.size - 1].board.set(it.value.toInt(), Cell(col, row, it.value.toInt(), false))
                }
                row++
            }
        }

        // play

        p = -1
        while (++p < moves.size) {

            val updatedBoards: MutableList<Board> = mutableListOf<Board>()

            for (board in boards.withIndex()) {

                if (board.value.board.contains(moves[p])) {

                    // mark as found
                    board.value.board[moves[p]]?.marked = true

                    // check if there's full col or row
                    board.value.marked =
                        (board.value.board.filter { it.value.row == board.value.board[moves[p]]?.row }.all { it.value.marked }) ||
                        (board.value.board.filter { it.value.col == board.value.board[moves[p]]?.col }.all { it.value.marked })

                    if (board.value.marked) {
                        updatedBoards.add(board.value)
                    }
                }
            }

            for (board in boards) {
                val winner = stopRule(board, boards)
                if (winner != null) {

                    return moves[p] * winner.board.filter { !it.value.marked }.map { it.value.number }.sum()

                }
            }
        }

        return 0
    }

}