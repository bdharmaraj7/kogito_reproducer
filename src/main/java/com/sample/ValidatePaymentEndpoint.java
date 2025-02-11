package com.sample;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.inject.Inject;


import org.kie.api.runtime.KieRuntimeBuilder;
import org.kie.api.runtime.KieSession;


@Path("/validate-payment")
public class ValidatePaymentEndpoint {

    @Inject
    KieRuntimeBuilder kieRuntimeBuilder;

    @POST()
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Result executeQuery(Loan loan) {
        KieSession session = kieRuntimeBuilder.newKieSession();
        
        Result res = new Result();
               
        session.setGlobal("result", res);
        session.insert(loan);
        session.startProcess("SampleProcess");
        session.fireAllRules();

        return res;
    }

}
