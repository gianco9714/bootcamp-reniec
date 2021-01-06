package com.gian.reniec.controllers;

import com.gian.reniec.model.request.ReniecRequest;
import com.gian.reniec.model.response.ReniecResponse;
import com.gian.reniec.service.IReniecService;
import io.reactivex.Single;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequestMapping("/external")
@Api(value = "ReniecController", produces = "application/json", tags = { "Reniec Controller" })
public class ReniecController {

    @Autowired
    private IReniecService reniecService;

    @ApiOperation(value = "Validar Reniec", tags = { "Reniec Controller" })
    @PostMapping(value = "/reniec/validate", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Consulta Éxitosa", response = ReniecResponse.class),
            @ApiResponse(code= 500, message = "500 Error Internal.")})
    public Single<ReniecResponse> validateReniec(@RequestBody ReniecRequest reniecRequest){

        log.info("Controller: Post Reniec with Document Number: " + reniecRequest.getDocument());
        return reniecService.validateReniec(reniecRequest);
    }
}
