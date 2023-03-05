package example.dto;

public class RequestedTimeRangeDataDTO {
    public long start;
    public long end;
    public long nbTimes;

    public long getStart() {
        return start;
    }

    public RequestedTimeRangeDataDTO setStart(long start) {
        this.start = start;
        return this;
    }

    public long getEnd() {
        return end;
    }

    public RequestedTimeRangeDataDTO setEnd(long end) {
        this.end = end;
        return this;
    }

    public long getNbTimes() {
        return nbTimes;
    }

    public RequestedTimeRangeDataDTO setNbTimes(long nbTimes) {
        this.nbTimes = nbTimes;
        return this;
    }

    @Override
    public String toString() {
        return "start=" + start +
                ", end=" + end +
                ", nbTimes=" + nbTimes;
    }
}
