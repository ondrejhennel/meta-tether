SUMMARY = "A custom Wayland/Weston image for a tethered photography device"
LICENSE = "MIT"

# Base this image on core-image
inherit core-image

IMAGE_FEATURES:append = " ssh-server-openssh weston"

IMAGE_INSTALL:append = " \
    packagegroup-base \
    util-linux \
    usbutils \
    mc \
    wget \
    rsync \
    network-config \
    wpa-supplicant \
    wireless-regdb-static \
    avahi-daemon \
    \
    gphoto2 \
    python3-tethergui \
"

# Add 2 GB extra space for the photos
IMAGE_ROOTFS_EXTRA_SPACE = "2097152"
