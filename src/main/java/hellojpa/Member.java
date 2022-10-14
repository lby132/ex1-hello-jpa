package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity	// JPA가 이 객체를 사용해야겠다는걸 인식함
public class Member {

    @Id	// JPA에게 primary key를 알려줘야함
    private Long id;
    private String name;

    public Member() {
    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
