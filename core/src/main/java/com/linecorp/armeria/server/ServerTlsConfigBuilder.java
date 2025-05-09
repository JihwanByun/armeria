/*
 * Copyright 2024 LINE Corporation
 *
 * LINE Corporation licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.linecorp.armeria.server;

import static java.util.Objects.requireNonNull;

import com.linecorp.armeria.common.AbstractTlsConfigBuilder;
import com.linecorp.armeria.common.TlsProvider;
import com.linecorp.armeria.common.annotation.UnstableApi;

import io.netty.handler.ssl.ClientAuth;

/**
 * A builder class for creating a {@link TlsProvider} that provides server-side TLS.
 */
@UnstableApi
public final class ServerTlsConfigBuilder extends AbstractTlsConfigBuilder<ServerTlsConfigBuilder> {

    private ClientAuth clientAuth = ClientAuth.NONE;

    ServerTlsConfigBuilder() {}

    /**
     * Sets the client authentication mode.
     */
    public ServerTlsConfigBuilder clientAuth(ClientAuth clientAuth) {
        this.clientAuth = requireNonNull(clientAuth, "clientAuth");
        return this;
    }

    /**
     * Returns a newly-created {@link ServerTlsConfig} based on the properties of this builder.
     */
    public ServerTlsConfig build() {
        return new ServerTlsConfig(allowsUnsafeCiphers(), meterIdPrefix(), clientAuth, tlsCustomizer());
    }
}
