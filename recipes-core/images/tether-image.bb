# Base this image on core-image-base
require recipes-core/images/core-image-base.bb

IMAGE_FEATURES:append = " splash ssh-server-openssh weston"

IMAGE_INSTALL:append = " \
    packagegroup-base \
    bash \
    bzip2 \
    coreutils \
    curl \
    file \
    findutils \
    gawk \
    grep \
    gzip \
    less \
    sed \
    tar \
    unzip \
    util-linux \
    wget \
    which \
    xz \
    \
    mc \
    \
    iputils \
    iproute2 \
    iproute2-tc \
    \
    usbutils \
    \
    network-config \
    wpa-supplicant \
    wireless-regdb-static \
    bluez5 \
    \
    gphoto2 \
    python3 \
    gtk4 \
    python3-pygobject \
    python3-numpy \
    libgphoto2 \
    python3-gphoto2 \
    python3-rawpy \
"