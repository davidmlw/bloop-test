
import org.scalatest.{ConfigMap, BeforeAndAfterAllConfigMap}
import org.scalatest.freespec.{AnyFreeSpec}

class FooTester extends AnyFreeSpec with BeforeAndAfterAllConfigMap{

  private val key = "key"
  private var value = "Hello World"

  override def beforeAll(configMap: ConfigMap) {


    println(System.getProperty("java.version"))
    println(System.getProperty("java.runtime.version"))
    println(System.getProperty("key"))
    println(sys.env.get("key"))

    assume(configMap.isDefinedAt(key), "Config key: " + key)
    value = configMap.getRequired[String](key)
  }

  "Basic test" in {
    println(value)
  }
}
