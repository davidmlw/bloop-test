
import org.scalatest.{ConfigMap, BeforeAndAfterAllConfigMap}
import org.scalatest.freespec.{AnyFreeSpec}

class FooTester extends AnyFreeSpec with BeforeAndAfterAllConfigMap{

  private var value = "Hello World"
  private val key = "key"

  override def beforeAll(configMap: ConfigMap) {
    assume(
      configMap.isDefinedAt(key),
      "Config key: " + key
    )
    value = configMap.getRequired[String](key)
  }

  // Delete the temp file
  override def afterAll(configMap: ConfigMap) {
  }

  "Basic test in chiseltest" in {
    println(value)
  }
}
