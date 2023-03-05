package example.dto;

public class RequestStatesDTO {
    private RequestedTimeRangeDTO parameters;

    @Override
    public String toString() {
        return "{parameters: {" +  parameters + "}}";
    }

    public RequestedTimeRangeDTO getParameters() {
        return parameters;
    }

    public RequestStatesDTO setParameters(RequestedTimeRangeDTO parameters) {
        this.parameters = parameters;
        return this;
    }
}
