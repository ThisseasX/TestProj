package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;

@Controller
public class InterController {

    private final MessageSource messageSource;

    @Autowired
    public InterController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/inter")
    public String inter(Locale locale, Model model) {
        String welcome = messageSource.getMessage("test.code", new Object[]{"Thiss"}, locale);
        model.addAttribute("message", welcome);

        // obtain locale from LocaleContextHolder
        Locale currentLocale = LocaleContextHolder.getLocale();
        model.addAttribute("locale", currentLocale);

        model.addAttribute("startMeeting", "10:30");
        return "inter";
    }
}
