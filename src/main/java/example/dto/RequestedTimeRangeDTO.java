package example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestedTimeRangeDTO {

    @JsonProperty("requested_timerange")
    private RequestedTimeRangeDataDTO requestedTimerangeData;

    @Override
    public String toString() {
        return "requested_time_range {" + requestedTimerangeData + '}';
    }

    public RequestedTimeRangeDataDTO getRequestedTimerangeData() {
        return requestedTimerangeData;
    }

    public RequestedTimeRangeDTO setRequestedTimerangeData(RequestedTimeRangeDataDTO requestedTimerangeData) {
        this.requestedTimerangeData = requestedTimerangeData;
        return this;
    }
}
