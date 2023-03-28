package com.example.serverapi.controller;

import com.example.serverapi.model.Server;
import com.example.serverapi.repository.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servers")
public class ServerController {
    @Autowired
    private ServerRepository serverRepository;

    @GetMapping
    public ResponseEntity<List<Server>> getAllServers() {
        List<Server> servers = serverRepository.findAll();
        return new ResponseEntity<>(servers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Server> getServerById(@PathVariable("id") String id) {
        Optional<Server> server = serverRepository.findById(id);
        if (server.isPresent()) {
            return new ResponseEntity<>(server.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<Server> addServer(@RequestBody Server server) {
        Server addedServer = serverRepository.save(server);
        return new ResponseEntity<>(addedServer, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteServer(@PathVariable("id") String id) {
        serverRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<Server>> findServersByName(@PathVariable("name") String name) {
        List<Server> servers = serverRepository.findByNameContaining(name);
        if (servers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(servers, HttpStatus.OK);
        }
    }
}
