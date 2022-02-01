package gurkan.nisanci.internal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message {
    @Id
    @GeneratedValue
    @Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
    Long id;
    @Column
    String message;

    @CreationTimestamp
    @Column(updatable = false)
    Timestamp dateCreated;

}
