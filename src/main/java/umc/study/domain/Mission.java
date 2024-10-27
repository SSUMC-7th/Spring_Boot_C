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
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "store_id")
    private Store store;

    @Column(nullable = false)
    private Integer reward;

    @Column(nullable = false)
    private LocalDateTime deadline;

    @Lob
    @Column(nullable = false,columnDefinition = "text")
    private String missionSpec;
}
