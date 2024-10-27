package umc.study.domain.commom;


import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public abstract class BaseEntity {

    //LocalDateTime은 6자리 까지 만들어 주는가..?
    @CreatedDate
    @Column(columnDefinition = "datetime(6)")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(columnDefinition = "datetime(6)")
    private LocalDateTime updatedAt;
}
