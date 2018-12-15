package in.blucon.app.responsehandlers;


import in.blucon.app.object.Response;


public class RequestServiceFactory {
    private     Response response_;

    public RequestServiceFactory(Response response) {
        response_ = response;
    }

    public RequestHandler getRequestHandler() {

        switch (response_.getResponseCode()) {
            case 103:
                return new BillRequestHandler();

            case 100:
                return new MenuRequestHandler();

            case 106:
                return new ItemTypeRequestHandler();

            default:
                return null;
        }

    }
}
