# meta-tether

This is a Yocto Project layer that provides the software stack for a tethered photography device based on Raspberry Pi 5. It is compatible with Yocto 5.0 scarthgap.

## Setup Instructions

The setup follows a standard Yocto directory structure with a `sources` directory for layers and a `build` directory for output.

1.  **Create the workspace:**

    ```bash
    mkdir -p yocto/sources
    cd yocto/sources
    ```


2.  **Clone the required layers:**

    ```bash
    # Poky
    git clone -b scarthgap https://git.yoctoproject.org/poky

    # meta-openembedded
    git clone -b scarthgap https://git.openembedded.org/meta-openembedded

    # meta-raspberrypi
    git clone -b scarthgap https://github.com/agherzan/meta-raspberrypi.git

    # meta-tether (this project)
    git clone -b main https://github.com/ondrejhennel/meta-tether.git
    ```


3.  **Initialize the build:**

    ```bash
    cd ..
    TEMPLATECONF=../meta-tether/conf/templates/default source sources/poky/oe-init-build-env build
    ```


5.  **Configure Wi-Fi (Optional):**

    Edit `conf/local.conf` to add your network credentials:
    ```bitbake
    WIFI_COUNTRY = "country-code"
    WIFI_SSID = "your-network-ssid"
    WIFI_PSK_HASH = "your-generated-hash"
    ```
    You can generate the PSK hash using the `wpa-passphrase` command.


6.  **Build the image:**
    ```bash
    bitbake tether-image
    ```
    The finished image can be found under `build/tmp/deploy/images/raspberrypi5/tether-image-raspberrypi5.rootfs.wic.bz2`. You can then unzip it and flash it to the SD card using the `dd` command or your favourite flashing tool.

7.  **Accessing the Device:**

    The device will automatically boot into the tethergui application. For debugging and development, you can access the device via SSH.

    * **Default Hostname:** `tetherpi.local`
    * **User:** `root`
    * **Password:** (None) _(Root login without password is enabled for development)_

    ```bash
    ssh root@tetherpi.local
    ```

    **Overriding the Hostname:**
    To change the hostname, add the following to your `conf/local.conf`:

    ```bitbake
    hostname:pn-base-files = "your-new-name"
    ```
    After rebuilding and flashing, the device will be accessible at `your-new-name.local`.
