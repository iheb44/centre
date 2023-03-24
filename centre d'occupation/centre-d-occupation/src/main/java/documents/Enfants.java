package documents;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

public class Enfants {
    @MongoId(value = FieldType.OBJECT_ID)
    private String id;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    @DBRef
    private Responsable Resp;
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "GMT+8")
    private Date birthday;
    @CreatedDate
    private Date createdDate;
    @LastModifiedDate
    private Date lastModifiedDate;


}
