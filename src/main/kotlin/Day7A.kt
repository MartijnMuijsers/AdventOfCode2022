import java.io.File
import java.util.*

fun main() {
	var sum = 0L
	open class DeviceFile(var size: Long)
	class DeviceFolder(val parent: DeviceFolder? = null, var files: MutableMap<String, DeviceFile> = HashMap()) : DeviceFile(-1) {
		fun addToSum() {
			if (size == -1L) {
				size = 0L
				files.values.forEach {
					(it as? DeviceFolder)?.addToSum()
					size += it.size
				}
			}
			if (size <= 100000) sum += size
		}
	}
	val root = DeviceFolder()
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
	root.addToSum()
	println(sum)
}