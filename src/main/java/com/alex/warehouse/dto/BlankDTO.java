package com.alex.warehouse.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BlankDTO {
    private int id;
    private int request_id;
    private int driver_id;
    private int tanker_id;
    private int status_id;
    private int employee_id;
}
