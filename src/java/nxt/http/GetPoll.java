package nxt.http;

import nxt.NxtException;
import nxt.Poll;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;


public final class GetPoll extends APIServlet.APIRequestHandler {

    static final GetPoll instance = new GetPoll();

    private GetPoll() {
        super(new APITag[] {APITag.VS}, "includeVoters", "poll");
    }

    @Override
    JSONStreamAware processRequest(HttpServletRequest req) throws NxtException {
        Poll poll = ParameterParser.getPoll(req);
        boolean includeVoters = ParameterParser.getBoolean(req, "includeVoters", false);
        return JSONData.poll(poll, includeVoters);
    }
}
