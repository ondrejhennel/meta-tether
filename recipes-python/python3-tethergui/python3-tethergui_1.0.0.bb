SUMMARY = "A GTK-based application for tethered capture with digital cameras"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e49f4652534af377a713df3d9dec60cb"

inherit python_setuptools_build_meta systemd

SRC_URI = " \
	git://github.com/ondrejhennel/tethergui.git;protocol=https;branch=main \
	file://tethergui.service \
"
SRCREV = "80bc01d1adda5d253c11ede97ac988691f8ae5c3"

S = "${WORKDIR}/git"

SYSTEMD_SERVICE:${PN} = "tethergui.service"
SYSTEMD_AUTO_ENABLE = "enable"

RDEPENDS:${PN} = " \
	python3-rawpy \
	python3-pygobject \
	python3-gphoto2 \
	python3-core \
	gtk4 \
"

do_install:append() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/tethergui.service ${D}${systemd_system_unitdir}
}
