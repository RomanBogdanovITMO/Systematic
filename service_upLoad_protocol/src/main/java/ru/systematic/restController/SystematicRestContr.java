package ru.systematic.restController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import ru.systematic.model.Protocol;
import ru.systematic.service.ProtocolService;

import java.util.List;

@RestController
public class SystematicRestContr {
    private final Logger logger = LoggerFactory.getLogger(SystematicRestContr.class);
    private final ProtocolService protocolService;

    public SystematicRestContr(ProtocolService protocolService) {
        this.protocolService = protocolService;
    }

    @GetMapping("/add")
    public void addProtocol(@RequestBody Protocol protocol){
        logger.info("add protocol: " + protocol);
        protocolService.addProtocol(protocol);
    }
    @PostMapping("/list")
    public List<Protocol> fiandAll(){
        return protocolService.findAll();
    }

    @GetMapping("/protocol")
    public Protocol getProtocolById(@RequestParam int id,@RequestParam int first, @RequestParam int second){
        logger.info("params protocol: " + " id protocol-" + id + " firstInfo-" + first + " secondInfo-" + second);
        return protocolService.getProtocolById(id,first,second);
    }


}
