package example.controller;

import com.google.protobuf.StringValue;
import example.dto.*;
import example.proto.StatesProto;
import example.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> states(/*@RequestBody RequestStatesDTO states*/) {
//        System.out.println(states);
//        return new ResponseStatesDTO(counter.incrementAndGet(), String.format(template, "aa"));
        RequestStatesJsonDTO states1 = ss.getStates();
        StatesProto.States states2 = ss.getProtoStates();
//        System.out.println(states1.getModel().getRows().get(2));
//        StatesProto.States s = StatesProto.States.newBuilder()
//                .setModel("model1")
//                .setStatusMessage("statusMessage2")
//                .setStatus("status3")
//                .build();
//        System.out.println(states2.getStatusMessage());
//        System.out.println(states2.getStatus());
//        System.out.println(states2);
        return new ResponseEntity<>(states2, HttpStatus.OK);
//        return new ResponseEntity<>(states1, HttpStatus.OK);
    }
}
