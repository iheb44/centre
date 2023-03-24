package documents;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

@Data
@Document
public class Planning {
    @MongoId(value = FieldType.OBJECT_ID)

    private String id;
private String descPlanning;
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "GMT+8")
    private Date birthday;
    @CreatedDate
    private Date createdDate;
    @LastModifiedDate
    private Date lastModifiedDate;

}
