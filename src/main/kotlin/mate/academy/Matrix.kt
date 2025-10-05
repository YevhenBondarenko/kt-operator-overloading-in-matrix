package mate.academy

class Matrix(private val rows: Int, private val cols: Int) {
    private val data = Array(rows) { IntArray(cols) }

    operator fun get(row: Int, col: Int): Int = data[row][col]
    operator fun set(row: Int, col: Int, value: Int) {
        data[row][col] = value
    }

    operator fun plus(matrix: Matrix) = operatorFunction(matrix) { a, b -> a + b }

    operator fun minus(matrix: Matrix) = operatorFunction(matrix) { a, b -> a - b }

    private fun operatorFunction(matrix: Matrix, operation: (a: Int, b: Int) -> Int): Matrix {
        val result = Matrix(rows, cols)
        for (row in 0 until rows) {
            for (col in 0 until cols) {
                result[row, col] = operation.invoke(this[row, col], matrix[row, col])
            }
        }
        return result
    }

    override fun toString(): String {
        return data.joinToString(separator = "\n") { row -> row.joinToString(" ") }
    }
}
