/*
 * Copyright (c) 2012-2024 Arne Schwabe
 * Distributed under the GNU GPL v2 with additional terms. For full terms see the file doc/LICENSE.txt
 */

package de.blinkt.openvpn

import java.io.Serializable

data class ProfileSource<T>(val type: Type, val value: T) : Serializable {
    companion object {
        private const val serialVersionUID = 7421073899196998123L
    }

    init {
        val typeOk = when (type) {
            Type.CREATE -> value == null
            Type.IMPORT -> value is String
            Type.AS, Type.URL -> value is ProfileFromRemote
        }
        if (!typeOk) {
            throw TypeCastException()
        }
    }

    enum class Type {
        CREATE, IMPORT, AS, URL
    }
}
