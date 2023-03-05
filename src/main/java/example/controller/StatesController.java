package example.controller;

import com.google.common.io.BaseEncoding;
import com.google.protobuf.StringValue;
import example.dto.*;
import example.proto.StatesProto;
import example.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class StatesController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private StatesService ss;

    @CrossOrigin(origins = "*")
//    @PostMapping(value = "/states", consumes = "application/json", produces = "application/json")
    @GetMapping(value = "/states"/*, produces = "application/protobuf"*/)
//    @GetMapping(value = "/states", produces = "application/x-protobuf;charset=UTF-8")
//    @GetMapping(value = "/states", produces = "application/x-protobuf;charset=ASCII")
    public ResponseEntity<?> states(/*@RequestBody RequestStatesDTO states*/) {
        System.out.println(LocalDateTime.now());
//        System.out.println(states);
//        return new ResponseStatesDTO(counter.incrementAndGet(), String.format(template, "aa"));
        RequestStatesJsonDTO statesDefault = ss.getStates();
        StatesProto.States statesProto = ss.getProtoStates();
        String statesProtoBase64 = ss.getProtoStatesBase62();
//        String asBase64 = BaseEncoding.base64().encode(states2.toByteArray());
//        System.out.println(states1.getModel().getRows().get(2));
//        StatesProto.States s = StatesProto.States.newBuilder()
//                .setModel("model1")
//                .setStatusMessage("statusMessage2")
//                .setStatus("status3")
//                .build();
//        System.out.println(states2.getStatusMessage());
//        System.out.println(states2.getStatus());
//        System.out.println(states2);
        return new ResponseEntity<>(statesDefault, HttpStatus.OK);
//        return new ResponseEntity<>(states1, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/states-proto")
    public ResponseEntity<?> statesProto(/*@RequestBody RequestStatesDTO states*/) {
        StatesProto.States statesProto = ss.getProtoStates();
        return new ResponseEntity<>(statesProto, HttpStatus.OK);
    }
}
