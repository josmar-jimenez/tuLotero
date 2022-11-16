package com.tulotero.chispazo.entrypoint;

import com.tulotero.chispazo.usecase.ChispazoDrawFinder;
import com.tulotero.chispazo.usecase.ChispazoBetPrizeCalculator;
import com.tulotero.chispazo.domain.bean.ChispazoBet;
import com.tulotero.chispazo.domain.bean.ChispazoDraw;
import com.tulotero.chispazo.domain.bean.PrizeInfo;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/rest/chispazo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@OpenAPIDefinition(info = @Info(title = "Chispazo API", description = "Chispazo Game API", version = "1.0.0"))
@RequiredArgsConstructor
public class ChispazoResource {

    final ChispazoDrawFinder drawFinder;
    final ChispazoBetPrizeCalculator prizeCalculator;

    @Path("/draws/{drawId}")
    @GET
    @Operation(summary = "Returns information about a Chispazo Draw")
    @APIResponse(
            responseCode = "200",
            description = "Ok. Information with the Chispazo Draw",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(type = SchemaType.OBJECT, implementation = ChispazoDraw.class))
    )
    @APIResponse(
            responseCode = "404",
            description = "No Chispazo found for the Id passed as argument"
    )
    public Response getDrawInfo(@PathParam("drawId") Long drawId){
        Optional<ChispazoDraw> drawOpt = drawFinder.find(drawId);
        return drawOpt.map(this::createResponseOk)
                .orElse(createResponseNotFound());
    }

    @Path("/draws/{drawId}/prize")
    @POST
    @Operation(summary = "Check the prize of a Bet for a draw", description = "The bet and the draw id is sended. The prize is returned")
    @APIResponse(
            responseCode = "200",
            description = "Information with the prize for this bet is returned",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(type = SchemaType.OBJECT, implementation = PrizeInfo.class))
    )
    @APIResponse(
            responseCode = "404",
            description = "No Chispazo found for the Id passed as argument"
    )
    public Response calculatePrizeInfo(@PathParam("drawId") Long drawId, ChispazoBet bet){
        throw new UnsupportedOperationException("To be developed following the tests in ChispazoResourceTest");
    }

    private Response createResponseOk(Object entity) {
        return Response.status(Response.Status.OK)
                .entity(entity)
                .build();
    }

    private Response createResponseNotFound() {
        return Response.status(Response.Status.NOT_FOUND)
                .build();
    }
}