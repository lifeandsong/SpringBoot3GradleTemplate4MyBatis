package org.swmaestro.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class BaseModel {

    protected String used;
    protected String creator;
    protected Date createdAt;
    protected String updater;
    protected Date updatedAt;

}