package documents;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;
import util.TokenType;

@Data
@Document
@Builder
public class Token {

    @MongoId(value = FieldType.OBJECT_ID)
    private Integer id;

    @Indexed(unique = true)
    public String token;

    @Enumerated(EnumType.STRING)
    private TokenType tokenType = TokenType.BEARER;

    private boolean revoked;

    public boolean expired;

    @DBRef
    public Personne user;
}
