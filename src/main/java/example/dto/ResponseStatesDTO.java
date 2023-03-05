package example.dto;

public class ResponseStatesDTO {
    private long id;
    private String content;

    public ResponseStatesDTO(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}