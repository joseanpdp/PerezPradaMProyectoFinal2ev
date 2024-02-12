package japdp.tuita.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserPutDto {

	private Long   id;
	private String username;
	private String password;
	private String email;
	private String description;
	private String creationDate;

}
