package example.controller;

import example.dto.RequestStatesJsonDTO;
import example.proto.StatesProto;
import example.service.StatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class StatesController {

    @Autowired
    private StatesService ss;

    @CrossOrigin(origins = "*")
//    @PostMapping(value = "/states", consumes = "application/json", produces = "application/json")
    @GetMapping(value = "/states"/*, produces = "application/protobuf"*/)
//    @GetMapping(value = "/states", produces = "application/x-protobuf;charset=UTF-8")
//    @GetMapping(value = "/states", produces = "application/x-protobuf;charset=ASCII")
    public ResponseEntity<?> states(/*@RequestBody RequestStatesDTO states*/) {
        System.out.println(LocalDateTime.now());
        RequestStatesJsonDTO statesDefault = ss.getStates();
        StatesProto.States statesProto = ss.getProtoStates();
        String statesProtoBase64 = ss.getProtoStatesBase62();

        return new ResponseEntity<>(statesDefault, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/states-proto")
    public ResponseEntity<?> statesProto(/*@RequestBody RequestStatesDTO states*/) {
        StatesProto.States statesProto = ss.getProtoStates();
        return new ResponseEntity<>(statesProto, HttpStatus.OK);
    }
}
