package com.example.signeasy.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by vaishakhnr on 10/18/17.
 */
@Data
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BorrowPojo {
	private long memberId;
	private long bookId;
	private long quantity;
}
