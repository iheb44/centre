package documents;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;
import java.util.List;

public class Groupe {
    @MongoId(value = FieldType.OBJECT_ID)
    private String id;
    @DBRef
    private List<Enfants> Grpenfants;
    @DBRef
    private Responsable resp;
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "GMT+8")
    private Date birthday;
    @CreatedDate
    private Date createdDate;
    @LastModifiedDate
    private Date lastModifiedDate;

}
