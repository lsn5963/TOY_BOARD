package boardexample.myboard.learning;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PasswordEncoderTest {
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Test
    public void 패스워드_암호화() throws Exception{
        String password = "프리snl";

        String encodePassword = passwordEncoder.encode(password);
        System.out.println("encodePassword = " + encodePassword);
        assertThat(encodePassword).startsWith("&");
        assertThat(encodePassword).contains("{bcrypt}");
        assertThat(encodePassword).isNotEqualTo(password);
    }
}
