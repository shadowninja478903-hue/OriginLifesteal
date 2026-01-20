package com.example.originlifesteal;

import java.util.HashMap;
import java.util.UUID;

public class OriginManager {
    private static final HashMap<UUID, String> origins = new HashMap<>();
    public static void setOrigin(UUID uuid, String origin) {
        origins.put(uuid, origin);
    }
    public static String getOrigin(UUID uuid) {
        return origins.getOrDefault(uuid, "human");
    }
}