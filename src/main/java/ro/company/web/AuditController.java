package ro.company.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.company.service.AuditService;

import javax.inject.Inject;

/**
 * Created by Cristian.Dumitru on 3/11/2015.
 */
@Controller
@RequestMapping("/")
public class AuditController {

    private AuditService auditService;

    @Inject
    public AuditController(AuditService auditService) {
        this.auditService = auditService;
    }

    @RequestMapping(value = "/audit", method = RequestMethod.GET)
    public String audit(Model model) {

        model.addAttribute("auditList", auditService.findAllAudits());
        return "audit";
    }
}