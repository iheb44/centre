package documents;

import com.fasterxml.jackson.annotation.JsonFormat;
import documents.Groupe;
import documents.Personne;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

@Data
@Document
public class Responsable extends Personne {
    @MongoId(value = FieldType.OBJECT_ID)
    private String id;
    private String ResponsableNumber;
    @DBRef
    private Groupe groupe;
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "GMT+8")
    private Date birthday;
    @CreatedDate
    private Date createdDate;
    @LastModifiedDate
    private Date lastModifiedDate;

}
