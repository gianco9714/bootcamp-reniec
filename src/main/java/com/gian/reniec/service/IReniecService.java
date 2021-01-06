package com.gian.reniec.service;

import com.gian.reniec.model.request.ReniecRequest;
import com.gian.reniec.model.response.ReniecResponse;
import io.reactivex.Single;

public interface IReniecService {

    Single<ReniecResponse> validateReniec(ReniecRequest reniecRequest);
}
