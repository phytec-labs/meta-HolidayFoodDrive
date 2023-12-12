# add the rootfs version to the welcome banner
ROOTFS_POSTPROCESS_COMMAND += "remove_tty1_service; "

# remove getty@tty1.service and getty@.service
remove_tty1_service () {
    rm -f ${IMAGE_ROOTFS}/lib/systemd/system/getty@.service
    rm -f ${IMAGE_ROOTFS}/etc/systemd/system/getty.target.wants/getty@tty1.service
}

IMAGE_INSTALL:append = " packagegroup-audio nodejs ntpdate openjdk-8 sudo weight-scale python3-pip"

COMPATIBLE_MACHINE:phyboard-electra-am64xx-2 = "phyboard-electra-am64xx-2"
