package example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.BaseEncoding;
import com.google.protobuf.util.JsonFormat;
import example.dto.RequestStatesJsonDTO;
import example.proto.StatesProto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class StatesService {
    private String path;
    @Autowired
    private ObjectMapper om;
    private StatesProto.States states;
    String asBase64;
    @PostConstruct
    public void postConstruct() throws IOException {
        System.out.println("InitSequenceBean: postConstruct");
//        File file = ResourceUtils.getFile("classpath:static/17.1mb_3.10sec_states.json");
//        this.path = "classpath:static/test.json";
        this.path = "classpath:static/17.1mb_3.10sec_states.json";
//        this.path = "/Users/urijglusenkov/InteliJ/reserach_paper_optimization/src/main/resources/static/17.1mb_3.10sec_states.json";
        StatesProto.States.Builder structBuilder = StatesProto.States.newBuilder();
        JsonFormat.parser().ignoringUnknownFields().merge(new InputStreamReader(new FileInputStream(ResourceUtils.getFile(path))), structBuilder);
        this.states = structBuilder.build();
        asBase64 = BaseEncoding.base64().encode(this.states.toByteArray());
    }

    public String getProtoStatesBase62() {
        return asBase64;
    }
    public StatesProto.States getProtoStates() {
        StatesProto.States.Builder structBuilder = StatesProto.States.newBuilder();
        try {
            JsonFormat.parser().ignoringUnknownFields().merge(new InputStreamReader(new FileInputStream(ResourceUtils.getFile(path))), structBuilder);
            return structBuilder.build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public RequestStatesJsonDTO getStates() {
        try {
            File file = ResourceUtils.getFile(path);
//            File file = new File(path);
            return om.readValue(file, RequestStatesJsonDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
