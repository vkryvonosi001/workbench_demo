package com.example.workbench_demo.controller;

import com.example.workbench_demo.service.DomainService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/engagements")
public class DomainController {
    private final DomainService domainService;

    public DomainController(DomainService domainService) {
        this.domainService = domainService;
    }

    @PostMapping("{engagementId}/domains-config")
    public ResponseEntity<String> addDomains(@RequestBody List<String> domains,
                                             @RequestParam Boolean limitToClientRequest,
                                             @RequestParam Boolean limitToReportShare,
                                             @PathVariable String engagementId) {

        domainService.addDomains(domains, engagementId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{engagementId}/domains-config")
    public ResponseEntity<List<String>> getDomains(@PathVariable String engagementId) {
        return ResponseEntity.ok(domainService.getDomains(engagementId));
    }
}
