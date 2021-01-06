package com.gian.reniec.service.impl;

import com.gian.reniec.model.request.ReniecRequest;
import com.gian.reniec.model.response.ReniecResponse;
import com.gian.reniec.service.IReniecService;
import io.reactivex.Single;
import org.springframework.stereotype.Service;

@Service
public class RenicServiceImpl implements IReniecService {
    @Override
    public Single<ReniecResponse> validateReniec(ReniecRequest reniecRequest) {
        ReniecResponse response = new ReniecResponse();
        response.setSuccess(true);
        response.setEntityName("Reniec");

        return Single.just(response);
    }
}
