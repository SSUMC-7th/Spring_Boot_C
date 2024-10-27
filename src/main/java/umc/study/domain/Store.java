package umc.study.domain;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.service.annotation.GetExchange;
import umc.study.domain.commom.BaseEntity;

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

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String address;
    //Double? Float?
    private Float score;
}
