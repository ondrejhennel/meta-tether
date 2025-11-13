SUMMARY = "Python 3 bindings for libgphoto2"
DESCRIPTION = "A Python wrapper for the libgphoto2 C library, enabling camera access and control."
HOMEPAGE = "https://github.com/jim-easterbrook/python-gphoto2"
LICENSE = "LGPL-3.0-only"

LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=3000208d539ec061b899bce1d9ce9404"

inherit pypi setuptools3

PYPI_PACKAGE = "gphoto2"

SRC_URI[sha256sum] = "26087b7dffa251a78d42d06c5f0d899beda08f572dbeb637a1a846adbc71dee1"

DEPENDS = " \
    python3-setuptools-native \
    pkgconfig-native \
    libgphoto2 \
"

RDEPENDS:${PN} = " \
    python3-core \
    libgphoto2 \
"