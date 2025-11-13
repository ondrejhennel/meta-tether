SUMMARY = "Installs systemd-networkd WiFi config"
LICENSE = "CLOSED"

SRC_URI = "file://25-wlan.network"

do_install() {
    # Install systemd-networkd config
    install -d ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/25-wlan.network ${D}${sysconfdir}/systemd/network/
}

FILES:${PN} = "${sysconfdir}/systemd/network/25-wlan.network"
