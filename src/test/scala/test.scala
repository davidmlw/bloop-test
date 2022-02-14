
import org.scalatest.{ConfigMap, BeforeAndAfterAllConfigMap}
import org.scalatest.freespec.{AnyFreeSpec}

class FooTester extends AnyFreeSpec with BeforeAndAfterAllConfigMap{

  private val key = "key"
  private var value = "Hello World"

  override def beforeAll(configMap: ConfigMap) {


    println(s"java version: ${System.getProperty("java.version")}")
    println(s"runtime version: ${System.getProperty("java.runtime.version")}")
    println(s"user.dir: ${System.getProperty("user.dir")}")
    println(s"user.key: ${System.getProperty("user.key")}")
    println(s"key: ${System.getProperty("key")}")
    println(s"env user.dir: ${sys.env.get("user.dir")}")
    println(s"env key: ${sys.env.get("key")}")

    assume(configMap.isDefinedAt(key), "Config key: " + key)
    value = configMap.getRequired[String](key)
  }

  "Basic test" in {
    println(value)
  }
}
