package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity	// JPA가 이 객체를 사용해야겠다는걸 인식함
@SequenceGenerator(
    name = "MEMBER_SEQ_GENERATOR",
    sequenceName = "MY_SEQUENCE",
    initialValue = 1, allocationSize = 50)
public class Member {

    @Id    // JPA에게 primary key를 알려줘야함
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ_GENERATOR")
    private Long id;

    @Column(name = "name", updatable = false)
    private String username;

    public Member() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
