package com.go4u.keepitfreshplatform.reports.interfaces.rest.resources;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateReportResource {
    private String title;
    private String description;
}
