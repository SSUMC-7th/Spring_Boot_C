package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.commom.BaseEntity;
import umc.study.domain.enums.MissionStatus;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_mission_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @Column(nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    @Column(nullable = false)
    private Mission mission;

    //status에 따른 이름 바꿔주기
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MissionStatus missionStatus;
}
