import java.io.File

fun main() {
	File("input/8.txt").readLines().let { lines ->
		val grid = Array(lines[0].length) { IntArray(lines.size) }
		lines.forEachIndexed { y, line -> line.map { it - '0' }.forEachIndexed { x, h -> grid[x][y] = h } }
		println((grid.indices).sumOf { x -> grid[0].indices.count { y ->
			arrayOf(0 to 1, 0 to -1, 1 to 0, -1 to 0).any { (dx, dy) ->
				(1 until if (dy == 0) grid.size else grid[0].size).none { ci ->
					x + ci * dx >= 0 && y + ci * dy >= 0 && x + ci * dx < grid.size && y + ci * dy < grid[0].size && grid[x + ci * dx][y + ci * dy] >= grid[x][y]
				}
			}
		} })
	}
}