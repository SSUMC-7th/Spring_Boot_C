package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.commom.BaseEntity;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mission_id")

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    private Integer reward;

    private LocalDateTime deadline;

    private String missionSpec;
}
