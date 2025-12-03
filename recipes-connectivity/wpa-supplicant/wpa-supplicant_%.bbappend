FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "file://wpa_supplicant-wlan0.conf"

# Enable systemd service to connect at boot
SYSTEMD_SERVICE:${PN} = "wpa_supplicant@wlan0.service"
SYSTEMD_AUTO_ENABLE = "enable"

# Default to world regulatory domain if country code is not set
WIFI_COUNTRY ?= "00"

do_install:append() {
    # Only install the configuration if the SSID and PSK hash is specified
    if [ -n "${WIFI_SSID}" ] && [ -n "${WIFI_PSK_HASH}" ]; then
        # Install the config template
        install -d ${D}${sysconfdir}/wpa_supplicant
        install -m 0600 ${WORKDIR}/wpa_supplicant-wlan0.conf ${D}${sysconfdir}/wpa_supplicant/

        # Replace placeholders. Use tilde as sed delimiter to minimize conflicts with SSID.
        sed -i "s~@@WIFI_SSID@@~${WIFI_SSID}~g" ${D}${sysconfdir}/wpa_supplicant/wpa_supplicant-wlan0.conf
        sed -i "s~@@WIFI_PSK_HASH@@~${WIFI_PSK_HASH}~g" ${D}${sysconfdir}/wpa_supplicant/wpa_supplicant-wlan0.conf
        sed -i "s~@@WIFI_COUNTRY@@~${WIFI_COUNTRY}~g" ${D}${sysconfdir}/wpa_supplicant/wpa_supplicant-wlan0.conf
    fi
}