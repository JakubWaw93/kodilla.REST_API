package com.crud.tasks.domain;

import lombok.*;

@Getter
@Builder(access = AccessLevel.PUBLIC)
@RequiredArgsConstructor
public class Mail {

    private final String mailTo;
    private final String subject;
    private final String message;
    private final String toCC;

}
