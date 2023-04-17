package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1");
        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    void split2() {
        String[] actual = "1".split(",");
        assertThat(actual).contains("1");
        assertThat(actual).containsExactly("1");
    }

    @Test
    void substring() {
        String actual = "(1,2)".substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    void substring2() {
        String actual = "abc".substring(0, 2);
        assertThat(actual).isEqualTo("ab");
    }

    @Test
    void charAt() {
        String actual = "abc";
        assertThat(actual.charAt(0)).isEqualTo('a');
        assertThat(actual.charAt(1)).isEqualTo('b');
        assertThat(actual.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("String 클래스의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트")
    void charAt2() {
        String actual = "abc";
        assertThatThrownBy(() -> {
            actual.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
