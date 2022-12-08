import java.io.File

fun main() {
	File("input/8.txt").readLines().let { lines ->
		val grid = Array(lines[0].length) { IntArray(lines.size) }
		lines.forEachIndexed { y, line -> line.map { it - '0' }.forEachIndexed { x, h -> grid[x][y] = h } }
		println((1 until grid.size - 1).maxOf { x -> (1 until grid[0].size - 1).maxOf { y ->
			arrayOf(0 to 1, 0 to -1, 1 to 0, -1 to 0).map { (dx, dy) ->
				(0 until if (dy == 0) grid.size else grid[0].size).first { ci ->
					!(x + ci * dx >= 0 && y + ci * dy >= 0 && x + ci * dx < grid.size && y + ci * dy < grid[0].size && (ci <= 1 || grid[x + (ci - 1) * dx][y + (ci - 1) * dy] < grid[x][y]))
				} - 1
			}.reduce(Int::times)
		} })
	}
}