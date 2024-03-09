/*
 * Copyright (c) 2012-2024 Arne Schwabe
 * Distributed under the GNU GPL v2 with additional terms. For full terms see the file doc/LICENSE.txt
 */

package de.blinkt.openvpn

import java.io.Serializable

data class ProfileFromRemote(
        val isAS: Boolean,
        val url: String,
        val username: String,
        val password: String,
        val useAutologin: Boolean
) : Serializable {
    companion object {
        private const val serialVersionUID = 2915762045175411698L
    }
}
