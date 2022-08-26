package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StringCalculatorTest {
    private StringCalculator sut;

    @BeforeEach
    void setup() {
        sut = new StringCalculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 2:3", "4 + 10:14", "7 + 3:10", "8 - 1:7", "1 + 65 - 3 / 3:21"}, delimiter = ':')
    void sum(String expr, int result) {
        assertThat(sut.sum(expr)).isEqualTo(result);
    }
}
