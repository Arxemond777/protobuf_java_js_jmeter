package example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Struct;
import com.google.protobuf.util.JsonFormat;
import example.dto.RequestStatesJsonDTO;
import example.proto.StatesProto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.stream.Collectors;

@Service
public class StatesService {
    private RequestStatesJsonDTO data;
//    private InputStream inputStream;
    private String path;
    @Autowired
    private ObjectMapper om;
    private StatesProto.States states;
    @PostConstruct
    public void postConstruct() throws IOException {
        System.out.println("InitSequenceBean: postConstruct");
//        File file = ResourceUtils.getFile("classpath:static/17.1mb_3.10sec_states.json");
        this.path = "classpath:static/test.json";
//        this.path = "classpath:static/17.1mb_3.10sec_states.json";
        File file = ResourceUtils.getFile(path);
        StatesProto.States.Builder structBuilder = StatesProto.States.newBuilder();
        JsonFormat.parser().ignoringUnknownFields().merge(new InputStreamReader(new FileInputStream(ResourceUtils.getFile(path))), structBuilder);
        this.states = structBuilder.build();
//        String content = new String(Files.readAllBytes(file.toPath()));
//        System.out.println(content.substring(0, 50));
//        data = om.readValue(file, RequestStatesJsonDTO.class);
//        inputStream = new FileInputStream(ResourceUtils.getFile(path));
//        System.out.println(data);
        System.out.println("InitSequenceBean: postConstruct");
    }

    public StatesProto.States getProtoStates() {
//        StatesProto.States states = null;
//        try {
////            String text = new BufferedReader(
////                    new InputStreamReader(new FileInputStream(ResourceUtils.getFile(path)), StandardCharsets.UTF_8))
////                    .lines()
////                    .collect(Collectors.joining("\n"));
////            System.out.println(text);
////            StatesProto.States.parseFrom(new FileInputStream(ResourceUtils.getFile(path)));
////            states = StatesProto.States.parseFrom(new FileInputStream(ResourceUtils.getFile(path)));
////            JsonFormat.parser().ignoringUnknownFields().merge(new BufferedReader(new InputStreamReader(new FileInputStream(ResourceUtils.getFile(path))), StatesProto.States.newBuilder());
//            /*StatesProto.States.Builder structBuilder = StatesProto.States.newBuilder();
//            JsonFormat.parser().ignoringUnknownFields().merge(new InputStreamReader(new FileInputStream(ResourceUtils.getFile(path))), structBuilder);
//            states = structBuilder.build();*/
////            YourObject value = StatesProto.States.build();
//        } catch (IOException e) {
//            System.err.println(e.getMessage());
//        }
        return this.states;
//        Struct.Builder structBuilder = Struct.newBuilder();
//        JsonFormat.parser().ignoringUnknownFields().merge("json", structBuilder);
////        structBuilder.build().
//        return structBuilder.build();
//        Struct.Builder protobuf = ProtobufUtil.fromJson(jsonStr);
    }

    public RequestStatesJsonDTO getStates() {
        return this.data;
    }
}
