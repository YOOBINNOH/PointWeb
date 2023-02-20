//package Domain;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//public class Team {
//
//    @Id @GeneratedValue
//    private Long team_id;
//
//    @OneToMany(mappedBy = "member_id")
//    private List<Member> members = new ArrayList<>();
//
//    private Long current_team_point;
//
//    private Long give_team_point;
//
//    private Long receive_team_point;
//
//
//
//
//}
