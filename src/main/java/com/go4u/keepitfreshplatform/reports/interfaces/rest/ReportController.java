package com.go4u.keepitfreshplatform.reports.interfaces.rest;


import com.go4u.keepitfreshplatform.reports.domain.model.aggregates.Report;
import com.go4u.keepitfreshplatform.reports.domain.services.ReportCommandService;
import com.go4u.keepitfreshplatform.reports.domain.services.ReportQueryService;
import com.go4u.keepitfreshplatform.reports.interfaces.rest.resources.CreateReportResource;
import com.go4u.keepitfreshplatform.reports.interfaces.rest.resources.ReportResource;
import com.go4u.keepitfreshplatform.reports.interfaces.rest.transform.CreateReportCommandFromResourceAssembler;
import com.go4u.keepitfreshplatform.reports.interfaces.rest.transform.ReportResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "api/v1/reports", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Reports", description = "Operations related to reports")
public class ReportController {
    private final ReportCommandService reportCommandService;
    private final ReportQueryService reportQueryService;

    public ReportController(ReportCommandService reportCommandService, ReportQueryService reportQueryService) {
        this.reportCommandService = reportCommandService;
        this.reportQueryService = reportQueryService;
    }

    //@Operation(
    //        summary = "Create a new report",
    //        description = "Creates a new report with the provided title and description.")
    //@ApiResponses(value = {
    //    @ApiResponse(responseCode = "201", description = "Report created successfully"),
    //    @ApiResponse(responseCode = "400", description = "Invalid input data")
    //})
    //@PostMapping()

}
