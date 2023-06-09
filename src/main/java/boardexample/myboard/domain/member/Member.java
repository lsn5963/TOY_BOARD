package boardexample.myboard.domain.member;

import boardexample.myboard.domain.BaseTimeEntity;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;    //primary Key
    @Column(nullable = false, length = 30, unique = true)
    private String username;    //아이디
    private String password;    //비밀번호
    @Column(nullable = false, length = 30)
    private String name;    //이름(실명)
    @Column(nullable = false, length = 30)
    private String nickName;    //별명
    @Column(nullable = false, length = 30)
    private Integer age;    //나이
    @Enumerated(EnumType.STRING)
    private Role role;  //권한 -> USER, ADMIN

    public void updatePassword(PasswordEncoder passwordEncoder, String password){
        this.password = passwordEncoder.encode(password);
    }
    public void updateName(String name){
        this.name = name;
    }
    public void updateNickName(String nickName){
        this.nickName = nickName;
    }
    public void updateAge(int age){
        this.age = age;
    }

    public void encodePassword(PasswordEncoder passwordEncoder){
        this.password = passwordEncoder.encode(password);
    }
}
