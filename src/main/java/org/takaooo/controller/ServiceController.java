package org.takaooo.controller;

import com.sun.jersey.multipart.FormDataParam;
import org.takaooo.service.StatementReaderService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.FileNotFoundException;

@Path("myresource")
public class ServiceController {

    private StatementReaderService readerService = new StatementReaderService();

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Hello!";
    }


    @POST
    @Path("/upload/{bank}")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public String upload(
            @FormDataParam("file") File inputFile,
            @PathParam("bank") String bank
    ) throws FileNotFoundException {
        readerService.read(inputFile, bank);
        return "Received File!";
    }
}
