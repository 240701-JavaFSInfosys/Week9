package com.revature;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class Launcher implements RequestHandler<Object, String> {

    @Override
    public String handleRequest(Object o, Context context) {

        context.getLogger().log("The Maven Lambda is Running!");

        return "Hello from the Maven app running on an AWS Lambda";

    }

}
