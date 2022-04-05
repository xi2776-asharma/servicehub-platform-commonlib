package com.unobank.servicehub.platform.commonlib.configuration.properties;

import com.unobank.servicehub.platform.commonlib.constant.MambuConstants;
import lombok.Data;
import lombok.Synchronized;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@ConfigurationProperties(prefix = "paynamics-api.uri")
@Data
public class PaynamicsApiProperties {

    private String protocol;
    private String host;
    private String path;

    public URI getUri() {
        return UriComponentsBuilder.fromHttpUrl(getUrl()).path(getPath()).build().toUri();
    }

    public String getUrl() {
        return getProtocol() + MambuConstants.PROTOCOL_HOST_CONNECTOR + getHost();
    }

    @Synchronized
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    @Synchronized
    public void setHost(String host) {
        this.host = host;
    }
}
