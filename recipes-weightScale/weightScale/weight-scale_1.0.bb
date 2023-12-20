# Copyright (C) 2023 tloan <tloan@phytec.com>
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "phyFood Drive - weight-scale Service Recipe"
LICENSE = "CLOSED"

RDEPENDS:${PN} += "bash"

inherit systemd

SYSTEMD_AUTO_ENABLE:${PN} = "enable"
SYSTEMD_SERVICE:${PN} = "weight-scale.service"

SYSTEMD_AUTO_ENABLE:${PN}-sound = "enable"
SYSTEMD_SERVICE:${PN}-sound = "weight-sound.service"

PACKAGES = " \
    ${PN} \
    ${PN}-sound \
"

SYSTEMD_PACKAGES = " \
    ${PN} \
    ${PN}-sound \
"

SRC_URI = " \
    file://displayWeight.sh \
    file://readWeight.sh \
    file://readWeight_dummy.sh \
    file://weight-scale.service \
    file://weight-sound.service \
    file://food-sound.sh \
    file://xmas-sounds/sound1.wav \
    file://xmas-sounds/sound2.wav \
    file://xmas-sounds/sound3.wav \
    file://xmas-sounds/sound4.wav \
    file://xmas-sounds/sound5.wav \
    file://xmas-sounds/sound6.wav \
    file://xmas-sounds/sound7.wav \
    file://xmas-sounds/sound8.wav \
    file://xmas-sounds/sound9.wav \
    file://xmas-sounds/sound10.wav \
"

FILES:${PN} += " \
    ${systemd_unitdir}/system/weight-scale.service \
    ${bindir}/displayWeight.sh \
    ${bindir}/readWeight.sh \
    ${bindir}/readWeight_dummy.sh \
"

FILES:${PN}-sound += " \
    ${systemd_unitdir}/system/weight-sound.service \
    ${bindir}/food-sound.sh \
    ${sysconfdir}/xmas-sounds/sound1.wav \
    ${sysconfdir}/xmas-sounds/sound2.wav \
    ${sysconfdir}/xmas-sounds/sound3.wav \
    ${sysconfdir}/xmas-sounds/sound4.wav \
    ${sysconfdir}/xmas-sounds/sound5.wav \
    ${sysconfdir}/xmas-sounds/sound6.wav \
    ${sysconfdir}/xmas-sounds/sound7.wav \
    ${sysconfdir}/xmas-sounds/sound8.wav \
    ${sysconfdir}/xmas-sounds/sound9.wav \
    ${sysconfdir}/xmas-sounds/sound10.wav \
"

do_install:append() {
  install -d ${D}/${systemd_unitdir}/system
  install -m 0644 ${WORKDIR}/weight-scale.service ${D}/${systemd_unitdir}/system/weight-scale.service
  install -m 0644 ${WORKDIR}/weight-sound.service ${D}/${systemd_unitdir}/system/weight-sound.service

  install -d ${D}/${bindir}
  install -m 0755 ${WORKDIR}/displayWeight.sh ${D}/${bindir}/displayWeight.sh
  install -m 0755 ${WORKDIR}/readWeight.sh ${D}/${bindir}/readWeight.sh
  install -m 0755 ${WORKDIR}/readWeight_dummy.sh ${D}/${bindir}/readWeight_dummy.sh
  install -m 0755 ${WORKDIR}/food-sound.sh ${D}/${bindir}/food-sound.sh

  install -d ${D}/${sysconfdir}/xmas-sounds
  install -m 0755 ${WORKDIR}/xmas-sounds/sound1.wav ${D}/${sysconfdir}/xmas-sounds/sound1.wav
  install -m 0755 ${WORKDIR}/xmas-sounds/sound2.wav ${D}/${sysconfdir}/xmas-sounds/sound2.wav
  install -m 0755 ${WORKDIR}/xmas-sounds/sound3.wav ${D}/${sysconfdir}/xmas-sounds/sound3.wav
  install -m 0755 ${WORKDIR}/xmas-sounds/sound4.wav ${D}/${sysconfdir}/xmas-sounds/sound4.wav
  install -m 0755 ${WORKDIR}/xmas-sounds/sound5.wav ${D}/${sysconfdir}/xmas-sounds/sound5.wav
  install -m 0755 ${WORKDIR}/xmas-sounds/sound6.wav ${D}/${sysconfdir}/xmas-sounds/sound6.wav
  install -m 0755 ${WORKDIR}/xmas-sounds/sound7.wav ${D}/${sysconfdir}/xmas-sounds/sound7.wav
  install -m 0755 ${WORKDIR}/xmas-sounds/sound8.wav ${D}/${sysconfdir}/xmas-sounds/sound8.wav
  install -m 0755 ${WORKDIR}/xmas-sounds/sound9.wav ${D}/${sysconfdir}/xmas-sounds/sound9.wav
  install -m 0755 ${WORKDIR}/xmas-sounds/sound10.wav ${D}/${sysconfdir}/xmas-sounds/sound10.wav
}

COMPATIBLE_MACHINE:phyboard-electra-am64xx-2 = "phyboard-electra-am64xx-2"
