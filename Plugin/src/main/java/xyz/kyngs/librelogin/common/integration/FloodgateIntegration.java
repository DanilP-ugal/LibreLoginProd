/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package xyz.kyngs.librelogin.common.integration;

import java.util.UUID;
import org.geysermc.floodgate.api.FloodgateApi;
import org.geysermc.floodgate.api.player.FloodgatePlayer;
import org.jetbrains.annotations.Nullable;

public class FloodgateIntegration {

    private final FloodgateApi api;

    public FloodgateIntegration() {
        api = FloodgateApi.getInstance();
    }

    public boolean isFloodgateId(UUID uuid) {
        return api.isFloodgatePlayer(uuid);
    }

    @Nullable
    public UUID getUUID(String username) {
        var player = getPlayer(username);

        if (player == null) {
            return null;
        }

        return player.getCorrectUniqueId();
    }

    public FloodgatePlayer getPlayer(String username) {
        for (FloodgatePlayer floodgatePlayer : api.getPlayers()) {
            if (floodgatePlayer.getCorrectUsername().equals(username)) {
                return floodgatePlayer;
            }
        }

        return null;
    }
}
