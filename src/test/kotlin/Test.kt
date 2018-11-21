import org.assertj.core.api.Assertions
import org.junit.Test

class Test {

    @Test
    fun test() {
        Assertions.assertThat("this").isNotEqualTo("that")
    }
}
