
package com.example.hazelcast;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {

    private final HazelcastInstance hazelcastInstance;

    public CacheController(HazelcastInstance hazelcastInstance) {
        this.hazelcastInstance = hazelcastInstance;
    }

    @GetMapping("/put")
    public String put(@RequestParam String key, @RequestParam String value) {
        IMap<String, String> map = hazelcastInstance.getMap("sharedCache");
        map.put(key, value);
        return "Key-Value pair added: " + key + " -> " + value;
    }

    @GetMapping("/get")
    public String get(@RequestParam String key) {
        IMap<String, String> map = hazelcastInstance.getMap("sharedCache");
        return "Value for key " + key + ": " + map.get(key);
    }
}
