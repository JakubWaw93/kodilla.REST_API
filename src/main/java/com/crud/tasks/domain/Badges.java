package com.crud.tasks.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Badges {

    private int votes;
    private AttachmentsByType attachmentsByType;
}
