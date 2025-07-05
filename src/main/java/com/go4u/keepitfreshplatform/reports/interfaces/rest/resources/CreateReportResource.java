package com.go4u.keepitfreshplatform.reports.interfaces.rest.resources;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class CreateReportResource {
    private String title;
    private String description;
}
