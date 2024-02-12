package japdp.tuita.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PublicationPostDto {

    private long   userId;
    private String text;
    private String creationDate;
    private String editionDate;
	
}
