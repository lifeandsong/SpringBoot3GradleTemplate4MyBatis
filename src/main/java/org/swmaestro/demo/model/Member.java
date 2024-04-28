package org.swmaestro.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Base Model
 *
 * @since	2022-06-29
 * @author	ywkim
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class Member extends BaseModel {

    private String id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String name;

    private String email;

    private String phone;

}
