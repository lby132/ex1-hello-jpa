package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity	// JPA가 이 객체를 사용해야겠다는걸 인식함
public class Member extends BaseEntity {

    @Id    // JPA에게 primary key를 알려줘야함
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    //@JoinColumn(name = "TEAM_ID", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Team team;

//    @ManyToMany
//    @JoinColumn(name = "member")
//    private List<MemberProduct> memberProducts = new ArrayList<>();

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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }


}
