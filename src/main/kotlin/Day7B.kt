import java.io.File
import java.util.*

var best = 70000000L
val root = DeviceFolder()

open class DeviceFile(var size: Long)
class DeviceFolder(val parent: DeviceFolder? = null, var files: MutableMap<String, DeviceFile> = HashMap()) : DeviceFile(-1) {

	fun calculateSum() {
		if (size != -1L) return
		size = 0L
		files.values.forEach {
			(it as? DeviceFolder)?.calculateSum()
			size += it.size
		}
	}

	fun checkBest() {
		files.values.mapNotNull { it as? DeviceFolder }.forEach(DeviceFolder::checkBest)
		if (size >= root.size - 40000000 && size < best) best = size
	}

}

fun main() {
	var current = root
	File("input/7.txt").forEachLine { line ->
		if (line.startsWith("$ cd ")) {
			val target = line.split(' ')[2]
			current = when (target) {
				"/" -> root
				".." -> current.parent!!
				else -> current.files[target] as DeviceFolder
			}
		} else if (!line.startsWith("$ "))
			current.files[line.split(' ')[1]] = if (line.startsWith("dir ")) DeviceFolder(current) else DeviceFile(line.split(' ')[0].toLong())
	}
	root.calculateSum()
	root.checkBest()
	println(best)
}