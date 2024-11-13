package umc.study.domain;


import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.service.annotation.GetExchange;
import umc.study.domain.common.BaseEntity;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "region_id")
    private Region region;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(length = 50)
    private String address;

    @Column(nullable = false)
    private Float score;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private final List<Mission> missionList = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private final List<Review> reviewList = new ArrayList<>();

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", score=" + score +
                ", region=" + (region != null ? region.getName() : "N/A") + // region의 이름 출력
                '}';
    }

}
