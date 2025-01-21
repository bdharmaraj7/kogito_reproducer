package com.sample;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
