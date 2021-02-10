package com.practice.dontcallme.backend;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class CameraArrangement {

    public CameraArrangement(String macAddress, @NotBlank String ipv4Address) {
        this.macAddress = macAddress;
        this.ipv4Address = ipv4Address;
    }

    @Id
    private String macAddress = "A1-B2-C3-D4-E5-F6";

    @NotBlank
    private String ipv4Address;

    private String ipv6Address;


    public String getIpv6Address() {
        return ipv6Address;
    }

    public void setIpv6Address(String ipv6Address) {
        this.ipv6Address = ipv6Address;
    }

}