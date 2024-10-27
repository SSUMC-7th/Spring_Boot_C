package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import org.w3c.dom.Text;
import umc.study.domain.commom.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Terms extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "terms_id")
    private Long id;

    @Column(nullable = false, length = 20)
    private String title;

    @Lob
    @Column(nullable = false, columnDefinition = "text")
    private String body;

    @Column(nullable = false)
    private boolean optional;
}
