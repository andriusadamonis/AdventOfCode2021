class Day4 {

    data class Board(val no: Int, var marked: Boolean, val board: MutableMap<Int, Cell>)
    data class Cell(val col: Int, val row: Int, val number: Int, var marked: Boolean)

    fun bingoWinning(data: List<String>): Int {
        return play(data, { markedBoards, boards ->
            markedBoards.firstOrNull { it.marked }
        })
    }

    fun bingoLosing(data: List<String>): Int {
        return play(data, { markedBoards, boards ->
            if (boards.all({ it.marked }))
                markedBoards.lastOrNull()
            else
                null
        })
    }

    fun play(data: List<String>, stopRule: (markedBoards: List<Board>, boards: List<Board>) -> Board?): Int {

        // load

        val moves = data.get(0).split(",").map { it.toInt() }

        var boards = mutableListOf<Board>()

        var p = 0 // start from 1
        var row = 0
        while (++p < data.size) {
            val str = data[p].trim()
            if (str.isBlank()) {
                boards += Board(boards.size, false, mutableMapOf<Int, Cell>())
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

            val markedBoards: MutableList<Board> = mutableListOf()

            for (board in boards.withIndex()) {

                if (board.value.board.contains(moves[p])) {

                    // mark as found
                    board.value.board[moves[p]]?.marked = true

                    // check if there's full col or row
                    val mark =
                        (board.value.board.filter { it.value.row == board.value.board[moves[p]]?.row }.all { it.value.marked }) ||
                        (board.value.board.filter { it.value.col == board.value.board[moves[p]]?.col }.all { it.value.marked })

                    if (!board.value.marked && mark) {

                        board.value.marked = true
                        markedBoards.add(board.value)

                    }
                }
            }

            val winner = stopRule(markedBoards, boards)
            if (winner != null) {

                return moves[p] * winner.board.filter { !it.value.marked }.map { it.value.number }.sum()

            }
        }

        return 0
    }

}