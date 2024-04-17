package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
@RequiredArgsConstructor
@Qualifier("templateEngine")
public class MailCreatorService {

    private final TemplateEngine templateEngine;
    private final AdminConfig adminConfig;

    public String buildTrelloCardEmail(String message) {
        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "https://jakubwaw93.github.io");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("companyName", adminConfig.getCompanyName());
        return templateEngine.process("mail/created-trello-card-mail.html", context);
    }

}
