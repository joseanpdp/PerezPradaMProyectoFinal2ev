package japdp.tuita.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PublicationPutDto {

	private Long   id;
    private Long   userId;
    private String text;
    private String creationDate;
    private String editionDate;
	
}
